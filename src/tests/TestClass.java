package src.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.commons.validator.routines.UrlValidator;
import org.testng.annotations.*;
import src.main.pageObjects.Chapter1PageObjects;
import src.main.pageObjects.HomePageObjects;

import static com.codeborne.selenide.Selenide.*;

public class TestClass {
    HomePageObjects homePageObject;

    @Parameters({"chromeDriverPath"})
    @BeforeClass
    public void doBeforeClass(@Optional("chromedriver.exe") String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("selenide.browser", "Chrome");
        homePageObject = new HomePageObjects();
    }

    @Parameters({"URL"})
    @Test
    public void verifyHomePage(@Optional("http://book.theautomatedtester.co.uk/") String URL) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (URL.isEmpty()) {
            System.out.println("URL is not valid.");
        } else if (!urlValidator.isValid(URL)) {
            System.out.println("URL is not valid.");
        }

        // Opening required URL
        open(URL);
        $(homePageObject.ChapterOneLink).shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = {"verifyHomePage"})
    public void verifyTextOnChapter1View() {
        // Clicking on Chapter1 link.
        homePageObject.clickOnChapter1();

        // Verifying text on Chapter1 view.
        Chapter1PageObjects chapter1PageObject = new Chapter1PageObjects();
        chapter1PageObject.verifyText();
    }

    @Test(dependsOnMethods = {"verifyHomePage", "verifyTextOnChapter1View"})
    public void navigateBackAndVerifyHomePage() {
        // Navigating back to homepage.
        back();
        $(homePageObject.ChapterOneLink).shouldBe(Condition.visible);
    }

    @AfterClass
    public void doAfterClass() {
        //Closing driver
        Selenide.closeWebDriver();
    }
}
