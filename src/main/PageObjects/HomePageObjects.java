package src.main.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Selenide.*;

public class HomePageObjects {
    public By chapter1 = By.linkText("Chapter1");

    public void clickOnChapter1() {
        try {
            $(chapter1).click();
        } catch (ElementIsNotClickableException | NoSuchElementException | ElementNotVisibleException | StaleElementReferenceException e) {
            System.out.println(e);
        }
    }
}
