package de.neuefische.myCoolPassValidation;

public class PassValidator {

    private static final String[] INCLUDED_SPECIAL_LETTERS = {"!", "%", "_", "?", "$", "&", "="};

    private static final String EMPTY_ERR_MESSAGE = "Not a valid password: password is empty!";
    private static final String TOO_SHORT_ERR_MESSAGE = "Not a valid password: needs to contain 8 chars at least!";
    private static final String NO_NUMBER_ERR_MESSAGE = "Not a valid password: needs to contain one number at least";
    private static final String UPPER_LOWER_CASE_ERR_MESSAGE = "Not a valid password: needs to contain upper and lower case letters";
    private static final String SPECIAL_CHARS_ERR_MESSAGE = "Not a valid password: needs to contain at least one of the following special characters: ";
    private static final String ONE_OR_MORE_NOT_VALID_ERR_MESSAGE = "One or more passwords are not valid";
    private static final String EMPTY_ARRAY_ERR_MESSAGE = "Empty passwords!";

    private static final String VALID_PASSWORD_MESSAGE = "Password accepted";
    private static final String ALL_VALID_PASSWORDS_MESSAGE = "All passwords are valid";


    /*
    Zum Testen wahrscheinlich besser, wenn mehr als zwei Ausgaben (also als boolean) ausgegeben werden.
    Denn die Ausgabe selber ist nicht direkt mit dem Problem verknüpft - alle Abbruchbedingungen führen zu der Ausgabe von
    false. Nur mit Hilfe der Comments lassen sich diese auf die Quelle hinweisen. Mit einer Nummerierung hätte man für jede
    Bedingung eine eigene Nummer.
     */

    public static boolean passValidation(String password){

        if (password == null){
            System.out.println(EMPTY_ERR_MESSAGE);
            return false;
        }

        if (password.length() < 8) {
            System.out.println(TOO_SHORT_ERR_MESSAGE);
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
                System.out.println(NO_NUMBER_ERR_MESSAGE);
                return false;
            }
        }

        if (password.toLowerCase().equals(password) || password.toUpperCase().equals(password)){
            System.out.println(UPPER_LOWER_CASE_ERR_MESSAGE);
            return false;
        }

        boolean specialCharChecker = true;
        while (specialCharChecker){
            String[] specialChars = INCLUDED_SPECIAL_LETTERS;
            for (int i = 0; i < specialChars.length; i++) {
                if (password.contains(specialChars[i])) {
                    specialCharChecker = false;
                }
            }
            if (specialCharChecker){
                System.out.println(SPECIAL_CHARS_ERR_MESSAGE);
                for (int i = 0; i < specialChars.length; i++){
                    System.out.print(specialChars[i] + " ");
                }
                return false;
            }
        }

        System.out.println(VALID_PASSWORD_MESSAGE);
        return true;
    }

    public static boolean passArrayValidation(String[] passwords){

        for (int i = 0; i < passwords.length; i++) {
            String password = passwords[i];
            if (!passValidation(password)) {
                System.out.println(ONE_OR_MORE_NOT_VALID_ERR_MESSAGE);
                return false;
            }
        }

        if (passwords.length > 0) {
            System.out.println(ALL_VALID_PASSWORDS_MESSAGE);
            return true;
        }
        System.out.println(EMPTY_ARRAY_ERR_MESSAGE);
        return false;
    }

}
