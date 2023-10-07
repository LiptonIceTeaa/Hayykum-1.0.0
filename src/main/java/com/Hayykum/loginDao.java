package com.Hayykum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class loginDao {
	
	String sql = "select * from clients where Passport_NO=? and password=?";
	String url = "jdbc:mysql://localhost:3306/hayykum_credentials";
	String username = "root";
	String password = "";
	
	public boolean check(String passportNO, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,passportNO);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean getRow(String passportNO, String field) {
		ArrayList<String> data = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection(url, username, password);

			
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
			rs = stmt.executeQuery("SELECT * FROM clients WHERE Passport_NO="+passportNO);                     
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
		
		return false;
	}
	
	
	public boolean checkUsingPassportNO(String passportNO) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select * from clients where Passport_NO="+passportNO;
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			//st.setString(1,passportNO);
		//	st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

}
