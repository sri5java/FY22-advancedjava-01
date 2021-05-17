
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SaveServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);

		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);

		String phone = request.getParameter("phone");
		int phone1 = Integer.parseInt(phone);

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String passwrod = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		Employee e = new Employee();
		e.setId(id1);
		e.setAge(age1);
		e.setPhone(phone1);

		e.setFname(fname);
		e.setLname(lname);
		e.setPassword(passwrod);
		e.setEmial(email);
		e.setCountry(country);

		int i = EmployeeDAO.saveEmployeeDetails(e);

		if (i > 0) {
			pw.println("<a href='Employee.html'> Add more Employees</a>");
			pw.println("<P> Record has been saved successfully !!!</p>");
		} else {
			pw.println("<a href='Employee.html' Add more Employees</a>");
			pw.println("<P>Unble to save the record !!!</p>");
		}

		pw.close();

	}

}
