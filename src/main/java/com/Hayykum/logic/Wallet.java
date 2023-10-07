package com.Hayykum.logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.security.KeyPair;
import java.security.KeyPairGenerator;


public class Wallet {
    private String publicKey;
    private String privateKey;
    private PersonalInfo personalInfo;
    private participants userType;
    private BlockChain blockChain;
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Wallet(PersonalInfo personalInfo, participants userType, BlockChain blockChain) {
        this.personalInfo = personalInfo;
        this.userType = userType;
        generateKeys();
        this.blockChain = blockChain;
        setSignatureString(userType);

    }

    public Wallet() {
    }

    void setSignatureString(participants userType) {

        switch (userType) {
            case MOH:
                setSignature("MOH190202");
                break;

            case MOI:
                setSignature("MOI190020");
                break;

            case MOFA:
                setSignature("MOFA002190");
                break;

            default:
                break;

        }

    }

    private void generateKeys() {
        try {
            KeyPair keyPair;
            String algorithm = "RSA"; // DSA DH etc
            keyPair = KeyPairGenerator.getInstance(algorithm).generateKeyPair();
            privateKey = keyPair.getPrivate().getEncoded().toString();
            publicKey = keyPair.getPublic().getEncoded().toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public participants getUserType() {
        return userType;
    }

    public void setUserType(participants userType) {
        this.userType = userType;
    }

    public BlockChain getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(BlockChain blockChain) {
        this.blockChain = blockChain;
    }
}

