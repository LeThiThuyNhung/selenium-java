package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TableTest {
    @Test
    /*
    open browser
    navigate to https://www.vietnamairlines.com/vn/vi/Home
    select 1 chieu
    select day 7/4/2025
    verify day selected
         */
    void verifyDaySelected() {
         WebDriver driver = new FirefoxDriver();
         driver.get("https://www.vietnamairlines.com/vn/vi/Home");

         driver.findElement(By.xpath("//button[.='Đồng ý']")).click();

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         wait
                 .until(
                         ExpectedConditions
                                 .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                 .click();

         driver.findElement(By.cssSelector("#bookYourTripType [data-content-title='Một chiều']")).click();

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                .click();

         driver.findElements(By.cssSelector(".ui-datepicker-group-first a")).stream()
                 .filter(x -> x.getText().equals("7"))
                 .findFirst()
                 .get()
                 .click();

         String departDate = wait
                 .until(
                         ExpectedConditions
                                 .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                 .getDomProperty("value");
        Assert.assertEquals(departDate, "07/04/2025");

        driver.quit();
    }
}
