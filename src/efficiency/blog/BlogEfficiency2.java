package efficiency.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BlogEfficiency2 {
	
	private int start;
	private int length;
	
	private final String url= "jdbc:mysql://localhost:3306/test";
	private final String user= "root";
	private final String password= "";
	
	private Connection connection;
	
	
	public BlogEfficiency2(int start, int length) {
		this.start= start;
		this.length= length;
	}
	
	public void execute() {
		try {
			connection= DriverManager.getConnection(url, user, password);
			
//			connection.prepareStatement("TRUNCATE TABLE testloadtable").execute();
//			connection.prepareStatement("ALTER SESSION SET SQL_TRACE=TRUE").execute();
			 
			PreparedStatement stmt = connection.prepareStatement("INSERT /* addBatch insert */ INTO test VALUES (?,?)");
			 
			for (int i=0;i<1000;i++)
			{
			  stmt.setInt(1, i);
			  stmt.setInt(2, i);	
			  stmt.addBatch();
			}
			stmt.executeBatch();
//			connection.commit();
			 
//			connection.prepareStatement("ALTER SESSION SET SQL_TRACE=FALSE").execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
