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

public class MOHQueryRecordDao {

	public Boolean checkIfUserExists(String passportNumber) {

		// connecting to database
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		// creating collection or get collection if exists.
		MongoCollection<Document> collection = database.getCollection("blockchain");
		// System.out.println("collection created/found getPreviousHash ");

		// Listing All Mongo Documents in Collection
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		System.out.println("Listing All Mongo Documents");
		Iterator it = iterDoc.iterator();

		Boolean found = false;

		while (it.hasNext()) {

			Document row = (Document) it.next();
			Document fields = (Document) row.get("fields");
			// Document personalInfo = (Document) fields.get("personalInfo");
			String hesham = fields.getString("passportNO");
			if (hesham.equals(passportNumber)) {
				found = true;

			}

		}
		iterDoc.cursor().close();
		mongo.close();

		return found;

	}
	
	public ArrayList<Document> getAllDocs(String passportNO){
		// connecting to database
					MongoClient mongo = new MongoClient( "localhost" , 27017 );
				    MongoDatabase database = mongo.getDatabase("blockchainLedger");
				    
				   //creating collection or get collection if exists.
				    MongoCollection<Document>  collection= database.getCollection("blockchain");
				    //System.out.println("collection created/found getPreviousHash ");
				    
					BasicDBObject searchQuery = new BasicDBObject();
					searchQuery.put("fields.passportNO", passportNO );// find docs with passport number = passportNO
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
					
					
					mongo.close();
					cursor.close();	
					return blocksFilteredByPassportNO;
					
				}
	
	
	public String getLatestBlockHash() {
		// connecting to database
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		// creating collection or get collection if exists.
		MongoCollection<Document> collection = database.getCollection("blockchain");
		// System.out.println("collection created/found getPreviousHash ");

		// Listing All Mongo Documents in Collection
		FindIterable<Document> iterDoc = collection.find();

		// Getting the iterator
		// System.out.println("Listing All Mongo Documents");
		Iterator it = iterDoc.iterator();

	
		String hash="";

		while (it.hasNext()) {

			Document row = (Document) it.next();
			Document fields = (Document) row.get("fields");
			// String passportNO = fields.get("passportNO");
			Document tran = (Document) fields.get("transaction");
			hash = tran.getString("txID");
	

		}
		System.out.println("MOI Latest block hash: "+hash);

		iterDoc.cursor().close();
		mongo.close();

		return hash;
	}
	}


