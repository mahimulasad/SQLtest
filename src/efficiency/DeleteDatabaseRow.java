package efficiency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDatabaseRow {

	private final String url= "jdbc:mysql://localhost:3306/test";
	private final String user= "root";
	private final String password= "";
	
	private Connection connection;
	private Statement statement;
	
	
	public DeleteDatabaseRow() {
		
		try {
			connection= DriverManager.getConnection(url, user, password);
			statement= connection.createStatement();
			statement.execute("delete from test where 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
