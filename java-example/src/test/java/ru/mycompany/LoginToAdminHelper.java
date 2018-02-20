package ru.mycompany;

import org.openqa.selenium.By;

public class LoginToAdminHelper extends TestBase {
    public void loginToAdmin() {
        String username="admin";
        String password="admin";

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }
}
