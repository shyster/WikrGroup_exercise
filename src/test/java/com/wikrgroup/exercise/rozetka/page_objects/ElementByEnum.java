package com.wikrgroup.exercise.rozetka.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public class ElementByEnum {
    public static WebElement getWebElement(WebDriver driver, PoEnum uiObjects) {
        List<PoEnum> enums = new ArrayList<>();
        WebElement element = null;
        PoEnum current = uiObjects;
        int i = 0;
        while (true) {
            enums.add(current);
            i++;
            if (i >= 100) {
                throw new RuntimeException("Looping or a lot of elements on page more than 100");
            }

            if (null == current.getParentName()) {
                break;
            }

            current = (PoEnum) current.getParentName();
        }

        ListIterator elements = enums.listIterator(enums.size());
        while (elements.hasPrevious()) {
            PoEnum en = (PoEnum) elements.previous();
            element = element == null ? driver.findElement(en.getBy()) : element.findElement(en.getBy());
        }

        return element;
    }
}
