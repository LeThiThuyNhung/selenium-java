package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.URI;


public class BraveTest {
    @Test
    void openBrowserWithDefaultMode(){
        try {
            Desktop.getDesktop().browse(new URI("https://brave.com/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void openBrowserWithHeadlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();
    }
}
