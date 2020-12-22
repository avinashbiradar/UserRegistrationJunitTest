import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestUserValidator {
    //use case 1 test cases for first name
    @Test
    //when the name starts with a capital letter
    public void givenFirstName_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("Avinash");
        Assert.assertEquals(true, result);
    }
    @Test
    //when a name starts with a small letter
    public void givenFirstName_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("avinash");
        Assert.assertEquals(false, result);
    }
    //when a name has 3 or more letters
    @Test
    public void givenFirstName_MinimumThreeLetters_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("Avi");
        Assert.assertEquals(true, result);
    }
    @Test
    //when a name does not contain 3 minimum letters
    public void givenFirstName_NotHaveMinimumThreeLetters_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateFirstName("Av");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_WhenLastNameStartsWithCapitalLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("Biradar");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_WhenLastNameNotStartsWithCapitalLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("biradar");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenLastName_WhenLastNameHaveMinimumThreeLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("Bir");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenLastName_WhenLastNameNotHaveMinimumThreeLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateLastName("bi");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenEmail_WhenEmailStartsWithSmallLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("adhauparag64@gmail.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenEmail_WhenEmailNotStartsWithSmallLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Abc@gmail.com");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenEmail_WhenEmailEndsWithComOrIn_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("abc111@yahoo.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenEmail_WhenEmailNotEndsWithComOrIn_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Abc@gmail.kjnk");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsFollowedByCountryCode_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 9604445258");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsNotFollowedByCountryCode_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("8105215414");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsTenDigit_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 9604445258");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsNotTenDigit_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePhone("91 8105215");
        Assert.assertEquals(false, result);
    }
}