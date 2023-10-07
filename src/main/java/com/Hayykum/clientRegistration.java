package com.Hayykum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class clientRegistration
 */
@WebServlet("/clientRegistration")
public class clientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String passportNO = request.getParameter("PassportNumber");
			String fName = request.getParameter("clientFirstName");
			String lName = request.getParameter("clientLastName");
			String nationality = request.getParameter("Nationality");
			String gender = request.getParameter("gender");
			String birthDate = request.getParameter("birthDate");
			
			registerClinetDao dao = new registerClinetDao();			
			Boolean rs= dao.registerClient(passportNO,birthDate,fName,lName,nationality,birthDate,gender,0);
			
			
			if(rs){
				
				 //session.setAttribute("clientPassport", username);
				
				   System.out.print(rs+" deez");

				   response.sendRedirect("../homePage.jsp");
				     
				  
				
			}else {
					System.out.print(rs);

				    session.setAttribute("getAlert", "Yes");//Just initialize a random variable.
					response.sendRedirect("CLIENT/clientRegistration.jsp");
			}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String passportNO = request.getParameter("PassportNumber");
		String fName = request.getParameter("clientFirstName");
		String lName = request.getParameter("clientLastName");
		String nationality = request.getParameter("Nationality");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");

		registerClinetDao dao = new registerClinetDao();
		Boolean rs = dao.registerClient(passportNO, birthDate,fName, lName, nationality, birthDate, gender,0);

		if (rs) {

			// session.setAttribute("clientPassport", username);

			System.out.print(rs + " deez");

			response.sendRedirect("../homePage.jsp");

		} else {
			System.out.print(rs);

			session.setAttribute("getAlert", "Yes");// Just initialize a random variable.
			response.sendRedirect("CLIENT/clientRegistration.jsp");
		}
	}

}
