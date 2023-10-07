package com.Hayykum.logic;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template AKK DJ Candice TheBoog
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.SupportedOptions;

public class BlockChainRunner {
    public static int difficulty = 3;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("*************************** Hayyakum GCC Connected Vaccine ***************************");
        BlockChain blockChain = new BlockChain();
        Wallet employeeWallet = createEmployeeWallet(blockChain);

        if (employeeWallet.getPublicKey() == null) {
            System.out.println("Faliure to add employee check role");
            System.exit(0);
        }

        else
            System.out.println("You're logged in with the Wallet : " + employeeWallet.getPublicKey());

        int choice;
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    if (employeeWallet.getUserType().equals(participants.MOH)) {
                        System.out.println("Enter patient passport number");
                        String passNO = scanner.next();

                        List<Block> blocks = blockChain.blockExits(passNO);
                        if (!blocks.isEmpty()) {// user exists
                            System.out.println("User already exists");
                            continue;

                        } else {

                            PatientInfo patientInfo = CreateRecord(passNO);// creates patient record + first dose :)
                            PersonalInfo personalInfo = patientInfo.getPersonalInfo();
                            Wallet patientWallet = new Wallet(patientInfo.getPersonalInfo(), participants.PATIENT,
                                    blockChain);
                            System.out
                                    .println("Patient is created with the Wallet Id: " + patientWallet.getPublicKey());
                            String transSignature = "Creating record for patient: "
                                    + patientWallet.getPersonalInfo().getFirstName()
                                    + " " + patientWallet.getPersonalInfo().getLastName() + " "
                                    + "Done by employee: " + employeeWallet.getPersonalInfo().getFirstName()
                                    + " " + employeeWallet.getPersonalInfo().getLastName() + "| Belonging to "
                                    + employeeWallet.getSignature();
                            int transID = 1;
                            Transaction patientMedicalRecord = setTransaction(transSignature, transID);
                            patientInfo.getVaccineInfo().setDoseNO(1);

                            // create array of fields to be added in the block
                            Object[] fieldsToBeAddedInBlock = { personalInfo, patientInfo.getVaccineInfo(),
                                    patientInfo.getPassportNO() };

                            // send a transaction proposal to MOH

                            Boolean txValid = sendTx(transID, new Object[0], fieldsToBeAddedInBlock);

                            // adds block to blockchain
                            if (!txValid)
                                patientMedicalRecord.setTransID(11);

                            Block block = new Block(blockChain.getLastHash(), fieldsToBeAddedInBlock,
                                    patientMedicalRecord);
                            block.mineBlock(difficulty);
                            blockChain.addBlock(block); // a block is added to the blockchain

                        }
                    } else {
                        System.out
                                .println("Current user role can not create a record !\nPlease select another action.");
                    }

                    break;

                case 2:
                    /*
                     * adding a dose means we cretae a block that has the dose number and passport
                     * number for a p[atient
                     */
                    if (employeeWallet.getUserType().equals(participants.MOH)) {
                        System.out.println("Please Enter Passport Number: ");
                        String passportNO = scanner.next();

                        List<Block> blocks = blockChain.blockExits(passportNO);
                       
                        if (!blocks.isEmpty()) {// user exists

                            // ask employee for patient vaccine dose details
                            VaccineInfo vaccineInfo2 = getVaccineInfo();

                            // updated = new PatientInfo(personalInfo2, passportNO, vaccineInfo2);
                            String transDiscription2 = "Added dose for patient: "
                                    + passportNO + " "
                                    + "Done by employee: " + employeeWallet.getPersonalInfo().getFirstName() + " "
                                    + employeeWallet.getPersonalInfo().getLastName() + "| Belonging to"
                                    + employeeWallet.getSignature();

                            Object[] dataFields = { vaccineInfo2, passportNO };// passing vaccineInfo and passport
                                                                               // number only, since we are adding a
                                                                               // dose
                            int transactionID = 5; // this indicates that this transaction is of type "add dose"

                            Transaction medicalRecord = setTransaction(transDiscription2,
                                    transactionID);

                            // send a transaction proposal to MOH
                            List<Block> blocks1 = blockChain.blockExits(passportNO);
                            Block latestDose = blocks1.get(0);
                            Block temp;
                            int indexOfBlock;
                            for (int i = 0; i <= blocks1.size() - 1; i++) {
                                temp = blocks1.get(i);
                                if (temp.getTx().getTransID() == 5 || temp.getTx().getTransID() == 1) {
                                    latestDose = temp;// latest
                                    indexOfBlock = 5;
                                }
                            }

                            VaccineInfo readVaccineInfoValues = null;
                            if (latestDose.getTx().getTransID() == 1) {
                                readVaccineInfoValues = (VaccineInfo) latestDose.getFields()[1];
                            } else if (latestDose.getTx().getTransID() == 5) {
                                readVaccineInfoValues = (VaccineInfo) latestDose.getFields()[0];
                            }

                            Object[] readFields = { readVaccineInfoValues, passportNO };// latest value of vaccine info

                            Boolean txValid = sendTx(transactionID, dataFields, readFields);

                            if (!txValid)
                                medicalRecord.setTransID(55);

                            Block block2 = new Block(blockChain.getLastHash(), dataFields, medicalRecord);
                            block2.mineBlock(difficulty);
                            blockChain.addBlock(block2);

                        } else {
                            System.err.println("Patient does not exits!");
                        }
                    } else {
                        System.out
                                .println("Current user role can not create a record !\nPlease select another action.");
                    }
                    break;

                case 3:
                    System.out.println("Please Enter Patient number: ");
                    String passportNumber = scanner.next();
                    List<Block> blocks1 = blockChain.blockExits(passportNumber);// resembles all blocks belonging to a
                                                                                // specific patient
                    System.out.println("a- Latest dose");
                    System.out.println("b- Compelete history");
                    char choiceWithin = scanner.next().toLowerCase().charAt(0);

                    if (!blocks1.isEmpty()) {

                        Block latestDose = blocks1.get(0);
                        Block temp;
                        int indexOfBlock;
                        for (int i = 0; i <= blocks1.size() - 1; i++) {
                            temp = blocks1.get(i);
                            if (temp.getTx().getTransID() == 5 || temp.getTx().getTransID() == 1) {
                                latestDose = temp;// latest
                                indexOfBlock = 5;
                            }
                        }

                        switch (choiceWithin) {
                            case 'a':
                                System.out.println("\t\t\t\t\t\t**************************\t\t\t\t\t\t");
                                if (employeeWallet.getUserType().equals(participants.MOH)) { // if user is from MOH

                                    System.out.println(latestDose.toString());

                                } else {

                                    System.out.println(
                                            getLimitedInfo(latestDose.getFields(), latestDose.getTx().getTransID()));
                                }
                                break;
                            case 'b':
                                if (employeeWallet.getUserType().equals(participants.MOH)) {
                                    for (Block block1 : blocks1) {
                                        System.out.println(block1.toString());

                                        System.out.println("\t\t\t\t\t\t**************************\t\t\t\t\t\t");

                                    }
                                } else {

                                    for (Block block1 : blocks1) {
                                        System.out.println(
                                                getLimitedInfo(block1.getFields(), block1.getTx().getTransID()));
                                        System.out.println("\t\t\t\t\t\t**************************\t\t\t\t\t\t");

                                    }
                                }

                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;

                        }

                    } else {
                        System.err.println("Patient does not exits!");
                    }
                    break;

                case 4:
                    for (Block block1 : blockChain.getBlocks()) {
                        System.out.println(block1.toString());
                    }
                    break;
                case 5:
                    System.out.println("Block Chain is " + (blockChain.isChainValid() ? "Valid" : "Invalid"));
                    break;

                case 6:
                    System.out.println("Please Enter Patient number: ");
                    String passportNumber2 = scanner.next();

                    List<Block> blocks12 = blockChain.blockExits(passportNumber2);
                    if (!blocks12.isEmpty()) {

                        int choice2 = getChoice2();

                        PatientPersonalInfo pI;
                        Block latestBlock;
                        String txDescriptionShort;
                        String txDescription;
                        int txID;
                        Transaction txToBeAdded;
                        Block blockToAdd;

                        switch (choice2) {

                            case 1:
                                System.out.println("Enter new patient name: ");
                                String newFirstName = scanner.next();

                                // retireve old name and save it into a variable
                                // search for latest block with id=2, if not found retrive first block created
                                // for this patient

                                latestBlock = getLatestBlockOfSpecifiedID(blocks12, 2);// returns lates block of
                                                                                       // id=2

                                pI = (PatientPersonalInfo) latestBlock.getFields()[0]; // retrives personal info
                                                                                       // object
                                PatientPersonalInfo oldPI = pI;
                                String oldName = pI.getFirstName() + " " + pI.getLastName();
                                pI.setFirstName(newFirstName);
                                txDescriptionShort = "Holder of passport number: "
                                        + passportNumber2 + " changed name from " + "'" + oldName + "' to "
                                        + pI.getFirstName()
                                        + " " + pI.getLastName();

                                txDescription = createTxDescription(txDescriptionShort, employeeWallet);// creates
                                                                                                        // tx
                                                                                                        // description
                                txID = 2;
                                txToBeAdded = setTransaction(txDescription,
                                        txID);
                                Object[] writeNameFields = { pI, passportNumber2 };
                                Object[] readNameFields = { oldPI, passportNumber2 };

                                Boolean txValid = sendTx(txID, readNameFields, writeNameFields);

                                if (!txValid)
                                    txToBeAdded.setTransID(22);

                                blockToAdd = new Block(blockChain.getLastHash(), writeNameFields, txToBeAdded);

                                blockToAdd.mineBlock(difficulty);

                                blockChain.addBlock(blockToAdd);

                                break;
                            case 2:
                                System.out.println("Enter new patient nationality: ");
                                String newNationality = scanner.next();

                                // retireve old nationality and save it into a variable
                                // search for latest block with id=3, if not found retrive first block created
                                // for this patient

                                latestBlock = getLatestBlockOfSpecifiedID(blocks12, 3);// returns lates
                                                                                       // block of
                                // id=3

                                pI = (PatientPersonalInfo) latestBlock.getFields()[0]; // retrives
                                                                                       // personal
                                                                                       // info
                                PatientPersonalInfo oldPi = pI;

                                String oldNationality = pI.getNationality();
                                pI.setNationality(newNationality);
                                txDescriptionShort = "Holder of passport number: "
                                        + passportNumber2 + " changed nationality from " + "'" + oldNationality
                                        + "' to "
                                        + pI.getNationality();

                                txDescription = createTxDescription(txDescriptionShort, employeeWallet);// creates
                                                                                                        // tx
                                                                                                        // description
                                txID = 3;
                                Transaction txChangeName = setTransaction(txDescription,
                                        txID);
                                Object[] writeNationalityFields = { pI, passportNumber2 };

                                Object[] readNationaityFields = { oldPi, passportNumber2 };

                                txValid = sendTx(txID, readNationaityFields, writeNationalityFields);

                                if (!txValid)
                                    txChangeName.setTransID(33);

                                blockToAdd = new Block(blockChain.getLastHash(), writeNationalityFields,
                                        txChangeName);
                                blockToAdd.mineBlock(difficulty);
                                blockChain.addBlock(blockToAdd);

                                break;
                            case 3:
                                // set dose number for a specific dose (ask user to input old number, and new
                                // number to switch it together)
                                System.out.println("Enter dose number to change: ");
                                int oldDose = scanner.nextInt();
                                System.out.println("Enter new dose number: ");
                                int newDose = scanner.nextInt();

                                // filter blocks12 to get only blocks with id=5 and dose number equal to input
                                // dose number

                                int y = 0;
                                // VaccineInfo vacInfo;
                                ArrayList<Block> blocksWithID_5_or_1 = new ArrayList<>();

                                for (Block c : blocks12) {
                                    if (y != 0 && c.getTx().getTransID() == 5 || y == 0) // we add first block since it
                                                                                         // holds a dose
                                        blocksWithID_5_or_1.add(c);
                                    y++;
                                }

                                // now blocksWithID_5_or_1 array holds all blocks with id=5 or 1
                                y = 0; // using y agian to avoid calling [0] in the first block created
                                VaccineInfo vacInfo = null ;
                                for (Block c : blocksWithID_5_or_1) {
                                    if (y != 0) {
                                        vacInfo = (VaccineInfo) c.getFields()[0];
                                        if (vacInfo.getDoseNO() == oldDose)
                                            vacInfo.setDoseNO(newDose);
                                        y++;
                                    } else if (y == 0) {
                                        vacInfo = (VaccineInfo) c.getFields()[1];
                                        if (vacInfo.getDoseNO() == oldDose)
                                            vacInfo.setDoseNO(newDose);
                                        y++;
                                    }

                                }

                                txDescriptionShort = "Holder of passport number: "
                                        + passportNumber2 + " changed dose nmber from " + "'" + oldDose
                                        + "' to "
                                        + vacInfo.getDoseNO();

                                txDescription = createTxDescription(txDescriptionShort, employeeWallet);// creates
                                                                                                        // tx
                                                                                                        // description
                                txID = 4;
                                Transaction txChangeDoseNumber = setTransaction(txDescription,
                                        txID);
                                Object[] newDoseNumberFieldsToBeAdded = { vacInfo, passportNumber2 };

                                VaccineInfo oldVaccineInfo = vacInfo;// only diffference here is that old value holds
                                                                     // old dose number
                                oldVaccineInfo.setDoseNO(oldDose);
                                Object[] oldDoseFields = { oldVaccineInfo, passportNumber2 };

                                Boolean valid2 = sendTx(txID, oldDoseFields, newDoseNumberFieldsToBeAdded);

                                // commits a block to ledger
                                if (!valid2)
                                    txChangeDoseNumber.setTransID(44);

                                blockToAdd = new Block(blockChain.getLastHash(), newDoseNumberFieldsToBeAdded,
                                        txChangeDoseNumber);
                                blockToAdd.mineBlock(difficulty);
                                blockChain.addBlock(blockToAdd);

                                break;
                            default:
                                System.out.println("Invalid choice\n");
                                break;
                        }

                    } else {
                        System.out.println("Patient doesnt exist !");
                    }
                    break;

                case 7:
                    System.out.println("Enter patient passport number");
                    String passportNO = scanner.next();
                    List<Block> blocks123 = blockChain.blockExits(passportNO);

                    if (!blocks123.isEmpty()) {

                        getPateintView(blocks123);

                    } else {
                        System.out.println("Patient doesnt exist! ");

                    }

            }

        } while (choice >= 1 && choice <= 7);

    }

    /* creates a transaction object for any transaction */
    public static Transaction setTransaction(String transactionDescription, int transID) {
        // removed a line here where we genrate a random transID for a transaction
        // a transaction consists of a {transID, time, transDescription}
        return new Transaction(transID, System.currentTimeMillis(), transactionDescription);
    }

    private static int getChoice() {
        System.out.println("Please choose the following actions: ");
        System.out.println("1 - Create Patient Record");
        System.out.println("2 - Add Patient dose");
        System.out.println("3 - View patient Record History");
        System.out.println("4 - View All Patients (BlockChain)");
        System.out.println("5 - Check if BlockChain is valid");
        System.out.println("6 - Edit patient info");
        System.out.println("7 - View patient record");
        System.out.println("8 - Exit");
        int choice = scanner.nextInt();
        return choice;
    }

    private static int getChoice2() {
        System.out.println("Please select from the following:");
        System.out.println("1- Change patient name");
        System.out.println("2- Change patient nationality");
        System.out.println("3- Change patient dose number");
        System.out.println("4- Exit");

        int choice = scanner.nextInt();
        return choice;
    }

    private static String createTxDescription(String type, Wallet employeeWallet) {
        String txDescription = type + ". Done by employee: " + employeeWallet.getPersonalInfo().getFirstName() + " "
                + employeeWallet.getPersonalInfo().getLastName() + " | Belonging to: " + employeeWallet.getSignature();

        return txDescription;
    }

    private static Block getLatestBlockOfSpecifiedID(List<Block> blocks, int id) {

        Block latestBlock = blocks.get(0);
        Block tempBlock;
        for (int i = blocks.size() - 1; i >= 0; i--) {
            tempBlock = blocks.get(i);
            if (tempBlock.getTx().getTransID() == id || tempBlock.getTx().getTransID() == id) {
                latestBlock = tempBlock;// latest block with specified ID
            } else {
                latestBlock = blocks.get(0);// no blocks found with speified ID
            }

        }

        return latestBlock;
    }

    private static Wallet createEmployeeWallet(BlockChain blockChain) {
        System.out.println("********** Creating Employee Wallet *************");
        System.out.println("***** Personal Information *****");
        System.out.println("Please Enter FirstName: ");
        String firstName = scanner.next();
        System.out.println("Please Enter LastName: ");
        String lastName = scanner.next();
        String role;
        do {
            System.out.println("Please Enter Role starting with H/I/F: ");
            role = scanner.next().toUpperCase();

        } while (role.charAt(0) != 'H' && role.charAt(0) != 'I' && role.charAt(0) != 'F');

        participants rolePart;
        switch (role.charAt(0)) {
            case 'H':
                rolePart = participants.MOH;

            case 'I':
                rolePart = participants.MOI;

            case 'F':
                rolePart = participants.MOFA;

            default:
                rolePart = participants.MOH;

        }

        PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, rolePart);

        switch (role.charAt(0)) {
            case 'H':
                return new Wallet(personalInfo, participants.MOH, blockChain);

            case 'I':
                return new Wallet(personalInfo, participants.MOI, blockChain);

            case 'F':
                return new Wallet(personalInfo, participants.MOFA, blockChain);

            default:
                return new Wallet();

        }
    }

    private static PatientInfo CreateRecord(String passNO) {

        System.out.println("Enter user record:");

        System.out.println("Please Enter FirstName: ");
        String firstName = scanner.next();
        System.out.println("Please Enter LastName: ");
        String lastName = scanner.next();
        System.out.println("Please Enter Brith date: ");
        String BirthDate = scanner.next();
        System.out.println("Passport Number: " + passNO);
        System.out.println("Please enter nationality: ");
        String nationality = scanner.next();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();

        PatientPersonalInfo personalInfo = new PatientPersonalInfo(firstName, lastName, participants.PATIENT, BirthDate,
                nationality, gender);
        VaccineInfo vaccineInfo = getVaccineInfo();
        PatientInfo patientInfo = new PatientInfo(personalInfo, passNO, vaccineInfo);

        return patientInfo;

    }

    static public VaccineInfo getVaccineInfo() {

        System.out.println("**********  Vaccine details ************");
        System.out.println("Enter dose number: ");
        int doseNO = scanner.nextInt();
        System.out.println("Please enter vaccination date DD/MM/YY: ");
        String doseDate = scanner.next();
        System.out.println("Please enter vaccination expiry date (if applicable) DD/MM/YY: ");
        String doseExpiry = scanner.next();
        System.out.println("Please enter vaccine type: ");
        String vaccineType = scanner.next();
        System.out.println("Enter country of vaccine");
        String vaccineCountry = scanner.next();

        return new VaccineInfo(doseNO, doseDate, doseExpiry, vaccineType, vaccineCountry);
    }

    public static StringBuilder getLimitedInfo(Object[] fields, int id) {
        StringBuilder strgBld = new StringBuilder();
        String firstName;
        String lastName;
        String gender;
        String passportNO;
        String vaccineDose;
        String vaccineType;

        VaccineInfo tempVaccinelInfo;

        if (id == 1) {
            PersonalInfo tempPersonalInfo = (PersonalInfo) fields[0];
            tempVaccinelInfo = (VaccineInfo) fields[1];

            firstName = "First name: " + tempPersonalInfo.getFirstName();
            lastName = "\nLast name: " + tempPersonalInfo.getLastName();
            gender = "\nGender: " + tempPersonalInfo.getRole();
            passportNO = "\nPassport number: " + fields[2];
            vaccineDose = "\nVaccine dose number: " + Integer.toString(tempVaccinelInfo.getDoseNO());
            vaccineType = "\nVaccine type: " + tempVaccinelInfo.getVaccineType();

            strgBld.append(firstName);
            strgBld.append(lastName);
            strgBld.append(gender);
            strgBld.append(passportNO);
            strgBld.append(vaccineDose);
            strgBld.append(vaccineType);

        } else {

            tempVaccinelInfo = (VaccineInfo) fields[0];
            passportNO = "\nPassport number: " + fields[1];
            vaccineDose = "\nVaccine dose number: " + Integer.toString(tempVaccinelInfo.getDoseNO());
            vaccineType = "\nVaccine type: " + tempVaccinelInfo.getVaccineType();

            strgBld.append(passportNO);
            strgBld.append(vaccineDose);
            strgBld.append(vaccineType);
        }

        return strgBld;

    }

    /*
     * prints a summary of a patient, takes list of blocks that belongs to a patient
     */
    public static void getPateintView(List<Block> blocks1) {

        String doseType;
        String doseDate;
        String doseExpiryDate;
        int doseNumber;

        String firstName;
        String lastName;

        Object[] doseFields;
        Object[] nameFields;

        /** getting latest dose block */
        Block latestDose = blocks1.get(0);
        Block temp;
        int transIDDose = 0;
        for (int i = 0; i <= blocks1.size() - 1; i++) {
            temp = blocks1.get(i);
            if (temp.getTx().getTransID() == 5 || temp.getTx().getTransID() == 1) {
                latestDose = temp;// latest dose block
                transIDDose = latestDose.getTx().getTransID();
            }
        }

        /* getting latest first name and last */
        Block latestName = blocks1.get(0);
        temp = null;
        int transIDName;

        for (int i = 0; i <= blocks1.size() - 1; i++) {
            temp = blocks1.get(i);
            if (temp.getTx().getTransID() == 2 || temp.getTx().getTransID() == 1) {
                latestName = temp;// latest dose block
                transIDName = latestName.getTx().getTransID();
            }
        }
        VaccineInfo vI = null;
        doseFields = latestDose.getFields();

        switch (transIDDose) {
            case 1:
                vI = (VaccineInfo) doseFields[1];
                break;
            case 5:
                vI = (VaccineInfo) doseFields[0];
                break;

        }

        doseType = vI.getVaccineType().toString();
        doseDate = vI.getDoseDate().toString();
        doseExpiryDate = vI.getDoseExpiry().toString();
        doseNumber = vI.getDoseNO();

        nameFields = latestName.getFields();
        PatientPersonalInfo pI = (PatientPersonalInfo) nameFields[0];

        firstName = pI.getFirstName();
        lastName = pI.getLastName();

        System.out.println("\n");
        System.out.println("Patient card: ");
        // System.out.println("________________________________________");
        System.out.println("Full name: " + firstName + " " + lastName);
        System.out.println("Vaccine type: " + doseType);
        System.out.println("Vaccine expiry date: " + doseExpiryDate);
        System.out.println("Vaccine date: " + doseDate);
        System.out.println("Vaccine number: " + doseNumber + "\n");

    }

    public static boolean sendTx(int id, Object[] readFields, Object[] writeFields) {

        if (id == 1 || id == 4 || id == 5) {

            // send to MOH for endorsement (check if valid)
            Boolean valid = MOHC.endorseTx(readFields, writeFields, id);
            // if transaction id valid, we now retrieve R,W set + endorser signature
            if (valid) {
                Object[] RWSET_SIGNATURE_MOH = MOHC.appendRW_set_signature(readFields, writeFields);
                String signatureMOH = (String) RWSET_SIGNATURE_MOH[RWSET_SIGNATURE_MOH.length - 1];
                String[] signatures = { signatureMOH };
               // String[] signatures = {"wrongSignature"};
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

