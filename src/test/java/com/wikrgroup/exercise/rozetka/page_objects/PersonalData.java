package com.wikrgroup.exercise.rozetka.page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.wikrgroup.exercise.core.Constants.MY_ROZETKA_URL;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class PersonalData extends MainPage {
    private static final String PERSONAL_DATA_URL = MY_ROZETKA_URL + "/profile/personal-information/";
    private Logger logger = Logger.getLogger(this.getClass());

    public static PersonalData openPage(WebDriver driver) {
        driver.get(PERSONAL_DATA_URL);
        return new PersonalData(driver);
    }

    Element personalInfo = element(By.id("personal_information"));
    Element panel = element(By.xpath("//div[@class='addit-f-i-indent']"));
    Element value = element(By.xpath("../descendant::div[@class='profile-info-l-i-text']"));

    Element nameLabel = element(panel, By.xpath("descendant::div[text()='Имя']"));
    Element name = element(nameLabel, value.getBy());

    Element emailLabel = element(panel, By.xpath("descendant::div[text()='Электронная почтa']"));
    Element email = element(emailLabel, value.getBy());

    public static PersonalData getPage(WebDriver driver) {
        return new PersonalData(driver);
    }

    public PersonalData(WebDriver driver) {
        super(driver);
        logger.info("wait Personal Data page");
        new WebDriverWait(driver, 120).until(
                ExpectedConditions.presenceOfElementLocated(personalInfo.getBy()));
    }

    public String getEmail() {
        String email = this.email.getWebElement().getText();
        logger.info("email: " + email);
        return email;
    }

    public String getName() {
        String name = this.name.getWebElement().getText();
        logger.info("name: " + name);
        return name;
    }

}
