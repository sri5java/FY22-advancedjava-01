
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistartionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistartionServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// Loading the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// create connection String
			String conStr = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "System";
			String pass = "oracle";

			// Establish the connection
			Connection con = DriverManager.getConnection(conStr, user, pass);

			// Prepare statement
			String sql = "insert into REGISTRATION values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id1);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, userName);
			ps.setString(5, password);

			int i = ps.executeUpdate();

			if (i > 0) {
//				out.print("You are successfully Registered");
				RequestDispatcher rd = request.getRequestDispatcher("reg1");
				rd.forward(request, response);

			} else {
				out.print("Sorry We are not adding any details to the DB");
				RequestDispatcher rd = request.getRequestDispatcher("/Registration.html");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
