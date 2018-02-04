package com.wikrgroup.exercise.core.email;

import com.wikrgroup.exercise.core.email.email_objects.EMail;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.wikrgroup.exercise.core.Constants.MASHAPE_API_KEY;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class TempMailOrg implements EmailApi {
    private static final String API_URL = "https://privatix-temp-mail-v1.p.mashape.com/request";
    private static final String API_EMAIL_DOMAINS = API_URL + "/domains/format/json/";
    private static final String API_GET_EMAILS_TEMPLATE = API_URL + "/mail/id/%s/format/json/";
    private static final String API_DELETE_EMAIL_TEMPLATE = API_URL + "/delete/id/%s/format/json/";

    public List<String> getDomains() {
        return getAuthorization()
                .get(API_EMAIL_DOMAINS)
                .then()
                .assertThat().log().all()
                .statusCode(SC_OK)
                .extract().jsonPath().getList(".");
    }

    public List<EMail> getGetEmails(String emailBox) {
        String url = String.format(API_GET_EMAILS_TEMPLATE, DigestUtils.md5Hex(emailBox));
        try {
            return getAuthorization().log().all()
                    .get(url).prettyPeek()
                    .then()
                    .assertThat()
                    .statusCode(SC_OK)
                    .extract().jsonPath().getList(".", EMail.class);
        } catch (ClassCastException e) {
            return Collections.emptyList();
        }
    }

    public List<EMail> getEmailsFrom(String emailBox, String fromEmail) {
        return getGetEmails(emailBox).stream()
                .filter(e -> e.getMailFrom().contains(fromEmail))
                .collect(Collectors.toList());
    }

    public List<EMail> getEmailsFrom(String emailBox, String fromEmail, String subject) {
        return getGetEmails(emailBox).stream()
                .filter(e -> e.getMailFrom().contains(fromEmail) && e.getMailSubject().equals(subject))
                .collect(Collectors.toList());
    }

    public boolean containsEmailsFrom(String emailBox, String fromEmail) {
        return getEmailsFrom(emailBox, fromEmail).size() > 0;
    }

    public boolean containsEmailsFrom(String emailBox, String fromEmail, String subject) {
        return getEmailsFrom(emailBox, fromEmail, subject).size() > 0;
    }

    public void deleteEmail(String md5Letter) {
        String url = String.format(API_DELETE_EMAIL_TEMPLATE, md5Letter);
        getAuthorization().log().all()
                .get(url).prettyPeek()
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body("result", is("success"));
    }

    private RequestSpecification getAuthorization() {
        return given().header(new Header("X-Mashape-Key", MASHAPE_API_KEY))
                .header(new Header("Accept", "application/json"));
    }
}
