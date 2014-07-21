/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import librarysystem.Entities.Address;
import librarysystem.Entities.Author;
import librarysystem.Entities.Book;
import librarysystem.Entities.Copy;
import librarysystem.Entities.Magazine;
import librarysystem.Entities.Member;
import librarysystem.UI.OptionsPage;
import librarysystem.UI.Publication;

/**
 *
 * @author Pramod
 */
public class Data {

    public static List<Author> authors;
    public static List<Book> books;
    public static List<Member> members;
    public static List<Address> address;
    public static List<Magazine> magazines;

    public static OptionsPage optionPage;
    public static JTabbedPane ftab;
    public static void init() {
        authors = new ArrayList<Author>();
        books = new ArrayList<Book>();
        members = new ArrayList<Member>();
        address = new ArrayList<Address>();
        magazines = new ArrayList<Magazine>();
    }

    public static void generateDate() {

        for (int i = 0; i < 15; i++) {
            Member mem = new Member("FirstName" + i, "LastName" + i, "phoneNumber" + i);
            address.add(new Address("Street" + i, "City" + i, "zipode" + i, "State" + i, mem));
            members.add(mem);

            Author auth = new Author("authFname" + i, "authLname" + i, "authPhoneNumber" + i);
            address.add(new Address("authStreet" + i, "authCity" + i, "authzipode" + i, "authState" + i, auth));
            auth.setShortBio("authBio" + i);
            auth.setCredentials("AuthCred" + i);
            authors.add(auth);

            Book book = new Book("Title" + i, "ISBN" + i, auth);
            //add Copies
            for (int j = 0; j < 10; j++) {
                new Copy(book);
            }
            books.add(book);

            Magazine magazine = new Magazine("magTitle" + i, i);
            for (int j = 0; j < 10; j++) {
                new Copy(magazine);
            }
            magazines.add(magazine);
        }
        for (int i = 1; i < 15; i = i + 2) {
            books.get(i).addAuthor(authors.get(i));
        }

    }

    public static void inMemoryDateGenerate() {
        
        Member Pramod = new Member("Pramod", "Jayswal", "9849058963");
        Member Ramesh = new Member("Ramesh", "Karna", "9875842563");
        Member Dinuka = new Member("Dinuka", "Malanayaka", "9654875635");
        Member Awais= new Member("Awais", "Tarikh", "9845863214");
        Member Yashir = new Member("Yashir", "Mukhtar", "9847556321");
        
        new Address("1001 S 5th Street" , "Montgomery", "12557", "Alabama", Pramod);
        new Address("1000 N 4th Street" , "FairField", "52557", "IOWA", Ramesh);
        new Address("800 N 10th Street" , "Juneau", "51557", "Alaska ", Dinuka);
        new Address("1002 N 4th Street" , "FairField", "52557", "IOWA", Awais);
        new Address("1001 N 4th Street" , "FairField", "52557", "IOWA", Yashir);
        
        members.add(Pramod);
        members.add(Ramesh);
        members.add(Dinuka);
        members.add(Awais);
        members.add(Yashir);
        
 

        Author brian = new Author("Dr. Brian" , "Smith", "98457623541");
        Author leyman = new Author("Dr. Leyman" , "Snow", "98458623541");
        Author drek = new Author("Dr. Drek" , "Freemen", "98457659541");
        Author leonardo = new Author("Dr. Leonardo" , "Decaprio", "98457623578");
        Author karry = new Author("Dr. Katty" , "Perry", "98457678941");
        
        new Address("1001 S 5th Street" , "Montgomery", "12557", "Alabama", brian);
        new Address("1000 N 4th Street" , "FairField", "52557", "IOWA", leyman);
        new Address("800 N 10th Street" , "Juneau", "51557", "Alaska ", drek);
        new Address("1002 N 4th Street" , "FairField", "52557", "IOWA", leonardo);
        new Address("1001 N 4th Street" , "FairField", "52557", "IOWA", karry);
        
        brian.setCredentials("Credentials of Brian");
        brian.setShortBio("Bio of Brian");
        leyman.setCredentials("Credentials of Leyman");
        leyman.setShortBio("Bio of Leyman");
        drek.setCredentials("Credentials of Drek");
        drek.setShortBio("Bio of Drek");
        leonardo.setCredentials("Credentials of Leonardo");
        leonardo.setShortBio("Bio of Leonardo");
        karry.setCredentials("Credentials of Katty");
        karry.setShortBio("Bio of Katty");
        
       
        authors.add(brian);
        authors.add(leonardo);
        authors.add(leyman);
        authors.add(drek);
        authors.add(karry);
                

        Book cpp = new Book("C++", "ISBN12456" ,brian);
        Book java = new Book("Java", "ISBN14589" ,leyman);
        Book database = new Book("DataBase", "ISBN8596" ,leonardo);
        Book ai = new Book("Artificial Intelligence", "ISBN1456" ,karry);
        Book cn = new Book("Computer Networks", "ISBN8965" ,drek);
        
        for (int j = 0; j < 5; j++) {
            new Copy(cpp);
            new Copy(java);
            new Copy(database);
            new Copy(ai);
            new Copy(cn);
        }
        books.add(cpp);
        books.add(java);
        books.add(database);
        books.add(ai);
        books.add(cn);
        
        cpp.addAuthor(karry);
        cpp.addAuthor(leyman);
        cpp.addAuthor(drek);
        
        java.addAuthor(brian);
                
        

        Magazine usaToday = new Magazine("USAToday", 12);
        Magazine nepalToday = new Magazine("NepalToday", 12);
        Magazine indiaToday = new Magazine("IndiaToday", 12);
        Magazine chinaToday = new Magazine("ChineToday", 12);
        Magazine lankaToday = new Magazine("LankaToday", 12);
        for (int j = 0; j < 5; j++) {
            new Copy(usaToday);
            new Copy(indiaToday);
            new Copy(nepalToday);
            new Copy(lankaToday);
            new Copy(chinaToday);
        }
        magazines.add(usaToday);
        magazines.add(lankaToday);
        magazines.add(nepalToday);
        magazines.add(indiaToday);
        magazines.add(chinaToday);
    }
    
public static List<Author> getAuthors() {
        return authors;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static List<Member> getMembers() {
        return members;
    }

    public static List<Address> getAddress() {
        return address;
    }

    public static List<Magazine> getMagazines() {
        return magazines;
    }
    
    
}
