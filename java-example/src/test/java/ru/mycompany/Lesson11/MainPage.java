package ru.mycompany.Lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage openUrlShop() {
        driver.get("http://localhost/litecart/en/");
        return this;
    }

    public WebElement section() {
        return driver.findElement(By.xpath("//div [contains(@id, 'box-most-popular')]//*[@class='content']"));
    }

    public List<WebElement> product() {
        return section().findElements(By.xpath(".//li"));
    }
}
