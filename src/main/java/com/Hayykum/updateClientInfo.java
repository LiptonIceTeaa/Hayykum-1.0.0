package com.Hayykum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class updateClientInfo {
	
	
//	String sql = "UPDATE clients SET fname =? WHERE Passport_NO=? ";
	//String sql= "UPDATE item SET fname = ? WHERE Passport_NO = ?";
	String url = "jdbc:mysql://localhost:3306/hayykum_credentials";
	String username = "root";
	String password = "";

	
	
	
	public boolean udpateClient(String passportNO,String field,String val) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "UPDATE clients SET "+ field+"=? WHERE Passport_NO=? ";
			PreparedStatement st = con.prepareStatement(sql);
			//st.setString(1,field);
			//st.setString(2, val);
			//st.setString(3, passportNO);
			
			st.setString(1,val);
			st.setString(2, passportNO);
			

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
