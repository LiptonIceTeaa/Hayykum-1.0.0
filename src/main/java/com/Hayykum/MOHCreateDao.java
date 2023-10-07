package com.Hayykum;


import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoDatabase;

import java.util.*;



import org.bson.Document;

import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;






public class MOHCreateDao {
	
	public MOHCreateDao() {
		System.out.println("cons called");
	}
	
	

    
	
    
    // creates a patient record + 1st dose
	public boolean addRecord(String passportNO,String fname,String lname,String nationality,String gender,
			String birthDate,String doseType,String doseDate,
			String doseLocation,String doseExpiry,int doseNumber,long txTimeStamp, int txID, String txType,
			String previousHash, String currentHash, int blockNonce, long blockTimeStamp,int blockIndex
			) {
		
	       
	      //Connecting to the database
	     // MongoDatabase database = mongo.getDatabase("myDatabase");
	      //Creating a collection
	     // database.createCollection("students");
	      //Preparing a document
		
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    MongoDatabase database = mongo.getDatabase("blockchainLedger");
	    
	    
	      Document document = new Document("Index",blockIndex);
	      document.append("currentHash", currentHash);
	      document.append("previousHash", previousHash);
	      document.append("timeStamp", blockTimeStamp);
	      document.append("nonce", blockNonce);
	      
	      
	      //creating personal info document
	      Document personalInfo = new Document();
	      personalInfo.append("fname", fname);
	      personalInfo.append("lname", lname);
	      personalInfo.append("nationality", nationality);
	      personalInfo.append("gender", gender);
	      personalInfo.append("birthDate", birthDate);
	      
	      //creating vaccine info document
	      Document vacInfo = new Document();
	      vacInfo.append("doseType",doseType);
	      vacInfo.append("doseDate", doseDate);
	      vacInfo.append("doseExpiry", doseExpiry);
	      vacInfo.append("doseNumber", doseNumber);
	      vacInfo.append("doseLocation", doseLocation);
	      
	      //creating transaction document
	      Document tx = new Document();
	      tx.append("timeStamp", txTimeStamp);
	      tx.append("txID", txID);
	      tx.append("txType", txType);
	      
	      
	      
	      
	      //Creating fields[] document
	      //fields[]Doc = personalInfo + vacInfo
	      
	      Document fieldsDoc = new Document();
	      fieldsDoc.append("passportNO", passportNO);
	      fieldsDoc.append("personalInfo", personalInfo);
	      fieldsDoc.append("vacInfo", vacInfo);
	      fieldsDoc.append("transaction", tx);
	      
	      

	      document.append("fields", fieldsDoc);
	      

	      
	      //Inserting the document into the collection
	      database.getCollection("blockchain").insertOne(document);
	      //System.out.println("Document inserted successfully");
	      
	      mongo.close();
	      return true;
	      
	      
	      
	}
	
	
	// returns specific element found in the last document added to collection
	public String getPreviousHash(int id) {
		
		// connecting to database
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    MongoDatabase database = mongo.getDatabase("blockchainLedger");
	    
	   //creating collection or get collection if exists.
	    MongoCollection<Document>  collection= database.getCollection("blockchain");
	    //System.out.println("collection created/found getPreviousHash ");
	    
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Index", id );// find docs with Index==id
		//System.out.println("Retrieving latest block");
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
		String latestDoc="null";
		
		 //while loop to retrieve element
		while (cursor.hasNext()) {			
			Document obj = (Document) cursor.next();
			latestDoc = obj.get("currentHash").toString();
			
		}
		
		mongo.close();
		cursor.close();	
		return latestDoc;
		
	}
	
	//returns count of document in a collection
	public int getBlockCount() {
		       // connecting to database
				MongoClient mongo = new MongoClient( "localhost" , 27017 );
			    MongoDatabase database = mongo.getDatabase("blockchainLedger");
		
			   int i = (int) database.getCollection("blockchain").countDocuments();
			    
				mongo.close();
				return i;
			    
			    
	}
	
	
	public Boolean checkIfUserExists(String passportNumber) {
		
		// connecting to database
				MongoClient mongo = new MongoClient( "localhost" , 27017 );
			    MongoDatabase database = mongo.getDatabase("blockchainLedger");
			    
			   //creating collection or get collection if exists.
			    MongoCollection<Document>  collection= database.getCollection("blockchain");
			   // System.out.println("collection created/found getPreviousHash ");
		
				//Listing All Mongo Documents in Collection
				FindIterable<Document> iterDoc = collection.find();
				
				// Getting the iterator
				//System.out.println("Listing All Mongo Documents");
				Iterator it = iterDoc.iterator();
				
				Boolean found = false;
				
				while (it.hasNext()) {
				
					
					Document row = (Document) it.next();
					Document fields = (Document) row.get("fields");
					//String passportNO =  fields.get("passportNO");
					String hesham = fields.get("passportNO").toString();
					if(hesham.equals(passportNumber)) {
						found=true;
						//return found;
					}
					
					//System.out.println("Passport number deezo: "+hesham);
						
				    
				}
				
				iterDoc.cursor().close();
				mongo.close();
				
		return found;
		
	}
	

	 
      

	
	
	
	

}
