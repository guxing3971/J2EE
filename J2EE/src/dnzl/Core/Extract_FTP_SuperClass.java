package dnzl.Core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.sql.SQLException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import dnzl.Core.db.ExtractVO;
import dnzl.common.CommonFTP;

public class Extract_FTP_SuperClass extends Extract_Task_SuperClass {

	private String file_name = null;

	private CommonFTP ftp_com = new CommonFTP();

	private FTPClient client = null;

	private String local_dir = "/datafile";

	public void setFile_name(String fileName) {
		file_name = fileName;
	}

	@Override
	public boolean Extract(ExtractVO vo) {
		boolean falg = false;
		vo = this.vo;
		initData();
		try {
			client = ftp_com.getConByEname(vo.getFTP_Ename());
			if (client != null) {
				falg = true;
				msg.append("<br/>连接FTP-->成功:" + vo.getFTP_Ename());
			} else {
				falg = false;
				msg.append("<br/>连接FTP-->失败:" + vo.getFTP_Ename());
			}
			falg = download();
			if (falg) {
				falg = true;
				msg.append("<br/>下载文件成功");
			} else {
				falg = false;
				msg.append("<br/>下载文件失败" + client.getStatus());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return falg;
	}

	private boolean download() throws IOException {
		boolean falg = false;
		String local_file = local_dir + "/" + file_name;
		File dir = new File(local_dir);
		msg.append("<br/>需要抽取的文件为:" + file_name);
		msg.append("<br/>本地存放路径为:" + local_file);

		int i = 0;
		while (!falg) {
			if (i > 5) {
				return false;
			} else {
				falg = remoteFile_exist(file_name);
				i++;
			}
			if (!falg) {
				try {
					Thread.sleep(5 * 60 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		if (falg) {
			File temp = new File(local_file);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if (!temp.exists()) {
				temp.createNewFile();
			}
			OutputStream out = null;
			out = new FileOutputStream(temp);
			if (falg) {
				log.setF_count("1");
				client.setFileType(FTPClient.BINARY_FILE_TYPE);
				falg = client.retrieveFile(
						new String(file_name.getBytes("UTF-8"), "ISO-8859-1"),
						out);
			}
			out.close();
			if (falg) {
				log.setT_count("1");
				msg.append("<br/>下载文件成功");
			} else {
				msg.append("<br/>下载文件失败" + client.getStatus());
			}
		} else {
			msg.append("<br/>远程文件不存在" + client.getStatus());
		}

		return falg;
	}

	private boolean remoteFile_exist(String file_name) throws IOException {
		boolean falg = false;
		FTPFile[] fs = client.listFiles();
		for (FTPFile ff : fs) {
			String name = ff.getName();
			if (file_name.equalsIgnoreCase(name)) {
				falg = true;
			}
		}
		return falg;
	}

	public void initData() {

	}

}
