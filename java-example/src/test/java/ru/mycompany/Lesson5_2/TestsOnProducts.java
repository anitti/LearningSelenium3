package ru.mycompany.Lesson5_2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mycompany.Products;
import ru.mycompany.ShopMainHelper;

public class TestsOnProducts extends ShopMainHelper {

    @Test
    public void checkProductDetails() {
        openUrlShop();

        WebElement section = driver.findElement(By.xpath("//div [contains(@id, 'box-campaigns')]//*[@class='content']"));
        WebElement product = section.findElement(By.xpath(".//li"));

        Products duck1 = new Products();
        WebElement price = product.findElement(By.xpath("//*[@class='regular-price']"));
        WebElement price_sale = product.findElement(By.xpath("//*[@class='campaign-price']"));

        duck1.name = product.findElement(By.xpath(".//*[@class='name']")).getAttribute("textContent");
        duck1.price = price.getAttribute("textContent");
        duck1.price_sale = price_sale.getAttribute("textContent");
        duck1.color_price = price.getCssValue("color").replaceAll("[rgba()]", "").split(", ");
        duck1.display_price = price.getCssValue("text-decoration");
        duck1.color_price_sale = price_sale.getCssValue("color").replaceAll("[rgba()]", "")
                .split(", ");
        duck1.display_price_sale = Integer.valueOf(price_sale.getCssValue("font-weight"));
        duck1.price_size = Float.valueOf(price.getCssValue("font-size").split("p")[0]);
        duck1.price_sale_size = Float.valueOf(price_sale.getCssValue("font-size").split("p")[0]);

        duck1.checkDetailProductOnOnePage(duck1);

        product.click();

        WebElement product_2 = driver.findElement(By.xpath("//*[@id='box-product']"));

        Products duck2 = new Products();
        WebElement price_2 = product_2.findElement(By.xpath("//*[@class='regular-price']"));
        WebElement price_sale_2 = product_2.findElement(By.xpath("//*[@class='campaign-price']"));

        duck2.name = product_2.findElement(By.xpath("//h1[@class='title']")).getAttribute("textContent");
        duck2.price = price_2.getAttribute("textContent");
        duck2.price_sale = price_sale_2.getAttribute("textContent");
        duck2.color_price = price_2.getCssValue("color").replaceAll("[rgba()]", "").split(", ");
        duck2.display_price = price_2.getCssValue("text-decoration");
        duck2.color_price_sale = price_sale_2.getCssValue("color").replaceAll("[rgba()]", "")
                .split(", ");
        duck2.display_price_sale = Integer.valueOf(price_sale_2.getCssValue("font-weight"));
        duck2.price_size = Float.valueOf(price_2.getCssValue("font-size").split("p")[0]);
        duck2.price_sale_size = Float.valueOf(price_sale_2.getCssValue("font-size").split("p")[0]);

        duck2.checkDetailProductOnOnePage(duck2);

        Assert.assertEquals(duck1.name, duck2.name);
        Assert.assertEquals(duck1.price, duck2.price);
        Assert.assertEquals(duck1.price_sale, duck2.price_sale);
    }
}
