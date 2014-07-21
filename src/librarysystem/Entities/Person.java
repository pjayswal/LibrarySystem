/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.Vector;

/**
 *
 * @author PJayswal
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
 
    public Address getAdress(){
        return address;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    
    public Address getAddress(){
        return address;
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

    public String getFullName(){
        return firstName+" "+lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  "First Name=" + firstName + ", Last Name=" + lastName + ", phoneNumber=" + phoneNumber + ", address=" + address ;
    }
    
    
    
}
