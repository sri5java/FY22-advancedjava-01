
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// HttpSession
//		HttpSession session = request.getSession();
//		String userName = (String) session.getAttribute("s");

		// URL Rewriting or hidden From fields
//		String userName = request.getParameter("username");
//		out.print("Welcome : " + userName);

		// Cookies
		Cookie[] cks = request.getCookies();
//		out.println("Welcome :" + cks[0].getValue());
		
		for(Cookie c : cks) {
			out.println("Welcome :" + c.getValue());
		}

	}
}
