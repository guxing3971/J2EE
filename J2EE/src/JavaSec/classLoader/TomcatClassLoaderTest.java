package JavaSec.classLoader;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于测试Tomcat的ClassLoader的结构
 *
 */
public class TomcatClassLoaderTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ClassLoader loader = this.getClass().getClassLoader();
		while(loader != null){
			out.println(loader.getClass().getName() +"<br/>");
			loader = loader.getParent();
		}
		
		out.println(String.valueOf(loader));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
