/*********************************************************************************
 * 报表：
 * 功能：
 * table:
 ********************************************************************************/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_ACCIDENTSTAT" AT "QHOMS"
(
	/*请填入参数, 参数的格式为<参数名>[<参数模式>]<参数类型> [:=|DEFAULT <表达式>] */
	para_yearmonth	IN VARCHAR(10)
)
AS
	/*变量说明部分*/
	var_id	varchar(10);
	var_delcore NUMBER(16,0);
	var_adscore NUMBER(16,0);
	var_score NUMBER(16,0);
BEGIN
	
	/*定义游标*/
	declare
		cursor rowset is SELECT id,ISNULL(delcore,0),ISNULL(adjuestscore,0) 
			FROM ASSESS.T_ASSESS_ACCIDENTSTAT
				WHERE yearmonth=para_yearmonth;

	begin
	/*执行体*/    
	open rowset;        
	loop           --提取一行数据到c_row          
	   fetch rowset into var_id,var_delcore,var_adscore;           --判读是否提取到值，没取到值就退出 
	   	 exit when rowset%notfound;
	   	 	SET var_score = var_delcore + var_adscore;  
	    	UPDATE ASSESS.T_ASSESS_ACCIDENTSTAT
	    		SET score = var_score
	    			WHERE id = var_id;
	   	end loop;       --关闭游标     
	 close rowset;
	end;	
	
END;
/*********************************************************************************
 * 报表：
 * 功能：
 * table:
 ********************************************************************************/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_LEADASSESSALLDUTY" AT "QHOMS"
(
	/*请填入参数, 参数的格式为<参数名>[<参数模式>]<参数类型> [:=|DEFAULT <表达式>] */
	para_yearmonth	IN VARCHAR(10)
)
AS
	/*变量说明部分*/
	var_id	varchar(10);
	var_score NUMBER(16,0);
BEGIN
	
	/*定义游标*/
	declare
		cursor rowset is SELECT id,decode(combineassess,'g',3,'u',0,'b',-3) from ASSESS.T_ASSESS_LEADASSESSALLDUTY
				WHERE yearmonth=para_yearmonth;

	begin
	/*执行体*/    
	open rowset;        
	loop           --提取一行数据到c_row          
	   fetch rowset into var_id,var_score;           --判读是否提取到值，没取到值就退出 
	   	 exit when rowset%notfound;
	    	UPDATE ASSESS.T_ASSESS_LEADASSESSALLDUTY
	    		SET assessscore = var_score
	    			WHERE id = var_id;
	   	end loop;       --关闭游标     
	 close rowset;
	end;	
	
END;
/*********************************************************************************
 * 报表：
 * 功能：
 * table:
 ********************************************************************************/
 CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_MONCENTER" AT "QHOMS"
(
	/*请填入参数, 参数的格式为<参数名>[<参数模式>]<参数类型> [:=|DEFAULT <表达式>] */
	para_yearmonth	IN VARCHAR(10)
)
/*指明是否加密该存储过程的定义, 此处为可选*/
/*WITH ENCRYPTION*/
AS
	/*变量说明部分*/
	var_id	varchar(10);
	var_asscore NUMBER(16,0);
	var_adscore NUMBER(16,0);
	var_wkscore NUMBER(16,0);
BEGIN
	declare
		cursor rowset is SELECT id,ISNULL(assessscore,0),ISNULL(adjuestscore,0) 
			FROM ASSESS.T_ASSESS_MONCENTERWORK
			WHERE yearmonth = para_yearmonth;
			
	begin
	/*执行体*/    
	open rowset;        
	loop           --提取一行数据到c_row          
	   fetch rowset into var_id,var_asscore,var_adscore;           --判读是否提取到值，没取到值就退出 
	   	 exit when rowset%notfound;
	   	 	SET var_wkscore = var_asscore + var_adscore;  
	    	UPDATE ASSESS.T_ASSESS_MONCENTERWORK
	    		SET workscore = var_wkscore
	    			WHERE id = var_id;
	   	end loop;       --关闭游标     
	 close rowset;
	end;	
END;




/*********************************************************************************
 * 报表：
 * 功能：
 * table:
 ********************************************************************************/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_SAFESUPERVISE" AT "QHOMS"
(
	/*请填入参数, 参数的格式为<参数名>[<参数模式>]<参数类型> [:=|DEFAULT <表达式>] */
	para_yearmonth	IN VARCHAR(10)
)
AS
	/*变量说明部分*/
	var_id	varchar(10);
	var_sascore NUMBER(16,0);
	var_asscore NUMBER(16,0);
	var_adscore NUMBER(16,0);

	
BEGIN
	
	/*定义游标*/
	declare
		cursor rowset is SELECT id,ISNULL(assessscore,0),ISNULL(adjuestscore,0) FROM ASSESS.T_ASSESS_SAFESUPERVISE
			WHERE yearmonth=para_yearmonth;

	begin
	/*执行体*/    
	open rowset;        
	loop           --提取一行数据到c_row          
	   fetch rowset into var_id,var_asscore,var_adscore;           --判读是否提取到值，没取到值就退出 
	   	 exit when rowset%notfound;
	   	 	SET var_sascore = var_asscore + var_adscore;  
	    	UPDATE ASSESS.T_ASSESS_SAFESUPERVISE
	    		SET safescore = var_sascore
	    			WHERE id = var_id;
	   	end loop;       --关闭游标     
	 close rowset;
end;	
	
END;



/*********************************************************************************
 * 报表：表4-1：XX年员工综合评价表（各项均为100分制）
 * 功能：计算 加权得分
 * table:ASSESS.T_ASSESS_YEARSTAFFCOBSTATDT
 ********************************************************************************/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_YearsCOBSATDT" AT "QHOMS"
(
	para_year	IN VARCHAR(10)
)
AS
	var_id		varchar(10);
	var_lab		NUMBER(16,0);		/*劳动纪律*/
	var_att		NUMBER(16,0);		/*工作态度*/
	var_abi		NUMBER(16,0);		/*工作能力*/
	var_inn		NUMBER(16,0);		/*创新精神*/
	var_add		NUMBER(16,0);

BEGIN
declare
	cursor rowset is SELECT id, labourscore, attitudescore, abilityscore, innovatescore
		FROM QHOMS.ASSESS.T_ASSESS_YEARSTAFFCOBSTATDT
		WHERE reportyear=para_year;

	begin
   
	open rowset;        
	loop
	   	fetch rowset into var_id,var_lab,var_att,var_abi,var_inn;
	   	exit when rowset%notfound;

	   		/*加权得分=劳动纪律得分×0.2＋工作态度得分×0.2＋创新精神得分×0.2＋工作能力得分×0.4。*/
	   		set var_add = 0.2 * (var_lab + var_inn + var_att) + 0.4*(var_abi);
	   		UPDATE	QHOMS.ASSESS.T_ASSESS_YEARSTAFFCOBSTATDT
	   			SET addscore = var_add
	   			WHERE id = var_id;
	   	end loop;   
	 close rowset;
	end;	
END;



/*********************************************************************************
 * 报表：表3：XX年员工关键绩效指标考核表
 * 功能：关键绩效指标得分
 * table：ASSESS.T_ASSESS_YEARKEYINDEX
 ********************************************************************************/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_YEARKEYINDEX" AT "QHOMS"
(
	para_year	IN VARCHAR(10)
)
AS
	var_id		VARCHAR(10);
	var_asscore	NUMBER(16,0);		/*考核分值*/
	var_adscore NUMBER(16,0);		/*调整分值*/
	var_sascore NUMBER(16,0);		/*关键绩效指标得分*/
BEGIN
declare
	cursor rowset is SELECT id,assessscore,adjuestscore
		FROM QHOMS.ASSESS.T_ASSESS_YEARKEYINDEX
		WHERE reportyear = para_year;
		

	begin
   
	open rowset;        
	loop

	   	fetch rowset into var_id,var_asscore,var_adscore;
	   	exit when rowset%notfound;

	   		/*关键绩效指标得分=100-考核分值+调整分值*/
	   		SET var_sascore = 100 - var_asscore + var_adscore;
	   		UPDATE	ASSESS.T_ASSESS_YEARKEYINDEX
	   			SET safescore = var_sascore
	   			WHERE id = var_id;
	   	end loop;   
	 close rowset;
	end;	
END;


/*********************************************************************************
 * 报表：表5：XX年员工年度业绩考核表
 * 功能：计算员工年度业绩考核得分
 * table：insert :ASSESS.T_ASSESS_YEARSTAFSTAT
 * 		  select :ASSESS.T_ASSESS_ACHIEVESTAT
 * 		  select :ASSESS.T_ASSESS_YEARIMPTASKSTAT
 * 		  select :ASSESS.T_ASSESS_YEARKEYINDEX
 * 		  select :ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL
 *        select :ASSESS.T_ASSESS_WORKUSERINFO
 ********************************************************************************/
 /*
CREATE TABLE QHOMS.ASSESS.T_ASSESS_YEARSTAFSTAT(
	id VARCHAR(10),
	reportyear VARCHAR(10),
	seq VARCHAR(10),
	usercode VARCHAR(20),
	username VARCHAR(50),
	deptid VARCHAR(50),
	station VARCHAR(20),
	monthscore NUMBER(16,2),
	imworkscore NUMBER(16,2),
	keyindexscore NUMBER(16,2),
	comscore NUMBER(16,2),
	sumscore NUMBER(16,2),
	equscore NUMBER(16,2),
PRIMARY KEY(id))
STORAGE( INITIAL 1 , NEXT 1 , MINEXTENTS 1 , on PRIMARY, FILLFACTOR 0 ) ;
*/
CREATE  PROCEDURE "ASSESS"."P_AssessCalculate_YEARSTAF" AT "QHOMS"
(
	para_year	IN VARCHAR(10)
)
AS
	var_usercode	varchar(20);
	var_username	varchar(50);
	var_deptid		varchar(50);
	var_station		varchar(20);
	var_monscore	NUMBER(16,2);
	var_imworkscore	NUMBER(16,2);
	var_keyscore	NUMBER(16,2);
	var_comscore	NUMBER(16,2);
	var_sumscore	NUMBER(16,2);
	var_equscore	NUMBER(16,2);
	var_name		VARCHAR(80);
	var_dd_temp		NUMBER(16,2);
	var_jk_temp		NUMBER(16,2);
	var_ry_temp		NUMBER(16,2);
	var_xs			NUMBER(16,5);
	var_sum 		NUMBER(16,2);
	var_countuser   NUMBER(16,0);
	var_countuser_dd NUMBER(16,0);
	var_countuser_jk NUMBER(16,0);
	var_temp		NUMBER(16,0);
	var_sum_dd		NUMBER(16,2);
	var_sum_jk		NUMBER(16,2);
	var_xs_dd		NUMBER(16,5);
	var_xs_jk		NUMBER(16,5);
	var_user_flag	VARCHAR(10);
BEGIN

	begin
	/*根据年份判断是否已经计算过该年度的数据*/
	SELECT count(*) into var_temp FROM ASSESS.T_ASSESS_YEARSTAFSTAT WHERE reportyear=para_year;
	IF var_temp  > 0 THEN
		/*如果计算了怎打印调语句后退出*/
		PRINT 'this PROCEDURE is called';
	ELSE
		/*如何没有计算，则
			先查询需要要的数据并，向表中插入数据
			然后在计算等效分
		*/
		begin
		declare
			cursor rowset is SELECT u.userid,u.username,u.deptid,u.station,
				ISNULL((select Avg(score) from ASSESS.T_ASSESS_ACHIEVESTAT where usercode=u.userid and yearmonth  like '%'+para_year+'%'),0) monthscore,
				ISNULL((select safescore from ASSESS.T_ASSESS_YEARIMPTASKSTAT where usercode = u.userid and reportyear  like '%'+para_year+'%' ),0) imworkscore,
				ISNULL((select safescore from ASSESS.T_ASSESS_YEARKEYINDEX where usercode = u.userid and reportyear  like '%'+para_year+'%' ),0) keyIndexscore,
				ISNULL((select sumscore  from ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL where usercode =u.userid and reportyear  like '%'+para_year+'%' ),0) comscore
			FROM ASSESS.T_ASSESS_WORKUSERINFO u;
		begin
		open  rowset;
			loop
			fetch rowset into var_usercode,var_username,var_deptid,var_station,
				var_monscore,var_imworkscore,var_keyscore,var_comscore;
		   	exit when rowset%notfound;
		   	/*计算总分*/
		   	/*总得分=月度业绩考核平均分×0.8+重点工作任务得分×0.08+关键绩效指标得分×0.08+综合评价得分×0.04*/
		   		set var_sumscore = 0.8 * var_monscore + 0.08 * (var_imworkscore + var_keyscore) + 0.04 * var_comscore;
		   		INSERT INTO ASSESS.T_ASSESS_YEARSTAFSTAT(id,reportyear,seq,usercode,username,deptid,station,
						monthscore,imworkscore,keyindexscore,comscore,sumscore,equscore)
		   			VALUES(ASSESS.T_ASSESS_YEARSTAFSTAT_SN.nextval,para_year,0,
		   				var_usercode,var_username,var_deptid,var_station,
		   				var_monscore,var_imworkscore,var_keyscore,var_comscore,var_sumscore,0);
		   	end loop;	
		close rowset;
		end;
		end;
		/*计算等效分*/
		/*等效分计算*/
	   		/*
	   		员工等效分，为按照平均100分归算后的分值本处按照
	   			调度员（含处长、副处长、调度安全员）、
	   			监控员（含处长、副处长、监控安全员）、
	   			其他处室人员分别归算

	   			调度员归算系数a=∑（调度员各员工总得分）÷调度员总人数÷100
	   			监控员归算系数b=∑（监控员各员工总得分）÷监控员总人数÷100
      			其他处室归算系数b=∑（其他处室各员工总得分）÷其他处室总人数÷100
      			人员等效分=个人总得分÷相应归算系数a或b或c。
	   		*/ 
	   	declare
		/*用于更新等效分*/
		cursor  deptset is select deptid FROM ASSESS.T_ASSESS_YEARSTAFSTAT group by deptid;
		cursor  userset is select Y.usercode,Y.sumscore,U.disorequflag 
			FROM ASSESS.T_ASSESS_YEARSTAFSTAT Y
			JOIN ASSESS.T_ASSESS_WORKUSERINFO U
			ON Y.usercode = U.userid;
		begin
		open deptset;
		open userset;
			loop
				fetch deptset into var_deptid;
   				exit when deptset%notfound;
   					/*根据部门计算如果是调度控制处*/

   						/*此处需要区分调度员和监控员*/
   						/*根据ASSESS.T_ASSESS_WORKUSERINFO表中的disorequflag字段EQU调度DIS监控*/
   					IF var_deptid ='1bd965db-c208-4607-8527-2e3f9d96392d' THEN
   						begin
   						/*调度*/
   						select sum(sumscore) into var_sum_jk FROM ASSESS.T_ASSESS_YEARSTAFSTAT Y,ASSESS.T_ASSESS_WORKUSERINFO U
							where Y.deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' and u.disorequflag = 'EQU';
						SELECT count(*) into var_countuser_jk FROM ASSESS.T_ASSESS_YEARSTAFSTAT Y,ASSESS.T_ASSESS_WORKUSERINFO U
							where Y.deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' and u.disorequflag ='EQU';
						SET var_xs_dd = var_sum_jk / var_countuser_jk / 100;

						/*监控*/
   						select sum(sumscore) into var_sum_dd FROM ASSESS.T_ASSESS_YEARSTAFSTAT Y,ASSESS.T_ASSESS_WORKUSERINFO U
							where Y.deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' and u.disorequflag = 'DIS';
						SELECT count(*) into var_countuser_dd FROM ASSESS.T_ASSESS_YEARSTAFSTAT Y,ASSESS.T_ASSESS_WORKUSERINFO U
							where Y.deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' and u.disorequflag ='DIS';
						SET var_xs_jk = var_sum_dd / var_countuser_dd / 100;

						loop
   							fetch userset into var_usercode,var_sumscore,var_user_flag;
   							exit when userset%notfound;
   							IF var_user_flag ='EQU' THEN
   								UPDATE ASSESS.T_ASSESS_YEARSTAFSTAT
   									set equscore = var_sumscore / var_xs_dd
   								WHERE usercode = var_usercode;
   							ELSE
   								UPDATE ASSESS.T_ASSESS_YEARSTAFSTAT
   									set equscore = var_sumscore / var_xs_jk
   								WHERE usercode = var_usercode;
   							END IF;
   						end loop;
   						end;
   					/*如果不是调度的则*/
					ELSE
						begin
						select sum(sumscore) into var_sum from ASSESS.T_ASSESS_YEARSTAFSTAT 
							where deptid = var_deptid;
						SELECT count(*) into var_countuser FROM ASSESS.T_ASSESS_YEARSTAFSTAT 
							where deptid = var_deptid;
						SET var_xs = var_sum /var_countuser / 100;
						loop
   							fetch userset into var_usercode,var_sumscore,var_user_flag;
   							exit when userset%notfound;
   							UPDATE ASSESS.T_ASSESS_YEARSTAFSTAT
   								set equscore = var_sumscore / var_xs
   							WHERE usercode = var_usercode;
   						end loop;
   						end;
					END IF;
   			end loop;
		close userset;
		close deptset;
		end;
	END IF;
	end;
END;
/*********************************************************************************
 * 报表：表4-3：XX年XX月领导综合评价计分表
 ********************************************************************************/

CREATE  FUNCTION "ASSESS"."GET_MONTH_SCORE" AT "QHOMS"
(para_yearmonth in varchar(10),para_deptid in varchar(50),para_deal in varchar(10))
return NUMBER
AS
	temsql varchar(1000);
	res	   NUMBER(16,0);
BEGIN
	temsql := 'SELECT a.assessscore FROM ASSESS.T_ASSESS_LEADASSESSALLDUTY a where a.yearmonth = '''||para_yearmonth||''' and a.dealman ='''||para_deal||''' and a.deptid ='''|| para_deptid||'''';
	print temsql;
	execute immediate temsql into res;
	return res;
end;


CREATE  FUNCTION "ASSESS"."GET_MONTH_SCORE_1" AT "QHOMS"
(para_yearmonth in varchar(10),para_userid in varchar(50),para_deal in varchar(10))
return NUMBER
AS
	temsql varchar(1000);
	res	   NUMBER(16,0);
BEGIN
	temsql := 'SELECT a.assessscore FROM ASSESS.T_ASSESS_LEADASSESSDISPDUTY a where a.yearmonth = '''||para_yearmonth||''' and a.dealman ='''||para_deal||''' and a.usercode ='''|| para_userid||'''';
	print temsql;
	execute immediate temsql into res;
	return res;
end;
/***********************************************************************
 * report:月领导综合评价计分表
 * function: 统计生成更新月领导综合评价计分表
 * table: 	T_ASSESS_LEADASSESSSTATSCORE
 *        	T_ASSESS_LEADASSESSDISPDUTY
 *			T_ASSESS_LEADASSESSALLDUTY
 ***********************************************************************/
CREATE  PROCEDURE "ASSESS"."P_ASSESSCALCULATE_LEADDISDUTY" AT "qhoms"
(
	para_yearmonth	IN VARCHAR(10)
)		
AS
	var_dir NUMBER(16,0);
	var_cle NUMBER(16,0);
	var_dep NUMBER(16,0);
	var_dept NUMBER(16,0);
	var_eng NUMBER(16,0);
	var_dut	NUMBER(16,0);
	var_deput NUMBER(16,0);
	var_deputy NUMBER(16,0);
	var_adjuest NUMBER(16,0);
	var_safescore NUMBER(16,0);
	var_userid	varchar(20);
	var_deptid varchar(50);
	var_station varchar(10);
	var_temp NUMBER(16,0);
BEGIN
	/*判断*/
	SELECT count(*) into var_temp FROM ASSESS.T_ASSESS_LEADASSESSSTATSCORE WHERE yearmonth=para_yearmonth;
	IF var_temp  > 0 THEN
		BEGIN
		print 'call  for update';
		declare 
			cursor updset is select usercode,deptid,directorscore,clerkscore,deponedirectorscore,deptwodirectorscore,
			engineerscore,dutyscore,deputyonescore,deputytwoscore,adjuestscore
			fROM ASSESS.T_ASSESS_LEADASSESSSTATSCORE WHERE yearmonth=para_yearmonth;
		begin 
		open updset;
			loop
			fetch updset into var_userid,var_deptid,var_dir,var_cle,var_dep,var_dept,var_eng,var_dut,var_deput,var_deputy,var_adjuest;
				exit when updset%notfound;
				/*如果是调度控制处*/
				IF var_deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' THEN
					BEGIN
					set var_safescore = 0.6*(var_dir+var_cle+var_dep+var_dept+var_eng) + 0.2*(var_dut)+0.1*(var_deput + var_deputy) + ISNULL(var_adjuest,0);
					UPDATE ASSESS.T_ASSESS_LEADASSESSSTATSCORE
						set safescore = var_safescore
						WHERE usercode=var_userid;
					END;
					
				ELSE
					BEGIN
					set var_safescore = 0.4 * (var_dir ) + 0.15*(var_cle+var_dep+var_dept+var_eng)+var_adjuest;
					UPDATE ASSESS.T_ASSESS_LEADASSESSSTATSCORE
						set safescore = var_safescore
						WHERE usercode=var_userid;
					END;
				END IF;
			end loop;
		close updset;
		end;
		END;
	ELSE 
		/*熟悉插入用户某月的信息记录*/

		declare 
			cursor userset is select u.userid,u.deptid,u.station from ASSESS.T_ASSESS_WORKUSERINFO u;
		begin
		open userset;        
		loop

		   	fetch userset into var_userid,var_deptid,var_station;
		   	exit when userset%notfound;
				INSERT INTO ASSESS.T_ASSESS_LEADASSESSSTATSCORE(id,yearmonth,
				seq,usercode,deptid,station)VALUES(T_ASSESS_LEADASSESSSTATSCORE_SN.nextval,
				para_yearmonth,0,var_userid,var_deptid,var_station);
		 end loop;   
		 close userset;
		end;

		begin
		declare
		cursor rowset is select u.usercode,u.deptid,u.station 
			From ASSESS.T_ASSESS_LEADASSESSSTATSCORE u;
		begin
		open rowset;        
		loop

		fetch rowset into var_userid,var_deptid,var_station;
		exit when rowset%notfound;	
		
		UPDATE ASSESS.T_ASSESS_LEADASSESSSTATSCORE
			SET directorscore=ISNULL(get_month_score(para_yearmonth,var_deptid,'CW'),0),
			 	clerkscore=ISNULL(get_month_score(para_yearmonth,var_deptid,'FG1'),0),
				deponedirectorscore =ISNULL(get_month_score(para_yearmonth,var_deptid,'FG2'),0),
				deptwodirectorscore =ISNULL(get_month_score(para_yearmonth,var_deptid,'FG3'),0),
				engineerscore =ISNULL(get_month_score(para_yearmonth,var_deptid,'FG4'),0),
				dutyscore = ISNULL(get_month_score_1(para_yearmonth,var_userid,'CZ'),0),
				deputyonescore = ISNULL(get_month_score_1(para_yearmonth,var_userid,'FC'),0),
				deputytwoscore = ISNULL(get_month_score_1(para_yearmonth,var_userid,'FC'),0)
			 where usercode=var_userid 
			 and yearmonth=para_yearmonth;		
		end loop;
		close rowset;
		end;
		end;
		
		/*计算总得分*/	
		declare 
			cursor updateset is select usercode,deptid,directorscore,clerkscore,deponedirectorscore,deptwodirectorscore,
			engineerscore,dutyscore,deputyonescore,deputytwoscore,adjuestscore
			fROM ASSESS.T_ASSESS_LEADASSESSSTATSCORE
			WHERE yearmonth=para_yearmonth;
		begin 
		open updateset;
			loop
			fetch updateset into var_userid,var_deptid,var_dir,var_cle,var_dep,var_dept,var_eng,var_dut,var_deput,var_deputy,var_adjuest;
				exit when updateset%notfound;
				/*如果是调度控制处*/
				IF var_deptid = '1bd965db-c208-4607-8527-2e3f9d96392d' THEN
					BEGIN
					set var_safescore = 0.6*(var_dir+var_cle+var_dep+var_dept+var_eng) + 0.2*(var_dut)+0.1*(var_deput + var_deputy) + ISNULL(var_adjuest,0);
					UPDATE ASSESS.T_ASSESS_LEADASSESSSTATSCORE
						set safescore = var_safescore
						WHERE usercode=var_userid
						and yearmonth=para_yearmonth;
					END;
					
				ELSE
					BEGIN
					set var_safescore = 0.4 * (var_dir ) + 0.15*(var_cle+var_dep+var_dept+var_eng)+var_adjuest;
					UPDATE ASSESS.T_ASSESS_LEADASSESSSTATSCORE
						set safescore = var_safescore
						WHERE usercode=var_userid
						and yearmonth=para_yearmonth;
					END;
				END IF;
			end loop;
		close updateset;
		end;
	END IF;
END;

/***********************************************************************
 * report:表4-2：XX年员工综合评价计分表
 * function: 统计生成更新年员工综合评价表
 * table : T_ASSESS_YEARSTAFFCOBSTATALL
 ***********************************************************************/

--FUNCTION NAME : GET_SCORE_YEARSTAFFCOBSTATDT
--功能：传一个报表年，用户代码和操作人 从表T_ASSESS_YEARSTAFFCOBSTATDT中查询并返回
--		该用户得当一个相关操作人该年度对该用户的加权得分
--FUNCTION NAME : GET_SCORE_YEARSTAFFCOBSTATDT
--功能：传一个报表年，用户代码和操作人 从表T_ASSESS_YEARSTAFFCOBSTATDT中查询并返回
--		该用户得当一个相关操作人该年度对该用户的加权得分
CREATE  FUNCTION "ASSESS"."GET_SCORE_YEARSTAFFCOBSTATDT" AT "QHOMS"
(
	/*请填入参数, 参数的格式为<参数名>[<参数模式>]<参数类型> [:=|DEFAULT <表达式>] */
	para_year IN OUT VARCHAR(10),
	para_usercode IN OUT VARCHAR(20),
	para_dealman IN OUT VARCHAR(20)
)
RETURN NUMBER(16,0)
/*指明是否加密该函数的定义, 此处为可选*/
/*WITH ENCRYPTION*/
AS
	/*变量说明部分*/
	tempsql varchar(1000);
	res NUMBER(16,0);
BEGIN
	tempsql := 'SELECT addscore FROM T_ASSESS_YEARSTAFFCOBSTATDT a where a.reportyear='''||para_year||''' and a.usercode ='''||para_usercode||''' and a.dealman ='''||para_dealman||'''';
	print tempsql;
	execute immediate tempsql into res;
	return res;        
END;


/***********************************************************************
 * report:年员工综合评价表
 * function: 统计生成更新年员工综合评价表
 * table : T_ASSESS_YEARSTAFFCOBSTATALL
 ***********************************************************************/


CREATE  PROCEDURE "ASSESS"."P_ASSESSCALCULATE_YEARCOMSCORE" AT "QHOMS"
(
	/*要计算或更新的年月*/
	para_year   varchar(10)
)
AS
	var_temp  NUMBER(16,0);
	var_usercode	varchar(50);
	var_deptid		varchar(50);
	var_station		varchar(50);
	var_cent		NUMBER(16,2);
	var_fg			NUMBER(16,2);
	var_other1		NUMBER(16,2);
	var_other2		NUMBER(16,2);
	var_other3		NUMBER(16,2);
	var_ad			NUMBER(16,2);
	var_sum			NUMBER(16,2);
BEGIN
	select count(*) into var_temp FROM ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL  where reportyear = para_year;
	IF var_temp > 0 THEN
		print 'call for update';
		declare
			cursor updateset is select a.usercode,a.centerleaderscore,a.fgcenterscore,a.otherleaderscore1,a.otherleaderscore2,a.otherleaderscore3,a.adjuestscore
				FROM ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL a WHERE a.reportyear = para_year;		

		begin
			open updateset;
			loop
				fetch updateset into var_usercode,var_cent,var_fg,var_other1,var_other2,var_other3,var_ad;
				exit when updateset%notfound;
				/*综合评价得分=中心主任评价加权得分×0.4+分管领导评价加权得分×0.3+∑（其他领导评价加权得分×0.1）+调整分值*/
				set var_sum =
					 0.4 * ISNULL(var_cent,0) +
					 0.3 * ISNULL(var_fg,0) + 
					 0.1 * (ISNULL(var_other1 + var_other2+var_other3,0)) +
					 ISNULL(var_ad,0);
				
				update ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL
					set sumscore = var_sum
					where usercode = var_usercode
					and reportyear = para_year;
			end loop;
			close updateset;
		end;
		
	ELSE
		PRINT 'call for insert';
		
		declare
			cursor userset is select u.userid,u.deptid,u.station FROM ASSESS.T_ASSESS_WORKUSERINFO u;	
	
		begin
			open userset;
			loop
				fetch userset into var_usercode,var_deptid,var_station;
				exit when userset%notfound;
				var_cent := ISNULL(GET_SCORE_YEARSTAFFCOBSTATDT(para_year,var_usercode,'CW'),0);
				var_fg := ISNULL(GET_SCORE_YEARSTAFFCOBSTATDT(para_year,var_usercode,'FG1'),0);
				var_other1 := ISNULL(GET_SCORE_YEARSTAFFCOBSTATDT(para_year,var_usercode,'FG2'),0);
				var_other2 := ISNULL(GET_SCORE_YEARSTAFFCOBSTATDT(para_year,var_usercode,'FG3'),0);
				var_other3 := ISNULL(GET_SCORE_YEARSTAFFCOBSTATDT(para_year,var_usercode,'FG4'),0);
				INSERT INTO ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL(
						id,
						reportyear,
						usercode,
						deptid,
						station,
						centerleaderscore,
						fgcenterscore,
						otherleaderscore1,
						otherleaderscore2,
						otherleaderscore3
						) VALUES(
						T_ASSESS_YEARSTAFFCOBSTATALL_SN.nextval,
						para_year,
						var_usercode,
						var_deptid,
						var_station,
						var_cent,
						var_fg,
						var_other1,
						var_other2,
						var_other3);
			end loop;
			close userset;
		end;
		
		
		declare
			cursor updatesum is select a.usercode,a.centerleaderscore,a.fgcenterscore,a.otherleaderscore1,a.otherleaderscore2,a.otherleaderscore3,a.adjuestscore
				FROM ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL a WHERE a.reportyear = para_year;	

		begin
			open updatesum;
			loop
				fetch updatesum into var_usercode,var_cent,var_fg,var_other1,var_other2,var_other3,var_ad;
				exit when updatesum%notfound;

				/*综合评价得分=中心主任评价加权得分×0.4+分管领导评价加权得分×0.3+∑（其他领导评价加权得分×0.1）+调整分值*/
		
				set var_sum =
					 0.4 * ISNULL(var_cent,0) +
					 0.3 * ISNULL(var_fg,0) + 
					 0.1 * (ISNULL(var_other1 + var_other2+var_other3,0)) +
					 ISNULL(var_ad,0);
				
				update ASSESS.T_ASSESS_YEARSTAFFCOBSTATALL
					set sumscore = var_sum
					where usercode = var_usercode
					and reportyear = para_year;
			end loop;
			close updatesum;
		end;
		
	END IF;
END;

-------------------------------------------------------------------------
CREATE or replace FUNCTION "EQUIP"."F_GetLineNameAndEquipName" AT "QHOMS"
(equipid varchar) return varchar2 is
	vCode VARCHAR(4000);
	vequipid VARCHAR(100);
	symbol varchar(20):=',';
	vStart   INTEGER := 1;
	vLeftPos INTEGER := 1;
	vtempequipidname VARCHAR(100);
	equipidname VARCHAR(4000):='';
BEGIN
   
		vCode := equipid||symbol;
		vLeftPos := INSTR(vCode, symbol, vStart);
		WHILE vLeftPos > 0 LOOP
			vequipid := SUBSTR(vCode, vStart, vLeftPos - vStart);
			
			select t.name into vtempequipidname from (
			       	select equip_id as CODE,equip_name AS NAME from  EQUIP.T_EQUIPINFO where equip_name=vequipid
 					UNION  
 					select line_id as CODE,line_name AS NAME from  EQUIP.T_c_LINE where line_name=vequipid
			) t where t.code=vequipid ;
			equipidname:=equipidname||vtempequipidname||',';
			vStart := vLeftPos + 1;
			vLeftPos := INSTR(vCode, symbol, vStart);
		END LOOP;
    equipidname:=substr(equipidname,1,length(equipidname)-1);
    return equipidname;
END;