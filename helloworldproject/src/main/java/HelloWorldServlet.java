
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloWorldServlet implements Servlet {

	public HelloWorldServlet() {
	}

	public void init(ServletConfig config) throws ServletException {

		System.out.println("Hello Servlet in init method !!!!");
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet in service method !!!!");

	}

}
