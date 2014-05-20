package dnzl.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dnzl.Core.db.SysdbConn;
import dnzl.DataFactory.SupperVo;
import dnzl.DataFactory.VODWPL;

/******************************************************************************
 * 
 * @summary 用于手动抽取数据
 *****************************************************************************/
public class ExtractAllData_DWPL {
	private static String start_time = "2014-02-26 19:00:00";

	private static String end_time = "2014-02-27 02:00:00";

	private SysdbConn db = new dnzl.Core.db.SysdbConn();

	private Connection F_conn = null;

	private Connection T_conn = null;

	public void initdb() {
		try {
			F_conn = db.C5000();
			T_conn = db.DNZL();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SupperVo> initVo_MXPL() throws Exception {
		List<SupperVo> list = new ArrayList<SupperVo>();

		String sql = "SELECT  ID, CODE MX_CODE, "
				+ "NAME MX_NAME, "
				+ "DDATE COUNT_DATE, "
				+ "HOUR , "
				+ "MAX_VALUE TOPLIMIT, "
				+ "MAX_TIME TOPLIMIT_TIME, "
				+ "MIN_VALUE LOWERLIMIT, "
				+ "MIN_TIME LOWERLIMIT_TIME, "
				+ "RUN_TIME RUN_TIME, "
				+ "OVER_UP_LIMIT TOPLIMIT_CD, "
				+ "OVER_LOW_LIMIT LOWERLIMIT_CD, "
				+ "VALID_RATE PERCENTS,  "
				+ "to_date(to_char(ddate,'yyyy-MM-dd')||' '||HOUR||':00:00') COUNTDATE "
				+ "FROM HISDB.SPECIAL_CALC_HOUR where code = 'sysqwF'  "
				+ "and to_date(to_char(ddate,'yyyy-MM-dd')||' '||HOUR||':00:00') >= DATEADD(HH,-1,to_date('"
				+ start_time
				+ "')) "
				+ "and to_date(to_char(ddate,'yyyy-MM-dd')||' '||HOUR||':00:00') <= DATEADD(HH,-1,to_date('"
				+ end_time + "')) ";

		System.out.println("[SQL]" + sql);
		ResultSet set = F_conn.createStatement().executeQuery(sql);
		if (set == null)
			return null;
		while (set != null && set.next()) {
			VODWPL vo = new VODWPL();
			vo.setTOPLIMIT_CD(set.getString("TOPLIMIT_CD"));
			vo.setLOWERLIMIT_CD(set.getString("LOWERLIMIT_CD"));
			vo.setTOPLIMIT(String.valueOf(set.getString("TOPLIMIT")));
			vo.setTOPLIMIT_TIME(set.getString("TOPLIMIT_TIME"));
			vo.setLOWERLIMIT(String.valueOf(set.getString("LOWERLIMIT")));
			vo.setLOWERLIMIT_TIME(set.getString("LOWERLIMIT_TIME"));
			vo.setPERCENTS(set.getString("PERCENTS"));
			vo.setYearTopLimit_CD(set.getString("TOPLIMIT_CD"));
			vo.setYearLowerLimit_CD(set.getString("LOWERLIMIT_CD"));
			vo.setYearPercents(set.getString("PERCENTS"));
			vo.setCOUNT_DATE(set.getString("COUNTDATE").substring(0,19));
			list.add((SupperVo) vo);
		}
		System.out.println("抽取数据:" + list.size() + "条");
		return list;
	}

	public void save(List<SupperVo> list) {
		try {
			Statement stmt = T_conn.createStatement();
			Iterator<SupperVo> iter = list.iterator();
			while (iter.hasNext()) {
				SupperVo vo = iter.next();
				vo.save_sql = vo.SaveStr();
				stmt.addBatch(vo.save_sql);
			}
			int[] temp = stmt.executeBatch();
			if (temp.length == list.size()) {
				System.out.println("实际入库:" + temp.length + "条");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ExtractAllData_DWPL obj = new ExtractAllData_DWPL();
		obj.initdb();
		obj.save(obj.initVo_MXPL());
	}

}
