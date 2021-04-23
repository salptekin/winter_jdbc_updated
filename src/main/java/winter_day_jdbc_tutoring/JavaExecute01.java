package winter_day_jdbc_tutoring;

import java.sql.*;

public class JavaExecute01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		/*
		 	Note 1: For DDL Statements(CREATE TABLE, DROP TABLE, ALTER TABLE) use execute() method
		 	Note 2: execute() method returns "boolean"
		 	Note 3: execute() method returns true if it returns ResultSet object, otherwise it returns false
		 	        I mean when you use execute() method with DDL Statements, you will get false.
		 	        When you use execute() method with DQL Statements, you will get true.
		*/
		
		//Drop demo table from database
		String q0 = "DROP TABLE demo PURGE";
		boolean r0 = st.execute(q0);
		System.out.println("From DROP: " + r0);//false
		
		//Create demo table which has demo_id(number) and demo_name(varchar2) fields
		String q1 = "CREATE TABLE demo(demo_id NUMBER(2), demo_name VARCHAR2(30))";
		boolean r1 = st.execute(q1);
		System.out.println("From CREATE: " + r1);//false
		
		//Make sure demo table is created
		String q2 = "SELECT * FROM demo";
		ResultSet rs2 = st.executeQuery(q2);
		
		//Add demo_address field into demo table (How to add a single field)
		String q3 = "ALTER TABLE demo ADD demo_address VARCHAR2(20)";
		boolean r3 = st.execute(q3);
		System.out.println("From ALTER: " + r3);//false
		
		//Add demo_code and demo_price fields into demo table (How to add multiple fields)
		String q4 = "ALTER TABLE demo ADD (demo_code CHAR(3), demo_price NUMBER(5))";
		boolean r4 = st.execute(q4);
		System.out.println("From ALTER: " + r4);//false
		
		//Change the data type of demo_code field to NUMBER(3)
		String q5 = "ALTER TABLE demo MODIFY demo_code NUMBER(3)";
		boolean r5 = st.execute(q5);
		System.out.println("From ALTER: " + r5);//false
		
		//Drop demo_price field from demo table
		String q6 = "ALTER TABLE demo DROP COLUMN demo_price";
		boolean r6 = st.execute(q6);
		System.out.println("From ALTER: " + r6);//false
		
		//Rename demo_name field to name_of_demo
		String q7 = "ALTER TABLE demo RENAME COLUMN demo_name TO name_of_demo";
		boolean r7 = st.execute(q7);
		System.out.println("From ALTER: " + r7);//false
		
		//Rename demo table to my_demo
		String q8 = "ALTER TABLE demo RENAME TO my_demo";
		boolean r8 = st.execute(q8);
		System.out.println("From ALTER: " + r8);//false
		
		con.close();//Connection
		st.close();//Statement
		rs2.close();//Resultset
	}

}
