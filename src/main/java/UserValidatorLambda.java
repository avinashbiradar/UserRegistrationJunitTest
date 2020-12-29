import java.util.regex.Pattern;
import java.util.regex.Pattern;
public class UserValidatorLambda {
    @FunctionalInterface
    interface Check {
        boolean check(String a, String b) throws InvalidUserException;
    }
    public static class UserRegistrationLambda {
        public static void main(String[] args) throws InvalidUserException {
            Check firstNameRegex = (String pattern, String firstName) -> {try {
                    if (Pattern.matches(pattern, firstName))
                        return true;
                    else
                        return false;
            }catch (NullPointerException e) {
                throw new InvalidUserException("Please enter proper message");
            }};
            Check lastNameRegex = (String pattern, String lastName) -> {try {
                    if (Pattern.matches(pattern,  lastName))
                        return true;
                    else
                        return false;
            }catch (NullPointerException e) {
                throw new InvalidUserException("Please enter proper message");
            }};
            Check emailRegex = (String pattern, String email) -> {try {
                    if (Pattern.matches(pattern, email))
                        return true;
                    else
                        return false;
            }catch (NullPointerException e) {
                throw new InvalidUserException("Please enter proper message");
            }};
            Check phoneRegex = (String pattern, String phoneNumber) -> {try {

                    if (Pattern.matches(pattern, phoneNumber))
                        return true;
                    else
                        return false;
            }catch (NullPointerException e) {
                throw new InvalidUserException("Please enter proper message");
            }};
            Check passwordRegex = (String pattern, String password) -> {try {
                if (Pattern.matches(pattern, password))
                        return true;
                    else
                        return false;
            }catch (NullPointerException e) {
                throw new InvalidUserException("Please enter proper message");
            }};

            firstNameRegex.check("^[A-Z]{1}[a-z]{2,}$","Avinash");
            firstNameRegex.check("^[A-Z]{1}[a-z]{2,}$","avinash");
            firstNameRegex.check("^[A-Z]{1}[a-z]{2,}$","avi");
            firstNameRegex.check("^[A-Z]{1}[a-z]{2,}$","Avi");
            lastNameRegex.check("^[A-Z]{1}[a-z]{2,}$","Biradar");
            lastNameRegex.check("^[A-Z]{1}[a-z]{2,}$","biradar");
            lastNameRegex.check("^[A-Z]{1}[a-z]{2,}$","bir");
            lastNameRegex.check("^[A-Z]{1}[a-z]{2,}$","Bir");
            emailRegex.check("^[a-zA-Z0-9\\\\-\\\\+\\\\.]+.([a-zA-Z0-9])*@([a-z0-9]+.[a-z]{2,}.([a-z]{2,})?)$","avinashbiradar64@gmail.com");
            emailRegex.check("^[a-zA-Z0-9\\\\-\\\\+\\\\.]+.([a-zA-Z0-9])*@([a-z0-9]+.[a-z]{2,}.([a-z]{2,})?)$","Avinash@gmail.co.in");
            emailRegex.check("^[a-zA-Z0-9\\\\-\\\\+\\\\.]+.([a-zA-Z0-9])*@([a-z0-9]+.[a-z]{2,}.([a-z]{2,})?)$","souvik199831#gmail.com");
            phoneRegex.check("^[1-9][0-9]+[ ]{0,1}+[1-9][0-9]{9}$","91 9923886906");
            phoneRegex.check("^[1-9][0-9]+[ ]{0,1}+[1-9][0-9]{9}$","91 9604445258");
            passwordRegex.check("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]{1}).{8,}","Avinash@123");
            passwordRegex.check("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]{1}).{8,}","Avinash$12345");

        }
    }
}
