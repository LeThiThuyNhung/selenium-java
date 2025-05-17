package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrameTest {
    @Test
    void tc06(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT"));


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM"));

        driver.quit();
    }
}
