/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pramod
 */
public abstract class Publication {
    private String Title;
    private List<Copy> copies;
    private List<Reservation> reservations;
    private int availCopy;
    private int noCopies;
    
    public Publication(String Title) {
        this.Title = Title;
        this.copies = new ArrayList<Copy>();
        reservations = new ArrayList<Reservation>();
        noCopies=0;
        availCopy=0;
    }

    public void addReservation(Reservation res){
        reservations.add(res);
    }
    public void addAnAvailCopy() {
        availCopy++;
    }
    public void removeAnAvailCopy() {
        availCopy--;
    }
    public int getNoCopies() {
        return noCopies;
    }

    public void setNoCopies(int noCopies) {
        this.noCopies = noCopies;
    }

    public List<Copy> getCopies() {
        return copies;
    }
    

    public void addCopy(Copy c){
        copies.add(c);
        noCopies++;
        //availCopy++;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    public int getNumberCopies(){
        return noCopies;
    }

    @Override
    public String toString() {
        return Title ;
    }
    public int getAvailNumCopy(){
        return availCopy;
    }
    public Copy getAcopy(){
        for(Copy c:copies){
            if(c.getStatus().equals(Copy.STATUS_AVAILABLE)){
                return c;
            }
        }
        return null;
    }
    public Reservation hasAnyReservation(){
        for(Reservation res: reservations){
            if(res.getStatus().equals(Reservation.STATUS_PENDING)){
                reservations.remove(res);
                return res;
            }
        }
        return null;
    }
    
    
    
}
