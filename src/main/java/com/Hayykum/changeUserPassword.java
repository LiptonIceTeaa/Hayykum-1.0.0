package com.Hayykum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class changeUserPassword
 */
@WebServlet("/changeUserPassword")
public class changeUserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recieve request and send back all personal info
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		String passportNO = (String) session.getAttribute("clientPassport");
		PrintWriter out = response.getWriter();
		
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		
		loginDao dao = new loginDao();
		
		if(dao.check(passportNO, oldPassword)) {
			
			updateClientInfo updateDao = new updateClientInfo();
			updateDao.udpateClient(passportNO, "password", newPassword);
			out.print("sucess");
			
		}else {
			out.print("wrong_password");
		}
		

	}

}
