package com.Hayykum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

/**
 * Servlet implementation class MOIQueryRecord
 */
@WebServlet("/MOIQueryRecord")
public class MOIQueryRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String checkBox = request.getParameter("checkbox");
		String passportNO = request.getParameter("passportNO");
		System.out.println("checkbox: " + checkBox);

		MOIQueryRecordDao dao = new MOIQueryRecordDao();
		boolean ifExists = dao.checkIfUserExists(passportNO);

		if (!ifExists) {
			System.out.print("User doesnt exist");

			session.setAttribute("getAlertMOIQueryUserDoesntExist", "Yes");// Just initialize a random variable.
			response.sendRedirect("MOI/MOIPage.jsp");

		} else {
			
			StringBuilder mainStr = new StringBuilder();
			System.out.println("cHECK BOX: " + checkBox);
			if (checkBox==null) {
				System.out.println("cHECK BOX checked: " + checkBox);
				
				// mainStr.append("deezo");
				// retrieve all docs for a user
				ArrayList<Document> docs = new ArrayList<>();
				docs = dao.getAllDocs(passportNO);
				// mainStr.append(docs);

				/** displaying content of array doc **/
				long timeStamp;
				int txID;
				String fname = "";
				String lname = "";
				String nationality = "";
				String gender = "";
				String birthDate = "";
				int doseNumber = 0;
				String doseType = "";
				String doseDate = "";
				String doseExpiry = "";
				String doseLocation = "";


				getClienPersonalInfo infoDao = new getClienPersonalInfo();
				ArrayList<String> personalInfoArr = infoDao.retrievePersonalInfoClient(passportNO);
				fname = personalInfoArr.get(0);
				lname = personalInfoArr.get(1);
				gender = personalInfoArr.get(2);
				birthDate = personalInfoArr.get(4);
				nationality = personalInfoArr.get(3);
				
				
				// append personal info
				mainStr.append("<b>Passport number: </b>"+passportNO);
				mainStr.append("<br><b>Full name: </b>" + fname +" "+lname);
				mainStr.append("<br><b>Gender: </b>" + gender);
				mainStr.append("<br><b>Nationality: </b>" + nationality);
				mainStr.append("<br><b>Birthdate: </b>" + birthDate+"<br>");
				

				mainStr.append("<p style=\"text-align:center;font-weight:bold;margin:0;padding:0;\"> <b>Vaccine doses: </p>");
				int i=1;
				// print doses
				for (Document d : docs) {
					
					/** getting basic info **/
					timeStamp = d.getLong("timeStamp");

					/** printing basic info */

					// mainStr.append("Timestamp: " + timeStamp);

					Document fields = (Document) d.get("fields");
					Document personalInfo = new Document();
					Document vaccineInfo = new Document();

					/** getting transaction info **/

					Document txInfo = (Document) fields.get("transaction");
					txID = txInfo.getInteger("txID");

					/** printing transaction info **/
					// mainStr.append(" ");
					// mainStr.append("***** Transaction data *****");
					// mainStr.append("Transaction ID: " + txID);
					String oldName = "";// USED TO RETIREVE ORIGINAL NAME INCASE IF NAME WAS CHANGED
					int oldDoseNumber = 0;

					switch (txID) {
					case 1,5:
						/** getting vaccine info **/
						vaccineInfo = (Document) fields.get("vacInfo");
						doseNumber = vaccineInfo.getInteger("doseNumber");
						doseType = vaccineInfo.getString("doseType");
						doseDate = vaccineInfo.getString("doseDate");
						doseExpiry = vaccineInfo.getString("doseExpiry");
						doseLocation = vaccineInfo.getString("doseLocation");
						
						
						
						mainStr.append("<p style=\"color:#5885AF;\">"+i+"- "+doseType+", taken on "+doseDate+" expires at "+doseExpiry+" taken in "+doseLocation+"</p>");
						
						i++;
						break;	
					}

				}
				
				
			} else {

				
				// retrieve all docs for a user
				ArrayList<Document> docs = new ArrayList<>();
				docs = dao.getAllDocs(passportNO);
				

				/** displaying content of array doc **/

				long timeStamp;
				int txID;
				String fname="";
				String lname="";
				String nationality="";
				String gender="";
				String birthDate="";
				int doseNumber=0;
				String doseType="";
				String doseDate="";
				String doseExpiry="";
				String doseLocation="";
				
				
				
				getClienPersonalInfo infoDao = new getClienPersonalInfo();
				ArrayList<String> personalInfoArr = infoDao.retrievePersonalInfoClient(passportNO);
				fname = personalInfoArr.get(0);
				lname = personalInfoArr.get(1);
				gender = personalInfoArr.get(2);
				birthDate = personalInfoArr.get(4);
				nationality = personalInfoArr.get(3);
				
				System.out.println("dfddfdfdfd");
				// PRINT UPDATED PERSONAL INFO
				mainStr.append("<b>Passport number: </b>"+passportNO);
				mainStr.append("<br><b>Full name: </b>" + fname +" "+lname);
				mainStr.append("<br><b>Gender: </b>" + gender);
				mainStr.append("<br><b>Nationality: </b>" + nationality);
				mainStr.append("<br><b>Birthdate: </b>" + birthDate);
				

				mainStr.append("<p style=\"font-weight:bold;text-align:center;margin=0;padding=0;\">  Transaction history  </p>");
				// printing all docs in a neat way
				for (Document d : docs) {

					/** getting basic info **/
					timeStamp = d.getLong("timeStamp");

					/** printing basic info */

					// mainStr.append("Timestamp: " + timeStamp);

					Document fields = (Document) d.get("fields");
					Document personalInfo = new Document();
					Document vaccineInfo = new Document();

					/** getting transaction info **/

					Document txInfo = (Document) fields.get("transaction");
					txID = txInfo.getInteger("txID");

					/** printing transaction info **/
					mainStr.append(" ");
					String oldName = "";// USED TO RETIREVE ORIGINAL NAME INCASE IF NAME WAS CHANGED
					int oldDoseNumber = 0;
					switch (txID) {
					case 1:
						mainStr.append("<p style=\"color:#D4AF37;margin=0;padding=0;font-weight:bold;\">________________________________________</p>");

						mainStr.append("<p style=\"color:#13265C;font-weight:bold;\">Added Dose</p>");
						
						/** getting vaccine info **/
						vaccineInfo = (Document) fields.get("vacInfo");
						doseNumber = vaccineInfo.getInteger("doseNumber");
						doseType = vaccineInfo.getString("doseType");
						doseDate = vaccineInfo.getString("doseDate");
						doseExpiry = vaccineInfo.getString("doseExpiry");
						doseLocation = vaccineInfo.getString("doseLocation");

						/** printing vaccine info **/
						
						mainStr.append("<p style=\"color:#5885AF;\">"+doseType+", taken on "+doseDate+" expires at "+doseExpiry+" taken in "+doseLocation+"</p>");

						break;

					case 2, 3:
						// name or nationality
						/** getting personal info **/
						personalInfo = (Document) fields.get("personalInfo");
						fname = personalInfo.getString("fname");
						lname = personalInfo.getString("lname");
						nationality = personalInfo.getString("nationality");
						gender = personalInfo.getString("gender");
						birthDate = personalInfo.getString("birthDate");

						/** printing personal info **/
						mainStr.append("<p style=\"color:#D4AF37;margin=0;padding=0;font-weight:bold;\">________________________________________</p>");

//						mainStr.append("***** Personal information *****");
						if (txID == 2) {
							
							mainStr.append("<p style=\"color:#13265C;font-weight:bold;tex-align:center;\">Change Name</p>");

							mainStr.append("<p style=\"color:#5885AF;margin:0;padding=0;\">"+oldName + " " + lname + " changed name to " + fname + " " + lname);
							mainStr.append(" at " + timeStamp+"</p>");

						}

						else if (txID == 3) {
							mainStr.append("<p style=\"color:#13265C;font-weight:bold;tex-align:center;\">Change Nationality</p>");

							mainStr.append("<p style=\"color:#5885AF;margin:0;padding=0;\">"+fname + " " + lname + " changed nationality to " + nationality);
							mainStr.append(" at " + timeStamp+"</p>");

						}

						mainStr.append(" ");

						break;

					case 4, 5:
						/** getting vaccine info **/

						vaccineInfo = (Document) fields.get("vacInfo");
						doseNumber = vaccineInfo.getInteger("doseNumber");
						doseType = vaccineInfo.getString("doseType");
						doseDate = vaccineInfo.getString("doseDate");
						doseExpiry = vaccineInfo.getString("doseExpiry");
						doseLocation = vaccineInfo.getString("doseLocation");
						mainStr.append("<p style=\"color:#D4AF37;margin=0;padding=0;font-weight:bold;\">________________________________________</p>");

						if (txID == 4) {
							mainStr.append("<p style=\"color:#13265C;font-weight:bold;tex-align:center;\">Change Dose Number</p>");
							
							Document changedDoseTx = (Document) fields.get("transaction");
							String description = changedDoseTx.getString("txType");
							mainStr.append("<p style=\"color:#5885AF\">"+description);
							Date date = new Date(timeStamp);
							mainStr.append("at " + date +"</p>");
							

						}

						else if (txID == 5) {
							mainStr.append("<p style=\"color:#13265C;font-weight:bold;tex-align:center;\">Added Dose</p>");

							mainStr.append("<p style=\"color:#5885AF\">"+doseType+", taken on "+doseDate+" expires at "+doseExpiry+" taken in "+doseLocation+"</p>");


						}

						break;
					}
				}
			}
			session.setAttribute("mainStrMOI", mainStr);
			response.sendRedirect("MOI/MOIPage.jsp");
		}
	}

}
