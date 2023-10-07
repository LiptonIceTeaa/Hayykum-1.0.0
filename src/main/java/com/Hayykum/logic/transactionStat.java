package com.Hayykum.logic;

public class transactionStat {
	
	
	 public static boolean sendTx(int id, Object[] readFields, Object[] writeFields) {

	        if (id == 1 || id == 4 || id == 5) {

	            // send to MOH for endorsement (check if valid)
	            Boolean valid = MOHC.endorseTx(readFields, writeFields, id);
	            // if transaction id valid, we now retrieve R,W set + endorser signature
	            if (valid) {
	                Object[] RWSET_SIGNATURE_MOH = MOHC.appendRW_set_signature(readFields, writeFields);
	                String signatureMOH = (String) RWSET_SIGNATURE_MOH[RWSET_SIGNATURE_MOH.length - 1];
	                String[] signatures = { signatureMOH };
	                Boolean mohSignatureValid = MOHC.commitTx(signatures);
	                Boolean moiSignatureValid = MOI.commitTx(signatures);
	                Boolean mofaSignatureValid = MOFA.commitTx(signatures);

	                if (mohSignatureValid && moiSignatureValid && mofaSignatureValid)
	                    return true;

	            }

	        } else if (id == 2 || id == 3) {
	            Boolean validMofa = MOFA.endorseTx(readFields, writeFields, id);
	            Boolean validMOI = MOI.endorseTx(readFields, writeFields, id);

	            if (validMofa && validMOI) {
	                Object[] RWSET_SIGNATURE_MOFA = MOFA.appendRW_set_signature(readFields, writeFields);
	                Object[] RWSET_SIGNATURE_MOI = MOI.appendRW_set_signature(readFields, writeFields);
	                String signatureMOI = (String) RWSET_SIGNATURE_MOI[RWSET_SIGNATURE_MOI.length - 1];
	                String signatureMOFA = (String) RWSET_SIGNATURE_MOFA[RWSET_SIGNATURE_MOFA.length - 1];
	                String[] signatures = { signatureMOI, signatureMOFA };
	                Boolean mohSignatureValid = MOHC.commitTx(signatures);
	                Boolean moiSignatureValid = MOI.commitTx(signatures);
	                Boolean mofaSignatureValid = MOFA.commitTx(signatures);

	                if (mohSignatureValid && moiSignatureValid && mofaSignatureValid)
	                    return true;

	            }

	        }

	        return false;
	    }

	    public static Boolean checkRWset(Object[] RWSET_SIGNATURE_1, Object[] RWSET_SIGNATURE_2) {

	        for (int i = 0; i < RWSET_SIGNATURE_1.length - 2; i++) {
	            if (RWSET_SIGNATURE_1[i].equals(RWSET_SIGNATURE_2[i])) {
	                continue;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }

}
