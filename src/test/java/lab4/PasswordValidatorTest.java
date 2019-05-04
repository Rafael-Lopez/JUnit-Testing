package lab4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @Before
    public void setUp(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void shouldContainAtLeast8Characters(){
        assertTrue(passwordValidator.validateNbOfCharacters("12345678"));
        assertFalse(passwordValidator.validateNbOfCharacters("1234567"));
        assertFalse(passwordValidator.validateNbOfCharacters(""));
        assertFalse(passwordValidator.validateNbOfCharacters(null));
    }

    @Test
    public void shouldContainAtLeast1Digit(){
        assertTrue(passwordValidator.validateNbOfDigits("abcdefgh1"));
        assertTrue(passwordValidator.validateNbOfDigits("1"));
        assertFalse(passwordValidator.validateNbOfDigits("abdcdefgh"));
        assertFalse(passwordValidator.validateNbOfDigits(""));
        assertFalse(passwordValidator.validateNbOfDigits(null));
    }

    @Test
    public void shouldContainUpperCaseAndLowerCaseLetters(){
        assertTrue(passwordValidator.validateNbOfUpperAndLowerCaseLetters("aB"));
        assertTrue(passwordValidator.validateNbOfUpperAndLowerCaseLetters("aB78ji_"));
        assertFalse(passwordValidator.validateNbOfUpperAndLowerCaseLetters("aa"));
        assertFalse(passwordValidator.validateNbOfUpperAndLowerCaseLetters(""));
        assertFalse(passwordValidator.validateNbOfUpperAndLowerCaseLetters(null));
    }

    @Test
    public void shouldValidatePassword(){
        assertFalse(passwordValidator.validatePassword("aB"));
        assertFalse(passwordValidator.validatePassword("aa"));
        assertFalse(passwordValidator.validatePassword(""));
        assertFalse(passwordValidator.validatePassword(null));
        assertFalse(passwordValidator.validatePassword("ab78ji_t"));
        assertTrue(passwordValidator.validatePassword("aB78ji_t"));
    }
}
