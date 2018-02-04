package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public interface PoEnum<T extends Enum<T>> {

    T getParentName();

    By getBy();

    WebElement getWebElement(WebDriver driver);

}
