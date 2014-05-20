package struts1.action;

import hibernate3.HibernateFactory;
import hibernate3.POJO.VO_user;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;



public class ListUserAction extends DispatchAction{

	public ActionForward listuser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Session session = HibernateFactory.getSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<VO_user> list = session.createSQLQuery("select * from hbm_tbl_user").addEntity(VO_user.class).list();
		Iterator<VO_user> iter = list.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			out.println(obj.toString()+"<br/>");
		}
		return null;
	}
	
}
