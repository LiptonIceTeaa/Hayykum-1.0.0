package com.Hayykum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MOFALogin
 */
@WebServlet("/MOFALogin")
public class MOFALogin extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = request.getParameter("emailMOFA");
		String password = request.getParameter("PasswordMOFA");
		String type = "MOFA";
		
		employeesLoginDao dao = new employeesLoginDao();
		
		
		Boolean result = dao.check(email,password,type);
		
		
		if(result){
			// System.out.print(result);
			
			session.setAttribute("MOFAEmployeeEmail", email);
			
			response.sendRedirect("MOFA/MOFAPage.jsp");
			
		}else {
			 //  System.out.print(result);
//			   out.println("<script type=\"text/javascript\">");
//			   out.println("alert('Email or password incorrect');");
//			   out.println("location='MOFALogin.jsp';");
//			   out.println("</script>");
			
			session.setAttribute("getAlert", "Yes");//Just initialize a random variable.
			response.sendRedirect("MOFA/MOFALogin.jsp");
			   
		}
	}

}
