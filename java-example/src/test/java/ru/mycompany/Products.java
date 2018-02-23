package ru.mycompany;

import org.junit.Assert;

public class Products {
    public String name;
    public String price;
    public String price_sale;
    public String[] color_price;
    public String display_price;
    public String[] color_price_sale;
    public Integer display_price_sale;
    public Float price_size;
    public Float price_sale_size;

    public void checkDetailProductOnOnePage(Products duck) {
        Assert.assertEquals(duck.color_price[0], duck.color_price[1]);
        Assert.assertEquals(duck.color_price[1], duck.color_price[2]);

        Assert.assertTrue(duck.display_price.contains("line-through"));

        Assert.assertEquals(duck.color_price_sale[1], "0");
        Assert.assertEquals(duck.color_price_sale[2], "0");

        Assert.assertTrue(duck.display_price_sale > 400);
        Assert.assertTrue(duck.price_size < duck.price_sale_size);
    }
}
