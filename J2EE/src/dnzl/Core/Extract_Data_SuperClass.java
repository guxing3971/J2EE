package dnzl.Core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import dnzl.Core.db.ExtractVO;
import dnzl.Core.db.SysdbConn;
import dnzl.DataFactory.SupperVo;

@SuppressWarnings("unused")
public class Extract_Data_SuperClass extends Extract_Task_SuperClass {

	public static Calendar dar = Calendar.getInstance();

	public static TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	public Connection F_conn = null;

	public Connection T_conn = null;

	public ResultSet result_set = null;

	public String F_sql = null;

	public String T_sql = null;

	public int T_Count = 0;

	public int F_Count = 0;

	public String method = "sql";

	public List<SupperVo> voArray = null;

	public Extract_Data_SuperClass() {
		dar.setTimeZone(timezone);
	}

	public void SetVoList(List<SupperVo> list) {
		voArray = list;
	}

	public void SetMethod(String fun) {
		method = fun;
	}

	public void initConns() {
		F_conn = SysdbConn.initByJNDI("CC5000");
		T_conn = SysdbConn.initByJNDI("DNZL");
	}


	public void destroy() {
		try {
			F_conn.close();
			T_conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		F_conn = null;
		T_conn = null;
	}

	public void printSet(ResultSet set) throws SQLException {
		StringBuffer str = new StringBuffer();
		if (set == null)
			return;
		while (set.next()) {
			int i = set.getMetaData().getColumnCount();
			for (int ii = 1; ii <= i; ii++) {
				str.append(set.getString(ii) + "\t");
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}

	public void printVo(List<SupperVo> vo) {
		if (vo == null)
			return;
		Iterator<SupperVo> iter = vo.iterator();
		SupperVo vos = null;
		while (iter.hasNext()) {
			vos = iter.next();
			System.out.println(vo.toString());
		}
	}

	public ResultSet resuletSet() {
		ResultSet set = null;
		if (F_conn != null && F_sql != null) {
			try {
				set = F_conn.createStatement().executeQuery(F_sql);
				msg.append("<br/>获取结果集成功<br/>执行的sql为:" + F_sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			msg.append("<br/>数据库连接异常或查询SQL为空");
		}
		return set;
	}

	public ResultSet resuletSet(String sql) throws Exception {
		ResultSet set = null;
		initConns();
		if (F_conn != null && sql != null) {
			Statement stmt = F_conn.createStatement();
			set = stmt.executeQuery(sql);
		} else {
			msg.append("<br/>数据库连接异常或查询SQL为空");
		}
		return set;
	}

	
	/**
	 * 将vos对应的vo数据保存到数据库中
	 * @param vos
	 * @return
	 */
	public boolean save(List<SupperVo> vos) {
		boolean falg = false;
		try {
			Statement stmt = T_conn.createStatement();
			F_Count = vos.size();
			Iterator<SupperVo> iter = vos.iterator();
			while (iter.hasNext()) {
				SupperVo vo = iter.next();
				vo.save_sql = vo.SaveStr();
				stmt.addBatch(vo.save_sql);
			}
			int[] temp = stmt.executeBatch();
			if (F_Count == temp.length) {
				T_Count = F_Count;
				falg = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			log.setF_count(String.valueOf(F_Count));
			log.setT_count(String.valueOf(T_Count));
		}
		System.out.println(this.getClass().getSimpleName() + "需要抽取的数据>"+ F_Count + "\t实际入库的数据>" + T_Count);
		return falg;
	}

	
	@Override
	public boolean Extract(ExtractVO vo) {
		boolean falg = false;
		initConns();
		if (F_conn != null && T_conn != null) {
			if ("sql".equalsIgnoreCase(method)) {
				falg = Extract_data();
			} else {
				falg = save(voArray);
			}
		} else {
			falg = false;
			msg.append("<br/>数据库连接异常或执行的sql存在问题");
		}
		destroy();
		return falg;
	}

	
	/*****************************************************************
	 * Extract_data
	 * summary: 完成以SELECT查询语句查询结果以INSERT语句插入的数据抽取方式
	 * 此过程中不对select语句的结果做任何的处理.
	 * warn: 必须保证SELECT的字段和INSERT的字段一样对
	 * Override:子类可以通过覆写该类来完成特殊的SELECT->INSERT对应功能
	 * 
	 * @return
	 ****************************************************************/
	public boolean Extract_data() {
		boolean falg = false;
		result_set = resuletSet();
		int count = 0;
		PreparedStatement pmst = null;
		try {
			pmst = T_conn.prepareStatement(T_sql);
			count = result_set.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (result_set.next()) {
				F_Count++;
				for (int i = 0; i < count; i++) {
					pmst.setString(i + 1, result_set.getString(i + 1));
				}
				falg = pmst.execute();
				T_Count++;
			}
			log.setStatus("true");
			msg.append("<br/>数据抽取成功");

		} catch (SQLException e) {
			e.printStackTrace();
			msg.append("<br/>数据抽取失败");
		} finally {
			log.setF_count(String.valueOf(F_Count));
			log.setT_count(String.valueOf(T_Count));
		}
		return falg;
	}

	
	/**
	 * 记录日志到文件中
	 * @param vo
	 */
	public synchronized void Insertlog(List<SupperVo> vo) {
		String str_time = sdf2.format(new Date());
		String file_name = "/datafile/dnzl/Extract/insert_" + str_time + ".log";
		File f = new File(file_name);
		if (!(f.exists())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			OutputStream out = new FileOutputStream(f, true);
			String str = "<!--" + this.getClass().getSimpleName() + "__"
					+ new Date() + "-->\n";
			out.write(str.getBytes());
			Iterator<SupperVo> iter = vo.iterator();
			while (iter.hasNext()) {
				SupperVo tvo = iter.next();
				tvo.save_sql = tvo.SaveStr();
				out.write(tvo.save_sql.getBytes());
			}
			out.write("\n".getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/************************************************************
	 * 以数据源方式抽取数据的子类必须重写该方法以设置
	 *  F_sql 抽取数据的sql语句(存储过程的方式还未开发)
	 *  T_sql 往oms库中插入数据的sql
	 *  inNeed 是否需要执行
	 ************************************************************/
	public void initData() {

	}

}
