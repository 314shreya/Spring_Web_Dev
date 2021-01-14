package Me1;
import java.sql.*;
//individual jdbc api classes need to be imported
import java.sql.DriverManager;

//
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//

public class Mee1 {
	//2.specify driver name and db url
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
	
	//3. db credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		//4. establish a connection
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//5. register a jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//6. open a connection
			System.out.println("Connecting to db.....");
			conn = DriverManager.getConnection(DB_URL, "root", "");
			
			//7. execute a query
			System.out.println("Creating a statement");
			stmt = conn.createStatement(); //this is done to "create" a sql statement
			String sql;
			
//			sql = "SELECT id,first,last,age FROM emp1";
//			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Creating table..........");
			String sql1 = "CREATE TABLE EMP1111"+
					"(id INTEGER not NULL, " +
					"first VARCHAR(255), " +
					"last VARCHAR(255), " +
					"age INTEGER, "+ 
					"PRIMARY KEY(id))";
			stmt.executeUpdate(sql1);
			
			System.out.println("Created table!....");
			
			//8. extract data from result
//			while(rs.next()) {
//				//retrieve by coloumn name
//				int id = rs.getInt("id");
//				int age = rs.getInt("age");
//				String first = rs.getString("first");
//				String last = rs.getString("last");
				
				//9. display values
//				System.out.print("\nID: " +id);
//				System.out.print(", Age: " +age);
//				System.out.print(", First: " +first);
//				System.out.print(", Last: " +last);
//			}
			
			//11. clean up the environment
//			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			//handle errors for jdbc
			se.printStackTrace();
		}catch(Exception e) {
			//handle errors for class.forName
			e.printStackTrace();
		}finally {
			//finally block used to close resources
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
				
			}//nothing we can do
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}//end finally try
		}//end try
	}
}