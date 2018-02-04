package com.wikrgroup.exercise.rozetka.page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.wikrgroup.exercise.core.Constants.MY_ROZETKA_URL;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class PersonalData {
    private static final String PERSONAL_DATA_URL = MY_ROZETKA_URL + "/profile/personal-information/";
    private Logger logger = Logger.getLogger(this.getClass());
    private WebDriver driver;

    public static PersonalData openPage(WebDriver driver) {
        driver.get(PERSONAL_DATA_URL);
        return new PersonalData(driver);
    }

    public PersonalData(WebDriver driver) {
        this.driver = driver;
        logger.info("wait Personal Data page");
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(UIObjects.PERSONAL_INFO.getBy()));
    }

    public String getEmail() {
        String email = UIObjects.EMAIL.getWebElement(driver).getText();
        logger.info("email: " + email);
        return email;
    }

    public String getName() {
        String name = UIObjects.NAME.getWebElement(driver).getText();
        logger.info("name: " + name);
        return name;
    }

    private enum UIObjects implements PoEnum {

        PERSONAL_INFO(null, By.id("personal_information")),
        PANEL(null, By.xpath("//div[@class='addit-f-i-indent']")),

        VALUE(null, By.xpath("../descendant::div[@class='profile-info-l-i-text']")),

        NAME_LABEL(PANEL, By.xpath("descendant::div[text()='Имя']")),
        NAME(NAME_LABEL, VALUE.getBy()),

        EMAIL_LABEL(PANEL, By.xpath("descendant::div[text()='Электронная почтa']")),
        EMAIL(EMAIL_LABEL, VALUE.getBy());

        private By by;
        private Enum anEnum;

        UIObjects(Enum anEnum, By by) {
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
}
