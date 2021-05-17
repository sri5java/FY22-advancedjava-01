
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "oracle");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static int saveEmployeeDetails(Employee e) {
		int status = 0;
		try {
			Connection con = EmployeeDAO.getConnection();
			String sql = "insert into employeeInfo values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getFname());
			ps.setString(3, e.getLname());
			ps.setString(4, e.getEmial());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getPhone());
			ps.setInt(7, e.getAge());
			ps.setString(8, e.getCountry());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return status;
	}

	public static List<Employee> getAllEmployeeDetails() {
		List<Employee> empList = new ArrayList<Employee>();

		try {
			Connection con = EmployeeDAO.getConnection();
			String sql = "select * from employeeInfo";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setEmial(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setPhone(rs.getInt(6));
				emp.setAge(rs.getInt(7));
				emp.setCountry(rs.getString(8));

				empList.add(emp);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return empList;
	}

	public static Employee getEmployeeDetailsById(int id) {
		Employee emp = new Employee();
		try {
			Connection con = EmployeeDAO.getConnection();
			String sql = "select * from employeeInfo where id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setEmial(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setPhone(rs.getInt(6));
				emp.setAge(rs.getInt(7));
				emp.setCountry(rs.getString(8));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp;

	}

}
