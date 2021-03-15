package com.k12.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface SimpleBy {
    WebElement getElement(WebDriver webDriver,
                          String locator,
                          int waitTime,
                          ExpectedConditionCallback expectedConditionCallback);
}
