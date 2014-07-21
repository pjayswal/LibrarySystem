/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import librarysystem.Utils;

/**
 *
 * @author Pjayswal
 */
public class Copy {
    static int num =12344;
    public static String STATUS_AVAILABLE="Available";
    public static String STATUS_LOANED="Loaned";
    public static String STATUS_ONHOLD="On Hold";
    //private static String STATUS_AVAILABLE="Available";
    
    private int copyNo;
    private Publication publication;
    private String status;
    private Reservation reservation;
    private List<Loan> loanHistory;

    public Copy(Publication publication) {
        this.copyNo = num++;
        this.publication = publication;
        this.setStatus(STATUS_AVAILABLE);
        loanHistory = new ArrayList<Loan>();
        
        if(publication!=null){
            publication.addCopy(this);
        }
        reservation=null;
    }
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status =new StringBuilder(status).toString();
        
        if(status.equals(STATUS_AVAILABLE)){
            publication.addAnAvailCopy();
        }
        else if(status.equals(STATUS_LOANED)){
            publication.removeAnAvailCopy();
        }
    }
    //public void setAvailable
    public void setLoan(Loan loan){
        loanHistory.add(loan);
        this.setStatus(Copy.STATUS_LOANED);
    }
    public Loan getCurrentLoan(){
        if(loanHistory.size()>=1)
            return loanHistory.get(loanHistory.size()-1);
        else 
            return null;
    }
    public int getCopyNo() {
        return copyNo;
    }

    public void setCopyNo(int copyNo) {
        this.copyNo = copyNo;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(getCopyNo());
        newRow.add(getStatus());
        if(!getStatus().equals(STATUS_AVAILABLE)){
            newRow.add(getCurrentLoan().getLoaner().getFullName());
            newRow.add(getCurrentLoan().getCheckOutDate());
        }
        else{
            newRow.add("N/A");
             newRow.add("N/A");
        }

        return newRow;
        
    }
    
    public void returnIt(){
        getCurrentLoan().setReturnDate(Utils.getDate());
        reservation = publication.hasAnyReservation();
        if(reservation!=null){
            reservation.hold(this);
            hold();
        }
        else{
            setStatus(STATUS_AVAILABLE);
        }
    }
    public void hold(){
        setStatus(STATUS_ONHOLD);
    }

    @Override
    public String toString() {
        return ""+getCopyNo()+""; //To change body of generated methods, choose Tools | Templates.
    }
    
}
