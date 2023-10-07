package com.Hayykum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class employeesLoginDao {
	
	String sql = "SELECT * from employees WHERE email=? and password=? and type=?";
	String url = "jdbc:mysql://localhost:3306/hayykum_credentials";
	String username = "root";
	String password = "";

	
	
	
	public boolean check(String email,String pass,String type) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,email);
			st.setString(2,pass);
			st.setString(3,type);
			
			System.out.print(st);
			
			
			
			
			ResultSet rs = st.executeQuery();
				
			if(rs.next() ) {
				return true;
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
