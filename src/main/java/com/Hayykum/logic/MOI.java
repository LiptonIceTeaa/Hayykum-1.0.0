package com.Hayykum.logic;


public class MOI {


    private final static String MOFA_Signature = "202190_MOFA";
    private final static String MOI_Signature = "190342_MOI";
    private final static String MOH_Signature = "190202_MOH";

    public static Boolean endorseTx(Object[] readFields, Object[] writeFields, int txID) {

        if (writeFields.length != 0 && readFields.length != 0) {
            return true;
        } else {
            return false;
        }

    }


    public static Object[] appendRW_set_signature(Object[] readFields, Object[] writeFields) {

        Object[] fields = { readFields, writeFields, MOI_Signature};

        return fields;

    }

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

