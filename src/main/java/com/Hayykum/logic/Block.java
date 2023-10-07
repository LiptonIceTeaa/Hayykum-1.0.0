package com.Hayykum.logic;


	import java.security.MessageDigest;

	import java.util.Arrays;


	public class Block {
	    private long timestamp;
	    private String currentHash;
	    private String previousHash;
	    private Object[] fields; // array of fields that a block will contain
	    private Transaction tx;
	    private int nonce;
	    private int blockNumber = 0;


	    public Object[] getFields() {
	        return fields;
	    }



	    public void setFields(Object[] fields) {
	        this.fields = fields;
	    }



	   

	    // public Block(String previousHash, PatientInfo patientInfo, Transaction tx) {
	    //     this.timestamp = System.currentTimeMillis();
	    //     this.previousHash = previousHash;
	    //     this.tx = tx;
	    //     this.patientInfo = patientInfo;
	    //     //setPa
	    //     nonce = 0;
	    //     currentHash = calculateHash();
	    // }

	    public Block(String previousHash,Object[] fields, Transaction tx) {
	        this.timestamp = System.currentTimeMillis();
	        this.previousHash = previousHash;
	        this.tx = tx;
	        this.fields = fields;// array vontoing fields to be added in a block
	        //setPa
	        nonce = 0;
	        currentHash = calculateHash();
	        blockNumber = BlockChain.getBlocksCount();
	        }

	    

	    
	    private String calculateHash() {
	        try {
	            String data = "";
	            
	                data += tx.toString();
	            
	            String input = timestamp + previousHash + data + nonce ;
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(input.getBytes("UTF-8"));

	            StringBuffer hexString = new StringBuffer();
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if (hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public void mineBlock(int difficulty) {
	        nonce = 0;
	        String target = new String(new char[difficulty]).replace('\0',
	                '0');
	        while (!currentHash.substring(0, difficulty).equals(target)) {
	            nonce++;
	            currentHash = calculateHash();
	        }
	    }

	    public long getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(long timestamp) {
	        this.timestamp = timestamp;
	    }

	    public String getCurrentHash() {
	        return currentHash;
	    }

	    public void setCurrentHash(String currentHash) {
	        this.currentHash = currentHash;
	    }

	    public String getPreviousHash() {
	        return previousHash;
	    }

	    public void setPreviousHash(String previousHash) {
	        this.previousHash = previousHash;
	    }

	    // public PatientInfo getPatientInfo() {
	    //     return patientInfo;
	    // }

	    // public void setPatientInfo(PatientInfo patientInfo) {
	    //     this.patientInfo = patientInfo;
	    // }

	    public Transaction getTx() {
	        return tx;
	    }

	    public void setTx(Transaction tx) {
	        this.tx = tx;
	    }

	    public int getNonce() {
	        return nonce;
	    }

	    public void setNonce(int nonce) {
	        this.nonce = nonce;
	    }



	    @Override
	    public String toString() {

	        String toString = "******************** Block " + blockNumber + " [currentHash=" + currentHash + ", fields= " + Arrays.toString(fields)
	        + ", nonce=" + nonce
	        + ", previousHash= " + previousHash + ", timestamp creation of block = " + timestamp + ", " + tx + " ]";
	        return toString;
	    }
	    
	}
