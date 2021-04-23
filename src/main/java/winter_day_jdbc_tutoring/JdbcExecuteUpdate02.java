package winter_day_jdbc_tutoring;

import java.sql.*;

public class JdbcExecuteUpdate02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		//Update the name of demo whose demo_id is 11 to 'First' in my_demo table
		String q1 = "UPDATE my_demo SET name_of_demo = 'First' WHERE demo_id = 11";
		int r1 = st.executeUpdate(q1);
    	System.out.println(r1 + " rows updated");
    	
    	//Update the demo_code whose demo_id is greater than 14 to 999 in my_demo table
    	String q2 = "UPDATE my_demo SET demo_code = 999 WHERE demo_id > 14";
		int r2 = st.executeUpdate(q2);
    	System.out.println(r2 + " rows updated" );
    	
    	//Update the name of demo whose demo_code is the second lowest to 'Second lowest' in my_demo table
    	String q3 = "UPDATE my_demo "
    				+ "SET name_of_demo = 'Second lowest' "
    				+ "WHERE demo_code =  (SELECT demo_code "
						    				+ "FROM my_demo "
						    				+ "ORDER BY demo_code ASC "
						    				+ "OFFSET 1 ROW "
						    				+ "FETCH NEXT 1 ROW ONLY)";
    	int r3 = st.executeUpdate(q3);
    	System.out.println(r3 + " rows updated");
    	
    	//Delete records whose demo_id is 16 from my_demo 
    	String q4 = "DELETE FROM my_demo WHERE demo_id = 16";
		int r4 = st.executeUpdate(q4);
    	System.out.println(r4 + " row deleted");
    	
    	//Delete records whose demo_code is the maximum from my_demo 
    	String q5 = "DELETE FROM my_demo "
    				+ "WHERE demo_code = (SELECT MAX(demo_code) "
    									  + "FROM my_demo)";
		int r5 = st.executeUpdate(q5);
    	System.out.println(r5 + " row deleted");
    	
    	//Delete records whose demo_id is 11 or 12 or 14 from my_demo 
    	String q6 = "DELETE FROM my_demo "
    				+ "WHERE demo_id IN (11, 12, 14)";
		int r6 = st.executeUpdate(q6);
    	System.out.println(r6 + " rows deleted");
	}

}
