package ru.mycompany.Lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mycompany.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Application extends TestBase {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;


    public Application(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        mainPage = new MainPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
    }

    public void quit() {
        driver.quit();
    }

    public void chooseProduct(Integer index) {
        mainPage.openUrlShop();
        mainPage.product().get(index).click();
    }

    public void addProductToCart(Integer i) {
        if (productPage.isOnThisPage()) {
            productPage.selectSize();
        }

        productPage.addToCart(productPage.count(productPage.cart()), i);
    }

    public void checkoutCart() {
        productPage.checkoutCart();
    }

    public void removeAll() {
        List<WebElement> btns=cartPage.btnRemove();

        for(int i=0;i<btns.size();i++) {
            WebElement table=cartPage.table();
            Integer rest=btns.size();
            System.out.println(rest);

            wait.until(visibilityOf(btns.get(0)));
            cartPage.btnRemove().get(0).click();

            driver.navigate().refresh();
            wait.until(stalenessOf(table));

            if (rest != 1) {
                wait.until(visibilityOfElementLocated(By.xpath("//table[contains(@class, 'dataTable')]")));
                btns=cartPage.btnRemove();
            }
        }
    }
}
