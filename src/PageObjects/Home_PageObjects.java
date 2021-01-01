package src.PageObjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Home_PageObjects {
    public void ClickOn_Chapter1() {
        $(By.cssSelector("div[class=mainbody] ul li a[href='/chapter1']")).click();
    }
}
