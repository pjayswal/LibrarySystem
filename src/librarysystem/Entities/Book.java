/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysystem.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Pramod
 */
public class Book extends Publication{
    private String ISBN;
    private List<Author> authors;
    
   
    public Book(String Title, String isbn,Author author) {
        super(Title);
        this.ISBN = isbn;
        this.authors = new ArrayList<Author>();
        
        addAuthor(author);
    }

  
    public void addAuthor(Author auth){
        if(auth!=null)
        authors.add(auth);
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    
    public String authorListToString(){
        String listAuthors="";
        int i=1;
        for(Author author:authors){
            listAuthors+=i+". "+author.getFullName()+"\n";
            i++;
        }
        return listAuthors;
        
    }
    public Vector getVector(){
        Vector newRow = new Vector();
        newRow.add(getISBN());
        newRow.add(getTitle());
        newRow.add(getNumberCopies());
        return newRow;
        
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
}
