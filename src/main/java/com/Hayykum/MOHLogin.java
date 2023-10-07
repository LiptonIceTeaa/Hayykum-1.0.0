package com.Hayykum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MOHLogin
 */
@WebServlet("/MOHLogin")
public class MOHLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String email = (String) session.getAttribute("MOHEmployeeEmail");
		String password = request.getParameter("passportNO");
		String type = "MOH";
		
		
		employeesLoginDao dao = new employeesLoginDao();
		
		boolean result = dao.check(email,password,type);
		
		if(result) {
			out.print("valid");
		}else {
			out.print("inValid");
		}
		
	}

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String email = request.getParameter("emailMOH");
		String password = request.getParameter("PasswordMOH");
		String type = "MOH";
		
		employeesLoginDao dao = new employeesLoginDao();
		
		
		Boolean result = dao.check(email,password,type);
		
		
		if(result){
			// System.out.print(result);
			
			session.setAttribute("MOHEmployeeEmail", email);
			
			response.sendRedirect("MOH/MOHPage.jsp");
			 //RequestDispatcher rd = request.getRequestDispatcher("MOH/MOHPage.jsp");
			// rd.forward(request, response);
			
		}else {
			 //  System.out.print(result);
//			   out.println("<script type=\"text/javascript\">");
//			   out.println("alert('Email or password incorrect');");
//			   out.println("window.location='MOHLogin.jsp';");
//			   out.println("</script>");
			
			session.setAttribute("getAlert", "Yes");//Just initialize a random variable.
			response.sendRedirect("MOH/MOHLogin.jsp");
			   
			   
			   
		}
	}

}
