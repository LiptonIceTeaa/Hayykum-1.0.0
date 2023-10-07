package com.Hayykum.logic;

public class Transaction {
	
	
	private long timestamp;
    private String transType;
    
    
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "Transaction [timestamp of transaction =" + timestamp + ", transID=" + transID + ", transType=" + transType + "]";
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    private int transID;

    public Transaction(int transID, long timestamp, String transType) {
        this.transID = transID;
        this.timestamp = timestamp;
        this.transType = transType;
    }

    


}
