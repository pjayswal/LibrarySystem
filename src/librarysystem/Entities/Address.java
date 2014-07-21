/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

/**
 *
 * @author PJayswal
 */
public class Address {
    private String Street;
    private String City;
    private String zipCode;
    private String State;
    private Person person;

    public Address(String Street, String City, String zipCode, String State,Person p) {
        this.Street = Street;
        this.City = City;
        this.zipCode = zipCode;
        this.State = State;
        this.person =p;
        if(p!=null)
            p.setAddress(this);
    }
    
    public boolean setPerson(Person p){
        this.person = p;
        if(p!=null){
            p.setAddress(this);
            return true;
        }
        return false;
    }
    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    @Override
    public String toString() {
        return  Street + " " + City + " " + zipCode + " " + State ;
    }
   
}
