package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vladislav Kulasov on 05.02.2018.
 */
public enum MainPage implements PoEnum {
    HTML(null, By.tagName("html")),
    BODY(HTML, By.tagName("body"));

    private By by;
    private Enum anEnum;

    MainPage(Enum anEnum, By by) {
        this.anEnum = anEnum;
        this.by = by;
    }

    @Override
    public Enum getParentName() {
        return anEnum;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public WebElement getWebElement(WebDriver driver) {
        return ElementByEnum.getWebElement(driver, this);
    }
}
