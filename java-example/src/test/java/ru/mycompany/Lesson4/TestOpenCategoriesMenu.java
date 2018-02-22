package ru.mycompany.Lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.mycompany.AdminHelper;

public class TestOpenCategoriesMenu extends AdminHelper {

    @Test
    public void clickCategoriesMenu() {
        loginToAdmin();
        String locator_cat = "li#app-";
        Integer count_cat = driver.findElements(By.cssSelector(locator_cat)).size();

        for (int i = 1; i <= count_cat; i++) {
            driver.findElement(By.cssSelector(locator_cat + ":nth-of-type(" + i + ")")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());

            String locator_subcat = "li [id ^= doc]";
            Integer count_subcat = driver.findElements(By.cssSelector(locator_subcat)).size();

            if (count_subcat > 0) {
                for (int j=1; j <= count_subcat; j++) {
                    driver.findElement(By.cssSelector(locator_subcat + ":nth-of-type(" + j + ")")).click();
                    Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
                }
            }
        }
    }
}


