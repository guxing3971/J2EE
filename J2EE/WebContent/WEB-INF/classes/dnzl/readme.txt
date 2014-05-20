数据源配置:
	2013-7-20 17:50
	操他大爷到今天位置数据库的菜确定下来.干 gov
	
	数据来源: 
		192.168.30.150  DM6.0 HISDB HISDB
	本系统:
		10.215.181.25  DM6.2 INTERFACE/INTERFACE
		
	以下以Tomcat7.0为web容器进行部属
		■ 在Tomcat服务器上conf/context.xml中的<Context></Context>标签中
		<Resource 
	       name="CC5000" 
	       auth="Container" 
	       type="javax.sql.DataSource"
	       maxActive="100" 
	       maxIdle="30" 
	       maxWait="10000"
	       username="HISDB" 
	       password="HISDB" 
	       driverClassName="dm.jdbc.driver.DmDriver"
	       url="jdbc:dm://192.168.30.150:12345/HISDB"
		/>
		<Resource 
	       name="DNZL" 
	       auth="Container" 
	       type="javax.sql.DataSource"
	       maxActive="100" 
	       maxIdle="30" 
	       maxWait="10000"
	       username="INTERFACE" 
	       password="INTERFACE" 
	       driverClassName="dm.jdbc.driver.DmDriver"
	       url="jdbc:dm://127.0.0.1:12345/DNZL"
		/>		
		
		■
		在web.xml中加入
		<resource-ref>
	      <description>DB Connection</description>
	      <res-ref-name>CC5000</res-ref-name>
	      <res-type>javax.sql.DataSource</res-type>
	      <res-auth>Container</res-auth>
  		</resource-ref>
  		<resource-ref>
	      <description>DB Connection</description>
	      <res-ref-name>DNZL</res-ref-name>
	      <res-type>javax.sql.DataSource</res-type>
	      <res-auth>Container</res-auth>
  		</resource-ref>
  		
  		
		■
	CIM-OMS写入
		电网频率				http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_01_W
		母线电压				http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_02_W
		母线状态切换数据		http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_03_W
		线路状态切换数据		http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_04_W
		变压器状态切换数据		http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_05_W
		母线					http://sjzy.sgcc.com.cn/cis/SMS/OMS/BusbarLine_W
		母线电压统计值			http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_07_W
		电网频率统计值			http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_06_W
		断路器状态切换数据		http://sjzy.sgcc.com.cn/cis/SMS/OMS/Breaker_W
		断路器				http://sjzy.sgcc.com.cn/cis/SMS/OMS/Breaker_01_W
		架空线路设备			http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_01_W
		电缆线路设备			http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_02_W
		变压器				http://sjzy.sgcc.com.cn/cis/SMS/OMS/PowerTransformer_W
		
/**************************************************************************
 * 	@time:2013-7-30 09:23
 *  @summary
 *		设备的表有:
 *				断路器		breaker
 *				母线:		busbarsection
 *				线路:		aclinesegment
 *							aclineend
 *				变压器:		powertransformer
 *							transformerwinding
 *				时时数据表: 	HISDB.MANALOG_DATA_SCADA_yyyyMMdd
 *
 *	@@计算统计电能质量相关的四类设备的停运状态信息
 *		线路	母线	断路器		主变
 *	主要操作的表
 *		ems.MANALOG_DATA_SCADA
 *		该表中有四个主要字段
 *				table_no对应一个数字通过数字对应一张表
 *				field_id对应上面表中的一个列
 *				area区域表
 *				key记录号
 *
 *		另外几张表分别为:
 *			ems.ACLINEEND			线路端点表
 *			ems.ACLINESEGMENT		线路表
 *			ems.BREAKER				断路器表
 *			ems.BUSBARSECTION		母线表
 *			ems.POWERTRANSFORMER	主变表
 *			ems.TRANSFORMERWINDING	主变绕组表
 *		其中的对应关系为:
 *				407  -> 断路器表
 * 					407:50  ->p  	有功值
 * 					407:60  ->q 	无功值
 * 					407:70  ->i 	电流值  * 
 *				410	 -> 母线表
 *					410:100	v_c_value 		C相电压幅值
 *					410:30	->v 			线电压     *
 *					410:50	->f 			频率
 *					410:60	->v_value_2 	线电压2
 *					410:70	->v_value_3 	线电压3
 *					410:80	->v_a_value 	A相电压幅值
 *					410:90	->v_b_value 	B相电压幅值
 *				414	 -> 交流线段表
 *				415	 -> 交流线段端点表
 *					415:30	->p		有功值
 *					415:40	->q 	无功值
 *					415:50	->i 	电流值 *
 *					415:60	->v 	电压值
 *				416	 -> 变压器表
 *				417	 -> 变压器绕组表
 *					417:50	->p		有功值
 *					417:60	->q		无功值
 *					417:70	->i		电流值 *
 *					417:80	->tap 	分接头位置			
 *
 *	select count(*) from ems.breaker;   			3328
 *	select count(*) from ems.busbarsection; 		895
 *	select count(*) from ems.aclinesegment; 		526
 *	select count(*) from ems.aclineend;    			1042
 *	select count(*) from ems.powertransformer; 		288
 *	select count(*) from ems.transformerwinding; 	665
 ***************************************************************************/
 
 
 
 
