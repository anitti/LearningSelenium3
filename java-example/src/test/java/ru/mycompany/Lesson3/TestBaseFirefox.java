package ru.mycompany.Lesson3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseFirefox {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions().setLegacy(false);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
