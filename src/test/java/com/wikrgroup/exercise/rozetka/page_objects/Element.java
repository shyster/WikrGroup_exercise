package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    private By by = null;
    private Element parentContext;

    public Element(By by) {
        this.by = by;
    }

    public Element(Element searchContext, By by) {
        this(by);
        this.parentContext = searchContext;
    }

    public WebElement getWebElement(WebDriver driver) {
        return parentContext == null ? driver.findElement(by) : parentContext.getWebElement(driver).findElement(by);
    }

    public By getBy() {
        return by;
    }

    public static Element newElement(By by) {
        return new Element(by);
    }

    public static Element newElement(Element parent, By by) {
        return new Element(parent, by);
    }

}
