package com.tts.addBook;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class DataFile {
    // private static Object FileUtils;

    //******************************** Read the address book from a file and save into an ArrayList *******************************************
    public static void readData(List<Entry> addressbook) throws FileNotFoundException {

        String[] fields=new String[4];
        try {

            File file = new File("addressBook.txt");
            if(file.exists()){
                Scanner reader = new Scanner(file);
                reader.nextLine();
                reader.nextLine();
                if(!reader.nextLine().equals("")) {// For the case we don't have the last update line to skip reading line
                    reader.nextLine();

                }

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    fields = line.split(",");
                    addressbook.add(new Entry(fields[0], fields[1], fields[2], fields[3]));
                }
                reader.close();}
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }
    //******************************** Save address book to a file *******************************************
    public static void saveToData(AddressBook addressbook) throws IOException {
        if(addressbook.getAddressBook().isEmpty())
            return;
        String[] fields=new String[4];
        try {
            File file=new File("addressBook.txt");
            FileWriter writer=null;
            if(file.createNewFile()||file.length()==0){
                writer=new FileWriter(file);
                writer.write("Created on "+ LocalDate.now()+" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"))+" By "+System.getProperty("user.name")+"\n");
                writer.write("*********************************************************\n\n");

            }else{
                Scanner reader=new Scanner(file);
                String firstLine=reader.nextLine();
                System.out.println(firstLine);
                reader.close();
                writer=new FileWriter(file);
                writer.write(firstLine+"\n");
                writer.write("Last updated on "+LocalDate.now()+" "+ LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"))+" By "+System.getProperty("user.name")+"\n");
                writer.write("***********************************************************\n\n");
            }

            for(Entry entry :addressbook.getAddressBook()){
                String line=entry.getfName()+","+
                        entry.getlName()+","+
                        entry.getPhoneNum()+","+
                        entry.getEmail()+"\n";
                writer.write(line);

            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //****************** Delete the database File when clear the address book ************************
    public static void deleteFile() throws IOException {
        File file=new File("addressBook.txt");
        FileWriter writer=new FileWriter(file);
        writer.write("");
        writer.close();
//        RandomAccessFile raf=new RandomAccessFile(file,"rw");
//        raf.close();
//        file.deleteOnExit();
//        file.delete();
        //Now the file will  get deleted
//The file will not get deleted because raf is open on the file to be delete
// But if I close RandomAccessFile before calling delete then I am able to delete the file
    }

    public static void main(String[] args) throws IOException {
        deleteFile();
    }
}
