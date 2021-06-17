
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean status = false;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			status = LoginDAO.validateUserDetails(userName, password);

			if (status) {
				pw.print("<body bgcolor='Cyan'/>");
				pw.print("<H1>Welcome " + userName + "</H1>");
			} else {
				pw.print("<body bgcolor='Cyan'/>");
				pw.print("<H1>Invalid User Credentials </H1>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
