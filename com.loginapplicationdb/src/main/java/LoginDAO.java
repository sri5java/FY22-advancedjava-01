import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static boolean validateUserDetails(String userName, String password)
			throws SQLException, ClassNotFoundException {
		boolean status = false;
		// Loading the JDBC Driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// preparing connection String
		String str = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "System";
		String dbPassword = "oracle";

		// establish the database Connection
		Connection con = DriverManager.getConnection(str, dbUserName, dbPassword);

		// Preparing statement for executing SQL Query
		String sql = "select * from studentinfo where USERNAME = ? AND PASSWORD = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);

		//Execute Query
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		ps.close();
		con.close();
		return status;
	}
}
