package com.quiz.student.database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
		Connection connection = null;
		PreparedStatement ps = null;
		private void insertStudentData(String RollNo, String LastName,String FirstName,String DOB,String Email,String City,String Marks,String Grade) throws SQLException {
			try {
				ConnectionJdbc connectionJdbc = new ConnectionJdbc();
				connection = connectionJdbc.getConnectionDetails();
				ps = connection.prepareStatement("insert into studentdetails(RollNo,LastName,FirstName,DOB,Email,City)values(?,?,?,?,?,?)");
				ps.setString(1, RollNo);
				ps.setString(2, LastName);
				ps.setString(3, FirstName);
				ps.setString(4, DOB );
				ps.setString(5, Email);
				ps.setString(6, City);
	            
				ps = connection.prepareStatement("insert into score(Marks,Grade) Values (?,?)");
				ps.setString(1, Marks);
				ps.setString(2, Grade);
				int i = ps.executeUpdate();
				System.out.println("Record is inserted successfully.." + i);
				} 
			catch (Exception e) {
				e.printStackTrace();
				} 
			finally {
				connection.close();
				ps.close();
				}
				}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Scanner sc = new Scanner(System.in);
			
			     System.out.println("Enter RollNo: ");
			     String RollNo = sc.next();
			     System.out.println("Enter LastName: ");
			     String LastName = sc.next();
			     System.out.println("Enter FirstName: ");
			     String FirstName = sc.next();
			     System.out.println("Enter DOB: ");
			     String DOB = sc.next();
			     System.out.println("Enter Email: ");
			     String Email = sc.next();
			     System.out.println("Enter City: ");
			     String City = sc.next();
			     System.out.println("Enter Marks: ");
			     String Marks = sc.next();
			     System.out.println("Enter Grade: ");
			     String Grade = sc.next();
			     QuizStart quiz = new QuizStart();
					quiz.start();
			     UserInput userInput = new UserInput();
			     userInput.insertStudentData(RollNo,LastName,FirstName,DOB,Email,City,Marks,Grade);
			    
			    sc.close();

	}
}
