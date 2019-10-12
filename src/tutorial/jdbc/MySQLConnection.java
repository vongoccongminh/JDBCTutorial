package tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		
		String hostName = "localhost";
		String dbName = "TEST";
		String userName = "root";
		String password = "root";
		
		return getMySQLConnection(hostName, dbName, userName, password); 
	}
	public static Connection getMySQLConnection (String hostName, String dbName, String userName, String password) 
			throws SQLException, ClassNotFoundException {
		
		String ConnectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection conn = DriverManager.getConnection(ConnectionURL, userName, password);
						
		return conn;
	}
}
