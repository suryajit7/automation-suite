package com.springfield.framework.core;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface AwaitInterface {

    void syncUsingAwait(WebElement element);

}
