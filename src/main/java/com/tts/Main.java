package com.tts;

import java.util.*;

public class Main extends Entry {
    public static int entryInput;


    public static void main(String[] args) {
        AddressBook newAddy = new AddressBook();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

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
                // Add an entry

                Entry newEntry = new Entry();
                System.out.println("Enter first name: ");
                newEntry.setfName(sc.next());
                System.out.println("Enter last name: ");
                newEntry.setlName(sc.next());
                System.out.println("Enter email: ");
                newEntry.setEmail(sc.next());
                System.out.println("Enter phone number: ");
                newEntry.setPhoneNum(sc.next());
                newAddy.add(newEntry);
                System.out.println("Added entry!");


            } else if (entryInput == 2) {
                // Remove an entry
                System.out.println("Enter email: \n");
                String input = sc.next();
                newAddy.delete(input);

            } else if (entryInput == 3) {
                // Search for an entry
                System.out.println("Enter email: \n");
                String search = sc.next();
                newAddy.look(search);



            } else if (entryInput == 4) {
                // Printing the address book

                Entry[] listOfEntries = newAddy.viewAll();

                for (int i = 0; i < listOfEntries.length; i++) {
                    System.out.println(listOfEntries[i].toString());
                }
            } else if (entryInput == 5) {
                //Deleting the address book

                newAddy.deleteAll();
                System.out.println("Address book has been successfully cleared.");

            } else if(entryInput > 6 | entryInput < 1){
                System.out.println("Invalid response, please try again.");
            }
        }
        while (entryInput != 6);
        System.out.println("Good Bye!");
    }
}