/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.UI;

import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import librarysystem.Data;
import librarysystem.Entities.Address;
import librarysystem.Entities.Author;
import librarysystem.Entities.Book;
import librarysystem.Entities.Copy;
import librarysystem.Entities.Loan;
import librarysystem.Entities.Magazine;
import librarysystem.Entities.Member;
import librarysystem.Entities.Reservation;

/**
 *
 * @author Pramod
 */
public class ReturnTab extends javax.swing.JPanel {
    
    boolean memberFilled;
    List<Author> authors;
    List<Book> books;
    List<Member> members;
    List<Address> address;
    List<Magazine> magazines;
   
    /**
     * Creates new form ReturnTab
     */
    public ReturnTab() {
        initComponents();
        
        authors = Data.authors;
        books = Data.books;
        members = Data.members;
        magazines =Data.magazines;
        address = Data.address;
        memberFilled=false;
        //initialize();
    }

    public void initialize(){
        setMembers();
        populateComponents(members.get(0));
        repaint();
        revalidate();
    }
    public void setMembers(){
        clearMembers();
        for(Member member: members){
            findMemberByName.addItem(member);
            findMemberbyId.addItem(member.getMemberId());
        }

        repaint();
        revalidate();
        memberFilled =true;
       
    }
    public void clearMembers(){
        memberFilled =false;
        findMemberByName.removeAllItems();
        findMemberbyId.removeAllItems();
    }
    
    public void populateComponents(Member member){
        DefaultTableModel defaultModel = (DefaultTableModel) loanTable.getModel();
        defaultModel.setRowCount(0);
        loanedPublicationComboBox.removeAllItems();
        for(Loan loan:member.getLoans()){
            if(loan.getReturnDate()==null)
            loanedPublicationComboBox.addItem(loan);
            defaultModel.addRow(loan.getVector());
        }
        if(member.getLoans().size()<1){
            returnButton.setEnabled(false);
        }
        else
            returnButton.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        findMemberbyId = new javax.swing.JComboBox();
        findMemberByName = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loanedPublicationComboBox = new javax.swing.JComboBox();
        returnButton = new javax.swing.JButton();
        publicationTitle = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        loanTable = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Find Member"));

        jLabel1.setText("By Id:");

        findMemberbyId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMemberbyIdActionPerformed(evt);
            }
        });

        findMemberByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMemberByNameActionPerformed(evt);
            }
        });

        jLabel2.setText("By Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(findMemberbyId, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(162, 162, 162))
                    .addComponent(findMemberByName, 0, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findMemberbyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findMemberByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel7.setText("Current Loans:");

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        publicationTitle.setEditable(false);
        publicationTitle.setText("Loan Details");

        loanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Publication", "Copy No.", "Check Out Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(loanTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(returnButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(41, 41, 41)
                                .addComponent(loanedPublicationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publicationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(publicationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loanedPublicationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(returnButton)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void findMemberbyIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMemberbyIdActionPerformed
        // TODO add your handling code here:
        if(memberFilled==true){
            findMemberByName.setSelectedIndex(findMemberbyId.getSelectedIndex());
             populateComponents((Member)findMemberByName.getSelectedItem());
        }
    }//GEN-LAST:event_findMemberbyIdActionPerformed

    private void findMemberByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMemberByNameActionPerformed
        // TODO add your handling code here:
        if(memberFilled==true){
            findMemberbyId.setSelectedIndex(findMemberByName.getSelectedIndex());
             populateComponents((Member)findMemberByName.getSelectedItem());
        }

    }//GEN-LAST:event_findMemberByNameActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        Loan loan = (Loan)loanedPublicationComboBox.getSelectedItem();
        Copy copy = loan.getCopy();
        loan.getLoaner().returnIt(copy);
        populateComponents((Member)findMemberByName.getSelectedItem());
        
        
        JTabbedPane functionTab =(JTabbedPane)this.getParent();
        ReservationTab res =(ReservationTab) functionTab.getComponent(2);
        res.initialize();
        LoanTab loanTab =(LoanTab) functionTab.getComponent(0);
        loanTab.initLoanPanel();
    }//GEN-LAST:event_returnButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox findMemberByName;
    private javax.swing.JComboBox findMemberbyId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable loanTable;
    private javax.swing.JComboBox loanedPublicationComboBox;
    private javax.swing.JTextField publicationTitle;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
