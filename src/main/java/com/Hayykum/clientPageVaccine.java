package com.Hayykum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class clientPageVaccine
 */
@WebServlet("/clientPageVaccine")
public class clientPageVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** retieving vaccine info of client */
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		String passportNO = (String)session.getAttribute("clientPassport");
		PrintWriter out = response.getWriter();
		ArrayList<String> data = new ArrayList<>();
		getClientVaccineInfo getVaccineInfos = new getClientVaccineInfo();
		data = getVaccineInfos.getVaccineInfo(passportNO);
		int i=0;
		String d="";
		
//		
//		for(String a : data) {
//			System.out.println(a+" ");
//		}
		for(String a: data) {
			if(a.equals("-")) {
				//System.out.println("dose: "+data.get(i-2)+" | dose expiry: "+data.get(i-1));
				d = d+" "+data.get(i-2) +", "+data.get(i-1)+",," ;
				
			}
			i++;
			
		}
		
		out.print(d);
		
		
		
		
	}

	

}
