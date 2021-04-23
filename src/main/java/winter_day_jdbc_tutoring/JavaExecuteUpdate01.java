package winter_day_jdbc_tutoring;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaExecuteUpdate01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		//Insert a single record into my_demo table
		String q1 = "INSERT INTO my_demo VALUES(11, 'First demo', 'Miami', 111)";
		int r1 = st.executeUpdate(q1);
		System.out.println(r1 + " row inserted");
		
			//Insert multiple records into my_demo table
		
		//1.Way: Use PreparedStatement
		
		/*
		 	To insert multiple data follow the steps
			 	1) Create a POJO(Plain Old Java Object) Class
			 		a)Create private variables
			 		b)Create all getters and setters
			 		c)Create Constructor with all variables
			 		d)Craete toString() method
			 	2) Create a list of the POJO Class objects
			 	3) By using for-each loop insert the records
		*/
		
		List<MyDemo> records = new ArrayList<>();
		records.add(new MyDemo(12, "Second demo", "Istanbul", 222));
		records.add(new MyDemo(13, "Third demo", "Jacksonville", 333));
		records.add(new MyDemo(14, "Fourth demo", "London", 444));
		records.add(new MyDemo(15, "Fifth demo", "Virginia", 555));
		records.add(new MyDemo(16, "Sixth demo", "Tallahasse", 666));
		
		//If you want to use same syntax repeatedly you need to 
		//	a)Use question marks
		//  b)Use PreparedStatement Object instead of Statement Object
		String q2 = "INSERT INTO my_demo values(?, ?, ?, ?)";
		
		PreparedStatement pst = con.prepareStatement(q2);
		
		for(MyDemo w : records) {
			
			pst.setInt(1, w.getDemo_id());
			pst.setString(2, w.getName_of_demo());
			pst.setString(3, w.getDemo_address());
			pst.setInt(4, w.getDemo_code());
			
			pst.addBatch();
			
		}
		
		int arr[] = pst.executeBatch();
		
		System.out.println(arr.length + " rows inserted");
		
		
		//2.Way: 
		int r = 0;
		for(MyDemo w : records) {
			
			String q3 = "INSERT INTO my_demo VALUES(" + w.getDemo_id() + ",'" + w.getName_of_demo() + "','" + w.getDemo_address() + "','" + w.getDemo_code() + "')";
            r = r + st.executeUpdate(q3);
			
		}
		System.out.println(r + " rows inserted");
		
		
		
		
		
		
		
		
		
		
		

	}

}
