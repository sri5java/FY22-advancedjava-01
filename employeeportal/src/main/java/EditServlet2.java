
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet2() {
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

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
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
		e.setId(id);
		e.setAge(age1);
		e.setPhone(phone1);

		e.setFname(fname);
		e.setLname(lname);
		e.setPassword(passwrod);
		e.setEmial(email);
		e.setCountry(country);
		
		int status = 0;
		try {
			status = EmployeeDAO.updateEmployeeDetails(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(status >0) {
			response.sendRedirect("ViewServlet");
		}else {
			out.println("<body bgcolor='cyan'>");
			out.println("<H1>Sorry unable to proceed for updation<H1>");
		}
		out.close();
	}
}
