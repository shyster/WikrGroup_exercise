package com.wikrgroup.exercise.core.email;

import com.wikrgroup.exercise.core.email.email_objects.EMail;

import java.util.List;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public interface EmailApi {

    List<String> getDomains();
    List<EMail> getGetEmails(String emailBox);
    List<EMail> getEmailsFrom(String emailBox, String fromEmail);
    List<EMail> getEmailsFrom(String emailBox, String fromEmail, String subject);
    boolean containsEmailsFrom(String emailBox, String fromEmail);
    boolean containsEmailsFrom(String emailBox, String fromEmail, String subject);
    void deleteEmail(String md5Letter);
}
