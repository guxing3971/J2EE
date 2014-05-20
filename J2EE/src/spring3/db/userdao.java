package spring3.db;

import hibernate3.POJO.VO_user;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class userdao extends HibernateDaoSupport{
	

	
	/**
	 * 将一个POJO的VO_user保存到库中
	 */
	public void insert(VO_user vo){
		this.getHibernateTemplate().save(vo);
	}
	
	/**
	 * 更新一个POJO
	 */
	public void update(VO_user vo){
		this.getHibernateTemplate().update(vo);
		
	}
	
	/**
	 * 查询POJO以分页的形式
	 * @param currentPage
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<?> queryPage(int currentPage,int size){
		int max = currentPage * size;
		String sql ="select * from (select A.*,ROWNUM  runnum from (select * from hbm_tbl_user ) A)"
				+ " WHERE runnum <="+ max+" and runnum >= "+(max - size)+"";
		List<VO_user> list = this.getSession().createSQLQuery(sql).addEntity(VO_user.class).list();
		return list;
	} 
}


