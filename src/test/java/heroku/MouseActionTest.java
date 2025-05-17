package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionTest {
    @Test
    void hoverTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
        WebElement avatar = driver.findElements(By.className("figure")).get(1);

        action.moveToElement(avatar).perform();
        Assert.assertTrue(avatar.findElement(By.xpath(".//h5")).isDisplayed());
        driver.quit();
    }

    @Test
    void dragAndDropTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        action.clickAndHold(source).moveToElement(target).release().build().perform();

        Assert.assertTrue(driver.findElement(By.id("column-a")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.id("column-b")).getText().contains("A"));

        driver.quit();
    }

    @Test
    void horizontalSliderTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        action.clickAndHold(slider).moveByOffset(slider.getSize().getWidth(), 0).release().build().perform();

        String value = driver.findElement(By.id("range")).getText();
        Assert.assertEquals(value, "5");

        driver.quit();
    }

    @Test
    void infiniteScrollTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions action = new Actions(driver);
        for (int i = 0; i < 10; i++) {
            action.scrollByAmount(0, 100).perform();
            Thread.sleep(1000); // Wait for the page to load
        }

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='jscroll-added']")).isDisplayed());
        driver.quit();
    }

    @Test
    void contextMenuTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.getCurrentUrl().contains("context_menu"));

        driver.quit();
    }

    @Test
    void keyPressTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions action = new Actions(driver);
        //action.sendKeys(Keys.ESCAPE).perform();
        action.keyDown(Keys.ESCAPE).perform();
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You entered: ESCAPE"));

       driver.quit();
    }
}
