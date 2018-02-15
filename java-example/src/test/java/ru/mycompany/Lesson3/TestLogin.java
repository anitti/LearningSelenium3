package ru.mycompany.Lesson3;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestLogin extends TestBaseInternetExplorer { //TestBaseFirefox, TestBaseChrome

    @Test
    public void loginToAdmin() {
        String username="admin";
        String password="admin";

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

    }
}
