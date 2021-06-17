
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimpleServlet extends GenericServlet {

	private static final long serialVersionUID = -3621431034452905588L;
	String message;

	public SimpleServlet() {

	}

//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("Inside init method");
//		message = "Hello Simple Servlet";
//	}

//	public void destroy() {
//		System.out.println("Inside destory method");
//	}
//
//	public ServletConfig getServletConfig() {
//		return null;
//	}
//
//	public String getServletInfo() {
//		return "Srikanth";
//	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("inside service method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML><BODY BGCOLOR='YELLOW'>");
		out.println("<H1>" + "Hello Guys" + "</H1>");
		out.println("</BODY></HTML>");
	}
}
