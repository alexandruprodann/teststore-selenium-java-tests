package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import Utilities.BaseClass;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SignupTest extends BaseClass {

    @Test
    public void signUp() {

        // Pages
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        SignUpPage signUpPage = new SignUpPage();


        // Steps
        Reporter.log("Proceed to Homepage: " + TestConstants.BASE_URL);
        navigateToUrl(TestConstants.BASE_URL);

        Reporter.log("Click Sign In button");
        homePage.clickSignIn();

        Reporter.log("Click 'No account? Create one here' link");
        loginPage.clickCreateAccountLink();

        Reporter.log("Fill in the Sign Up form");
        signUpPage.enterSignUpDetails();
        signUpPage.clickSaveBtn();

        Reporter.log("Observe user is redirected to Homepage after signup");
        String expectedUrl = TestConstants.BASE_URL;
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "Sign up was not successful (not redirected to the homepage). " +
                "\nCurrent URL is: " + getDriver().getCurrentUrl());
    }
}
