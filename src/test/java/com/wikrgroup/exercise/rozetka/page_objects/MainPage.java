package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vladislav Kulasov on 05.02.2018.
 */
public class MainPage extends BasePage {

    Element html = element(By.tagName("html"));
    Element body = element(html, By.tagName("body"));

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
