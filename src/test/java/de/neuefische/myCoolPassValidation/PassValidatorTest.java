package de.neuefische.myCoolPassValidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    /*
    @Test
    void shouldValidatePassWithNumbers(){
        String pass = "sfksjhsfbbs";
        Assertions.assertFalse(PassValidator.passValidation(pass));
    }

     */

}