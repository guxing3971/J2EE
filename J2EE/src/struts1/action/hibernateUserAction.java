package struts1.action;

import hibernate3.HibernateFactory;
import hibernate3.POJO.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;



public class hibernateUserAction extends DispatchAction {

	public ActionForward AddUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		UserVO  vo = new UserVO();
		vo.setUserid(String.valueOf(System.currentTimeMillis()));
		vo.setUsername(request.getParameter("username"));
		hbm_save(vo);
		return mapping.findForward("success");
	}

	public ActionForward ListUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.cancelled(mapping, form, request, response);
	}
	
	
	public void hbm_save(UserVO vo){
		Session session = (Session) HibernateFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(vo);
		tx.commit();
		session.close();
	}
}
