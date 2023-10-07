package com.Hayykum;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MOICreateDao {
	
	
	 // creates a patient record + 1st dose
		public boolean addRecord(
				) {
			
		       
		      //Connecting to the database
		     // MongoDatabase database = mongo.getDatabase("myDatabase");
		      //Creating a collection
		     // database.createCollection("students");
		      //Preparing a document
			
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
		    MongoDatabase database = mongo.getDatabase("blockchainLedger");
		    
		    
		      Document document = new Document();
		      document.append("currentHash", "example");
		     
		      
		      
		
		      
		      
		      
		      
		      //Creating fields[] document
		      //fields[]Doc = personalInfo + vacInfo
		     
		      

		   

		      
		      //Inserting the document into the collection
		      database.getCollection("blockchainMOI").insertOne(document);
		      //System.out.println("Document inserted successfully");
		      
		      mongo.close();
		      return true;
		      
		      
		      
		}

}
