
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletExample extends GenericServlet{

	public ServletExample() {
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		System.out.println("Hello Service method");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<HTML>");
		out.print("<Body bgcolor ='Yellow'>");
		out.print("Hello Team");
		out.print("</Body>");
		out.print("</HTML>");
	}

}
