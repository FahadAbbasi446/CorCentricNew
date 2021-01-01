package src.PageObjects;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;

public class Chapter1_PageObjects {
    public void VerifyText() {
        $(By.id("divontheleft")).shouldHave(text("Assert that this text is on the page"));
    }
}
