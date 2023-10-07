package com.Hayykum;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AddDoseDao {
	
	
	
	// creates a patient record + 1st dose
		public boolean addDose(String passportNO,String doseType,String doseDate,
				String doseLocation,String doseExpiry,int doseNumber,long txTimeStamp,String txType,
				String previousHash, String currentHash, int blockNonce, long blockTimeStamp,int txID,int blockIndex
				) {
			
			
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
		    MongoDatabase database = mongo.getDatabase("blockchainLedger");
		    
		    
		      Document document = new Document("Index",blockIndex);
		      document.append("currentHash", currentHash);
		      document.append("previousHash", previousHash);
		      document.append("timeStamp", blockTimeStamp);
		      document.append("nonce", blockNonce);
		      
		      
		      
		      
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
		      
		      
		      Document fieldsDoc = new Document();
		      fieldsDoc.append("passportNO", passportNO);
		      fieldsDoc.append("vacInfo", vacInfo);
		      fieldsDoc.append("transaction", tx);
		      
		      

		      document.append("fields", fieldsDoc);
		      

		      
		      //Inserting the document into the collection
		      database.getCollection("blockchain").insertOne(document);
		      System.out.println("Document inserted successfully");
		      
		      mongo.close();
		      return true;
		      
		      
		      
		}
	     // returns specific element found in the last document added to collection
		public Document getLatestDose(String passportNo) {
			
			// connecting to database
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
		    MongoDatabase database = mongo.getDatabase("blockchainLedger");
		    
		   //creating collection or get collection if exists.
		    MongoCollection<Document>  collection= database.getCollection("blockchain");
		    //System.out.println("collection created/found getPreviousHash ");
		    
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("fields.passportNO", passportNo );// find docs with passportNO==passportNumber	
			//System.out.println("Retrieving latest dose block");
			MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
			String latestDoc="null";
			ArrayList<Document> blocksFilteredByPassportNO = new ArrayList<>();
			 //while loop to retrieve element
			try {
	            while (cursor.hasNext()) {
	            	Document block = cursor.next();
	            	
	            	blocksFilteredByPassportNO.add(block);
	            	//System.out.println("row: "+block);
	            	
	            }
	        } finally {
	            cursor.close();
	        }
			
			Document latestDoseDoc = new Document();
			//filter blocks that have id==5 or id==1
			for(int i=0;i<blocksFilteredByPassportNO.size();i++) {
				Document temp = (Document) blocksFilteredByPassportNO.get(i);
				Document tempLvl2 = (Document) temp.get("fields");
				Document tempLvl3 = (Document) tempLvl2.get("transaction");
				if(tempLvl3.get("txID").toString().equals("5") || tempLvl3.get("txID").toString().equals("1")) {
					latestDoseDoc = (Document) tempLvl2.get("vacInfo");
				}
			}
			
			mongo.close();
			cursor.close();	
			return latestDoseDoc;
			
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
						//Document personalInfo = (Document) fields.get("personalInfo");
						String hesham = fields.getString("passportNO");
							if(hesham.equals(passportNumber)) {
							found=true;
							
							
						}
						
							
					    
					}
					iterDoc.cursor().close();
					mongo.close();
					
			return found;
			
		}
		
		// returns specific element found in the last document added to collection
		public String getPreviousHash(int id) {
			
			// connecting to database
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
		    MongoDatabase database = mongo.getDatabase("blockchainLedger");
		    
		   //creating collection or get collection if exists.
		    MongoCollection<Document>  collection= database.getCollection("blockchain");
		    System.out.println("collection created/found getPreviousHash ");
		    
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("Index", id );// find docs with Index==id
			System.out.println("Retrieving latest block");
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

}
