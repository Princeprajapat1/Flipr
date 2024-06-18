package com;
import java.sql.*;
public class Conn {
	Connection con;
	Statement stmt;
	String url="jdbc:mysql://localhost:3306/tour";
	String id="root";
	String pass="The cow1@";
	Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
 con=DriverManager.getConnection(url,id,pass);
	stmt= con.createStatement();
		
		}catch(Exception e) {
			e.printStackTrace();

	}
	}
	
	
public static void main(String args[]) {
	
}

}
