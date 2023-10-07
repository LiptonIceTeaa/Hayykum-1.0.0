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

public class MOHUpdateRecordDao {

	// adds block for nationality/name update
	public boolean update(String passportNO, String changeType, String fname, String lname, String gender,
			String nationality, String birthDate, int txID, long txTimeStamp, String txType, String previousHash,
			String currentHash, int blockIndex, int blockNonce, long blockTimeStamp) {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		Document document = new Document("Index", blockIndex);
		document.append("currentHash", currentHash);
		document.append("previousHash", previousHash);
		document.append("timeStamp", blockTimeStamp);
		document.append("nonce", blockNonce);

		// creating personal info document
		Document personalInfo = new Document();
		personalInfo.append("fname", fname);
		personalInfo.append("lname", lname);
		personalInfo.append("nationality", nationality);
		personalInfo.append("gender", gender);
		personalInfo.append("birthDate", birthDate);

		// creating transaction document
		Document tx = new Document();
		tx.append("timeStamp", txTimeStamp);
		tx.append("txID", txID);
		tx.append("txType", txType);

		Document fieldsDoc = new Document();
		fieldsDoc.append("passportNO", passportNO);
		fieldsDoc.append("personalInfo", personalInfo);
		fieldsDoc.append("transaction", tx);

		document.append("fields", fieldsDoc);

		// Inserting the document into the collection
		database.getCollection("blockchain").insertOne(document);
		System.out.println("Document inserted successfully");

		mongo.close();
		return true;

	}

	// adds block for dose number change
	public boolean addBlockDoseNumberChange(String passportNO, String doseType, String doseDate, String doseLocation, String doseExpiry,
			int doseNumber, long txTimeStamp, String txType, String previousHash, String currentHash, int blockNonce,
			long blockTimeStamp, int txID, int blockIndex) {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		Document document = new Document("Index", blockIndex);
		document.append("currentHash", currentHash);
		document.append("previousHash", previousHash);
		document.append("timeStamp", blockTimeStamp);
		document.append("nonce", blockNonce);

		// creating vaccine info document
		Document vacInfo = new Document();
		vacInfo.append("doseType", doseType);
		vacInfo.append("doseDate", doseDate);
		vacInfo.append("doseExpiry", doseExpiry);
		vacInfo.append("doseNumber", doseNumber);
		vacInfo.append("doseLocation", doseLocation);

		// creating transaction document
		Document tx = new Document();
		tx.append("timeStamp", txTimeStamp);
		tx.append("txID", txID);
		tx.append("txType", txType);

		Document fieldsDoc = new Document();
		fieldsDoc.append("passportNO", passportNO);
		fieldsDoc.append("vacInfo", vacInfo);
		fieldsDoc.append("transaction", tx);

		document.append("fields", fieldsDoc);

		// Inserting the document into the collection
		database.getCollection("blockchain").insertOne(document);
		//System.out.println("Document inserted successfully");

		mongo.close();
		return true;

	}

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

	// gets block for change name/nationality
	public Document getFirstBlock(String passportNo, String type) {

		// connecting to database
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		// creating collection or get collection if exists.
		MongoCollection<Document> collection = database.getCollection("blockchain");
		//System.out.println("collection created/found getPreviousHash ");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("fields.transaction.txID", 1);// find doc with Index==1
		//System.out.println("Retrieving latest name block");
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
		String latestName = "null";
		ArrayList<Document> blocksFilteredByPassportNO = new ArrayList<>();
		Document oldVal = new Document();
		// while loop to retrieve element
		try {
			while (cursor.hasNext()) {
				Document block = cursor.next();
				//System.out.println("Row: " + block);
				Document blockLvl2 = (Document) block.get("fields");
				Document blockLvl3 = (Document) blockLvl2.get("personalInfo");
				//System.out.println("Personal info: " + blockLvl3);
				if (blockLvl2.getString("passportNO").equals(passportNo))
					oldVal = blockLvl3;

			}
		} finally {
			cursor.close();
		}

		mongo.close();
		cursor.close();
		return oldVal;

	}
	
	// gets block for change name/nationality
		public Document getFirstBlockDoseNumberChange(String passportNo,int oldDoseNumber) {

			// connecting to database
			MongoClient mongo = new MongoClient("localhost", 27017);
			MongoDatabase database = mongo.getDatabase("blockchainLedger");

			// creating collection or get collection if exists.
			MongoCollection<Document> collection = database.getCollection("blockchain");
			//System.out.println("collection created/found getPreviousHash ");

			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("fields.transaction.txID", 5);// find docs with Index==5
			//System.out.println("Retrieving latest name block");
			MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
			String latestName = "null";
			ArrayList<Document> blocksFilteredByPassportNO = new ArrayList<>();
			Document oldVal = new Document();
			// while loop to retrieve element
			
			/* case sceario *?
			
			{1,3,3} --> {1,2,3} works
			{1,2,2} --> {1,2,3} doesnt work
			{1,2,3,2} --> {1,2,3,4} dosent work
			
			if code finds duplicate then compare position of duplicates,
			compare first value found with its left friend; if more by one then its not the issue,
			now go to second value and now its the one to change. (elaborate more before coding it)

			 */
			try {
				while (cursor.hasNext()) {
					Document block = cursor.next();
					//System.out.println("Row: " + block);
					Document blockLvl2 = (Document) block.get("fields");
					Document blockLvl3 = (Document) blockLvl2.get("vacInfo");
					//System.out.println("Vaccine info: " + blockLvl3);
					if (blockLvl2.getString("passportNO").equals(passportNo) 
							&& blockLvl3.getInteger("doseNumber")== oldDoseNumber ) {
						oldVal = blockLvl3;
						break;
					}

				}
			} finally {
				cursor.close();
			}

			mongo.close();
			cursor.close();
			return oldVal;

		}

//returns specific element found in the last document added to collection
	public String getPreviousHash(int id) {

		// connecting to database
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		// creating collection or get collection if exists.
		MongoCollection<Document> collection = database.getCollection("blockchain");
		//System.out.println("collection created/found getPreviousHash ");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Index", id);// find docs with Index==id
		//System.out.println("Retrieving latest block");
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
		String latestDoc = "null";

		// while loop to retrieve element
		while (cursor.hasNext()) {
			Document obj = (Document) cursor.next();
			latestDoc = obj.get("currentHash").toString();

		}
		mongo.close();
		cursor.close();
		return latestDoc;

	}

	// returns count of document in a collection
	public int getBlockCount() {
		// connecting to database
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("blockchainLedger");

		int i = (int) database.getCollection("blockchain").countDocuments();

		mongo.close();
		return i;

	}
	
	


}
