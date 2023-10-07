package com.Hayykum.logic;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class PersonalInfo {
    private String firstName;
    private String lastName;
    private participants role;

    public PersonalInfo(String firstName, String lastName, participants role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getRole() {
        return role.toString();
    }

    public void setRole(participants role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "First Name= " + firstName  +
                ", Last Name= " + lastName  +
                ", Role= " + role +

                "}";
    }
}
