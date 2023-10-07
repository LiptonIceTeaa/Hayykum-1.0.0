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
 * Servlet implementation class clientPage
 */
@WebServlet("/clientPage")
public class clientPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recieve request and send back all personal info
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		String passportNO = (String)session.getAttribute("clientPassport");
		PrintWriter out = response.getWriter();
		getClienPersonalInfo getInfo = new getClienPersonalInfo();
		ArrayList<String> data = new ArrayList<>();getInfo.retrievePersonalInfoClient(passportNO);
		data = getInfo.retrievePersonalInfoClient(passportNO);
		out.print(data.get(0)+","+data.get(1)+","+data.get(2)+","+data.get(3)+","+data.get(4)+","+data.get(5));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
