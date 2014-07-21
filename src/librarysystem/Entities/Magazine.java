/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.Vector;

/**
 *
 * @author Pramod
 */
public class Magazine extends Publication {
    private int issueNo;

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }
    public Magazine(String Title, int issueNo) {
        super(Title);
        this.issueNo = issueNo;
    }
    
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(getTitle());
        newRow.add(getIssueNo());
        newRow.add(getNumberCopies());
        return newRow;
        
    }
    
}
