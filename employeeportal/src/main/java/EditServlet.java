
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<H1> Update EMployee </H1>");

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Employee emp = EmployeeDAO.getEmployeeDetailsById(id);

		out.println("<body bgcolor='cyan'>");
		out.print("<form action='EditServlet2' method='get'>");
		out.print("<table>");
		out.print("<tr>" 
				+ "<td>ID : </td>" 
				+ "<td> <input type='text' name='id' value='" + emp.getId() + "'></td>"
				+ "</tr>");
		out.print("<tr>" 
				+ "<td>First Name : </td>" 
				+ "<td> <input type='text' name='fname' value='" + emp.getFname()+ "'></td>"
				+ "</tr>");
		out.print("<tr>" 
				+ "<td>Last Name</td>" 
				+ "<td> <input type='text' name='lname' value='" + emp.getLname()+ "'/></td>"
				+ "</tr>");
		out.print("<tr>" 
				+ "<td>EMail </td>" 
				+ "<td> <input type='text' name='email' value='" + emp.getEmial()+ "'/>" + "</td>"
				+ "</tr>");
		out.print("<tr>" 
				+ "<td>Password </td>" 
				+ "<td> <input type='text' name='password' value='" + emp.getPassword()+ "'/></td>"
				+ "</tr>");
		out.print("<tr>" + "<td>Phone Number</td>" + "<td> <input type='text' name='phone' value='" + emp.getPhone()
				+ "'/></td></tr>");
		out.print("<tr>" + "<td>Age </td>" + "<td> <input type='text' name='age' value='" + emp.getAge()
				+ "'/></td></tr>");

		out.print("<tr><td>Country : </td><td>");
		out.print("<select name='country'>");
		out.print("<option> India </option>");
		out.print("<option> USA </option>");
		out.print("<option> UK </option>");
		out.print("<option> Others </option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='edit & save'/><td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();

	}
}
