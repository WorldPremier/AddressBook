package com.tts.addBook;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static AddressBook addressBook=new AddressBook();
    static Scanner scanner=new Scanner(System.in);

    //***************************ADD ENTRY********************************
    public static void addAction() throws IOException {
        String fName;
        String lName;
        String phoneNumber;
        String email;
        System.out.println("Enter First Name");
        fName=scanner.nextLine();
        if(Validation.exitApp(fName)){//If Q/Quit exit the application
            DataFile.saveToData(addressBook);
            System.exit(0) ;}
        while(!Validation.validateFirstName(fName)){
            System.out.println("This is not a valid First Name, try again!");
            fName=scanner.nextLine();
        }
        System.out.println("Enter Last Name");
        lName=scanner.nextLine();
        if(Validation.exitApp(lName)){//If Q/Quit exit the application
            DataFile.saveToData(addressBook);
            System.exit(0) ;}
        while(!Validation.validateFirstName(lName)){
            System.out.println("This is not a valid First Name, try again!");
            lName=scanner.nextLine();
        }
        System.out.println("Enter a valid Phone Number");
        phoneNumber=scanner.nextLine();
        while(!Validation.validatePhoneNumber(phoneNumber)){
            System.out.println("This is not a valid phone number, try again!");
            phoneNumber=scanner.nextLine();
        }
        System.out.println("Enter a valid Email Address");
        email=scanner.nextLine();
        while(!Validation.validateEmailAddress(email)){
            System.out.println("This is not a valid email address, try again!");
            email=scanner.nextLine();
        }
        addressBook.addEntry(new Entry(fName,lName,phoneNumber,email));
    }

    //**************************DO SEARCH FOR AN ENTRY**************************************
    public static void searchAction() throws IOException {
        System.out.println("What field do you want to search by? 1-4");
        System.out.println("1) First name");
        System.out.println("2) Last name");
        System.out.println("3) Email address");
        System.out.println("4) Phone number");
        String input;

        int action=0;
        while(!(action>0 && action<5)) {
            try {
                String quitApp=scanner.nextLine();
                System.out.println("Enter a valid number from 1 to 5 please");
                if(Validation.exitApp(quitApp)){//If Q/Quit exit the application
                    DataFile.saveToData(addressBook);
                    System.exit(0) ;}
                action = Integer.parseInt(quitApp);
            } catch (Exception e) {
                System.out.println("This is not valid number from 1 to 4, try again");
            }
        }

        switch (action){
            case 1:
                System.out.println("Enter First Name");
                input=scanner.nextLine();
                if(Validation.exitApp(input)){//If Q/Quit exit the application
                    DataFile.saveToData(addressBook);
                    System.exit(0) ;}
                while(!Validation.validateFirstName(input)){
                    System.out.println("This is not a valid First Name, try again!");
                    input=scanner.nextLine();
                }
                addressBook.searchByfName(input);
                break;
            case 2:
                System.out.println("Enter Last Name");
                input=scanner.nextLine();
                if(Validation.exitApp(input)){//If Q/Quit exit the application
                    DataFile.saveToData(addressBook);
                    System.exit(0) ;}
                while(!Validation.validateLastName(input)){
                    System.out.println("This is not a valid Last Name, try again!");
                    input=scanner.nextLine();
                }
                addressBook.searchBylName(input);
                break;
            case 3:
                System.out.println("Enter a valid Email Address");
                input=scanner.nextLine();
                if(Validation.exitApp(input)){//If Q/Quit exit the application
                    DataFile.saveToData(addressBook);
                    System.exit(0) ;}
                while(!Validation.validateEmailAddress(input)){
                    System.out.println("This is not a valid phone number, try again!");
                    input=scanner.nextLine();
                }
                addressBook.searchByEmail(input);
                break;
            case 4:
                System.out.println("Enter a valid Phone Number");
                input=scanner.nextLine();
                if(Validation.exitApp(input)){//If Q/Quit exit the application
                    DataFile.saveToData(addressBook);
                    System.exit(0) ;}
                while(!Validation.validatePhoneNumber(input)){
                    System.out.println("This is not a valid phone number, try again!");
                    input=scanner.nextLine();
                }
                addressBook.searchByPhone(input);
                break;

        }

    }

    //***************************************REMOVE ENTRY*****************************************
    public static void removeAction(){
        String email;
        System.out.println("Enter a valid Email Address for the entry you want to remove");
        email=scanner.nextLine();
        while(!Validation.validateEmailAddress(email)){
            System.out.println("This is not a valid email address, try again!");
            email=scanner.nextLine();
        }
        addressBook.deleteEntry(email);
    }

    //**********************************DELETE ADDRESS BOOK****************************************
    public static void deleteAction() throws IOException {
        addressBook.deleteAddressBook();
    }

    //**************************************PRINT ACTION***************************************
    public static void printAction(){
        addressBook.printAddressBook();
    }
    //************************************DO ACTION*****************************************************
    public static void doAction(int action ) throws IOException {
        switch (action){
            case 1:
                addAction();
                break;
            case 2:
                removeAction();
                break;
            case 3:
                searchAction();
                break;
            case 4:
                printAction();
                break;
            case 5:
                deleteAction();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        addressBook=new AddressBook();
        DataFile.readData(addressBook.getAddressBook());
        String quit="";
        out:
        do{
            System.out.println("Please choose what you'd like to do with the data:\n");
            System.out.println("*********** Actions List **************");
            System.out.println("1) Add an entry");
            System.out.println("2) Remove an entry");
            System.out.println("3) Search for a specific entry");
            System.out.println("4) Print the address book");
            System.out.println("5) Delete the address book");
            System.out.println("6) Quit");
            int action=0;
            do{
                try {
                    System.out.println("Enter a valid number from 1 to 5 please");
                    String input=scanner.nextLine();
                    if(Validation.exitApp(input)) {
                        DataFile.saveToData(addressBook);
                        break out;
                    }
                    action = Integer.parseInt(input);
                }catch (Exception e){
                    System.out.println("Enter a valid number from 1 to 5 please");
                }}while (!(action>0 && action <7));
            if(action>0 && action <7) {
                doAction(action);

            }
            else
                System.out.println("Enter a valid number from 1 to 6 please");
            if(action==6) {
                DataFile.saveToData(addressBook);
                break;
            }
            System.out.println("Do you want to perform more action? Y/Yes");
            quit=scanner.nextLine();
        }while(quit.equalsIgnoreCase("y")||quit.equalsIgnoreCase("yes"));
        DataFile.saveToData(addressBook);
    }

}


//
//public class AddressBook extends Entry{
//    private List<Entry> listOfEntries;
//
//    public AddressBook(){
//        this.listOfEntries = new ArrayList<>();
//    }
//
//    public void add(Entry addressBookEntry){
//        //this .add adds a new object  to a List
//        this.listOfEntries.add(addressBookEntry);
//    }
//
//    public void delete(int index){
//        //List.remove(int index) removes a object at the given index
//        this.listOfEntries.remove(index);
//    }
//
//    public Entry get(int index){
//        return this.listOfEntries.get(index);
//    }
//    public Entry[] viewAll(){
//        //create a new array with the size of our list
//        Entry[] result = new Entry[this.listOfEntries.size()];
//
//        //List.toArray(Arr[] array)fills our array with data from the list
//        this.listOfEntries.toArray(result);
//
//        //return the filled array
//        return result;
//
//    }
//}




//package com.tts;
//
//import java.util.ArrayList;
//import java.util.*;
//import java.util.List;
//import com.tts.Entry;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Main{
//public static int entryInput;
//    private static String fName;
//    private static String lName;
//    private static String email;
//    private static String phoneNum;
//
//    static AddressBook addBook = new AddressBook();
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in).useDelimiter("\n");
//
//        Entry newEntry = new Entry();
//        System.out.println("Enter first name: ");
//        newEntry.setfName(sc.next());
//        System.out.println("Enter last name: ");
//        newEntry.setlName(sc.nextLine());
//        System.out.println("Enter Email: ");
//        newEntry.setEmail(sc.nextLine());
//        System.out.println("Enter your phone number");
//        newEntry.setPhoneNum(sc.nextInt());
//
//
//        do {
//        System.out.println("1) Add an entry\n" +
//                "2) Remove an entry\n" +
//                "3) Search for a specific entry\n" +
//                "4) Print Address Book\n" +
//                "5) Delete Book\n" +
//                "6) Quit\n" +
//                "Please choose what you'd like to do with the database:\n");
//        entryInput = sc.nextInt();
//
//
//                if (entryInput == 1) {
//                    System.out.println("\"Please enter your first, last name, phone number and email. Press enter after each input.\"");
//                    fName = sc.next();
//                    lName = sc.next();
//                    email = sc.next();
//                    phoneNum = sc.nextInt();
//                    Entry values = null;
//                    values.addEntry(getfName(), getlName(), getEmail(), getPhoneNum());
//
//
//
//                    System.out.println("First Name " + fName);
//
//                } else if (entryInput == 2) {
//                    //this block deletes whatever input has been stored.
//                        addBook.delete(sc.nextInt());
//
//                } else if (entryInput == 3) {
//                //search an entry.
////                addBook.(sc.findInLine());
//                    addBook.notifyAll();
//
//                } else if (entryInput == 4) {
//                    //Printing the address book
////                    Entry[] listOfEntries = new addBook.viewAll();
//                    addBook.viewAll();
//
//                } else if (entryInput == 5) {
//                    addBook.delete(sc.nextInt());
//
//                } else {
//                    System.out.println("Invalid entry!!");
//                }
//
//            }
//            while (entryInput < 6 | entryInput >6);
//            System.out.println("Good Bye!");
//        }
//
//    private static int getPhoneNum() {
//        return phoneNum;
//    }
//
//    private static String getEmail() {
//        return email;
//    }
//
//    private static String getlName() {
//        return lName;
//    }
//
//    private static String getfName() {
//        return fName;
//    }
//}
//
//
//
//
//
