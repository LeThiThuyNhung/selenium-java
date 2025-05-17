package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookingTest {
    @Test

    void verifyDaySelected() {
         FirefoxOptions firefoxOptions = new FirefoxOptions();
         firefoxOptions.addArguments("--headless=new"); // hoặc chỉ "--headless"
         firefoxOptions.addArguments("--no-sandbox");
         firefoxOptions.addArguments("--disable-dev-shm-usage");
         WebDriver driver = new FirefoxDriver(firefoxOptions);
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
                 .filter(x -> x.getText().equals("30"))
                 .findFirst()
                 .get()
                 .click();

         String departDate = wait
                 .until(
                         ExpectedConditions
                                 .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                 .getDomProperty("value");
        Assert.assertEquals(departDate, "30/05/2025");

        driver.quit();
    }
}
