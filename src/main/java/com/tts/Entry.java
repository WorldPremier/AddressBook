package com.tts;


public class Entry {
    private String fName;
    private String lName;
    private String email;
    private String phoneNum;


    public Entry(String fName, String lName, String email, String phoneNum){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNum = phoneNum;
    }
    public Entry() {}



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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Contact Info{" + '\n' +
                "First Name:" + fName + '\n' +
                "Last Name:" + lName + '\n' +
                "Email:" + email + '\n' +
                "Phone Number:" + phoneNum + '\n' +
                '}';
    }
}