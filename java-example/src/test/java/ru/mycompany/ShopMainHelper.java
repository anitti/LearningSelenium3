package ru.mycompany;

import ru.mycompany.Lesson3.TestBaseChrome;
import ru.mycompany.Lesson3.TestBaseFirefox;
import ru.mycompany.Lesson3.TestBaseFirefoxESR;
import ru.mycompany.Lesson3.TestBaseInternetExplorer;

public class ShopMainHelper extends TestBase { //Меняем наследование от нужного класса для вызова другого браузера

    public void openUrlShop() {
        driver.get("http://localhost/litecart/en/");
    }
}
