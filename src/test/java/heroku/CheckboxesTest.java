
package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.CheckBoxPage;

import static utils.Browser.*;

public class CheckboxesTest {

    CheckBoxPage checkBoxPage;
    @BeforeClass
    void setUp() {
        openBrowser("chrome");
        checkBoxPage = new CheckBoxPage();
    }
    @Test
    void tc02() {
        checkBoxPage.open();

        checkBoxPage.check("1");
        Assert.assertTrue(checkBoxPage.isChecked("1"));

        checkBoxPage.check("2");
        Assert.assertTrue(checkBoxPage.isChecked("2"));

    }

    @Test
    void verifyCheckAllButtonWorking()  {
        checkBoxPage.open();
        click(By.xpath("//button[@data-test='check-all-button']"));

        Assert.assertTrue(checkBoxPage.isChecked("1"));
        Assert.assertTrue(checkBoxPage.isChecked("2"));
        Assert.assertTrue(checkBoxPage.isChecked("3"));

    }

    @Test
    void verifyUnCheckAllButtonWorking() throws InterruptedException {
        checkBoxPage.open();

        click(By.xpath("//*[@data-test='check-all-button']"));
        click(By.xpath("//*[@data-test='uncheck-all-button']"));

        Assert.assertFalse(checkBoxPage.isChecked("1"));
        Assert.assertFalse(checkBoxPage.isChecked("2"));
        Assert.assertFalse(checkBoxPage.isChecked("3"));

    }

//    @Test
//    void ableToUncheckAllCheckboxes() throws InterruptedException {
//        checkBoxPage.open();
//
//        click(By.cssSelector("button[data-test='check-all-button']"));
//        click(By.cssSelector("button[data-test='uncheck-all-button']"));
//
//        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']")).isSelected());
//        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']")).isSelected());
//        Assert.assertFalse(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']")).isSelected());
//
//        Thread.sleep(5000);
//        driver.quit();
//    }
    @AfterClass
    void tearDown() {
        quit();
    }
}
