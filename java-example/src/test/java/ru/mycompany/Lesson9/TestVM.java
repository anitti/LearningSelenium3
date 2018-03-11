package ru.mycompany.Lesson9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestVM {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://10.0.0.95:4444/wd/hub"), DesiredCapabilities.chrome()); //internetExplorer());
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    @Test
    public void test() {
        driver.get("http://seleniumhq.org/");
        System.out.println("test");
    }

}
