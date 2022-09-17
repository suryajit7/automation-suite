package com.springfield.framework.env.driver;

import com.springfield.framework.core.annotation.LazyConfiguration;
import com.springfield.framework.core.annotation.ThreadScopeBean;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.springfield.framework.data.Constants.WEBDRIVER_RUNMODE;
import static java.util.Collections.singletonList;

@LazyConfiguration
public class WebDriver {

    protected String host;

    @ThreadScopeBean
    @ConditionalOnProperty(name = WEBDRIVER_RUNMODE, havingValue = "remote")
    public org.openqa.selenium.WebDriver getRemoteWebDriver() throws MalformedURLException {

        host = System.getenv("HUB_HOST") != null ? System.getenv("HUB_HOST") : "localhost";
        return new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), getCapabilities());
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = WEBDRIVER_RUNMODE, havingValue = "cloud")
    public org.openqa.selenium.WebDriver remoteChromeDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL("https://uchihasuryajit_rIUiWy:HXYBWT4pHu8sCrrXTQNz@hub.browserstack.com/wd/hub"), getCapabilities());
    }

    private Capabilities getCapabilities() {

        MutableCapabilities mutableCapabilities = new ChromeOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        //chromeOptions.setCapability("se:name", getTestResult().getTestClass().getRealClass().getSimpleName());
        chromeOptions.setExperimentalOption("excludeSwitches", singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("prefs", prefs);

        return mutableCapabilities.merge(chromeOptions);
    }
}
