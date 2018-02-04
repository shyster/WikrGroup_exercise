package com.wikrgroup.exercise.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public interface Browser extends AutoCloseable {
    WebDriver open();

    WebDriver open(DesiredCapabilities capabilities);

    WebDriver getWebDriver();
}
