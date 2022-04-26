package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find sign in link and click on it
        clickOnElement(By.linkText("Sign In"));

        //This is from requirement
        String expectedMessage = "Welcome Back!";

        //Actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));

        //Validate expected message and actual message
        Assert.assertEquals("unable to navigate on welcome page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find sign in link and click on it
        clickOnElement(By.linkText("Sign In"));

        //Find email element
        sendTextToElement(By.name("user[email]"), "kp@gmail.com");

        //Find Password element
        sendTextToElement(By.id("user[password]"), "123456");

        //Find login button and click on it
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        //This is from requirement
        String expectedMessage = "Invalid email or password.";

        //Actual Message
        String actualMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));


        Assert.assertEquals("Error message is not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
