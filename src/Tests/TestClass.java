package src.Tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import src.main.PageObjects.Chapter1PageObjects;
import src.main.PageObjects.HomePageObjects;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {

    @Parameters({ "chromeDriverPath" })
    @BeforeClass
    public void doBeforeClass(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("selenide.browser", "Chrome");
    }
    @Parameters({ "URL" })
    @Test
    public void verifyHomePage(String URL) {
        // Opening required URL
        open(URL);
        HomePageObjects homePageObject = new HomePageObjects();
        homePageObject.verifyUserIsOnHomePage();
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

    @Test(dependsOnMethods = {"verifyTextOnChapter1View"})
    public void navigateBackAndVerifyHomePage() {
        // Navigating back to homepage.
        back();
        HomePageObjects homePageObject = new HomePageObjects();
        homePageObject.verifyUserIsOnHomePage();
    }

    @AfterClass
    public void doAfterClass() {
        //Closing driver
        WebDriverRunner.closeWebDriver();
    }
}
