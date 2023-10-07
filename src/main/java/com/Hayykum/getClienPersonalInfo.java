package com.Hayykum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getClienPersonalInfo {

	//String sql = "SELECT * FROM clients WHERE Passport_NO = ? ";
	String url = "jdbc:mysql://localhost:3306/hayykum_credentials";
	String username = "root";
	String password = "";

	public ArrayList<String> retrievePersonalInfoClient(String passportNO) {
		ArrayList<String> data = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Passport adS: "+passportNO);
				
			String fname;
			String lname;
			String birthDate="";
			String gender;
			String nationality;
			int dosesNO;
			
			Connection cons = DriverManager.getConnection(url, username, password);;
			Statement stmt;
			ResultSet rs;
			
			stmt = cons.createStatement();     // Create a Statement object           1 
			String query = "SELECT * FROM clients WHERE Passport_NO = '"+passportNO+"'; ";
			//String query ="SELECT * FROM clients HAVING Passport_NO = "+passportNO;
			rs = stmt.executeQuery(query);                     
			                                  // Get the result table from the query
			while (rs.next()) {               // Position the cursor                 3 
			 fname = rs.getString("fname"); 
			 lname = rs.getString("lname"); 
			 gender = rs.getString("gender"); 
			 birthDate = rs.getString("birthDate");
			 nationality = rs.getString("nationality");
			 dosesNO = rs.getInt("dosesNO"); 
			 data.add(fname);
			 data.add(lname);
			 data.add(gender);
			 data.add(nationality);
			 data.add(birthDate);
			 data.add(String.valueOf(dosesNO));
			 
			 
			                                  // Print the column value
			}
			rs.close();                       // Close the ResultSet                 4 
			stmt.close();                     // Close the Statement                 5 
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
