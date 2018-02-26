package ru.mycompany.Lesson7;

import org.junit.Test;
import ru.mycompany.CustomerHelper;
import ru.mycompany.RegistraionInShopHelper;
import ru.mycompany.ShopMainHelper;

import static ru.mycompany.RandomizeHelper.getRandomString;

public class TestRegistarionInShop extends ShopMainHelper{

    @Test
    public void testRegistrationInShop() {
        openUrlShop();

        RegistraionInShopHelper reg = new RegistraionInShopHelper(driver);
        CustomerHelper customer = new CustomerHelper();
        customer.initCustomer();

        reg.registrationCustomer(customer);
        reg.logoutCustomer();
        reg.loginCustomer(customer);
    }
}
