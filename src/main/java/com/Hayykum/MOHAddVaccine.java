package com.Hayykum;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.Hayykum.logic.Block;
import com.Hayykum.logic.BlockChainRunner;
import com.Hayykum.logic.Transaction;
import com.Hayykum.logic.VaccineInfo;

/**
 * Servlet implementation class MOHAddVaccine
 */
@WebServlet("/MOHAddVaccine")
public class MOHAddVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("lol ez");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		//PrintWriter out = response.getWriter();
				HttpSession session = request.getSession();
				String employeeString = session.getAttribute("MOHEmployeeEmail").toString();
				
				// Reading post parameters from the request
		        String passportNO = request.getParameter("passportNO");
		        String doseType = request.getParameter("doseType");
		        String doseDate = request.getParameter("doseDate");
		        String doseLocation = request.getParameter("doseLocation");
		        String doseExpiry = request.getParameter("doseExpiry");
		        int doseNumber = Integer.parseInt(request.getParameter("doseNumber"));
		        AddDoseDao dao = new AddDoseDao();
		        Document vaccineInfoo = dao.getLatestDose(passportNO);
		        System.out.println("Dose doc: "+vaccineInfoo);
		        int latestDoseNumber=0;
		       
			    
			    latestDoseNumber = vaccineInfoo.getInteger("doseNumber");
			    
			    
			    getClienPersonalInfo infoDao = new getClienPersonalInfo();
				ArrayList<String> personalInfoArr = infoDao.retrievePersonalInfoClient(passportNO);
				for(String a: personalInfoArr) {
					System.out.println("a: "+a);
				}
				latestDoseNumber = Integer.parseInt(personalInfoArr.get(5));
				
		        
		  if(!dao.checkIfUserExists(passportNO)) {
			  
			  session.setAttribute("getAlertMOHAddDose", "Yes");
			  response.sendRedirect("MOH/MOHAddDose.jsp");  
			  return;
			  
			  
		  }else if(doseNumber <= latestDoseNumber || (doseNumber-latestDoseNumber)!=1){
			  session.setAttribute("getAlertMOHAddDoseAlreadyExists", "Yes");
			  response.sendRedirect("MOH/MOHAddDose.jsp");  
			  return;
			  
		  }
		  else {
		        	
		        	
		        	
		        	VaccineInfo vaccineInfo = new VaccineInfo(doseNumber,doseDate
		        			,doseExpiry,doseType,doseLocation);
		        	
		        	
		        	String transDiscription = "Added dose for patient: "
                            + passportNO
                            + " | Done by employee: " + employeeString;
		        	
		        	Object[] fields = { vaccineInfo, passportNO };
		        	
		        	int transID = 5;
		        	int blockCount = dao.getBlockCount();
		        	String previousHash = dao.getPreviousHash(blockCount);
		        	
		        	 Transaction medicalRecord = BlockChainRunner.setTransaction(transDiscription,
		        			 transID);
		     		
		     		
		        	 Document latestDose = dao.getLatestDose(passportNO);
		        	 int readDoseNumber = latestDose.getInteger("doseNumber");
		        	 String readDoseDate = latestDose.getString("doseDate");
		        	 String readDoseExpiry = latestDose.getString("doseExpiry");
		        	 String readDoseType = latestDose.getString("doseType");
		        	 String readDoseLocation = latestDose.getString("doseLocation");
		        	 VaccineInfo readVacInfo = new VaccineInfo(readDoseNumber,readDoseDate,
		        			 readDoseExpiry,readDoseType,readDoseLocation);
		        	 
		        	 Object [] readFields = {readVacInfo,passportNO};
		        	 Boolean txValid = BlockChainRunner.sendTx(transID, fields, readFields);
		        	 if(!txValid) {
		        		 medicalRecord.setTransID(-1);
		        		 String transSignatureWrong = "Added dose for patient: "
		                            + passportNO
		                            + " | Done by employee: " + employeeString + "| Transaction status: "+txValid;
		             	medicalRecord.setTransType(transSignatureWrong);
		        	 }
		        	 
		        	 Block block = new Block(previousHash, fields, medicalRecord);
		        	 block.mineBlock(BlockChainRunner.difficulty);
		        	 
		        	 String currentHash = block.getCurrentHash();
		        	 int nonce = block.getNonce();
		        	 long timeStamp = block.getTimestamp();
		        	 
		        	 /* Transaction data */
		     		long txTimeStamp = medicalRecord.getTimestamp();
		     		int txID = medicalRecord.getTransID();
		     		String txType = medicalRecord.getTransType();
		     		int blockIndex = dao.getBlockCount()+1;
		        	 dao.addDose(passportNO,
			     				doseType, doseDate, doseLocation, doseExpiry, doseNumber,
			     				txTimeStamp,txType, previousHash, currentHash, nonce, txTimeStamp, txID,
			     				blockIndex);
		        	 
		        	 updateClientInfo updateClientInfoDao = new updateClientInfo();
		        	 updateClientInfoDao.udpateClient(passportNO, "dosesNO", String.valueOf(doseNumber));
		        	 
		        	session.setAttribute("getAlertMOHAddDoseSucess", "Yes");
		        	response.sendRedirect("MOH/MOHAddDose.jsp");
		        	 return;
		        	 
		  }
		  
		  
		        }
	
	
		        
	}


