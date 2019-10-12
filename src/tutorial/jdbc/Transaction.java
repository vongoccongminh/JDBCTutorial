package tutorial.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

	public static void AddSalary (Connection conn) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		String sql = "insert into Salary_Grade (Grade, High_Salary, Low_Salary) values  (3, 30000, 40000) ";
		
		statement.executeUpdate(sql);
		
	}
	
	public static void EditSalary (Connection conn) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		String sql = "insert into Salary_Grade (Grade, High_Salary, Low_Salary) values  (3, 50000, 50000) ";
		
		statement.executeUpdate(sql);
		
	}
	
	public static void showData (Connection conn) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		String sql = "select * from salary_grade";
		
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			int ID = rs.getInt(1);
			int highSalary = rs.getInt(2);
			int lowSalary = rs.getInt(3);
			
			System.out.println("ID : " + ID + " high salary : " + highSalary + " low salary : " + lowSalary);
		}
		
	}
	
	public static void delete (Connection conn) throws SQLException {
		
		Statement statement = conn.createStatement();
		
		String sql = "delete from salary_grade where Grade = 3 ";
		
		statement.executeUpdate(sql);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection conn = MySQLConnection.getMySQLConnection();
		
		conn.setAutoCommit(false); // commit moi thuc thi lenh tren database
		//delete(conn);
		//AddSalary(conn);
		//conn.commit();
		//showData(conn);
		try {
			showData(conn);
			AddSalary(conn);
			showData(conn);
			//conn.commit();
			
			EditSalary(conn);
			showData(conn);
			conn.commit();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("catch");
			showData(conn);
			conn.rollback();
			System.out.println("rollback");
			showData(conn);
		}
		
		conn.close();
	}

}
