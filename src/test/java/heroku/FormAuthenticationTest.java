
package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {

    @Test
    void tc01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys(new CharSequence[]{"tomsmith"});
        driver.findElement(By.id("password")).sendKeys(new CharSequence[]{"SuperSecretPassword!"});

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below."));

        Thread.sleep(5000);
        driver.quit();
    }
}
