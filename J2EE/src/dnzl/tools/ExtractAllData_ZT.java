package dnzl.tools;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import dnzl.Core.Extract_ZT_SupperClass;
import dnzl.Core.db.SysdbConn;
@SuppressWarnings("unused")
public class ExtractAllData_ZT {
	public Connection F_con = null;
	
	private Connection T_con = null;
	
	private SysdbConn db = new dnzl.Core.db.SysdbConn();
	
	private String strTime="20140121";
	
	private String strHour="16";
	
	public void initdb(){
		try{
			F_con = db.C5000();
			T_con = db.DNZL();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public  void  runData() throws SQLException{
		
		String sql = "select * from HISDB.MANALOG_DATA_SCADA_"+strTime;
		
		
		List<String> insert = new ArrayList<String>();
		ResultSet set = null;
		Statement stmt = null;
		if(F_con != null){
			 set =  F_con.createStatement().executeQuery(sql);
			 stmt = T_con.createStatement();
		}
		
		String temp =null;
		String tempB = null;
		

		while(set.next()){
			StringBuffer sbuf = new StringBuffer();
			sbuf.append("INSERT INTO EMS.MANALOG_DATA_SCADA values(");
			temp = set.getString("DATA_ID");
			tempB = (new BigInteger(temp)).toString(2);
			int len = tempB.length();
			String str =set.getString("NAME");

			sbuf.append(temp+",");
			sbuf.append("'"+(new BigInteger(temp)).toString(2)+"',");
			sbuf.append(0+",");
			sbuf.append("'"+strHour+"',");
			//table_id
			sbuf.append(Integer.valueOf(tempB.substring(0,len-48),2)+",");
			//filed_id
			sbuf.append(Integer.valueOf(tempB.substring(len-48,len-32),2)+",");
			//area
			sbuf.append(Integer.valueOf(tempB.substring(len-32,len-24),2)+",");
			//key
			sbuf.append(Integer.valueOf(tempB.substring(len-24), 2)+",");			
			
			for( int i=0;i<60;i++){
				String tempss = set.getString("DATA_"+strHour+"_"+i);
				if(tempss == null){
					tempss = "0";
				}
				sbuf.append("'"+tempss+"',");
				
			}
			sbuf.append("'"+set.getString("CODE")+"',");
			sbuf.append("'"+str+"');");
			insert.add(sbuf.toString());
			stmt.addBatch(sbuf.toString());
		}
		
		int[] res = null;
		try{
			res = stmt.executeBatch();

			T_con.commit();
		}catch(Exception e){
			e.printStackTrace();
			T_con.rollback();
		}finally{

			stmt.close();
			
		}
		System.out.println("状态运行数据->\t\t"+res.length);
	}
	public void Deal_breaker() throws SQLException{
		
		List<String> insert = new ArrayList<String>();
		
		String sqltext ="SELECT * FROM EMS.MANALOG_DATA_SCADA WHERE TABLE_NO='407'"
				+ "	AND FIELD_ID='70' and code !='null' and name !='null' and hours="+strHour;
		ResultSet set = T_con.createStatement().executeQuery(sqltext);
		
		
		boolean b_falg =false;
		boolean t_falg = false;
		int count = 0;
		String  temp = null;
		Statement stmt =  T_con.createStatement();
		
		while(set.next()){
			count++;
			temp = set.getString("Data_0");
			if(Integer.parseInt(temp) < 5){	
				t_falg = false;
			}else{
				t_falg = true;
			}

			
			for(int i =1;i<60;i++){
				//从大于5到小于5之间发生一次越界表示一次事件	
				if(b_falg){
					if(Integer.parseInt(set.getString("Data_"+i)) < 5){
						b_falg = false;
						
					}
				}else{	
					if(Integer.parseInt(set.getString("Data_"+i)) > 5){
						b_falg = true;
					}
				}	
				if( b_falg != t_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					String sql = null;
					if(b_falg){
						t_falg = true;

						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_DLQ VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,1)";
					}else{
						t_falg = false;
						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_DLQ VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",1,0)";
					}
					insert.add(sql);
				}
			}
		}
		
		int[] res = null;
		try{
			res = stmt.executeBatch();
			T_con.commit();
		}catch(Exception e){
			e.printStackTrace();
			T_con.rollback();
		}finally{
			stmt.close();
		}

		System.out.println("断路器状态切换:需要计算的数据条数:\t\t\t"+count+"\t状态切换数据"+res.length);	
	}

	public void Deal_busbarsection() throws SQLException{
		List<String> insert = new ArrayList<String>();
		ResultSet set = T_con.createStatement().executeQuery("SELECT * FROM EMS.MANALOG_DATA_SCADA WHERE TABLE_NO='410'"
				+ "	AND FIELD_ID='30' and code !='null' and name !='null' and hours="+strHour);
		
		boolean b_falg =false;
		boolean t_falg = false;
		int count = 0;
		String  temp = null;
		Statement stmt =  T_con.createStatement();		
		while(set.next()){
			count ++;
			temp = set.getString("Data_0");

			if(Integer.parseInt(temp) < 5){	
				t_falg = false;
			}else{
				t_falg = true;
			}
			b_falg = t_falg;
			for(int i =1;i<60;i++){

				//从大于5到小于5之间发生一次越界表示一次事件	
				if(b_falg){
					if(Integer.parseInt(set.getString("Data_"+i)) < 5){
						b_falg = false;
						
					}
				}else{	
					if(Integer.parseInt(set.getString("Data_"+i)) > 5){
						b_falg = true;
					}
				}
				
				if( b_falg != t_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					String sql = null;
					if(b_falg){
						t_falg = true;

						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_MX VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,1)";
					}else{
						t_falg = false;
						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_MX VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",1,0)";
					}
					insert.add(sql);
					stmt.addBatch(sql);
				}
			}
		}
		int[] res = null;
		try{
			res = stmt.executeBatch();
			T_con.commit();
		}catch(Exception e){
			e.printStackTrace();
			T_con.rollback();
		}finally{
			stmt.close();
		}
		System.out.println("母线状态切换:需要计算的数据条数\t\t\t"+count+"\t状态切换数据"+res.length);	
	}

	
	public void Deal_aclineend() throws SQLException{
		List<String> insert = new ArrayList<String>();
		ResultSet set = T_con.createStatement().executeQuery("SELECT * FROM EMS.MANALOG_DATA_SCADA WHERE TABLE_NO='415'"
				+ "	AND FIELD_ID='50' and code !='null' and name !='null' and hours="+strHour);
		boolean b_falg =false;
		boolean t_falg = false;
		int count = 0;
		String  temp = null;
		Statement stmt =  T_con.createStatement();		
		while(set.next()){
			count++;
			temp = set.getString("Data_0");

			
			//判断整点时是否为5~0这个范围内
			if(Integer.parseInt(temp) < 5){	
				t_falg = false;
			}else{
				t_falg = true;
			}
			b_falg = t_falg;
			for(int i =1;i<60;i++){

				
			//从大于5到小于5之间发生一次越界表示一次事件	
			if(b_falg){
				if(Integer.parseInt(set.getString("Data_"+i)) < 5){
					b_falg = false;
					
				}
			}else{	
				if(Integer.parseInt(set.getString("Data_"+i)) > 5){
					b_falg = true;
				}
			}				
				
				if( b_falg != t_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					String sql = null;
					if(b_falg){
						t_falg = true;

						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_XL VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,1,0,1)";
					}else{
						t_falg = false;
						sql = "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_XL VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",1,0,1,0)";
					}
					insert.add(sql);
					stmt.addBatch(sql);
				}
			}
		}
		int[] res = null;
		try{
			res = stmt.executeBatch();
			T_con.commit();
		}catch(Exception e){
			e.printStackTrace();
			T_con.rollback();
		}finally{
			stmt.close();
		}
		System.out.println("线路状态切换:需要计算的数据条数\t\t\t"+count+"\t状态数据"+res.length);	
	}
	

	
	public void Deal_transformerwinding() throws SQLException{
		List<String> insert = new ArrayList<String>();
		String sqltext ="SELECT distinct "+
				"LEFT(H.CODE,locate('-',H.CODE,1)-1) code, "+
				"LEFT(H.NAME,locate('-',H.NAME,1)-1) name, "+
				"H.Data_0 Hdata_0,H.Data_1 Hdata_1,H.Data_2 Hdata_2,H.Data_3 Hdata_3, "+
				"H.Data_4 Hdata_4,H.Data_5 Hdata_5,H.Data_6 Hdata_6,H.Data_7 Hdata_7, "+
				"H.Data_8 Hdata_8,H.Data_9 Hdata_9,H.Data_10 Hdata_10,H.Data_11 Hdata_11, "+
				"H.Data_12 Hdata_12,H.Data_13 Hdata_13,H.Data_14 Hdata_14,H.Data_15 Hdata_15, "+
				"H.Data_16 Hdata_16,H.Data_17 Hdata_17,H.Data_18 Hdata_18,H.Data_19 Hdata_19, "+
				"H.Data_20 Hdata_20,H.Data_21 Hdata_21,H.Data_22 Hdata_22,H.Data_23 Hdata_23, "+
				"H.Data_24 Hdata_24,H.Data_25 Hdata_25,H.Data_26 Hdata_26,H.Data_27 Hdata_27, "+
				"H.Data_28 Hdata_28,H.Data_29 Hdata_29,H.Data_30 Hdata_30,H.Data_31 Hdata_31, "+ 
				"H.Data_32 Hdata_32,H.Data_33 Hdata_33,H.Data_34 Hdata_34,H.Data_35 Hdata_35, "+
				"H.Data_36 Hdata_36,H.Data_37 Hdata_37,H.Data_38 Hdata_38,H.Data_39 Hdata_39, "+
				"H.Data_40 Hdata_40,H.Data_41 Hdata_41,H.Data_42 Hdata_42,H.Data_43 Hdata_43, "+
				"H.Data_44 Hdata_44,H.Data_45 Hdata_45,H.Data_46 Hdata_46,H.Data_47 Hdata_47, "+
				"H.Data_48 Hdata_48,H.Data_49 Hdata_49,H.Data_50 Hdata_50,H.Data_51 Hdata_51, "+
				"H.Data_52 Hdata_52,H.Data_53 Hdata_53,H.Data_54 Hdata_54,H.Data_55 Hdata_55,  "+
				"H.Data_56 Hdata_56,H.Data_57 Hdata_57,H.Data_58 Hdata_58,H.Data_59 Hdata_59, "+
				"M.Data_0 Mdata_0,M.Data_1 Mdata_1,M.Data_2 Mdata_2,M.Data_3 Mdata_3, "+
				"M.Data_4 Mdata_4,M.Data_5 Mdata_5,M.Data_6 Mdata_6,M.Data_7 Mdata_7, "+
				"M.Data_8 Mdata_8,M.Data_9 Mdata_9,M.Data_10 Mdata_10,M.Data_11 Mdata_11, "+
				"M.Data_12 Mdata_12,M.Data_13 Mdata_13,M.Data_14 Mdata_14,M.Data_15 Mdata_15, "+
				"M.Data_16 Mdata_16,M.Data_17 Mdata_17,M.Data_18 Mdata_18,M.Data_19 Mdata_19, "+
				"M.Data_20 Mdata_20,M.Data_21 Mdata_21,M.Data_22 Mdata_22,M.Data_23 Mdata_23, "+
				"M.Data_24 Mdata_24,M.Data_25 Mdata_25,M.Data_26 Mdata_26,M.Data_27 Mdata_27, "+
				"M.Data_28 Mdata_28,M.Data_29 Mdata_29,M.Data_30 Mdata_30,M.Data_31 Mdata_31, "+
				"M.Data_32 Mdata_32,M.Data_33 Mdata_33,M.Data_34 Mdata_34,M.Data_35 Mdata_35, "+
				"M.Data_36 Mdata_36,M.Data_37 Mdata_37,M.Data_38 Mdata_38,M.Data_39 Mdata_39, "+
				"M.Data_40 Mdata_40,M.Data_41 Mdata_41,M.Data_42 Mdata_42,M.Data_43 Mdata_43, "+
				"M.Data_44 Mdata_44,M.Data_45 Mdata_45,M.Data_46 Mdata_46,M.Data_47 Mdata_47, "+
				"M.Data_48 Mdata_48,M.Data_49 Mdata_49,M.Data_50 Mdata_50,M.Data_51 Mdata_51, "+
				"M.Data_52 Mdata_52,M.Data_53 Mdata_53,M.Data_54 Mdata_54,M.Data_55 Mdata_55, "+
				"M.Data_56 Mdata_56,M.Data_57 Mdata_57,M.Data_58 Mdata_58,M.Data_59 Mdata_59, "+
				"L.Data_0 Ldata_0,L.Data_1 Ldata_1,L.Data_2 Ldata_2,L.Data_3 Ldata_3, "+
				"L.Data_4 Ldata_4,L.Data_5 Ldata_5,L.Data_6 Ldata_6,L.Data_7 Ldata_7, "+
				"L.Data_8 Ldata_8,L.Data_9 Ldata_9,L.Data_10 Ldata_10,L.Data_11 Ldata_11, "+
				"L.Data_12 Ldata_12,L.Data_13 Ldata_13,L.Data_14 Ldata_14,L.Data_15 Ldata_15, "+
				"L.Data_16 Ldata_16,L.Data_17 Ldata_17,L.Data_18 Ldata_18,L.Data_19 Ldata_19, "+
				"L.Data_20 Ldata_20,L.Data_21 Ldata_21,L.Data_22 Ldata_22,L.Data_23 Ldata_23, "+
				"L.Data_24 Ldata_24,L.Data_25 Ldata_25,L.Data_26 Ldata_26,L.Data_27 Ldata_27, "+
				"L.Data_28 Ldata_28,L.Data_29 Ldata_29,L.Data_30 Ldata_30,L.Data_31 Ldata_31, "+
				"L.Data_32 Ldata_32,L.Data_33 Ldata_33,L.Data_34 Ldata_34,L.Data_35 Ldata_35, "+
				"L.Data_36 Ldata_36,L.Data_37 Ldata_37,L.Data_38 Ldata_38,L.Data_39 Ldata_39, "+
				"L.Data_40 Ldata_40,L.Data_41 Ldata_41,L.Data_42 Ldata_42,L.Data_43 Ldata_43, "+
				"L.Data_44 Ldata_44,L.Data_45 Ldata_45,L.Data_46 Ldata_46,L.Data_47 Ldata_47, "+
				"L.Data_48 Ldata_48,L.Data_49 Ldata_49,L.Data_50 Ldata_50,L.Data_51 Ldata_51, "+
				"L.Data_52 Ldata_52,L.Data_53 Ldata_53,L.Data_54 Ldata_54,L.Data_55 Ldata_55, "+
				"L.Data_56 Ldata_56,L.Data_57 Ldata_57,L.Data_58 Ldata_58,L.Data_59 Ldata_59 "+
				"FROM ( "+
						"SELECT * FROM EMS.MANALOG_DATA_SCADA  "+
						"WHERE TABLE_NO='417' AND FIELD_ID ='70'  "+ 
						"AND HOURS="+strHour+" and code like '%-h') H "+
						" JOIN (SELECT * FROM EMS.MANALOG_DATA_SCADA "+
						"WHERE TABLE_NO='417' AND FIELD_ID ='70' "+
							"AND HOURS="+strHour+" and code like '%-m') M "+
							"ON LEFT(H.CODE,locate('-',H.CODE,1)-1) = LEFT(M.CODE,locate('-',M.CODE,1)-1) "+
							" JOIN (SELECT * FROM EMS.MANALOG_DATA_SCADA WHERE TABLE_NO='417' "+
							" AND FIELD_ID ='70'  AND HOURS="+strHour +" and code like '%-l') L "+
							"ON LEFT(H.CODE,locate('-',H.CODE,1)-1) = LEFT(L.CODE,locate('-',L.CODE,1)-1)";
		ResultSet set = T_con.createStatement().executeQuery(sqltext);

		Statement stmt =  T_con.createStatement();	
	
		boolean bh_falg =false,bm_falg=false,bl_falg=false;
		boolean th_falg =false,tm_falg=false,tl_falg =false;
		int count = 0;
		String  temp = null;
		
		while(set.next()){
			//用于统计需要计算的数据条数
			count++;
			
			//分为高中低三端进行分段计算
			
			//Hdata_0 ~ Hdata_59
			
			//判断从Hdata_0 ~ Hdata_59之间发生从大于5到小于  小于5到大于5之间的越界情况
			temp = set.getString("HData_0");
			if(Integer.parseInt(temp) < 5){	
				th_falg = false;
			}else{
				th_falg = true;
			}
			bh_falg = th_falg;
			for(int i =1;i<60;i++){
				if(bh_falg){
					if(Integer.parseInt(set.getString("HData_"+i)) < 5){
						bh_falg = false;						
					}
				}else{
					if(Integer.parseInt(set.getString("HData_"+i)) > 5){
						bh_falg = true;
					}
				}
				//如果发生越界情况做一次事件记录
				if( bh_falg != th_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					int mq = (Integer.parseInt(set.getString("MData_"+(i-1)))  < 5 )?0:1;
					int mh = (Integer.parseInt(set.getString("MData_"+(i)))  < 5 )?0:1;
					int lq =(Integer.parseInt(set.getString("LData_"+(i-1)))  < 5 )?0:1;
					int lh = (Integer.parseInt(set.getString("LData_"+(i)))  < 5 )?0:1;
					String sql = null;
					if(bh_falg){
						th_falg = true;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+ "1,0,"+mq+","+mh+","+lq+","+lh+")";
							
					}else{
						th_falg = false;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+ "0,1,"+mq+","+mh+","+lq+","+lh+")";
					}
					insert.add(sql);
					stmt.addBatch(sql);
				}
			}
			
			

			
			//判断从Mdata_0 ~ Mdata_59之间发生从大于5到小于  小于5到大于5之间的越界情况

			temp = set.getString("MData_0");
			if(Integer.parseInt(temp) < 5){	
				th_falg = false;
			}else{
				th_falg = true;
			}
			bh_falg = th_falg;
			for(int i =1;i<60;i++){
				if(bh_falg){
					if(Integer.parseInt(set.getString("MData_"+i)) < 5){
						bh_falg = false;						
					}
				}else{
					if(Integer.parseInt(set.getString("MData_"+i)) > 5){
						bh_falg = true;
					}
				}
				//如果发生越界情况做一次事件记录
				if( bh_falg != th_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					int hq = (Integer.parseInt(set.getString("HData_"+(i-1)))  < 5 )?0:1;
					int hh = (Integer.parseInt(set.getString("HData_"+(i)))  < 5 )?0:1;
					int lq =(Integer.parseInt(set.getString("LData_"+(i-1)))  < 5 )?0:1;
					int lh = (Integer.parseInt(set.getString("LData_"+(i)))  < 5 )?0:1;
					String sql = null;
					if(bh_falg){
						th_falg = true;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+hq+","+hh+",1,0,"+lq+","+lh+")";
							
					}else{
						th_falg = false;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+hq+","+hh+",0,1,"+lq+","+lh+")";
					}
					insert.add(sql);
					stmt.addBatch(sql);
				}
			}			
			
			
			//判断从Ldata_0 ~ Ldata_59之间发生从大于5到小于  小于5到大于5之间的越界情况
			
			temp = set.getString("LData_0");
			if(Integer.parseInt(temp) < 5){	
				th_falg = false;
			}else{
				th_falg = true;
			}
			bh_falg = th_falg;
			for(int i =1;i<60;i++){
				if(bh_falg){
					if(Integer.parseInt(set.getString("LData_"+i)) < 5){
						bh_falg = false;						
					}
				}else{
					if(Integer.parseInt(set.getString("LData_"+i)) > 5){
						bh_falg = true;
					}
				}
				//如果发生越界情况做一次事件记录
				if( bh_falg != th_falg){
					String sM =null;
					if(i<10){
						sM = "0"+i;
					}else{
						sM =i+"";
					}
					int hq = (Integer.parseInt(set.getString("HData_"+(i-1)))  < 5 )?0:1;
					int hh = (Integer.parseInt(set.getString("HData_"+(i)))  < 5 )?0:1;
					int mq =(Integer.parseInt(set.getString("MData_"+(i-1)))  < 5 )?0:1;
					int mh = (Integer.parseInt(set.getString("MData_"+(i)))  < 5 )?0:1;
					String sql = null;
					if(bh_falg){
						th_falg = true;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+hq+","+hh+","+mq+","+mh+",1,0)";
							
					}else{
						th_falg = false;
						sql =  "INSERT INTO dnzlZHILIANG.HANDLERESULT_ZT_ZB VALUES("+
								"dnzlZHILIANG.SEQ_RECORDID.NEXTVAL,'41301056630101000','青海省电力公司',"
								+ "\'"+set.getString("CODE")+"\',"
								+ "\'"+set.getString("NAME")+"\',"
								+"to_date(\'"+strTime+" "+strHour+":"+sM+":00\','yyyyMMdd HH:mi:ss')"+",0,0,0,0,0,"
								+hq+","+hh+","+mq+","+mh+",0,1)";
					}
					insert.add(sql);
					stmt.addBatch(sql);
				}
			}			
		}

		int[] res = null;
		try{
			res = stmt.executeBatch();
			T_con.commit();
		}catch(Exception e){
			e.printStackTrace();
			T_con.rollback();
		}finally{
			stmt.close();
		}
		System.out.println("主变状态切换:需要计算的数据条数\t\t\t"+count+"\t状态数据"+res.length);	
	}
	
	public void Extract(){
		try {
			runData();
			Thread.sleep(1000 * 60);
			Deal_breaker();
			Thread.sleep(1000 * 30);
			Deal_busbarsection();
			Thread.sleep(1000 * 30);
			Deal_aclineend();
			Thread.sleep(1000 * 30);
			Deal_transformerwinding();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		try {
			F_con.close();
			T_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			F_con = null;
			T_con = null;
		}
	}

	public static void main(String[] args) throws SQLException{
		ExtractAllData_ZT obj = new ExtractAllData_ZT();
		obj.initdb();
		obj.Extract();
		obj.destroy();
	}
}