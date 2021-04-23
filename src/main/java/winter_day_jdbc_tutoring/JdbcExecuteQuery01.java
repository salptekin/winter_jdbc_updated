package winter_day_jdbc_tutoring;

//1.Step: Import SQL package
import java.sql.*;

public class JdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.Step: Register to the Oracle Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step: Establish connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		//4.Step: Create a statement
		Statement st = con.createStatement();
		
		//1.Example: Select all data from countries table
		//5.Step: Execute query and store the result
		String q1 = "SELECT * "
					+ "FROM countries";
		ResultSet rs1 = st.executeQuery(q1);
		
		//6.Step: Process the result
		while(rs1.next()) {
			System.out.println(rs1.getString(1) + " - " + rs1.getString(2) + " - " + rs1.getInt(3));
		}
		
		//2.Example: Select country name whose region_id is less than 3
		String q2 = "SELECT country_name "
					+ "FROM countries "
					+ "WHERE region_id < 3";
		ResultSet rs2 = st.executeQuery(q2);
		while(rs2.next()) {
			System.out.println(rs2.getString(1));
		}
		
		//3.Example: Select country id and country name whose region_id is the second highest
		String q3 = "SELECT country_id, country_name "
					+ "FROM countries "
					+ "ORDER BY region_id DESC "
					+ "OFFSET 1 ROW "
					+ "FETCH NEXT 1 ROW ONLY";
		ResultSet rs3 = st.executeQuery(q3);
		
		while(rs3.next()) {
			System.out.println(rs3.getString("COUNTRY_ID") + " - " + rs3.getString("COUNTRY_NAME"));
		}
		
		//4.Example: Select all data about the country whose region_id is the third lowest 
		String q4 = "SELECT * "
					+ "FROM countries "
					+ "ORDER BY region_id ASC "
					+ "OFFSET 2 ROW "
					+ "FETCH NEXT 1 ROW ONLY";
		
		ResultSet rs4 = st.executeQuery(q4);
		
		while(rs4.next()) {
			System.out.println(rs4.getString(1) + " - " + rs4.getString(2) + " - " + rs4.getInt(3));
		}

		//7.Step: Close everything
		con.close();
		st.close();
		rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();

	}

}
