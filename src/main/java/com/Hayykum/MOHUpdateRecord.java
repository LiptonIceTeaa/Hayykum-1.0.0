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

import org.bson.Document;

import com.Hayykum.logic.Block;
import com.Hayykum.logic.BlockChainRunner;
import com.Hayykum.logic.PatientPersonalInfo;
import com.Hayykum.logic.Transaction;
import com.Hayykum.logic.VaccineInfo;
import com.Hayykum.logic.participants;

/**
 * Servlet implementation class MOHUpdateRecord
 */
@WebServlet("/MOHUpdateRecord")
public class MOHUpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		

		String passportNO = request.getParameter("passportNO");
		String changeType = request.getParameter("changeType");
		
		System.out.println("I am here @ get methodds\nPassport number: "+passportNO);
		System.out.println("Change type:: "+changeType);


		MOHUpdateRecordDao dao = new MOHUpdateRecordDao();

		boolean isValid = dao.checkIfUserExists(passportNO);

		if (!isValid) {
			// return null
		} else {
			
			Document personalInfo = dao.getFirstBlock(passportNO, changeType);
			
			getClienPersonalInfo infoDao = new getClienPersonalInfo();
			ArrayList<String> personalInfoArr = infoDao.retrievePersonalInfoClient(passportNO);
			String fname;
			String nationality;
			
			
			if (changeType.equals("fname")) {
				
				fname = personalInfoArr.get(0);
				out.print(fname);
				
				
			} else if (changeType.equals("nationality")) {
				
				nationality = personalInfoArr.get(3);
				out.print(nationality);
				
			} else {
				// return null
			}
		}

	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String passportNO = request.getParameter("passportNO");
		String changeType = request.getParameter("changeType");
		String oldValDose = request.getParameter("previousValue");
		String newVal = request.getParameter("newValue");

		String employeeString = session.getAttribute("MOHEmployeeEmail").toString();

		MOHUpdateRecordDao dao = new MOHUpdateRecordDao();
		updateClientInfo updateDao = new updateClientInfo();

		if (!dao.checkIfUserExists(passportNO)) {
			System.out.print("User doesnt exist");

			session.setAttribute("getAlertMOHUpdateUserDoesntExist", "Yes");// Just initialize a random variable.
			response.sendRedirect("MOH/MOHUpdate.jsp");

		} else {

			Document oldValues = new Document();
			//oldValues = dao.getFirstBlock(passportNO, changeType);
		//	System.out.println("Row final: " + oldValues);
		//	String oldNationality = oldValues.getString("nationality");
		//	String oldFName = oldValues.getString("fname");
		//	String oldLName = oldValues.getString("lname");
		//	String gender = oldValues.getString("gender");
		//	String birthDate = oldValues.getString("birthDate");
			
			getClienPersonalInfo infoDao = new getClienPersonalInfo();
			ArrayList<String> personalInfoArr = infoDao.retrievePersonalInfoClient(passportNO);
			String oldFName = personalInfoArr.get(0);
			System.out.println("PRONONVOWN" +oldFName);
			String oldLName = personalInfoArr.get(1);
			String gender = personalInfoArr.get(2);
			String birthDate = personalInfoArr.get(4);
			String oldNationality = personalInfoArr.get(3);
			

			if (changeType.equals("nationality")) {

				System.out.println("Old nationality: " + oldNationality);

				PatientPersonalInfo oldPi = new PatientPersonalInfo(oldFName, oldLName, participants.PATIENT, birthDate,
						oldNationality, gender);

				PatientPersonalInfo newPi = oldPi;
				newPi.setNationality(newVal);

				String txDescriptionShort = "Holder of passport number: " + passportNO + " changed from " + " "
						+ oldNationality + " to " + newPi.getNationality() + " | Done by employee: " + employeeString;

				int txID = 3;
				Transaction tx = BlockChainRunner.setTransaction(txDescriptionShort, txID);

				Object[] readFields = { oldPi, passportNO };
				Object[] writeFields = { newPi, passportNO };

				Boolean txValid = BlockChainRunner.sendTx(txID, readFields, writeFields);

				if (!txValid) {
					tx.setTransID(-1);
				}

				int blockCount = dao.getBlockCount();
				String previousHash = dao.getPreviousHash(blockCount);
				Block block = new Block(previousHash, writeFields, tx);
				block.mineBlock(BlockChainRunner.difficulty);
				String currentHash = block.getCurrentHash();
				int nonce = block.getNonce();
				long timeStamp = block.getTimestamp();
				int index = blockCount + 1;

				int txIDD = tx.getTransID();
				long txTime = tx.getTimestamp();
				String txDescription = tx.getTransType();

				dao.update(passportNO, changeType, newPi.getFirstName(), newPi.getLastName(), newPi.getGender(),
						newPi.getNationality(), newPi.getbirthDate(), txIDD, txTime, txDescription, previousHash,
						currentHash, index, nonce, timeStamp);
				
				updateDao.udpateClient(passportNO, changeType, newVal);
				System.out.println("Update block added");

			} else if (changeType.equals("fname")) {

				System.out.println("Old name: " + oldFName);

				PatientPersonalInfo oldPi = new PatientPersonalInfo(oldFName, oldLName, participants.PATIENT, birthDate,
						oldNationality, gender);

				PatientPersonalInfo newPi = oldPi;

				newPi.setFirstName(newVal);
				;

				String txDescriptionShort = "Holder of passport number: " + passportNO + " changed from " + " "
						+ oldFName + " to " + newPi.getFirstName() + " | Done by employee: " + employeeString;

				int txID = 2;
				Transaction tx = BlockChainRunner.setTransaction(txDescriptionShort, txID);

				Object[] readFields = { oldPi, passportNO };
				Object[] writeFields = { newPi, passportNO };

				Boolean txValid = BlockChainRunner.sendTx(txID, readFields, writeFields);

				if (!txValid) {
					tx.setTransID(-1);
				}

				int blockCount = dao.getBlockCount();
				String previousHash = dao.getPreviousHash(blockCount);
				Block block = new Block(previousHash, writeFields, tx);
				block.mineBlock(BlockChainRunner.difficulty);
				String currentHash = block.getCurrentHash();
				int nonce = block.getNonce();
				long timeStamp = block.getTimestamp();
				int index = blockCount + 1;

				int txIDD = tx.getTransID();
				long txTime = tx.getTimestamp();
				String txDescription = tx.getTransType();

				dao.update(passportNO, changeType, newPi.getFirstName(), newPi.getLastName(), newPi.getGender(),
						newPi.getNationality(), newPi.getbirthDate(), txIDD, txTime, txDescription, previousHash,
						currentHash, index, nonce, timeStamp);
				
				updateDao.udpateClient(passportNO, changeType, newVal);
				System.out.println("Update block added");

			} else {

				// chnage specific dose number
				// retrieve block with specific dose number and specific passport number
				// save it in an oldVacInfo object
				// create new newVacInfo object

				System.out.println("Old dose number: " + oldValDose);

				/* block with specific dose number and specific passport number */
				int oldDoseNo = Integer.parseInt(oldValDose);
				Document oldDoseVacInfo = new Document();
				oldDoseVacInfo = dao.getFirstBlockDoseNumberChange(passportNO, oldDoseNo);
				String doseType = oldDoseVacInfo.getString("doseType");
				String doseDate = oldDoseVacInfo.getString("doseDate");
				String doseExpiry = oldDoseVacInfo.getString("doseExpiry");
				String doseLocation = oldDoseVacInfo.getString("doseLocation");
				System.out.println("Vac info row: " + oldDoseVacInfo);

				/* old vacInfo block paramaters */
				VaccineInfo oldVi = new VaccineInfo(oldDoseNo, doseDate, doseExpiry, doseType, doseLocation);

				VaccineInfo newVi = oldVi;

				int newDoseNumber = Integer.parseInt(newVal);
				newVi.setDoseNO(newDoseNumber);

				String txDescriptionShort = "Holder of passport number: " + passportNO + " changed from dose number: "
						+ " " + oldValDose + " to " + newVi.getDoseNO() + " | Done by employee: " + employeeString;

				int txID = 4;
				Transaction tx = BlockChainRunner.setTransaction(txDescriptionShort, txID);

				Object[] readFields = { oldVi, passportNO };
				Object[] writeFields = { newVi, passportNO };

				Boolean txValid = BlockChainRunner.sendTx(txID, readFields, writeFields);

				if (!txValid) {
					tx.setTransID(-1);
				}

				int blockCount = dao.getBlockCount();
				String previousHash = dao.getPreviousHash(blockCount);
				Block block = new Block(previousHash, writeFields, tx);
				block.mineBlock(BlockChainRunner.difficulty);
				String currentHash = block.getCurrentHash();
				int nonce = block.getNonce();
				long timeStamp = block.getTimestamp();
				int index = blockCount + 1;

				int txIDD = tx.getTransID();
				long txTime = tx.getTimestamp();
				String txDescription = tx.getTransType();

				dao.addBlockDoseNumberChange(passportNO, doseType, newVi.getDoseDate(), newVi.getVaccineCountry(),
						newVi.getDoseExpiry(), newVi.getDoseNO(), txTime, txDescription, previousHash, currentHash,
						nonce, timeStamp, txIDD, index);
				
				updateDao.udpateClient(passportNO, changeType, newVal);
				System.out.println("Update block added");

			}

			session.setAttribute("getAlertMOHUpdateUserUpdated", "Yes");// Just initialize a random variable.
			response.sendRedirect("MOH/MOHUpdate.jsp");
		}

	}

}
