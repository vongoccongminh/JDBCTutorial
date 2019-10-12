package tutorial.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		return MySQLConnection.getMySQLConnection();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Get connection ... ");
		
		Connection conn = ConnectionUtils.getConnection();
		
		System.out.println("Get connection " + conn);
	    System.out.println("Done!");
		
	    Statement statement = conn.createStatement();
	    
	    // SELECT * 
	    /*
	    String sql = "Select * from Employee";
	    
	    ResultSet rs = statement.executeQuery(sql);
	    
	    while(rs.next()) {
	    	
	    	String empName = rs.getString(2);
	    	int empID = rs.getInt(1);
	    	String empNo = rs.getString("emp_no");
	    	System.out.println("-----------------");
	    	System.out.println("ID = " + empID + " NAME : " + empName + " NO : " + empNo);
	    	
	    }
	    
	    conn.close();
	    */
	    
	    // INSERT
	    
	    /*String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary) values (2, 20000, 10000)";
	    
	    int count = statement.executeUpdate(sql);
	    
	    System.out.println(count);
	   
	    conn.close();*/
	    
	    String sql = "select * from employee where emp_name like ? and dept_id = ? ";
	    
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    
	    pstm.setString(1, "%S");
	    pstm.setInt(2, 20);
	    
	    ResultSet rs = pstm.executeQuery();
	    
	    while(rs.next()) {
	    	System.out.println("ID : " + rs.getInt("emp_id") + " Name : " + rs.getString("emp_name") + " Department ID: " + rs.getInt("dept_id"));
	    }
	    
	    System.out.println("Another parameters");
	    
	    pstm.setString(1, "K%");
	    pstm.setInt(2, 10);
	    rs = pstm.executeQuery();
	    while(rs.next()) {
	    	System.out.println("ID : " + rs.getInt("emp_id") + " Name : " + rs.getString("emp_name") + " Department ID: " + rs.getInt("dept_id"));
	    }
	    
	 
	}

}
