package com.Hayykum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

/**
 * Servlet implementation class MOHQuery
 */
@WebServlet("/MOHQueryRecord")
public class MOHQueryRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = request.getParameter("emailMOH");

		String passportNO = request.getParameter("passportNO");
		String radioButtonChoice = request.getParameter("group1");

		MOHQueryRecordDao dao = new MOHQueryRecordDao();

		if (!dao.checkIfUserExists(passportNO)) {
			//mainStr.append("User dosen't exist");

			session.setAttribute("MOHQueryUserDoesntExist", "Yes");// Just initialize a random variable.
			response.sendRedirect("MOH/MOHQuery.jsp");
				return;

		} else {

			StringBuilder mainStr = new StringBuilder();
			
			
			//mainStr.append("Radio choice: " + radioButtonChoice);

			/** retrieve all document belonging to a certain passport number **/
			ArrayList<Document> docs = dao.getAllDocs(passportNO);

			if (radioButtonChoice.equals("allRecords")) {

				/** displaying content of array doc **/
				int index;
				int nonce;
				String currentHash;
				String previousHash;
				long timeStamp;
				int txID;
				String txDescription;
				long txTime;
				String fname;
				String lname;
				String nationality;
				String gender;
				String birthDate;
				int doseNumber;
				String doseType;
				String doseDate;
				String doseExpiry;
				String doseLocation;

				for (Document d : docs) {
					
					
					
					/** getting basic info **/
					index = d.getInteger("Index");
					nonce = d.getInteger("nonce");
					currentHash = d.getString("currentHash");
					previousHash = d.getString("previousHash");
					timeStamp = d.getLong("timeStamp");

					/** printing basic info */
					
					//mainStr.append(System.getProperty("line.separator"));
					mainStr.append("<br><p style=\"color:blue;text-align:center;font-weight:bold;\""+"<b>********** Block "+ index +" metadata **********</b></p>");
					mainStr.append("<p style="+"\"color:#666699\""+">Current hash: " + currentHash);
					mainStr.append("<br>Previous hash: " + previousHash);
					mainStr.append("<br>Timestamp: " + timeStamp + " | Nonce: " + nonce +"</p>");

					Document fields = (Document) d.get("fields");
					Document personalInfo = new Document();
					Document vaccineInfo = new Document();

					/** getting transaction info **/

					Document txInfo = (Document) fields.get("transaction");
					txID = txInfo.getInteger("txID");
					txDescription = txInfo.getString("txType");
					txTime = txInfo.getLong("timeStamp");

					/** printing transaction info **/
					//mainStr.append(System.getProperty("line.separator"));
					mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;  Transaction Data &nbsp; &nbsp; &nbsp;  </p>");
					mainStr.append("<p style="+"\"color:#666699\""+">Transaction: " + txDescription);
					mainStr.append("<br>Transaction ID: " + txID);
					mainStr.append("<br>Timestamp: " + txTime+"</p>");

					switch (txID) {
					case 1:
						/** getting personal info **/
						personalInfo = (Document) fields.get("personalInfo");
						fname = personalInfo.getString("fname");
						lname = personalInfo.getString("lname");
						nationality = personalInfo.getString("nationality");
						gender = personalInfo.getString("gender");
						birthDate = personalInfo.getString("birthDate");

						/** printing personal info **/
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Personal Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style=\"color:#666699\">"+"First name: " + fname);
						mainStr.append(" | Last name: " + lname);
						mainStr.append("<br>Nationality: " + nationality);
						mainStr.append(" | Gender: " + gender);
						mainStr.append("<br>Birth date: " + birthDate+"</p>");

						/** getting vaccine info **/
						vaccineInfo = (Document) fields.get("vacInfo");
						doseNumber = vaccineInfo.getInteger("doseNumber");
						doseType = vaccineInfo.getString("doseType");
						doseDate = vaccineInfo.getString("doseDate");
						doseExpiry = vaccineInfo.getString("doseExpiry");
						doseLocation = vaccineInfo.getString("doseLocation");

						/** printing vaccine info **/
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Vaccine Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style=\"color:#666699\">"+"Dose number: " + doseNumber);
						mainStr.append(" | Dose: " + doseType);
						mainStr.append("<br>Dose date: " + doseDate);
						mainStr.append("<br>Dose expiry date: " + doseExpiry);
						mainStr.append("<br>Dose lcoation: " + doseLocation+"</p>");

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
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Personal Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style=\"color:#666699\">"+"First name: " + fname);
						mainStr.append(" | Last name: " + lname);
						mainStr.append("<br>Nationality: " + nationality);
						mainStr.append(" | Gender: " + gender);
						mainStr.append("<br>Birth date: " + birthDate+"</p>");
						break;

					case 4, 5:
						/** getting vaccine info **/
						vaccineInfo = (Document) fields.get("vacInfo");
						doseNumber = vaccineInfo.getInteger("doseNumber");
						doseType = vaccineInfo.getString("doseType");
						doseDate = vaccineInfo.getString("doseDate");
						doseExpiry = vaccineInfo.getString("doseExpiry");
						doseLocation = vaccineInfo.getString("doseLocation");
						

						/** printing vaccine info **/
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Vaccine Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style=\"color:#666699\">"+"Dose number: " + doseNumber);
						mainStr.append(" | Dose: " + doseType);
						mainStr.append("<br>Dose date: " + doseDate);
						mainStr.append("<br>Dose expiry date: " + doseExpiry);
						mainStr.append("<br>Dose lcoation: " + doseLocation+"</p>");
						
						break;
					}

				}

			} else if (radioButtonChoice.equals("latestDose")) {

				Document latestDose = new Document();

				/** getting latest dose from docs file **/
				for (Document d : docs) {

					Document fields = (Document) d.get("fields");
					Document transactionInfo = (Document) fields.get("transaction");
					int txID = transactionInfo.getInteger("txID");
					if (txID == 1 || txID == 5 || txID == 4) {

						Document vaccineInfo = (Document) fields.get("vacInfo");
						int vacDose = vaccineInfo.getInteger("doseNumber");
						// mainStr.append("Dose number: "+vacDose);
						latestDose = vaccineInfo;
					}

				}

				/** getting vaccine info **/

				int doseNumber = latestDose.getInteger("doseNumber");
				String doseType = latestDose.getString("doseType");
				String doseDate = latestDose.getString("doseDate");
				String doseExpiry = latestDose.getString("doseExpiry");
				String doseLocation = latestDose.getString("doseLocation");

				/** printing vaccine info **/
				//mainStr.append(System.getProperty("line.separator"));
				mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Vaccine Data &nbsp; &nbsp; &nbsp;  </p>");
				mainStr.append("<p style=\"color:#666699\">"+"Dose number: " + doseNumber);
				mainStr.append(" | Dose: " + doseType);
				mainStr.append("<br>Dose date: " + doseDate);
				mainStr.append("<br>Dose expiry date: " + doseExpiry);
				mainStr.append("<br>Dose lcoation: " + doseLocation+"</p>");

			} else {

				Document latestDose = new Document();

				/** getting latest dose from docs file **/
				for (Document d : docs) {

					Document fields = (Document) d.get("fields");
					Document transactionInfo = (Document) fields.get("transaction");
					int txID = transactionInfo.getInteger("txID");
					if (txID == 1 || txID == 5 || txID == 4) {
						latestDose = (Document) fields.get("vacInfo");

						/** getting basic info **/
						int index = d.getInteger("Index");
						int nonce = d.getInteger("nonce");
						String currentHash = d.getString("currentHash");
						String previousHash = d.getString("previousHash");
						long timeStamp = d.getLong("timeStamp");

						
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"color:blue;text-align:center;font-weight:bold;\""+"<b>********** Block "+ index +" metadata **********</b></p>");
						mainStr.append("<p style="+"\"color:#666699\""+">Current hash: " + currentHash);
						mainStr.append("<br>Previous hash: " + previousHash);
						mainStr.append("<br>Timestamp: " + timeStamp + " | Nonce: " + nonce +"</p>");

						/** getting transaction info **/

						txID = transactionInfo.getInteger("txID");
						String txDescription = transactionInfo.getString("txType");
						long txTime = transactionInfo.getLong("timeStamp");

						/** printing transaction info **/
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Transaction Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style="+"\"color:#666699;text-align:center\""+">Transaction: " + txDescription);
						mainStr.append("<br>Transaction ID: " + txID);
						mainStr.append("<br>Timestamp: " + txTime+"</p>");

						/** getting vaccine info **/

						int doseNumber = latestDose.getInteger("doseNumber");
						String doseType = latestDose.getString("doseType");
						String doseDate = latestDose.getString("doseDate");
						String doseExpiry = latestDose.getString("doseExpiry");
						String doseLocation = latestDose.getString("doseLocation");

						/** printing vaccine info **/
						//mainStr.append(System.getProperty("line.separator"));
						mainStr.append("<br><p style=\"text-align:center;font-weight:bold;\">"+"&nbsp; &nbsp; &nbsp;   Vaccine Data &nbsp; &nbsp; &nbsp;  </p>");
						mainStr.append("<p style=\"color:#666699;\">"+"Dose number: " + doseNumber);
						mainStr.append(" | Dose: " + doseType);
						mainStr.append("<br>Dose date: " + doseDate);
						mainStr.append("<br>Dose expiry date: " + doseExpiry);
						mainStr.append("<br>Dose lcoation: " + doseLocation+"</p>");

					}

				}

			}
			
			String mainStrString = mainStr.toString();
			
			session.setAttribute("mainStr", mainStrString);// Just initialize a random variable.
			session.setAttribute("MOHQueryUserExist", "Yes");// Just initialize a random variable.
			response.sendRedirect("MOH/MOHQuery.jsp");
			return;

		}
	}

}
