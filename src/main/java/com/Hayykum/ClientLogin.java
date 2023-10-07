package com.Hayykum;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClientLogin
 */
@WebServlet("/ClientLogin")
public class ClientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("clientPassportNO");
		String birthDate = request.getParameter("birthDate");
		
		loginDao dao = new loginDao();
		
		
		if(dao.check(username, birthDate)){
			//HttpSession session = request.getSession();
			session.setAttribute("clientPassport", username);
			
			response.sendRedirect("CLIENT/clientPage.jsp");
			
		}else {
			   
			    session.setAttribute("getAlert", "Yes");//Just initialize a random variable.
				response.sendRedirect("CLIENT/clientLogin.jsp");
			   
		}
		
	}

}
