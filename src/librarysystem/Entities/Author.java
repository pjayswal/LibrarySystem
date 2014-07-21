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
public class Author extends Person{
    private String shortBio;
    private String Credentials;
    
    public Author(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getCredentials() {
        return Credentials;
    }

    public void setCredentials(String Credentials) {
        this.Credentials = Credentials;
    }

    @Override
    public String toString() {
        return getFullName(); //To change body of generated methods, choose Tools | Templates.
    }
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(getFullName());
        newRow.add(getPhoneNumber());
        newRow.add(this.getAddress());
        newRow.add(this.getShortBio());
        newRow.add(getCredentials());
        return newRow;
        
    }
}
