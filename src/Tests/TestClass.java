package src.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;
import src.main.PageObjects.Chapter1PageObjects;
import src.main.PageObjects.HomePageObjects;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {
    @Parameters({"chromeDriverPath"})
    @BeforeClass
    public void doBeforeClass(@Optional("path of driver will be mentioned here if not provided from XML file") String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("selenide.browser", "Chrome");
    }

    @Parameters({"URL"})
    @Test
    public void verifyHomePage(@Optional("http://book.theautomatedtester.co.uk/") String URL) {
        // Opening required URL
        open(URL);
        HomePageObjects homePageObject = new HomePageObjects();
        $(homePageObject.chapter1).shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = {"verifyHomePage"})
    public void verifyTextOnChapter1View() {
        // Clicking on Chapter1 link.
        HomePageObjects homePageObject = new HomePageObjects();
        homePageObject.clickOnChapter1();

        // Verifying test on Chapter1 view.
        Chapter1PageObjects chapter1PageObject = new Chapter1PageObjects();
        chapter1PageObject.verifyText();
    }

    @Test(dependsOnMethods = {"verifyHomePage", "verifyTextOnChapter1View"})
    public void navigateBackAndVerifyHomePage() {
        // Navigating back to homepage.
        back();
        HomePageObjects homePageObject = new HomePageObjects();
        $(homePageObject.chapter1).shouldBe(Condition.visible);
    }

    @AfterClass
    public void doAfterClass() {
        //Closing driver
        WebDriverRunner.closeWebDriver();
    }
}
