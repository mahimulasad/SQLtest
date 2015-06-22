package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SQLTest{
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	private final String URL= "jdbc:mysql://localhost:3306/test";
	private final String USER= "root";
	private final String PASSWORD= "";
	
	public SQLTest() {
		//no definition of constructor is needed
	}
	
	public void insert(String word, int count, double intensity) {
		try {
			connection= DriverManager.getConnection(URL,USER, PASSWORD);
			statement= connection.createStatement();
			String queryString= "INSERT INTO testtable VALUES('"+word+
					"', '"+count+"', '"+intensity+"')";
			statement.executeUpdate(queryString);
			
			statement.close();
			connection.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void search(){
		try {
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			statement= connection.createStatement();
			resultSet= statement.executeQuery("SELECT * FROM testtable");
			System.out.println("No of rows: "+resultSet.getRow());
			
			while (resultSet.next()) {
				String word= resultSet.getString(1);
				int count= resultSet.getInt(2);
				double intensity= resultSet.getDouble(3);
				System.out.println(word+" "+count+" "+intensity);
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


public class TestSQL {

	public static void main(String[] args) {

		SQLTest sqlTest= new SQLTest();
		sqlTest.search();
		sqlTest.insert("abc", 1, 0.5);
		sqlTest.search();
		sqlTest.insert("def", 2, 0.1);
		sqlTest.search();
		
	}

}
