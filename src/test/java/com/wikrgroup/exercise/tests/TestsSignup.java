package com.wikrgroup.exercise.tests;

import com.wikrgroup.exercise.core.LetterParser;
import com.wikrgroup.exercise.core.User;
import com.wikrgroup.exercise.core.email.EmailApi;
import com.wikrgroup.exercise.core.email.TempMailOrg;
import com.wikrgroup.exercise.core.email.email_objects.EMail;
import com.wikrgroup.exercise.core.selenium.Browser;
import com.wikrgroup.exercise.core.selenium.BrowserFactory;
import com.wikrgroup.exercise.core.selenium.Browsers;
import com.wikrgroup.exercise.rozetka.page_objects.PersonalData;
import com.wikrgroup.exercise.rozetka.page_objects.Signup;
import org.awaitility.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.wikrgroup.exercise.core.Constants.*;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.awaitility.Awaitility.await;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class TestsSignup {

    private Browser browser = BrowserFactory.getBrowserInstance(Browsers.CHROME);

    @BeforeClass
    public void setUp() throws Exception {
        browser.open();
    }

    @Test(description = "test signup to rozetka")
    public void testSignup() {
        EmailApi tempMailOrg = new TempMailOrg();
        User user = new User().getRandom();

        WebDriver driver = browser.getWebDriver();
        Signup.openPage(driver).login(user);

        //wait emails
        await().pollInterval(Duration.TEN_SECONDS).atMost(WAIT_EMAIL_MIN, MINUTES)
                .until(() -> (tempMailOrg.containsEmailsFrom(user.getEmail(), ROZETKA_EMAIL, ROZETKA_CONFIRM_EMAIL_SUBJECT)));
        //get email
        EMail eMail = tempMailOrg.getEmailsFrom(user.getEmail(), ROZETKA_EMAIL, ROZETKA_CONFIRM_EMAIL_SUBJECT).get(0);
//        //delete email
//        tempMailOrg.deleteEmail(eMail.getMailId());
        //get confirm url
        String confirmUrl = new LetterParser().getConfirmUrl(eMail.getMailText());

        driver.get(confirmUrl);
        //validate
        PersonalData personalData = PersonalData.getPage(driver);
        Assert.assertEquals(personalData.getEmail(), user.getEmail(), "Incorrect email");
        Assert.assertEquals(personalData.getName(), user.getName(), "Incorrect name");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        browser.close();
    }

}
