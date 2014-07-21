/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.Vector;
import librarysystem.Utils;

/**
 *
 * @author Pjayswal
 */
public class Reservation {
    public static String STATUS_PENDING ="Pending";
    public static String STATUS_ONHOLD ="On Hold";
    public static String STATUS_CANCELLED ="Cancelled";
    public static String STATUS_FULLFILLED ="Fullfilled";
    
    
    private String status;
    private String statusDate;
    private Member member;
    private Publication publication;
    private Copy reservedCopy;
    
    public Reservation(Member member, Publication publication) {
        this.member = member;
        this.publication = publication;
        publication.addReservation(this);
        setStatus(STATUS_PENDING);
        setStatusDate(Utils.getDate());
    }

    public void setReservedCopy(Copy reservedCopy) {
        this.reservedCopy = reservedCopy;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(member.getFullName());
        newRow.add(publication.getTitle());
        newRow.add(getStatus());
        newRow.add(getStatusDate());
        return newRow;
        
    }

    @Override
    public String toString() {
        return publication.getTitle();
    }
    
    public void hold(Copy copy){
        setStatus(STATUS_ONHOLD);
        setStatusDate(Utils.getDate());
        setReservedCopy(copy);
    }
    public Copy pickUp(){
        setStatus(STATUS_FULLFILLED);
        setStatusDate(Utils.getDate());
        return reservedCopy;
    }
    public void cancel(){
        setStatus(STATUS_CANCELLED);
        setStatusDate(Utils.getDate());
        if(reservedCopy!=null)
        reservedCopy.setStatus(Copy.STATUS_AVAILABLE);
    }
}
