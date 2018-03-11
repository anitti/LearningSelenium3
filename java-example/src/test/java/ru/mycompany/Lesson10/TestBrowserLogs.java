package ru.mycompany.Lesson10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mycompany.AdminHelper;

import java.util.List;

public class TestBrowserLogs extends AdminHelper {

    @Test
    public void testBrowserLogsOnProductPage() {
        loginToAdmin();
        openCatalog();
        driver.findElement(By.linkText("Rubber Ducks")).click();

        String locator_products = "(//input[contains(@name, 'products')]/../.. //a [1]) ";
        Integer count = driver.findElements(By.xpath(locator_products)).size();


        for (int i = 1; i <= count; i++) {
            WebElement product = driver.findElement(By.xpath(locator_products + "[" + i + "]"));
            product.click();
            System.out.println(getBrowserLogs().getAll().size());
            Assert.assertTrue(getBrowserLogs().getAll().size() == 0);

            openCatalog();
            driver.findElement(By.linkText("Rubber Ducks")).click();
        }

    }
}
