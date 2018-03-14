package ru.mycompany.Lesson11;

import org.junit.Test;
import ru.mycompany.TestBase;

public class TestWorkWithCart2 extends TestBase {

    @Test
    public void testAddAndRemoveProductsFromCart2() {
        Application app = new Application(driver, wait);

        for (int i = 0; i < 3; i++) {
            app.chooseProduct(i);
            app.addProductToCart(i);
        }

        app.checkoutCart();
        app.removeAll();
    }
}
