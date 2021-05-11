package com.tts.addBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private Scanner scanner = new Scanner(System.in);
    private String confirm;
    private  List<Entry> addressBook;
    public AddressBook(List<Entry> addressBook){
        this.addressBook=addressBook;
    }
    public AddressBook(){
        this.addressBook=new ArrayList<>();
    }
    public List<Entry> getAddressBook(){
        return this.addressBook;
    }
    public void  setAddressBook(List<Entry> addressBook){
        this.addressBook=addressBook;
    }
    ////////////////////////// Add An Entry ////////////////////////////////////
    public void addEntry(Entry entry){
        boolean found=false;
        for(Entry item:addressBook){
            if(item.getEmail().equalsIgnoreCase(entry.getEmail())) {
                found=true;
                int index=addressBook.indexOf(item);// Get the index of the matching entry found in the addressBook
                // to use it later if the user wants to update the existing entry
                System.out.println("There is an existing entry related to the entered entry email_address");
                System.out.println( item.toString());
                System.out.println("Do you want to update this existing entry? Y/Yes");
                confirm=scanner.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")){
                    addressBook.set(index,entry);
                    System.out.println("This entry was successfully updated");
                    System.out.println(entry.toString());
                    return;

                }
                else
                    System.out.println("Thank you");
                return;
            }}
        if(!found) {// There is no existing entry with matched email address in the addressBook
            addressBook.add(entry);
            System.out.println("The entry was successfully added to the addressBook, thank you!");

        }




    }
    ////////////////////////// Delete An Entry ////////////////////////////////////
    public void deleteEntry(String email){
        for(Entry item:addressBook){
            if(email.equalsIgnoreCase(item.getEmail())) {
                System.out.println( item.toString());
                System.out.println("Are you sure you want do delete this entry? Y/Yes");
                confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")){
                    System.out.println("This entry was successfully deleted\n"+item.toString());
                    addressBook.remove(item);

                }
                else
                    System.out.printf("Sorry! There is no entry related to the entered Email-Address %s\n",email);
            }
        }
    }
    ////////////////////////// Search by Email Address ////////////////////////////////////
    public void searchByEmail(String email){
        boolean found=false;
        for(Entry item:addressBook){
            if(email.equalsIgnoreCase(item.getEmail())) {
                System.out.println("This entry related to the entered email address is:");
                System.out.println( item.toString());
                found=true;
                break;

            }
        }
        if(!found){
            System.out.printf("Sorry! There is no entry related to the entered Email-Address %s\n",email);
        }

    }
    ////////////////////////// Search by Phone Number ////////////////////////////////////
    public void searchByPhone(String phone){
        List<Entry> temp=new ArrayList<>();
        for(Entry item:addressBook) {
            if (phone.equalsIgnoreCase(item.getPhoneNum())) {
                System.out.println( item.toString());
                temp.add(item);
            }
        }
        System.out.println(temp);
        if(temp.size()>0){
            System.out.printf("We found (%d) related to the entered Phone-Number:\n",temp.size());
            for (Entry item:temp)
                System.out.println( item.toString());
        }
        else
            System.out.printf("Sorry! There is no entry related to the entered Phone-Number %s\n",phone);


    }
    ////////////////////////// Search by First name ////////////////////////////////////
    public void searchByfName(String fName){
        List<Entry> temp=new ArrayList<>();
        for(Entry item:addressBook) {
            //if (item.getFirstName().toUpperCase().contains(fname.toUpperCase())) {// get all the entries which have the substring anywhere
            if (item.getfName().substring(0, fName.length()).equalsIgnoreCase(fName)) {//get all the entries which start with the entered substring
                temp.add(item);
            }
        }
        if(temp.size()>0){
            System.out.printf("We found (%d) related to the entered First name:\n",temp.size());
            for (Entry item:temp)
                System.out.println( item.toString());
        }
        else
            System.out.printf("Sorry! There is no entry related to the entered First name %s\n",fName);
    }
    ////////////////////////// Search by Last name ////////////////////////////////////
    public void searchBylName(String lName){
        List<Entry> temp=new ArrayList<>();
        for(Entry item:addressBook) {
            // if (item.getLastName().toUpperCase().contains(lname.toUpperCase())) {
            if (item.getlName().substring(0,lName.length()).equalsIgnoreCase(lName)) {
                temp.add(item);
            }
        }
        if(temp.size()>0){
            System.out.printf("We found (%d) related to the entered Last name:\n",temp.size());
            for (Entry item:temp)
                System.out.println( item.toString());
        }
        else
            System.out.printf("Sorry! There is no entry related to the entered Last name %s\n",lName);


    }
    ////////////////////////// Print Address book ////////////////////////////////////
    public void printAddressBook(){

        if(addressBook.size()>0){
            System.out.printf("This address book contains (%d) entry :\n",addressBook.size());
            for (Entry item:addressBook)
                System.out.println( "****************** Entry "+(addressBook.indexOf(item)+1)+" **************\n" + item.toString());
        }
        else
            System.out.println("Sorry! This address book is empty");


    }
    ////////////////////////// Delete the address book ////////////////////////////////////
    public void deleteAddressBook() throws IOException {

        System.out.println("Are you sure you want do delete this entry? Y/Yes");
        confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")){
            addressBook.clear();
            DataFile.deleteFile();
            System.out.println("This addressBook was successfully deleted");
        }

    }



}


//package com.tts;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Main {
//    static AddressBook addressBook=new AddressBook();
//    static Scanner scanner=new Scanner(System.in);
//
//    //***************************ADD ENTRY********************************
//    public static void addAction() throws IOException {
//        String fName;
//        String lName;
//        String phoneNumber;
//        String email;
//        System.out.println("Enter First Name");
//        fName=scanner.nextLine();
//        if(Validation.exitApp(fName)){//If Q/Quit exit the application
//            DataFile.saveToData(addressBook);
//            System.exit(0) ;}
//        while(!Validation.validateFirstName(fName)){
//            System.out.println("This is not a valid First Name, try again!");
//            fName=scanner.nextLine();
//        }
//        System.out.println("Enter Last Name");
//        lName=scanner.nextLine();
//        if(Validation.exitApp(lName)){//If Q/Quit exit the application
//            DataFile.saveToData(addressBook);
//            System.exit(0) ;}
//        while(!Validation.validateFirstName(lName)){
//            System.out.println("This is not a valid First Name, try again!");
//            lName=scanner.nextLine();
//        }
//        System.out.println("Enter a valid Phone Number");
//        phoneNumber=scanner.nextLine();
//        while(!Validation.validatePhoneNumber(phoneNumber)){
//            System.out.println("This is not a valid phone number, try again!");
//            phoneNumber=scanner.nextLine();
//        }
//        System.out.println("Enter a valid Email Address");
//        email=scanner.nextLine();
//        while(!Validation.validateEmailAddress(email)){
//            System.out.println("This is not a valid email address, try again!");
//            email=scanner.nextLine();
//        }
//        addressBook.addEntry(new Entry(fName,lName,phoneNumber,email));
//    }
//
//    //**************************DO SEARCH FOR AN ENTRY**************************************
//    public static void searchAction() throws IOException {
//        System.out.println("What field do you want to search by? 1-4");
//        System.out.println("1) First name");
//        System.out.println("2) Last name");
//        System.out.println("3) Email address");
//        System.out.println("4) Phone number");
//        String input;
//
//        int action=0;
//        while(!(action>0 && action<5)) {
//            try {
//                String quitApp=scanner.nextLine();
//                System.out.println("Enter a valid number from 1 to 5 please");
//                if(Validation.exitApp(quitApp)){//If Q/Quit exit the application
//                    DataFile.saveToData(addressBook);
//                    System.exit(0) ;}
//                action = Integer.parseInt(quitApp);
//            } catch (Exception e) {
//                System.out.println("This is not valid number from 1 to 4, try again");
//            }
//        }
//
//        switch (action){
//            case 1:
//                System.out.println("Enter First Name");
//                input=scanner.nextLine();
//                if(Validation.exitApp(input)){//If Q/Quit exit the application
//                    DataFile.saveToData(addressBook);
//                    System.exit(0) ;}
//                while(!Validation.validateFirstName(input)){
//                    System.out.println("This is not a valid First Name, try again!");
//                    input=scanner.nextLine();
//                }
//                addressBook.searchByFName(input);
//                break;
//            case 2:
//                System.out.println("Enter Last Name");
//                input=scanner.nextLine();
//                if(Validation.exitApp(input)){//If Q/Quit exit the application
//                    DataFile.saveToData(addressBook);
//                    System.exit(0) ;}
//                while(!Validation.validateLastName(input)){
//                    System.out.println("This is not a valid Last Name, try again!");
//                    input=scanner.nextLine();
//                }
//                addressBook.searchByLName(input);
//                break;
//            case 3:
//                System.out.println("Enter a valid Email Address");
//                input=scanner.nextLine();
//                if(Validation.exitApp(input)){//If Q/Quit exit the application
//                    DataFile.saveToData(addressBook);
//                    System.exit(0) ;}
//                while(!Validation.validateEmailAddress(input)){
//                    System.out.println("This is not a valid phone number, try again!");
//                    input=scanner.nextLine();
//                }
//                addressBook.searchByEmail(input);
//                break;
//            case 4:
//                System.out.println("Enter a valid Phone Number");
//                input=scanner.nextLine();
//                if(Validation.exitApp(input)){//If Q/Quit exit the application
//                    DataFile.saveToData(addressBook);
//                    System.exit(0) ;}
//                while(!Validation.validatePhoneNumber(input)){
//                    System.out.println("This is not a valid phone number, try again!");
//                    input=scanner.nextLine();
//                }
//                addressBook.searchByPhone(input);
//                break;
//
//        }
//
//    }
//
//    //***************************************REMOVE ENTRY*****************************************
//    public static void removeAction(){
//        String email;
//        System.out.println("Enter a valid Email Address for the entry you want to remove");
//        email=scanner.nextLine();
//        while(!Validation.validateEmailAddress(email)){
//            System.out.println("This is not a valid email address, try again!");
//            email=scanner.nextLine();
//        }
//        addressBook.deleteEntry(email);
//    }
//
//    //**********************************DELETE ADDRESS BOOK****************************************
//    public static void deleteAction() throws IOException {
//        addressBook.deleteAddressBook();
//    }
//
//    //**************************************PRINT ACTION***************************************
//    public static void printAction(){
//        addressBook.printAddressBook();
//    }
//    //************************************DO ACTION*****************************************************
//    public static void doAction(int action ) throws IOException {
//        switch (action){
//            case 1:
//                addAction();
//                break;
//            case 2:
//                removeAction();
//                break;
//            case 3:
//                searchAction();
//                break;
//            case 4:
//                printAction();
//                break;
//            case 5:
//                deleteAction();
//                break;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        addressBook=new AddressBook();
//        DataFile.readData(addressBook.getAddressBook());
//        String quit="";
//        out:
//        do{
//            System.out.println("Please choose what you'd like to do with the data:\n");
//            System.out.println("*********** Actions List **************");
//            System.out.println("1) Add an entry");
//            System.out.println("2) Remove an entry");
//            System.out.println("3) Search for a specific entry");
//            System.out.println("4) Print the address book");
//            System.out.println("5) Delete the address book");
//            System.out.println("6) Quit");
//            int action=0;
//            do{
//                try {
//                    System.out.println("Enter a valid number from 1 to 5 please");
//                    String input=scanner.nextLine();
//                    if(Validation.exitApp(input)) {
//                        DataFile.saveToData(addressBook);
//                        break out;
//                    }
//                    action = Integer.parseInt(input);
//                }catch (Exception e){
//                    System.out.println("Enter a valid number from 1 to 5 please");
//                }}while (!(action>0 && action <7));
//            if(action>0 && action <7) {
//                doAction(action);
//
//            }
//            else
//                System.out.println("Enter a valid number from 1 to 6 please");
//            if(action==6) {
//                DataFile.saveToData(addressBook);
//                break;
//            }
//            System.out.println("Do you want to perform more action? Y/Yes");
//            quit=scanner.nextLine();
//        }while(quit.equalsIgnoreCase("y")||quit.equalsIgnoreCase("yes"));
//        DataFile.saveToData(addressBook);
//    }
//
//}
//
//
////
////public class AddressBook extends Entry{
////    private List<Entry> listOfEntries;
////
////    public AddressBook(){
////        this.listOfEntries = new ArrayList<>();
////    }
////
////    public void add(Entry addressBookEntry){
////        //this .add adds a new object  to a List
////        this.listOfEntries.add(addressBookEntry);
////    }
////
////    public void delete(int index){
////        //List.remove(int index) removes a object at the given index
////        this.listOfEntries.remove(index);
////    }
////
////    public Entry get(int index){
////        return this.listOfEntries.get(index);
////    }
////    public Entry[] viewAll(){
////        //create a new array with the size of our list
////        Entry[] result = new Entry[this.listOfEntries.size()];
////
////        //List.toArray(Arr[] array)fills our array with data from the list
////        this.listOfEntries.toArray(result);
////
////        //return the filled array
////        return result;
////
////    }
////}
//
//
