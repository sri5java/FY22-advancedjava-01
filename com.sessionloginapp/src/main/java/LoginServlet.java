
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if (pass.equals("srikanth")) {
			// Create a session using http session
//			HttpSession session = request.getSession();
//			session.setAttribute("s", user);
//			response.sendRedirect("welcome");

			// URL Rewriting
//			response.sendRedirect("welcome?username="+ user);

			// creating a new hidden form field
//			out.println("<form action='welcome' method='Post'>");
//			out.println("<input type='hidden' name='username' value='" + user + "'>");
//			out.println("<input type='submit' value='submit' >");
//			out.println("</form>");

			// Cookies

			Cookie ck = new Cookie("username", user);
//			ck.setMaxAge(10);
			response.addCookie(ck);
			response.sendRedirect("welcome");

		}
	}
}
