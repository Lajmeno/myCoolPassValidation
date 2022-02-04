package de.neuefische.myCoolPassValidation;

import java.util.Locale;

public class PassValidator {

    public static boolean passValidation(String password){

        if (password.length() < 8) {
            System.out.println("Not a valid password: needs to contain 8 chars at least!");
            return false;
        }

        boolean numberChecker = true;
        while (numberChecker){
            for (int i = 0; i < 10; i++) {
                if (password.contains("" + i)) {
                    numberChecker = false;
                }
            }
            if (numberChecker){
                System.out.println("Not a valid password: needs to contain one number at least");
                return false;
            }
        }


        if (password.toLowerCase() == password){
            System.out.println("Not a valid password: needs to contain upper case letters");
            return false;
        }else if(password.toUpperCase() == password){
            System.out.println("Not a valid password: needs to contain lower case letters");
            return false;
        }

        boolean specialCharChecker = true;
        while (specialCharChecker){
            String[] specialChars = {"!", "%", "_", "?", "$", "&", "="};
            for (int i = 0; i < specialChars.length; i++) {
                if (password.contains(specialChars[i])) {
                    specialCharChecker = false;
                }
            }
            if (specialCharChecker){
                System.out.println("Not a valid password: needs to contain at least one of the following special characters: ");
                for (int i = 0; i < specialChars.length; i++){
                    System.out.print(specialChars[i] + " ");
                }
                return false;
            }
        }

        System.out.println("Password accepted");
        return true;
    }






    public static void main(String[] args) {
        passValidation("hadhH377hadk");
    }


}
