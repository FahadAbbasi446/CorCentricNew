package src.Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import src.PageObjects.Chapter1_PageObjects;
import src.PageObjects.Home_PageObjects;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {

    @BeforeTest
    public void doBeforeTest() {
        String chromeDriverPath2 = System.getProperty("user.dir") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath2);
        System.setProperty("selenide.browser", "Chrome");
    }

    @Test
    public void TestToVerifyTextOnChapter1View() {
        // Opening required URL
        open("http://book.theautomatedtester.co.uk/");

        // Clicking on Chapter1 link.
        Home_PageObjects PageObjects1 = new Home_PageObjects();
        PageObjects1.ClickOn_Chapter1();

        // Verifying test on Chapter1 view.
        Chapter1_PageObjects Ch_HomePage = new Chapter1_PageObjects();
        Ch_HomePage.VerifyText();

        // Navigating back to homepage.
        back();
    }
}
