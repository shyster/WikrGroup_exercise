package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    private final WebDriver driver;
    private final By by;
    private Element parentContext;

    public Element(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
    }

    public Element(WebDriver driver, Element searchContext, By by) {
        this(driver, by);
        this.parentContext = searchContext;
    }

    public WebElement getWebElement() {
        return parentContext == null ? driver.findElement(by) : parentContext.getWebElement().findElement(by);
    }

    public By getBy() {
        return by;
    }

}
