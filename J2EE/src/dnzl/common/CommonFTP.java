package dnzl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.sql.SQLException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import dnzl.Core.db.FTPDao;
import dnzl.Core.db.FTPVO;

public class CommonFTP {
	private FTPVO ftp_vo = null;
	private FTPDao dao = new FTPDao();
	private FTPClient ftp_client = null;
	private String username = null;
	private String password = null;
	private int port = 0;
	private String host = null;
	private boolean binaryMode = true;
	private boolean passiveMode = true;
	private String msg = null;
	private String localdir = "C:/Users/Administrator/Desktop";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CommonFTP() {

	}

	public CommonFTP(FTPVO vo) {
		this.ftp_vo = vo;
	}

	public void initData() {
		this.username = ftp_vo.getFTP_user();
		this.password = ftp_vo.getFTP_pass();
		this.port = Integer.parseInt(ftp_vo.getFTP_port());
		this.host = ftp_vo.getHostName();
	}

	public void initClient() throws IOException, SQLException {
		initData();
		ftp_client = new FTPClient();
		int reply = -1;
		ftp_client.connect(host, port);
		ftp_client.login(username, password);
		reply = ftp_client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp_client.disconnect();
			msg = msg + "\nFTP-错误:" + reply;
		} else {
			ftp_client.setControlEncoding("GBK");
			if (binaryMode) {
				ftp_client.setFileType(FTPClient.BINARY_FILE_TYPE);
			} else {
				ftp_client.setFileType(FTPClient.ASCII_FILE_TYPE);
			}
			if (passiveMode) {
				ftp_client.enterLocalPassiveMode();
			} else {
				ftp_client.enterRemotePassiveMode();
			}
		}
	}

	public FTPClient getConByEname(String name) throws SQLException,
			SocketException, IOException {

		FTPDao ftpDao = new FTPDao();
		FTPClient client = null;
		FTPVO vo = ftpDao.getVOByEname(name);
		String host = vo.getHostName();
		int port = Integer.parseInt(vo.getFTP_port());
		String username = vo.getFTP_user();
		String password = vo.getFTP_pass();
		client = new FTPClient();
		int reply = -1;
		client.connect(host, port);
		client.login(username, password);
		reply = client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			client.disconnect();
			System.out.println("\t连接FTP失败" + reply);
			client = null;
		} else {
			client.setControlEncoding("GBK");
			if (binaryMode) {
				client.setFileType(FTPClient.BINARY_FILE_TYPE);
			} else {
				client.setFileType(FTPClient.ASCII_FILE_TYPE);
			}
			if (passiveMode) {
				client.enterLocalPassiveMode();
			} else {
				client.enterRemotePassiveMode();
			}
		}
		return client;
	}

	public boolean download_file(String str) throws IOException, SQLException {
		initClient();
		boolean res = false;
		File local_file = new File(localdir + "/" + str);
		OutputStream out = null;
		try {
			res = local_file.createNewFile();
			msg = msg + "创建本地文件成功\n";
		} catch (IOException e) {
			msg = msg + "创建本地文件错误\n";
			e.printStackTrace();
		}
		try {
			out = new FileOutputStream(local_file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		if (res) {
			try {
				res = ftp_client.retrieveFile(str, out);
				msg = msg + "下载文件成功\n";
			} catch (IOException e) {
				msg = msg + "下载文件失败:" + str + "\n";
				e.printStackTrace();
			}
		}
		if (res) {
			System.out
					.println("\t下载文件成功:\t远程文件" + str + "\t本地文件:" + local_file);
		}
		destory();
		return res;
	}

	public boolean download_dir(String str) throws IOException, SQLException {
		boolean res = false;
		initClient();
		return res;
	}

	public boolean put_file(String str) throws IOException, SQLException {
		initClient();
		boolean res = false;
		try {
			InputStream intput = new FileInputStream(new File(str));
			try {
				ftp_client.appendFile(str, intput);
			} catch (IOException e) {
				msg = msg + "上传文件失败\n";
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			msg = msg + "读取本地文件失败\n";
			e.printStackTrace();
		}
		return res;
	}

	public boolean pud_dir(String str) throws IOException, SQLException {
		boolean res = false;
		initClient();
		destory();
		return res;
	}

	public boolean log() throws SQLException {
		boolean res = false;
		res = dao.Update("FTP_Readme", msg, ftp_vo.getRecordid());
		return res;
	}

	// 释放相关的连接
	public void destory() {
		try {
			ftp_client.disconnect();
			System.out.println("\t关闭FTP连接:---->成功\t" + ftp_vo.getFTP_EName()
					+ ">" + ftp_vo.getHostName() + "\n");
		} catch (IOException e) {
			System.out.println("\t关闭FTP连接错误\n");
			e.printStackTrace();
		}
	}

}
