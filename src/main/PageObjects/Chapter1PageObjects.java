package src.main.PageObjects;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Condition.*;

public class Chapter1PageObjects {
    By textToVerify = By.id("divontheleft");
    String message = "Assert that this text is on the page";

    public void verifyText() {
        try {
            $(textToVerify).shouldHave(text(message));
        } catch (ElementIsNotClickableException | NoSuchElementException | ElementNotVisibleException | StaleElementReferenceException e) {
            System.out.println(e);
        }
    }
}
