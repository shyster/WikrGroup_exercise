package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public class ElementByEnum {
    public static WebElement getWebElement(WebDriver driver, PoEnum uiObjects) {
        Deque<PoEnum> enums = new LinkedList<>();
        WebElement element = null;
        PoEnum current = uiObjects;
        int i = 0;
        do {
            i++;
            if (i >= 100) {
                throw new RuntimeException("Looping or a lot of elements on page more than 100");
            }
            enums.push(current);
            current = (PoEnum) current.getParentName();
        } while (!(null == current));

        while (!enums.isEmpty()) {
            PoEnum en = enums.pop();
            element = element == null ? driver.findElement(en.getBy()) : element.findElement(en.getBy());
        }

        return element;
    }
}
