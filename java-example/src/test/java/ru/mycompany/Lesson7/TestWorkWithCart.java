package ru.mycompany.Lesson7;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.mycompany.ShopMainHelper;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestWorkWithCart extends ShopMainHelper {

    @Test
    public void testAddAndRemoveProductsFromCart() {

        for (int i = 0; i < 3; i++) {
            openUrlShop();
            WebElement section=driver.findElement(By.xpath("//div [contains(@id, 'box-most-popular')]//*[@class='content']"));
            List<WebElement> product=section.findElements(By.xpath(".//li"));

            product.get(i).click();

            if (driver.findElements(By.xpath("//select[@name='options[Size]']")).size() != 0) {
                new Select(driver.findElements(By.name("options[Size]")).get(0)).selectByIndex(1);
            }

            driver.findElement(By.name("add_cart_product")).click();

            WebElement cart = driver.findElement(By.id("cart"));
            WebElement count = cart.findElement(By.className("quantity"));

            wait.until(textToBePresentInElement(count, i+1 + ""));
        }

        driver.findElement(By.xpath("//a[contains(text(), 'Checkout »')]")).click();
        List<WebElement> btnRemove = driver.findElements(By.xpath("//li[@class = 'item']//*[@name = 'remove_cart_item']"));

        for (int i = 0; i < btnRemove.size(); i++) {
            WebElement table = driver.findElement(By.xpath("//table[contains(@class, 'dataTable')]"));
            Integer rest = btnRemove.size();

            wait.until(visibilityOf(btnRemove.get(0)));
            btnRemove.get(0).click();

            driver.navigate().refresh();
            wait.until(stalenessOf(table));

            if (rest != 1) {
                wait.until(visibilityOfElementLocated(By.xpath("//table[contains(@class, 'dataTable')]")));
                btnRemove = driver.findElements(By.xpath("//li[@class = 'item']//*[@name = 'remove_cart_item']"));
            }
        }
    }
}
