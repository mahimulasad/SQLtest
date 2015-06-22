package efficiency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Multivalue insert
 * using string concat operation
 * faster than +
 * 
 */
public class Efficiency5 {
	
	private int start;
	private int length;
	
	private final String url= "jdbc:mysql://localhost:3306/test";
	private final String user= "root";
	private final String password= "";
	
	private Connection connection;
	private Statement statement;
	
	
	public Efficiency5(int start, int length) {
		this.start= start;
		this.length= length;
	}
	
	public void execute() {
		String sqlUpdate= "insert into test values(" + start + ", " + (start + 1)
				+ ")";
		for(int i=start+1; i<start+length; i++){
			String temp= ",(" + i + ", " + (i + 1)+ ")";
			sqlUpdate= sqlUpdate.concat(temp) ;//here is the difference with Efficient4
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			
			statement.executeUpdate(sqlUpdate);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
