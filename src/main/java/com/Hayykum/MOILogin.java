package com.Hayykum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MOILogin
 */
@WebServlet("/MOILogin")
public class MOILogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = request.getParameter("emailMOI");
		String password = request.getParameter("PasswordMOI");
		String type = "MOI";
		
		employeesLoginDao dao = new employeesLoginDao();
		
		
		Boolean result = dao.check(email,password,type);
		
		
		if(result){
			session.setAttribute("MOIEmployeeEmail", email);
			
			response.sendRedirect("MOI/MOIPage.jsp");
			
		}else {
		
			session.setAttribute("getAlert", "Yes");//Just initialize a random variable.
			response.sendRedirect("MOI/MOILogin.jsp");
			   
		}
	}

}
