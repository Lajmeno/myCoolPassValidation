package de.neuefische.myCoolPassValidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PassValidatorTest {

    @Test
    void shouldNotValidatePassOfLength0(){
        String pass = "";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

    @Test
    void shouldNotValidatePassWithNoNumbers(){
        String pass = "bcdefghijk";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

    @Test
    void shouldNotValidatePassWithOnlyLowerCase(){
        String pass = "8dadkh83uuuuu";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

    @Test
    void shouldNotValidatePassWithOnlyUpperCase(){
        String pass = "8ASTGDBH77";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

    @Test
    void shouldNotValidatePassWithNoSpecialChars(){
        String pass = "djadHdw6766";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

    @Test
    void shouldValidatePassWith8Chars(){
        String pass = "7dgHiwo!";
        Assertions.assertTrue(PassValidator.passValidation(pass));
    }


    @Test
    void shouldValidatePassWithNull(){
        String pass = null;
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }



    /////Test for Arrays/////////

    @Test
    void shouldNotValidateArrayOfPassOfLength0(){
        String[] passwords = new String[0];
        Assertions.assertFalse(PassValidator.passArrayValidation(passwords));
    }

    @Test
    void shouldNotValidateEmptyArrayOfPassOfLength1(){
        String[] passwords = new String[1];
        Assertions.assertFalse(PassValidator.passArrayValidation(passwords));
    }

    @Test
    void shouldNotValidateArrayWithNotValidPass(){
        String[] passwords = {"adadhHkf"};
        Assertions.assertFalse(PassValidator.passArrayValidation(passwords));
    }

    @Test
    void shouldNotValidateArrayWithOneNotValidPass(){
        String[] passwords = {"adadhHkf8!", "hadh"};
        Assertions.assertFalse(PassValidator.passArrayValidation(passwords));
    }



    /*
    @Test
    void shouldValidatePassWithNumbers(){
        String pass = "sfksjhsfbbs";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

     */

}