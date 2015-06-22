package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class SQLValue{
	
	//connection interface that creates the connection with the database
	private Connection connection;
	private Statement statement;//statement interface
	private ResultSet resultSet;//resultset, that holds the query result after the query
	
	//location of the database in mysql
	private final String URL= "jdbc:mysql://localhost:3306/teadb";
	//username of the database
	//for mysql "root" is default
	private final String USER= "root";
	//password of the database
	//for "root" there is no password
	private final String PASSWORD= "";
	
	public SQLValue() {
		//no definition of constructor is needed
	}
	
	public void execute() {
		
		Intensity intensity1 = getIntensity("sss");
		if (intensity1==null) {
			System.out.println("No match found for sss");
		}
		else {
			System.out.println(intensity1.getAnger()+" "+ intensity1.getJoy());
		}
		intensity1= getIntensity("qqq");
		if (intensity1== null) {
			System.out.println("No match found for qqq");
		}
		else {
			System.out.println(intensity1.getJoy());
		}
		
		int emotype= getEmoType(":)");
		if (emotype==-1) {
			System.out.println("No emo found");
		}
		else {
			System.out.println(emotype);
		}
		
		emotype= getEmoType(":(");
		if (emotype==-1) {
			System.out.println("No emo found");
		}
		else {
			System.out.println(emotype);
		}
		
		double coefficient= getCoefficient("aaa");
		if (coefficient== -1.00) {
			System.out.println("No coefficient found");
		}
		else {
			System.out.println(coefficient);
		}
		coefficient= getCoefficient("aaaa");
		if (coefficient== -1.00) {
			System.out.println("No coefficient found");
		}
		else {
			System.out.println(coefficient);
		}
	}
	
	public Intensity getIntensity(String word) {
		Intensity intensity= null;
		try {
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			statement= connection.createStatement();
			resultSet= statement.executeQuery("SELECT W.anger, W.disgust, W.fear, W.guilt, "
					+ " W.interest, W.joy, W.sadness, W.shame, W.surprise"
					+ " FROM WORD W WHERE W.word='"+word+"'");
			
			if (resultSet.next()) {
				intensity= new Intensity();
				intensity.setAnger(resultSet.getDouble(1));
				intensity.setDisgust(resultSet.getDouble(2));
				intensity.setFear(resultSet.getDouble(3));
				intensity.setGuilt(resultSet.getDouble(4));
				intensity.setInterest(resultSet.getDouble(5));
				intensity.setJoy(resultSet.getDouble(6));
				intensity.setSadness(resultSet.getDouble(7));
				intensity.setShame(resultSet.getDouble(8));
				intensity.setSurprise(resultSet.getDouble(9));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intensity;
		
	}
	
	
	//return the type of the emoticon from the database
	// if no emoticon is found return -1
	private int getEmoType(String emo) {
		int ret =-1;
		
		try {
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			statement= connection.createStatement();
			resultSet= statement.executeQuery("select e.emotion_id from emo e where e.emo='"+emo+"'");
			if (resultSet.next()) {
				ret= resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}
	
	//return the coefficient from the database
	//if the coefficient is not found then return -1.00
	private double getCoefficient(String coefficient) {
		double ret= -1.00;//default coefficient -1.00
		try {
			//creates the connection with database (url) 
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			statement= connection.createStatement();
			//result of the query will be stored in resultset
			resultSet= statement.executeQuery("select c.value from coefficient c where c.coefficient='"+coefficient+"'");
			//the pointer of the resultset will be placed before the 
			//1st element of the result set
			//resultset may contain several rows
			//as a query may return more than one row
			
			//resultSet.next() moves the pointer to one row
			//if the row is valid true is returned, else otherwise
			if (resultSet.next()) {
				//1st element of the row
				//indexing starts from 1
				ret= resultSet.getDouble(1);//get c.value
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ret;
	}
}


public class TestSQL2 {

	public static void main(String[] args) {

		SQLValue sqlValue= new SQLValue();
		sqlValue.execute();
		
	}

}
