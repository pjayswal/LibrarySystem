/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem;

import java.util.ArrayList;

import librarysystem.UI.OptionsPage;

/**
 *
 * @author Pramod
 */
public class LibrarySystem {
    
    /**
     * @param args the command line arguments
     */
    
    
   
    public static void main(String args[]) {
        
        Data.init();
        Data.inMemoryDateGenerate();
         
        
         
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data.optionPage =new OptionsPage();
                Data.optionPage.setVisible(true);
                //Data.ftab = OptionsPage.
            }
        });
        
    
    }
    
    public void generateMembers(){
        
    }
}
