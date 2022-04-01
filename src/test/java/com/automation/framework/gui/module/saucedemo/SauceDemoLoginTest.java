package com.automation.framework.gui.module.saucedemo;

import com.automation.framework.BaseTestNGTest;
import com.automation.framework.core.annotation.LazyAutowired;
import com.automation.framework.page.site.saucedemo.LoginPage;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class SauceDemoLoginTest extends BaseTestNGTest {

    @LazyAutowired
    private LoginPage login;

    @Value("${app.saucedemo.username}")
    private String username;


    @Test
    public void verifyLoginPage() {

        this.login.goToUrl()
                .enterCredentials(this.username, decryptService.getSauceDemoPassword())
                .clickLoginButton();
    }

}
