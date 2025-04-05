
package heroku;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    @Test
    void tc03() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void abSelectMultipleOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Grape");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

        select.deselectAll();

        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void verifyTextFieldDisabledByXpath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
        Assert.assertTrue(((WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")))).isEnabled());

        driver.quit();
    }

    @Test
    void verifyTextFieldDisable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertFalse(driver.findElement(By.cssSelector("form#input-example input")).isEnabled());

        driver.findElement(By.cssSelector("form#input-example button")).click();
        Assert.assertTrue(((WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form#input-example input")))).isEnabled());

        driver.quit();
    }
}
