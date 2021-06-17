
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
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

		out.println("<body bgcolor='#D4E6F1'>");
		out.println("<a href='Employee.html'> ADD NEW EMPLOYEE </a>");
		out.println("<H1>Employee Information </H1>");

		List<Employee> employeeList = EmployeeDAO.getAllEmployeeDetails();

		out.println("<table border='1' width='100%'>");
		out.println("<tr>" + "<th>ID</th>" + "<th>First Name</th>" + "<th>Last Name</th>" + "<th>User Name / Email</th>" + "<th>Password</th>"
				+ "<th>Phone</th>" + "<th>Age</th>"+"<th>Country</th>+</tr>");
		
		for(Employee e : employeeList) {
			out.println("<tr>"
					+"<td>" + e.getId()
					+"</td><td>" + e.getFname()
					+"</td><td>" + e.getLname()
					+"</td><td>" + e.getEmial()
					+"</td><td>" + e.getPassword()
					+"</td><td>" + e.getPhone()
					+"</td><td>" + e.getAge()
					+"</td><td>" + e.getCountry()
					+"</td><td><a href ='EditServlet?id=" + e.getId()+"'>edit</a></td>\r\n"
					+"<td><a href ='DeleteServelt?id=" + e.getId()+"'>delete</a></td></tr>\r\n"
					);
		}
		
		out.println("</table>");
		out.println("</body>");
		out.close();
	}
}
