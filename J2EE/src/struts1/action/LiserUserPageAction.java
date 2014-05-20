package struts1.action;

import hibernate3.POJO.VO_user;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import spring3.db.userdao;

public class LiserUserPageAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取Spring的容器
		WebApplicationContext ctx = WebApplicationContextUtils.  
	            getRequiredWebApplicationContext(getServlet().getServletContext());
		
		int currentPage = 1;
		int size = 100;
		if(!(null == request.getParameter("page") || "".equals(request.getParameter("page")))){
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		if(!(null == request.getParameter("size") || "".equals(request.getParameter("size")))){
			size = Integer.parseInt(request.getParameter("size"));
		}		
		System.out.println(currentPage+"="+size);
		userdao dao = (userdao) ctx.getBean("userdao");
		List<VO_user> list =(List<VO_user>) dao.queryPage(currentPage, size);
		Iterator<VO_user> iter = list.iterator();
		while(iter.hasNext()){
			out.print(iter.next().toString()+"<br/>");
		}
		
		return null;
	}

	
		
}
