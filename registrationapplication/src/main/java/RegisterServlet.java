
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		long phoneNumber = Long.parseLong(request.getParameter("phone"));
		int age = Integer.parseInt(request.getParameter("age"));

		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String emailID = request.getParameter("email");
		String password = request.getParameter("pass");
		String dob = request.getParameter("dob");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			PreparedStatement ps = con.prepareStatement("insert into registrationinfo values(?,?,?,?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, emailID);
			ps.setString(5, password);
			ps.setString(6, dob);
			ps.setLong(7, phoneNumber);
			ps.setInt(8, age);

			int i = ps.executeUpdate();

			if (i > 0) {
				out.print("You are Successfully Registered..");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
