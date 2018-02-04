package com.wikrgroup.exercise.core.selenium;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public enum Browsers {
    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("MicrosoftEdge"),
    IE("internet explorer"),
    SAFARI("safari"),
    PHANTOMJS("phantomjs"),
    HTMLUNIT("htmlunit");

    private final String name;

    Browsers(String name) {
        this.name = name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    public static Browsers getByName(String name) {
        if (name != null) {
            for (Browsers b : Browsers.values()) {
                if (name.equalsIgnoreCase(b.name)) {
                    return b;
                }
            }
        }
        return null;
    }

}
