package com.tts;

import java.util.*;

public class Main {
public static int entryInput;
    private static String fName;
    private static String lName;
    private static String email;
    private static int phoneNum;
//    private String fName;
//    private String lName;
//    private String email;

    public static void main(String[] args) {


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
                    System.out.println("\"Please enter your first, last name, phone number and email. Press enter after each input.\"");
                    fName = sc.next();
                    lName = sc.next();
                    email = sc.next();
                    phoneNum = sc.nextInt();
                    Entry values = null;
                    values.addEntry(getfName(), getlName(), getEmail(), getPhoneNum());


                    System.out.println("First Name " + fName);

                } else if (entryInput == 2) {

                } else if (entryInput == 3) {

                } else if (entryInput == 4) {

                } else if (entryInput == 5) {

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





