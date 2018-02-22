package ru.mycompany.Lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mycompany.ShopMainHelper;

import java.util.ArrayList;
import java.util.List;

public class TestCheckStickerOnProduct extends ShopMainHelper
{
    @Test
    public void checkStickerOnProduct() {
        openUrlShop();

        List<String> sections = new ArrayList<>();
        sections.add("//div [contains(@id, 'box-most-popular')]");
        sections.add("//div [contains(@id, 'box-campaigns')]");
        sections.add("//div [contains(@id, 'box-latest-products')]");

        for (int k = 0; k < sections.size(); k++) {
            String locator_products=".//li [contains(@class, 'link')]";
            WebElement section = driver.findElement(By.xpath(sections.get(k)));
            Integer count= section.findElements(By.xpath(locator_products)).size();
            System.out.println("Кол-во уток в секции - count = " + count);

            for (int i = 1; i <= count; i++) {
                WebElement product=section.findElement(By.xpath(locator_products + "[" + i + "]"));

                String locator_sticker=".//div [contains(@class, 'sticker')]";
                System.out.println("Кол-во стикеров у товара = " + product.findElements(By.xpath(locator_sticker)).size());
                Assert.assertTrue(product.findElements(By.xpath(locator_sticker)).size() == 1);
            }
        }
    }
}

