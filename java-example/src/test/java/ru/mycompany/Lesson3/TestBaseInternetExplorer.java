package ru.mycompany.Lesson3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBaseInternetExplorer {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        driver=new InternetExplorerDriver();
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void stop() {
        driver.quit();
        driver=null;
    }
}
