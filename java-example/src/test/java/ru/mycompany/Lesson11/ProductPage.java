package ru.mycompany.Lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ProductPage extends Page {

    public ProductPage(WebDriver driver,WebDriverWait wait) {
        super(driver, wait);
    }

   public boolean isOnThisPage() {
       return driver.findElements(By.xpath("//select[@name='options[Size]']")).size() != 0;
   }

   public void selectSize() {
       new Select(driver.findElements(By.name("options[Size]")).get(0)).selectByIndex(1);
   }

    public WebElement cart() {
        return driver.findElement(By.id("cart"));
    }

    public WebElement count(WebElement cart) {
        return cart.findElement(By.className("quantity"));
    }

   public void addToCart(WebElement count, Integer i) {
       driver.findElement(By.name("add_cart_product")).click();
       wait.until(textToBePresentInElement(count, i+1 + ""));
   }

   public void checkoutCart() {
       driver.findElement(By.xpath("//a[contains(text(), 'Checkout »')]")).click();
   }

}
