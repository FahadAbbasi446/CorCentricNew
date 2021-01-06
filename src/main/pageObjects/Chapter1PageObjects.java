package src.main.pageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Chapter1PageObjects {
    By leftDiv = By.id("divontheleft");
    String textToVerifyInLeftDiv = "Assert that this text is on the page";

    public void verifyText() {
        try {
            $(leftDiv).shouldHave(text(textToVerifyInLeftDiv));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
