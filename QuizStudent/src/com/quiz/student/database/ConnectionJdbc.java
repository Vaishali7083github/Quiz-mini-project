package com.quiz.student.database;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionJdbc {
	Connection connection = null;
	
	public Connection getConnectionDetails() { 
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection =
	DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root", "Vaishali@7083");
	} catch (Exception e) {
	e.printStackTrace();
	}
	return connection;
	}
	}



