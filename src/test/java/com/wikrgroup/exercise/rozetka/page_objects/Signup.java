package com.wikrgroup.exercise.rozetka.page_objects;

import com.wikrgroup.exercise.core.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.wikrgroup.exercise.core.Constants.MY_ROZETKA_URL;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class Signup{
    private static final String ROZETKA_SIGNUP_URL = MY_ROZETKA_URL + "signup/";
    private Logger logger = Logger.getLogger(this.getClass());
    private WebDriver driver;

    Element form = Element.newElement(By.id("signup_form"));
    Element name = Element.newElement(form, By.name("title"));
    Element email = Element.newElement(form, By.name("login"));
    Element password = Element.newElement(form, By.name("password"));
    Element submit = Element.newElement(form, By.className("btn-link-i"));

    public static Signup openPage(WebDriver driver) {
        driver.get(ROZETKA_SIGNUP_URL);
        return new Signup(driver);
    }

    public static Signup getPage(WebDriver driver) {
        return new Signup(driver);
    }

    public Signup(WebDriver driver) {
        this.driver = driver;
        logger.info("wait Signup page");
        new WebDriverWait(driver, 60).until(
                ExpectedConditions.presenceOfElementLocated(form.getBy()));
    }

    public PersonalData login(User user) {
        logger.info("Login as user:" + user);
        clearForm();
        name.getWebElement(driver).sendKeys(user.getName());
        email.getWebElement(driver).sendKeys(user.getEmail());
        password.getWebElement(driver).sendKeys(user.getPassword());
        submit.getWebElement(driver).click();
        return new PersonalData(driver);
    }

    public void clearForm() {
        password.getWebElement(driver).clear();
        email.getWebElement(driver).clear();
        name.getWebElement(driver).clear();
    }

}
