package ru.mycompany;

import org.openqa.selenium.WebElement;

import java.io.File;

import static ru.mycompany.RandomizeHelper.*;
import static ru.mycompany.RandomizeHelper.getRandomString;
import static ru.mycompany.RandomizeHelper.getRandomStringInt;

public class ProductsInfoHelper {
    public String status;
    public String name;
    public String code;
    public String categories;
    public String gender;
    public String quantity;
    public String chooseFile;
    public String dateFrom;
    public String dateTo;
    public String manufacturer;
    public String description;
    public String headTitle;
    public String purchasePrice;
    public String currency;
    public String priceUSD;
    public String priceEUR;

    public static void initProductInfo(ProductsInfoHelper product) {
        File file = new File("resources/duck.jpg");
        String absolutePath = file.getAbsolutePath();

        product.status = getRandomElementFromArray(new String[] {" Enabled", " Disabled"});
        product.name = getRandomString(5);
        product.code = getRandomStringInt(4);
        product.categories = "Rubber Ducks";
        product.gender = getRandomElementFromArray(new String[] {"Female", "Male", "Unisex"});
        product.quantity = getRandomStringInt(1);
        product.chooseFile = absolutePath;
        product.dateFrom = "1" + getRandomStringInt(1) + "012018";
        product.dateTo = "1" + getRandomStringInt(1) + "122018";

        product.manufacturer = "ACME Corp.";
        product.description = getRandomString(10);
        product.headTitle = getRandomString(5);

        product.purchasePrice = getRandomStringInt(2);
        product.currency = getRandomElementFromArray(new String[] {"US Dollars", "Euros"});
        product.priceUSD = getRandomStringInt(1);
        product.priceEUR = getRandomStringInt(1);
    }
}
