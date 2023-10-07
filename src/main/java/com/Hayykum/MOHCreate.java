package com.Hayykum;

import java.io.IOException;

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
import com.Hayykum.logic.PatientInfo;
import com.Hayykum.logic.PatientPersonalInfo;
import com.Hayykum.logic.Transaction;
import com.Hayykum.logic.VaccineInfo;
import com.Hayykum.logic.participants;
import com.Hayykum.logic.transactionStat;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 * Servlet implementation class MOHCreate
 */
@WebServlet("/MOHCreate")
public class MOHCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("User exists? ");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
		// Reading post parameters from the request
        String passportNO = request.getParameter("passportNO");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String nationality = request.getParameter("nationality");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        String doseType = request.getParameter("doseType");
        String doseDate = request.getParameter("doseDate");
        String doseLocation = request.getParameter("doseLocation");
        String doseExpiry = request.getParameter("doseExpiry");
        int doseNumber = Integer.parseInt(request.getParameter("doseNumber"));
       
        
        
		
        String employeeEmail = session.getAttribute("MOHEmployeeEmail").toString();
       // response.sendRedirect("MOH/MOHPage.jsp");
        
        
        
        
        
        
       // MOHCreateDao dao = new MOHCreateDao();
       // Boolean userExists = dao.checkIfUserExists(passportNO);
       // System.out.println("User exists? "+userExists);
        loginDao checkUserDao = new loginDao();
        boolean userExists = checkUserDao.checkUsingPassportNO(passportNO);
        if(userExists) {
        	
        	session.setAttribute("clientPassportNOAutoFill", passportNO);
        	//session.setAttribute("clientPassportNO",passportNO);
        	session.setAttribute("getAlertMOHCreateUserExists", "Yes");//Just initialize a random variable.
        	response.sendRedirect("MOH/MOHCreate.jsp");  
        	
        	
        	
        	
        }else {
        	 MOHCreateDao dao = new MOHCreateDao();
        	
        	//adding patient into sql database
        	clientRegistration registerSQL = new clientRegistration();
        	
        	
	//-----------------------------------------------------------
        
	
        	
        	 // creating patientInfo (perosonalInfo,vaccineInfo)
            PatientPersonalInfo personalInfo = new PatientPersonalInfo(fname, lname, participants.PATIENT, birthDate,
                    nationality, gender);
            VaccineInfo vaccineInfo = new VaccineInfo(doseNumber, doseDate, doseExpiry, doseType, doseLocation);
            PatientInfo patientInfo = new PatientInfo(personalInfo, passportNO, vaccineInfo);
            String transSignature = "Creating record for patient: "
                    + personalInfo.getFirstName()
                    + " " + personalInfo.getLastName()
                    + " Done by employee: " + employeeEmail;
            int transID = 1;
            Transaction patientMedicalRecord = BlockChainRunner.setTransaction(transSignature, transID);
            vaccineInfo.setDoseNO(1);            
           // create array of fields to be added in the block
            Object[] fieldsToBeAddedInBlock = { personalInfo, patientInfo.getVaccineInfo(),
                    patientInfo.getPassportNO() };
            
            transactionStat txStat = new transactionStat();
            Boolean txValid = BlockChainRunner.sendTx(transID, new Object[0], fieldsToBeAddedInBlock);
            
            if(!txValid) {
            	patientMedicalRecord.setTransID(-1);
            	String transSignatureWrong = "Creating record for patient: "
                        + personalInfo.getFirstName()
                        + " " + personalInfo.getLastName()
                        + " Done by employee: " + employeeEmail + "| Transaction status: "+txValid;
            	patientMedicalRecord.setTransType(transSignatureWrong);
            }
         
            
            int blockCount = dao.getBlockCount();//returns number of blocks in blockchain
            String previousHash = dao.getPreviousHash(blockCount);
            System.out.println("previousHash: "+previousHash);
            Block block = new Block(previousHash, fieldsToBeAddedInBlock,
    			      patientMedicalRecord);
    			block.mineBlock(BlockChainRunner.difficulty);
    			
    		//block info
    			
    		// Block metadata 
    		int blockNonce = block.getNonce();
    		String currentHash = block.getCurrentHash();
    		long blockTimeStamp = block.getTimestamp();
    		int blockIndex = blockCount+1;
    		
    		// Transaction data 
    		long txTimeStamp = patientMedicalRecord.getTimestamp();
    		int txID = patientMedicalRecord.getTransID();
    		String txType = patientMedicalRecord.getTransType();
    		
    			//blockChain.addBlock(block); // a block is added to the blockchain
    		

    		
    		// 1- compare with MOI
    		// if valid, compare with MOFA
    		// if not, check if MOI's last block index is greater than MOH last block index
    		// if not greater, do nothing, else
    		// ask MOI for entire blockchain
    		// check if blockchain is valid or not, if valid replace with MOH current blockchain
    		// now repeat with MOFA
    		
    		
    		dao.addRecord(
    				passportNO, fname, lname, nationality,gender, birthDate,
    				doseType, doseDate,doseLocation, doseExpiry,doseNumber,
    				txTimeStamp, txID, txType,
    				previousHash,currentHash, blockNonce,blockTimeStamp,blockIndex
    				);
    	
    		
    		registerClinetDao registerClinet = new registerClinetDao();
    		
    		registerClinet.registerClient(passportNO,birthDate ,fname, lname, nationality, birthDate, gender,1);
    		//response.sendRedirect("homePage.jsp");
    		session.setAttribute("getAlertMOHCreateUserAdded", "Yes");
    		//getAlertMOHCreateUserAdded
    		response.sendRedirect("MOH/MOHCreate.jsp");
        	return;
        
        	
        }			

	}
	
	
	

}
