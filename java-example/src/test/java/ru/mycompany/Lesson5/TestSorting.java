package ru.mycompany.Lesson5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mycompany.AdminHelper;

import java.util.ArrayList;
import java.util.List;

public class TestSorting extends AdminHelper {

    @Test
    public void testSortingCountries() {
        loginToAdmin();
        openCountriesIUrl();

        WebElement table= driver.findElement(By.name("countries_form"));
        List<WebElement> rows = table.findElements(By.className("row"));
        ArrayList<String> countries = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            String country = cells.get(4).getText();
            countries.add(country);
        }

        System.out.println(countries);

        List<String> copyForSort = copyAndSortList(countries);
        Assert.assertArrayEquals(countries.toArray(), copyForSort.toArray());

    }

    @Test
    public void TestSortingZonFromCountries() {
        loginToAdmin();
        openCountriesIUrl();

        WebElement table= driver.findElement(By.name("countries_form"));
        List<WebElement> rows = table.findElements(By.className("row"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
            String count_zones = cells.get(5).getText();
            System.out.println("count_zones = " + count_zones + " для страны " + cells.get(4).getText() + " с индексом " + i);

            if (!count_zones.equals("0")) {
                cells.get(4).findElement(By.tagName("a")).click();

                WebElement table_zones = driver.findElement(By.id("table-zones"));
                List<WebElement> rows_zones = table_zones.findElements(By.tagName("tr"));
                ArrayList<String> zones = new ArrayList<>();

                for (int j = 1; j < rows_zones.size()-1; j++) {
                    List<WebElement> cells_zones = rows_zones.get(j).findElements(By.tagName("td"));
                    String zone = cells_zones.get(2).getText();
                    zones.add(zone);
                }

                System.out.println(zones);

                List<String> copyForSort = copyAndSortList(zones);

                Assert.assertArrayEquals(zones.toArray(), copyForSort.toArray());

                openCountriesIUrl();
                table= driver.findElement(By.name("countries_form"));
                rows = table.findElements(By.className("row"));
            }
        }
    }

    @Test
    public void TestSortingCountriesFromZone() {
        loginToAdmin();
        openZonesUrl();

        WebElement table= driver.findElement(By.name("geo_zones_form"));
        List<WebElement> rows = table.findElements(By.className("row"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            cells.get(2).findElement(By.tagName("a")).click();

            WebElement table_edit = driver.findElement(By.id("table-zones"));
            List<WebElement> rows_edit = table_edit.findElements(By.tagName("tr"));
            ArrayList<String> zones = new ArrayList<>();

            for(int j = 1; j < rows_edit.size()-1; j++) {
                List<WebElement> cells_zones = rows_edit.get(j).findElements(By.tagName("td"));

                String text = cells_zones.get(2).findElement(By.cssSelector("[selected = selected]")).getText();
                zones.add(text);
            }

            System.out.println(zones);

            List<String> copyForSort = copyAndSortList(zones);

            Assert.assertArrayEquals(zones.toArray(),copyForSort.toArray());

            openZonesUrl();

            table= driver.findElement(By.name("geo_zones_form"));
            rows = table.findElements(By.className("row"));
        }
    }
}
