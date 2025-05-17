package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class CheckBoxPage {
    public void open() {
        visit("https://the-internet.herokuapp.com/checkboxes");
    }
    public void check(String checkBoxName) {
       if(!isSelected(By.cssSelector(String.format("form#checkboxes input[value='%s']", checkBoxName))))
       {
           click(By.cssSelector(String.format("form#checkboxes input[value='%s']", checkBoxName)));
       }
    }

    public void unCheck(String checkBoxName) {
        if(isSelected(By.cssSelector(String.format("form#checkboxes input[value='%s']", checkBoxName))))
        {
            click(By.cssSelector(String.format("form#checkboxes input[value='%s']", checkBoxName)));
        }
    }

    public boolean isChecked(String checkBoxName) {
        return isSelected(By.cssSelector(String.format("form#checkboxes input[value='%s']", checkBoxName)));
    }
}
