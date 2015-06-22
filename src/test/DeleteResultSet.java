package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteResultSet {

	public static void main(String[] args) {
		final String url= "jdbc:mysql://localhost:3306/test";
		final String user= "root";
		final String password= "";
		
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		Connection connection2;
		Statement statement2;
		
		try {
			connection= DriverManager.getConnection(url, user, password);
			statement= connection.createStatement();
			String queryString= "select * from test where no<150";
			resultSet= statement.executeQuery(queryString);
			while (resultSet.next()) {
				int no= resultSet.getInt(1);
				int value = resultSet.getInt(2);
				//System.out.println(no+" "+ value);
				connection2 = DriverManager.getConnection(url, user, password);
				statement2 = connection2.createStatement();
				String insertString = "insert into test2 values("+no+","+value+")";
				statement2.executeUpdate(insertString);
				
//				statement2.close();
//				connection2.close();
				
				String deleteString= "delete from test where no="+no;
				connection2= DriverManager.getConnection(url, user, password);
				statement2 = connection.createStatement();
				statement2.executeUpdate(deleteString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
