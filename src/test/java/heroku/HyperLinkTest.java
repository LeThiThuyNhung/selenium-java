

package heroku;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {

    @Test
    void verifyAbleNavigateToHyperLink() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/status_codes");

        String href = driver.findElement(By.linkText("200")).getDomAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code"));

        driver.navigate().back();
        href = driver.findElement(By.linkText("301")).getDomAttribute("href");
        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 301 status code."));

        driver.navigate().back();
        href = driver.findElement(By.linkText("404")).getDomAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 404 status code."));

        driver.navigate().back();
        href = driver.findElement(By.linkText("500")).getDomAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 500 status code."));

        driver.quit();
    }
}
