package ru.mycompany.Lesson7;

import org.junit.Test;
import ru.mycompany.CustomerHelper;
import ru.mycompany.RegistraionInShopHelper;
import ru.mycompany.ShopMainHelper;

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
