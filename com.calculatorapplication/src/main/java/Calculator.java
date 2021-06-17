
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String a1 = request.getParameter("n1");
		String a2 = request.getParameter("n2");
		
		int n1= Integer.parseInt(a1);
		int n2= Integer.parseInt(a2);
		
		String cal = request.getParameter("cal");
		
		switch(cal){
		
		case "add":
			pw.println("<HTML><BODY bgcolor='Cyan'> <h1>Addition</h1></Body></Html>" + (n1+n2));
			break;
		case "sub":
			pw.println("<HTML><BODY bgcolor='Cyan'> <h1>Subtraction</h1></Body></Html>" + (n1-n2));
			break;
		case "mul":
			pw.println("<HTML><BODY bgcolor='Cyan'> <h1>Multiplication</h1></Body></Html>" + (n1*n2));
			break;
		case "div":
			pw.println("<HTML><BODY bgcolor='Cyan'> <h1>Division</h1></Body></Html>" + (n1/n2));
			break;
		}

	}

}
