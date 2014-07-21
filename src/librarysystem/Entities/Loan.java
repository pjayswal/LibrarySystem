/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.Date;
import java.util.Vector;
import librarysystem.Utils;

/**
 *
 * @author Pjayswal
 */
public class Loan {
    private Copy copy;
    private Member loaner;
    private String checkOutDate;
    private String returnDate;

    public Loan( Member loaner,Copy copy) {
        this.copy = copy;
        this.loaner = loaner;
        copy.setLoan(this);
        setCheckOutDate(Utils.getDate()); 
        returnDate=null;
    }
    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Member getLoaner() {
        return loaner;
    }

    public void setLoaner(Member loaner) {
        this.loaner = loaner;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return copy.getPublication().getTitle(); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(toString());
        newRow.add(copy.getCopyNo());
        newRow.add(getCheckOutDate());
        
        newRow.add(getReturnDate());
        return newRow;
        
    }
    
    
    
}
