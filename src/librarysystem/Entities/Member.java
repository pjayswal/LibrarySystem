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
 * @author PJayswal
 */
public class Member extends Person{
    private static int totalMembers=5555678;
    private int memberId;
    List<Loan> loans;
    List<Reservation> reservations;
    List<Reservation> availReservation;
    
    public Member(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
        memberId= totalMembers++;
        loans = new ArrayList<Loan>();
        reservations = new ArrayList<Reservation>();
        availReservation= new ArrayList<Reservation>();
    }

    @Override
    public String toString() {
        return getFullName();
    }
    public int getMemberId(){
        return memberId;
    }
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(getMemberId());
        newRow.add(getFullName());
        newRow.add(getPhoneNumber());
        newRow.add(getAddress().toString());
        return newRow;
        
    }
    
    public void reserve(Publication pub){
        reservations.add(new Reservation(this, pub));
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    
    public List<Reservation> getUnfullFilledReservation(){
        availReservation.clear();
        for(Reservation r:reservations){
            if(r.getStatus().equals(Reservation.STATUS_ONHOLD)|| r.getStatus().equals(Reservation.STATUS_PENDING))
                availReservation.add(r);
        }
        return availReservation;
    }
    
    public void loan(Copy copy){
        loans.add(new Loan(this,copy));
    }
    public void returnIt(Copy copy){
        Loan loan=copy.getCurrentLoan();
        copy.returnIt();
    }
    
    public void pickUp(Reservation reservation){
        loan(reservation.pickUp());
    }
    public void cancelReservation(Reservation reservation){
        reservation.cancel();
    }
    
}
