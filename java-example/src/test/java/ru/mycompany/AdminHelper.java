package ru.mycompany;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminHelper extends TestBase {
    public void loginToAdmin() {
        String username="admin";
        String password="admin";

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    public void openCountriesIUrl() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    public void openZonesUrl() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }

    public List copyAndSortList(List<String> list) {
        List<String> copyForSort = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            copyForSort.add(list.get(i));
        }

        System.out.println(copyForSort.toString());
        Collections.sort(copyForSort);
        System.out.println(copyForSort.toString());

        return copyForSort;
    }
}
