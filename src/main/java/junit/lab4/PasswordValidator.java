package junit.lab4;

public class PasswordValidator {

    private final int MIN_NB_OF_CHARACTERS = 8;
    private final int MIN_NB_OF_DIGITS = 1;

    public boolean validatePassword(String password){
        return validateNbOfCharacters(password) && validateNbOfDigits(password) && validateNbOfUpperAndLowerCaseLetters(password);
    }

    public boolean validateNbOfCharacters(String s) {
        return s != null && s.length() == MIN_NB_OF_CHARACTERS;
    }

    public boolean validateNbOfDigits(String s) {
        String str = "";

        if (s != null){
            str = s.replaceAll("\\D+","");
        }

        return str.length() >= MIN_NB_OF_DIGITS;
    }

    public boolean validateNbOfUpperAndLowerCaseLetters(String s){
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        if (s != null) {
            hasUppercase = !s.equals(s.toLowerCase());
            hasLowercase = !s.equals(s.toUpperCase());
        }

        return hasUppercase && hasLowercase;
    }
}
