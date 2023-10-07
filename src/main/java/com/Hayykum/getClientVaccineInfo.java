package com.Hayykum;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class getClientVaccineInfo {
	

	public static ArrayList<String> getVaccineInfo(String passportNO) {
		
		MOIQueryRecordDao dao = new MOIQueryRecordDao();

		// retrieve all docs for a user
		ArrayList<Document> docs = new ArrayList<>();
		docs = dao.getAllDocs(passportNO);
		
		
		int txID ;
		String doseType = "";
		String doseExpiry = "";
		ArrayList<String> data = new ArrayList<>();
		for (Document d : docs) {

			Document fields = (Document) d.get("fields");
			
			Document vaccineInfo = new Document();

			Document txInfo = (Document) fields.get("transaction");
			txID = txInfo.getInteger("txID");
			

			switch (txID) {
			case 1, 5:
				//sSystem.out.println("in docs: "+d);
				/** getting vaccine info **/
				vaccineInfo = (Document) fields.get("vacInfo");
				doseType = vaccineInfo.getString("doseType");
				doseExpiry = vaccineInfo.getString("doseExpiry");
				data.add(doseType);
				data.add(doseExpiry);
				data.add("-");
				break;
			}
		}
	
		return data;

	}
}