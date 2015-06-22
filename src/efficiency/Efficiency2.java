package efficiency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * Connection is created once
 * each insert is under that connection
 * 
 */

public class Efficiency2 {
	
	private int start;
	private int length;
	
	private final String url= "jdbc:mysql://localhost:3306/test";
	private final String user= "root";
	private final String password= "";
	
	private Connection connection;
	private Statement statement;
	
	
	public Efficiency2(int start, int length) {
		this.start= start;
		this.length= length;
	}
	
	public void execute() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			for(int i=start; i<start+length; i++){
				String sqlUpdate = "insert into test values(" + i + ", " + (i + 1)
					+ ")";
				statement.executeUpdate(sqlUpdate);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
