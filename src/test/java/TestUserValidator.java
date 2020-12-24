import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;


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
        boolean result = userValidator.validateEmail("avinashbiradar64@gmail.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void getEmail_whenThreeDomain_shouldReturnFalse() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Avinash@gmail.co.in.com");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenEmail_WhenEmailEndsWithComOrIn_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("abc111@yahoo.com");
        Assert.assertEquals(true, result);
    }

    @Test
    public void getEmail_whenEmailValid_shouldReturnTrue()
    {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validateEmail("Avinash@gmail.com");
        Assert.assertEquals(true, result);
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

    @Test
    public void givenPassword_WhenPasswordIsMinimumEightDigit_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Avinash234$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordIsNotMinimumEightDigit_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("avin");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneCapitalLetter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Avinash123@");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneCapitalLetter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("avinash@");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneNumericNumber_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Avinashbiradar2$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneNumericNumber_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("adased@");
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneSpeacialCharacter_ShouldReturn_True() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("Avinash234$");
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenPassword_WhenPasswordNotHaveAtleastOneSpeacialCharacter_ShouldReturn_False() {
        UserValidator userValidator = new UserValidator();
        boolean result = userValidator.validatePassword("avinash123");
        Assert.assertEquals(false, result);
    }

    //UseCase11-Parameterised Test to validate multiple entry for the Email Address.
    @RunWith(Parameterized.class)
    public static class TestFormRegistration
    {
        String emailId;
        boolean expectedResult;
        private UserValidator emailVariable;
        UserValidator formObject = new UserValidator();
        public TestFormRegistration(String emailId, boolean expectedResult)
        {
            this.emailId = emailId;
            this.expectedResult = expectedResult;
        }
        @Before
        public void initialize()
        {
            emailVariable = new UserValidator();
        }
        @Parameterized.Parameters
        public static List<Object[]> emails()
        {
            return Arrays.asList(new Object[][] { {"Avinash@gmail.com", true}, {"Avinash@gmail.co.in",true}, {"avinashgmail.com", false}});
        }
        @Test
        public void testEmailId() {
                System.out.println("parameter email is->" + emailId);
                Assert.assertEquals(expectedResult, emailVariable.multipleEmailvalidate(emailId));
        }
    }
}