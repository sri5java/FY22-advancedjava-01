
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */

public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int a1 = Integer.parseInt(request.getParameter("n1"));
		int a2 = Integer.parseInt(request.getParameter("n2"));
		
		String username = request.getParameter("name1");
		String password = request.getParameter("name2");
		
		if(username.equalsIgnoreCase("Sumanth") && username.equalsIgnoreCase("Sumanth")) {
			
		}else {
			
		}

		if (request.getParameter("r1") != null) {
			out.println("<HTML><Body bgcolor='Yellow'><H1>Addition</H1></body></html>" + (a1 + a2));
		}

		if (request.getParameter("r2") != null) {
			out.println("<H1>Subtraction</H1>" + (a1 - a2));
		}

		if (request.getParameter("r3") != null) {
			out.println("<H1>Multiplication</H1>" + (a1 * a2));
		}
		try {
			if (request.getParameter("r4") != null) {
				out.println("<H1>Division</H1>" + (a1 / a2));
			}
		} catch (Exception e) {
			out.println("<H1>We are not allowing zeros, Please provide the proper Input<h1>");
		}
	}
}
