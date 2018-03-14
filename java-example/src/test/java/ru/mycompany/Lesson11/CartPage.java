package ru.mycompany.Lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CartPage extends Page {

    public CartPage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> btnRemove() {
        return driver.findElements(By.xpath("//li[@class = 'item']//*[@name = 'remove_cart_item']"));
    }

    public WebElement table() {
        return driver.findElement(By.xpath("//table[contains(@class, 'dataTable')]"));
    }
}
