package ru.mycompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistraionInShopHelper extends TestBase {
    private WebElement registration_link;
    private WebElement first_name;
    private WebElement last_name;
    private WebElement address1;
    private WebElement postcode;
    private WebElement city;
    private WebElement country;
    private WebElement zone;
    private WebElement email;
    private WebElement phone;
    private WebElement desired_password;
    private WebElement confirm_password;
    private WebElement create_account;
    WebDriver driver;

    public RegistraionInShopHelper(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public WebElement getRegistration_link() {
        registration_link = driver.findElement(By.linkText("New customers click here"));
        return registration_link;
    }

    public WebElement getFirst_name() {
        first_name = driver.findElement(By.name("firstname"));
        return first_name;
    }

    public WebElement getLast_name() {
        last_name = driver.findElement(By.name("lastname"));
        return last_name;
    }

    public WebElement getAddress1() {
        address1 = driver.findElement(By.name("address1"));
        return address1;
    }

    public WebElement getPostcode() {
        postcode = driver.findElement(By.name("postcode"));
        return postcode;
    }

    public WebElement getCity() {
        city = driver.findElement(By.name("city"));
        return city;
    }

    public WebElement getCountry() {
        country = driver.findElement(By.cssSelector("select[name = country_code]"));
        return country;
    }

    public WebElement getZone() {
        zone = driver.findElement(By.cssSelector("select[name = zone_code]"));
        return zone;
    }

    public WebElement getEmail() {
        email = driver.findElement(By.name("email"));
        return email;
    }

    public WebElement getPhone() {
        phone = driver.findElement(By.name("phone"));
        return phone;
    }

    public WebElement getDesired_password() {
        desired_password = driver.findElement(By.name("password"));
        return desired_password;
    }

    public WebElement getConfirm_password() {
        confirm_password = driver.findElement(By.name("confirmed_password"));
        return confirm_password;
    }

    public WebElement getCreate_account() {
        create_account = driver.findElement(By.name("create_account"));
        return create_account;
    }

    public void registrationCustomer(CustomerHelper customer) {
        this.getRegistration_link().click();
        this.getFirst_name().sendKeys(customer.first_name);
        this.getLast_name().sendKeys(customer.last_name);
        this.getAddress1().sendKeys(customer.address1);
        this.getPostcode().sendKeys(customer.postcode);
        this.getCity().sendKeys(customer.city);
        new Select(this.getCountry()).selectByVisibleText(customer.country);
        List<WebElement> zones = new Select(this.getZone()).getOptions();
        new Select(this.getZone()).selectByVisibleText(zones.get(customer.zone).getText());
        this.getEmail().sendKeys(customer.email);
        this.getPhone().sendKeys(customer.phone);
        this.getDesired_password().sendKeys(customer.password);
        this.getConfirm_password().sendKeys(customer.password);
        this.getCreate_account().click();
        }

    public void logoutCustomer() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public void loginCustomer(CustomerHelper customer) {
        driver.findElement(By.name("email")).sendKeys(customer.email);
        driver.findElement(By.name("password")).sendKeys(customer.password);
        driver.findElement(By.name("login")).click();
    }
}
