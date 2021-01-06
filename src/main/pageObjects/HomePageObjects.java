package src.main.pageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePageObjects {
    public By ChapterOneLink = By.linkText("Chapter1");

    public void clickOnChapter1() {
        try {
            $(ChapterOneLink).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
