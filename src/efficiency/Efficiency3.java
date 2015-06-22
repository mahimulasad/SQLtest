package efficiency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Insert using prepared statement
 * 
 * 
 */
public class Efficiency3 {
	
	private int start;
	private int length;
	
	private final String url= "jdbc:mysql://localhost:3306/test";
	private final String user= "root";
	private final String password= "";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	
	public Efficiency3(int start, int length) {
		this.start= start;
		this.length= length;
	}
	
	public void execute() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			String sqlUpdate= "insert into test values(?, ?)";
			preparedStatement = connection.prepareStatement(sqlUpdate);
			for(int i=start; i<start+length; i++){
				preparedStatement.setInt(1, i);
				preparedStatement.setInt(2, i+1);
				preparedStatement.executeUpdate();
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
