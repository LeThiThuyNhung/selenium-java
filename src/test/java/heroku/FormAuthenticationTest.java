package heroku;

import common.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.heroku.FormAuthenticationPage;
import utils.Browser;

import static utils.Browser.*;

public class FormAuthenticationTest extends TestBase {
    FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();

    @BeforeClass
    void setUp() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }


    //@Parameters ({"browser"})
    @Test
    void tc01() {
        formAuthenticationPage
                .open()
                .login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(formAuthenticationPage
                .getWelcomeMessage()
                .contains("You logged into a secure area!"));
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}