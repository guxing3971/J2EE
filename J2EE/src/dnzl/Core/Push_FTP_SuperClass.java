package dnzl.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import dnzl.Core.db.PushVO;
import dnzl.common.CommonFTP;

/***********************************************
 * 主要功能
 * 	  定义并实现了利用FTP方式推送数据任务的父类 
 *
 ***********************************************/
public class Push_FTP_SuperClass extends Push_Task_SuperClass{
	
	private String file_name = null;
	
	private String local_dir ="/datafile";
	
	private FTPClient client = null;
	
	private CommonFTP ftp_com = new CommonFTP();
	
	
	public void setFile_name(String fileName) {
		file_name = fileName;
	}

	private boolean remoteFile_exist(boolean delete) throws Exception{
		boolean falg = false;
		FTPFile[] fs = null;
		fs = client.listFiles();
		for(FTPFile ff:fs){
			String name = ff.getName();
			if(file_name.equalsIgnoreCase(name)){
				falg = true;
				msg.append("<br/>远程文件已经存在");
				if(delete){
					try {
						if(client.deleteFile(new String(file_name.getBytes("UTF-8"),"ISO-8859-1"))){
							msg.append("<br/>成功删除远程文件,开始重新上传");
						}else{
							msg.append("<br/>远程文件已经存在,上传可能会失败");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return falg;
	}
	
	
	@Override
	public boolean Push(PushVO vo) {
		this.vo = vo;
		boolean falg = false;
		initData();
			try {
				client = ftp_com.getConByEname(vo.getFTP_Ename());
				if(client != null){
					falg =true;
					msg.append("<br/>连接FTP成功");
				}else{
					msg.append("<br/>连接FTP失败"+client.getStatus());
				}
				if(falg){
					falg = upload();
					if(falg){
						msg.append("<br/>上传文件成功");
					}else{
						msg.append("<br/>上传文件失败"+client.getStatus());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		
		return falg;
	}
	
	
	private boolean upload() throws IOException{
		boolean falg = false;
		
		String local_file = local_dir +"/"+file_name;
		msg.append("<br/>需要推送的本地文件为:"+local_file);
		msg.append("<br/>远程文件为:"+file_name);
		File file = new File(local_file);
		
		
		int i=0;
		while(!falg){
			if(i>5){
				return false;
			}
			falg = file.exists();
			if(falg){
				falg=file.renameTo(file);
				i++;
			}
			if(!falg){
				try {
					Thread.sleep(5*60*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		InputStream in = new FileInputStream(file);
		try {
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			remoteFile_exist(true);
			falg = client.appendFile(new String(file_name.getBytes("GDK"),"ISO-8859-1"), in);
		} catch (Exception e) {
			e.printStackTrace();
			falg = false;
		}finally{
			in.close();
		}
		return falg;
	}
	


	public void initData(){
		
	}
	
}
