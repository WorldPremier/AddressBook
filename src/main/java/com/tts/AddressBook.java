package com.tts;
import java.util.*;


public class AddressBook extends Entry{
    private List<Entry> listOfEntries;

    public AddressBook(){
        this.listOfEntries = new ArrayList<>();
    }

    public void add(Entry addressBookEntry){
        //this .add adds a new object  to a List
        this.listOfEntries.add(addressBookEntry);
    }

    public void delete(int index){
        //List.remove(int index) removes a object at the given index
        this.listOfEntries.remove(index);
    }

    public Entry get(int index){
        return this.listOfEntries.get(index);
    }
    public Entry[] viewAll(){
        //create a new array with the size of our list
        Entry[] result = new Entry[this.listOfEntries.size()];

        //List.toArray(Arr[] array)fills our array with data from the list
        this.listOfEntries.toArray(result);

        //return the filled array
        return result;

    }
}


