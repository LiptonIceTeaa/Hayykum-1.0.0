package com.Hayykum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class registerClinetDao {
	
	
	String sql = "INSERT INTO clients VALUES (?,?,?,?,?,?,?,?)";
	String url = "jdbc:mysql://localhost:3306/hayykum_credentials";
	String username = "root";
	String password = "";

	
	
	
	public boolean registerClient(String passportNO,String passwordd,String firstName,String lastName, String nationality,String birthDate,String gender, int doseNO) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,passportNO);
			st.setString(2,passwordd);
			st.setString(3, birthDate);
			st.setString(4, gender);
			st.setString(5, firstName);
			st.setString(6, lastName);
			st.setString(7, nationality	);
			String doseNumber = String.valueOf(doseNO);
			st.setInt(8, doseNO	);
			
			int rs = st.executeUpdate();
				
			if(rs !=0 ) {
				return true;
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
