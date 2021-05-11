package com.tts.addBook;

public class Validation {

    public static void main(String[] args) {
//        String input;
//        Validation validation = new Validation();
//        boolean stop = false;
        System.out.println(validateEmailAddress("@gmail.com"));
        System.out.println(formatPhoneNumber("7042490232"));
    }

    public static boolean validatePhoneNumber(String phoneNum){
        String pattern = "\\d{10}";//123456789
        //current pattern recognizes any string of digits \d for numbers
        if(phoneNum.matches(pattern))
            return true;
        return false;
    }

    public static boolean validateEmailAddress(String email){
        //the first brackets allows any letter or number input
        //2nd brackets allow for @yahoo or @gmail basically any letter characters
        String pattern  = "^[a-zA-Z0-9_.] + @[a-zA-Z.]+?\\,[a-zA-Z]{2,3}$";
        if(email.matches(pattern))
            return true;
        return false;
    }

    public static String formatPhoneNumber(String phone){
        String formatPhone =  phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        return formatPhone;
    }

    public static boolean validateFirstName(String fName){
        String pattern = "^[A-Za-z\\s]+$";;//Accept only string and space
        if(fName.matches(pattern))
            return true;
        return false;
    }

    public static boolean validateLastName(String lName){
        String pattern = "^[A-Za-z\\s]+$";;//Accept only String and space
        if(lName.matches(pattern))
        return true;
        return false;
    }

    public static boolean exitApp(String input){
        if(input.equalsIgnoreCase("q")||input.equalsIgnoreCase("quit"))
            return true;
        return false;
    }

}
