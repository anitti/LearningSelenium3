package ru.mycompany.Lesson8;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mycompany.AdminHelper;

import java.util.List;
import java.util.Set;

public class TestEditCountry extends AdminHelper {

    @Test
    public void testCheckLinks() {
        loginToAdmin();
        openCountriesIUrl();
        driver.findElement(By.xpath("//a [@class = 'button'] [text() = ' Add New Country']")).click();

        String locator_links = "//a //i[@class='fa fa-external-link']";
        List<WebElement> links = driver.findElements(By.xpath(locator_links));

        for (int i = 0; i < links.size(); i++) {
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();

            links.get(i).click();

            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }
}
