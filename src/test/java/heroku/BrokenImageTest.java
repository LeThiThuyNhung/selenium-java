

package heroku;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenImageTest {
    @Test
    void verifyBrokenImage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));

        images.forEach((image) -> {
            String url = image.getDomAttribute("src");
            String naturalWidth = image.getDomProperty("naturalWidth");
            String naturalHeight = image.getDomProperty("naturalHeight");
            System.out.println("=====================================");
            System.out.println("naturalWidth: " + naturalWidth);
            System.out.println("naturalHeight: " + naturalHeight);
            System.out.println("url: " + url);
        });

        Assert.assertEquals(((WebElement)images.get(0)).getDomProperty("naturalWidth"), "0");
        Assert.assertEquals(((WebElement)images.get(1)).getDomProperty("naturalWidth"), "0");

        driver.quit();
    }
}
