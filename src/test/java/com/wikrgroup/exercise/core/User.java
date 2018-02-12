package com.wikrgroup.exercise.core;

import com.mifmif.common.regex.Generex;
import com.wikrgroup.exercise.core.email.TempMailOrg;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public class User {
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User getRandom() {
        name = getRandomUserName();
        email = name + new TempMailOrg().getDomains().get(0);
        password = getRandomUserPassword();
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String getRandomUserName() {
        return new Generex("[a-z0-9]{6}").random();
    }

    private String getRandomUserPassword() {
        return new Generex("[A-Z]{6}[0-9]{2}").random();
    }

    @Override
    public String toString() {
        return String.format("Name:%s; Email:%s; Password:%s", name, email, password);
    }
}
