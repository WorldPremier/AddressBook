package com.tts;

public class Entry extends Main{
    private String fName;
    private String lName;
    private String email;
    private int phoneNum;

    Entry(String fName, String lName, String email, int phoneNum){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNum = phoneNum;
    }
    Entry(){
        fName = "";
        lName = "";
        email = "";
        phoneNum =0;
    }

    public void addEntry(String fName, String lName, String email, int phoneNum) {
        new Entry(fName, lName, email, phoneNum);
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
