package com.tts;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import com.tts.Entry;

public class Main{
public static int entryInput;
    private static String fName;
    private static String lName;
    private static String email;
    private static int phoneNum;
//    private String fName;
//    private String lName;
//    private String email;

    public static void main(String[] args) {

        AddressBook addBook = new AddressBook();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        Entry newEntry = new Entry();
        System.out.println("Enter first name: ");
        newEntry.setfName(sc.next());
        System.out.println("Enter last name: ");
        newEntry.setlName(sc.nextLine());
        System.out.println("Enter Email: ");
        newEntry.setEmail(sc.nextLine());
        System.out.println("Enter your phone number");
        newEntry.setPhoneNum(sc.nextInt());


        do {
        System.out.println("1) Add an entry\n" +
                "2) Remove an entry\n" +
                "3) Search for a specific entry\n" +
                "4) Print Address Book\n" +
                "5) Delete Book\n" +
                "6) Quit\n" +
                "Please choose what you'd like to do with the database:\n");
        entryInput = sc.nextInt();


                if (entryInput == 1) {
                    System.out.println("\"Please enter your first, last name, phone number and email. Press enter after each input.\"");
                    fName = sc.next();
                    lName = sc.next();
                    email = sc.next();
                    phoneNum = sc.nextInt();
                    Entry values = null;
                    values.addEntry(getfName(), getlName(), getEmail(), getPhoneNum());



                    System.out.println("First Name " + fName);

                } else if (entryInput == 2) {
                    //this block deletes whatever input has been stored.
                        addBook.delete(sc.nextInt());

                } else if (entryInput == 3) {
                //search an entry.
//                addBook.(sc.findInLine());
                    addBook.notifyAll();

                } else if (entryInput == 4) {
                    //Printing the address book
//                    Entry[] listOfEntries = new addBook.viewAll();
                    addBook.viewAll();

                } else if (entryInput == 5) {
                    addBook.delete(sc.nextInt());

                } else {
                    System.out.println("Invalid entry!!");
                }

            }
            while (entryInput < 6 | entryInput >6);
            System.out.println("Good Bye!");
        }

    private static int getPhoneNum() {
        return phoneNum;
    }

    private static String getEmail() {
        return email;
    }

    private static String getlName() {
        return lName;
    }

    private static String getfName() {
        return fName;
    }
}





