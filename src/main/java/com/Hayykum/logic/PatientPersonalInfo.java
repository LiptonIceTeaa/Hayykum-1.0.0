package com.Hayykum.logic;


public class PatientPersonalInfo extends PersonalInfo {

    private String nationality;
    private String birthDate;
    private String gender;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getbirthDate() {
        return birthDate;
    }

    

    public PatientPersonalInfo(String firstName, String lastName, participants patient, String birthdate, String nationality, String gender) {
        super(firstName, lastName, patient);
        this.birthDate = birthdate;
        this.gender = gender;
        this.nationality = nationality;
        
        
    }

    @Override
    public String toString() {
        return super.toString()+" birthDate=" + birthDate + ", gender=" + gender + ", nationality=" + nationality;
    }

    

    
}

