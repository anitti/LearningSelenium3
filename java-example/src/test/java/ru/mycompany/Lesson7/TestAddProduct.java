package ru.mycompany.Lesson7;

import org.junit.Test;
import ru.mycompany.AdminHelper;
import ru.mycompany.ProductsAdminHelper;
import ru.mycompany.ProductsInfoHelper;

import static ru.mycompany.ProductsInfoHelper.initProductInfo;


public class TestAddProduct extends AdminHelper {

    @Test
    public void testAddProduct() {
        ProductsAdminHelper productObject = new ProductsAdminHelper(driver);
        ProductsInfoHelper product = new ProductsInfoHelper();

        loginToAdmin();
        openCatalog();

        initProductInfo(product);
        productObject.addNewProduct(product);
    }
}
