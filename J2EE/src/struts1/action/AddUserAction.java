package struts1.action;

import hibernate3.HibernateFactory;
import hibernate3.POJO.VO_user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AddUserAction extends DispatchAction{
	public ActionForward adduser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//利用hibernate将响应的数据插入到数据表中
		VO_user user = new VO_user();
		user.setUserid(String.valueOf(System.currentTimeMillis()));
		user.setUsername(request.getParameter("username"));
		user.setSex("man");
		user.setContent("测试数据");
		savetodb(HibernateFactory.getSession(),user);
		return mapping.findForward("success");
	}
	
	/**
	 * 通过hibernate将对象保存到数据库中
	 * @param session
	 * @param user
	 */
	public void savetodb(Session session,VO_user user){
		//打开事务
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		
		tx.commit();
		
		session.close();
	}
}
