package tests.chapter1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.architecture.HomePage;
import tests.TestBase;

import java.io.IOException;

public class Chapter1Tests extends TestBase {

    @Test
    public void shouldSeeChapter1Page() {
        HomePage homePage = new HomePage();
        homePage.open()
                .waitUntilElementShouldBeVisible(homePage, homePage.pageHeader, 10000L)
                .clickOnChapter1Link()
                .shouldSeeAssertText()
                .clickOnHomePageLink();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        setupDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        removeDriver();
    }
}
