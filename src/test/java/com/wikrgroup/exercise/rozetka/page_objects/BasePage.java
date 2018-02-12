package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public Element element(By by) {
        return new Element(driver, by);
    }

    public Element element(Element parent, By by) {
        return new Element(driver, parent, by);
    }
}
