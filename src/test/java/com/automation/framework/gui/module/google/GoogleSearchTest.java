package com.automation.framework.gui.module.google;

import com.automation.framework.BaseTestNGTest;
import com.automation.framework.core.annotation.LazyAutowired;
import com.automation.framework.page.app.google.GoogleSearchPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.automation.framework.core.AssertWebElement.assertThat;
import static com.automation.framework.report.TestExecutionListener.getTestMethod;

@Epic("Google")
@Feature("GoogleSearch")
public class GoogleSearchTest extends BaseTestNGTest {

    @LazyAutowired
    private GoogleSearchPage googleSearchPage;


    @Test
    public void verifySearchTest() {

        this.googleSearchPage.goToURL()
                .changeLanguage();

        logger.info("url passed");

        assertThat(googleSearchPage.getSearchComponent().getSearchInputField())
                .isDisplayed()
                .isNotNull();

        this.screenshotService.takeWebPageScreenshot(getTestMethod(), "");
        this.screenshotService.assertWebPageScreenshots(getTestMethod(), "");
    }

    @Test
    public void verifyGoogleSearchTest() {

        this.googleSearchPage.goToURL()
                .performSearch("test2");

        this.screenshotService.takeWebPageScreenshot(getTestMethod(), "test2");

        this.googleSearchPage.close();
    }


}
