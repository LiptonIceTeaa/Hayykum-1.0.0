package com.Hayykum.logic;



public class MOHC {

   
	// these values simulate MOH's database
    private final static String MOFA_Signature = "202190_MOFA";
    private final static String MOI_Signature = "190342_MOI";
    private final static String MOH_Signature = "190202_MOH";

    // newFields refer to the write values
    // this simulates a endorsing peer accessing shared ledger and retrieving the
    // read values

    public static Boolean endorseTx(Object[] readFields, Object[] writeFields, int txID) {
        switch (txID) {
            case 1:
                if (writeFields.length != 0) {
                    return true;
                } else {
                    System.out.println("Transaction is invalid ");
                    return false;
                }
                
            case 4,5:
                if(writeFields.length !=0 && readFields.length !=0){
                    return true;
                }else{
                    return false;
                }
                

        }

        return false;
    }

    public static Object[] appendRW_set_signature(Object[] readFields, Object[] writeFields) {

        Object[] fields = { readFields, writeFields, MOH_Signature };

        return fields;

    }


    // validates signtures of endorsing peers
    // comapre signatures sent from client with existing signature in database
    public static Boolean commitTx(String[] signatures){
        String MOH_sign;
        String MOI_sign;
        String MOFA_sign;

        if(signatures.length<2){ //MOH only
            MOH_sign = signatures[0];
            if(MOH_sign.equals(MOH_Signature))
                return true;
    
        }
        else if(signatures.length==2){
            MOI_sign = signatures[0];
            MOFA_sign = signatures[1];

            if(MOI_sign.equals(MOI_Signature)&& MOFA_sign.equals( MOFA_Signature))
            return true;
        }
            
        return false;
    }

}

