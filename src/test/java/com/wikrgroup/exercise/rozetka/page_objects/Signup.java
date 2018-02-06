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
public class Signup {
    private static final String ROZETKA_SIGNUP_URL = MY_ROZETKA_URL + "signup/";
    private Logger logger = Logger.getLogger(this.getClass());
    private WebDriver driver;

    public static Signup openPage(WebDriver driver) {
        driver.get(ROZETKA_SIGNUP_URL);
        return new Signup(driver);
    }

    public Signup(WebDriver driver) {
        this.driver = driver;
        logger.info("wait Signup page");
        new WebDriverWait(driver, 60).until(
                ExpectedConditions.presenceOfElementLocated(UIObjects.FORM.getBy()));
    }

    public Signup setName(String value) {
        logger.info("set name: " + value);
        WebElement element = UIObjects.NAME.getWebElement(driver);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public Signup setEmail(String value) {
        logger.info("set email: " + value);
        WebElement element = UIObjects.EMAIL.getWebElement(driver);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public Signup setPassword(String value) {
        logger.info("set password: " + value);
        WebElement element = UIObjects.PASSWORD.getWebElement(driver);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public PersonalData clickOnSubmit() {
        logger.info("click on submit");
        UIObjects.SUBMIT.getWebElement(driver).click();
        return new PersonalData(driver);
    }


    private enum UIObjects implements PoEnum {
        FORM(MainPage.BODY, By.id("signup_form")),
        NAME(FORM, By.name("title")),
        EMAIL(FORM, By.name("login")),
        PASSWORD(FORM, By.name("password")),
        SUBMIT(FORM, By.className("btn-link-i"));

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
