
package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    void tc02() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        this.check(checkBox1);
        Assert.assertTrue(checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        this.check(checkBox2);
        Assert.assertTrue(checkBox2.isSelected());

        driver.quit();
    }

    void check(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

    }

    void uncheck(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }

    }

    @Test
    void verifyCheckAllButtonWorking() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        driver.findElement(By.xpath("//button[@data-test='check-all-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox3']")).isSelected());

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void verifyUnCheckAllButtonWorking() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        driver.findElement(By.xpath("//*[@data-test='check-all-button']")).click();
        driver.findElement(By.xpath("//*[@data-test='uncheck-all-button']")).click();

        Assert.assertFalse(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@data-test='checkbox-checkbox3']")).isSelected());

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    void ableToUncheckAllCheckboxes() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");

        driver.findElement(By.cssSelector("button[data-test='check-all-button']")).click();
        driver.findElement(By.cssSelector("button[data-test='uncheck-all-button']")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']")).isSelected());

        Thread.sleep(5000);
        driver.quit();
    }
}
