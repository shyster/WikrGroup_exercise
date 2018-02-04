package com.wikrgroup.exercise.core.selenium;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.wikrgroup.exercise.core.Constants.PATH_TO_RESOURCES;

/**
 * Created by Vladislav Kulasov on 03.02.2018.
 */
public class Chrome implements Browser {
    private static final String OS_MODEL = System.getProperty("sun.arch.data.model");
    private WebDriver driver;

    @Override
    public void close() throws Exception {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    @Override
    public WebDriver getWebDriver() {
        if (null == driver) {
            throw new RuntimeException("need Open the browser before use getWebDriver");
        }

        return driver;
    }

    @Override
    public WebDriver open() {
        return open(new DesiredCapabilities());
    }

    @Override
    public WebDriver open(DesiredCapabilities capabilities) {
        if (driver != null) {
            return driver;
        }

        String chromeDriverPath;

        if (OS.isFamilyMac()) {
            chromeDriverPath = PATH_TO_RESOURCES + "/bin/mac/chromedriver";
        } else if (OS.isFamilyUnix()) {
            chromeDriverPath = PATH_TO_RESOURCES + "/bin/linux/" + OS_MODEL + "/chromedriver";
        } else if (OS.isFamilyWindows()) {
            chromeDriverPath = PATH_TO_RESOURCES + "/bin/win/chromedriver.exe";
        } else {
            throw new RuntimeException("bin of WebDriver not found");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        ChromeOptions options;
        options = (ChromeOptions) capabilities.getCapability(ChromeOptions.CAPABILITY);
        if (options == null) {
            options = new ChromeOptions();
        }

        options.addArguments("--start-maximized");
        options.addArguments("--always-authorize-plugins=true");
        options.addArguments("--browser.chrome.favicons=false");
        options.addArguments("--browser.chrome.site_icons=false");
        options.addArguments("--enable-save-password-bubble=false");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-webgl");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-ipv6");

//        options.addArguments("--user-agent=Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25");
        options.setExperimentalOption("prefs", chromePrefs);
        if (!OS.isFamilyMac()) {
            options.addArguments("--no-sandbox");
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        return driver;
    }
}
