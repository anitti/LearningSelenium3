package ru.mycompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsAdminHelper {
    private WebDriver driver;
    private WebElement btnAdd;
    private WebElement status;
    private WebElement name;
    private WebElement code;
    private WebElement categories;
    private WebElement gender;
    private WebElement quantity;
    private WebElement chooseFile;
    private WebElement dateFrom;
    private WebElement dateTo;
    private WebElement manufacturer;
    private WebElement description;
    private WebElement headTitle;
    private WebElement purchasePrice;
    private WebElement currency;
    private WebElement priceUSD;
    private WebElement priceEUR;
    private WebElement btnSave;

    public ProductsAdminHelper(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public WebElement get_btnAdd() {
        btnAdd = driver.findElement(By.xpath("//a[text() = ' Add New Product']"));
        return btnAdd;
    }

    public WebElement getStatus(String productStatus) {
        status = driver.findElement(By.xpath("//td[strong = 'Status']//label[text() = '" + productStatus + "']"));
        return status;
    }

    public WebElement getName() {
        name = driver.findElement(By.name("name[en]"));
        return name;
    }

    public WebElement getCode() {
        code = driver.findElement(By.name("code"));
        return code;
    }

    public WebElement getCategories(String productCategory) {
        categories = driver.findElement(By.xpath("//*[@type = 'checkbox'][@data-name = '" + productCategory + "']"));
        return categories;
    }

    public WebElement getGender(String productGender) {
        gender = driver.findElement(By.xpath("//td[contains(text(), '" + productGender + "')]/..//*[@type = 'checkbox']"));
        return gender;
    }

    public WebElement getQuantity() {
        quantity = driver.findElement(By.name("quantity"));
        return quantity;
    }

    public WebElement getChooseFile() {
        chooseFile = driver.findElement(By.name("new_images[]"));
        return chooseFile;
    }

    public WebElement getDateFrom() {
        dateFrom = driver.findElement(By.name("date_valid_from"));
        return dateFrom;
    }

    public WebElement getDateTo() {
        dateTo = driver.findElement(By.name("date_valid_to"));
        return dateTo;
    }

    public WebElement getManufacturer() {
        manufacturer = driver.findElement(By.name("manufacturer_id"));
        return manufacturer;
    }

    public WebElement getDescription() {
        description = driver.findElement(By.xpath("//*[@name = 'description[en]']"));
        return description;
    }

    public WebElement getHeadTitle() {
        headTitle = driver.findElement(By.name("head_title[en]"));
        return headTitle;
    }

    public WebElement getPurchasePrice() {
        purchasePrice = driver.findElement(By.name("purchase_price"));
        return purchasePrice;
    }

    public WebElement getCurrency() {
        currency = driver.findElement(By.name("purchase_price_currency_code"));
        return currency;
    }

    public WebElement getPriceUSD() {
        priceUSD = driver.findElement(By.name("prices[USD]"));
        return priceUSD;
    }

    public WebElement getPriceEUR() {
        priceEUR = driver.findElement(By.name("prices[EUR]"));
        return priceEUR;
    }

    public WebElement getBtnSave() {
        btnSave = driver.findElement(By.name("save"));
        return btnSave;
    }

    public void addNewProduct(ProductsInfoHelper product) {
        this.get_btnAdd().click();
        this.getStatus(product.status).click();
        this.getName().sendKeys(product.name);
        this.getCode().sendKeys(product.code);
        this.getCategories(product.categories).click();
        this.getGender(product.gender).click();
        this.getQuantity().sendKeys(product.quantity);
        this.getChooseFile().sendKeys(product.chooseFile);

        this.getDateFrom().sendKeys(product.dateFrom);
        this.getDateTo().sendKeys(product.dateTo);

        driver.findElement(By.linkText("Information")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("manufacturer_id")));

        new Select(this.getManufacturer()).selectByVisibleText(product.manufacturer);
        this.getDescription().sendKeys(product.description);
        this.getHeadTitle().sendKeys(product.headTitle);

        driver.findElement(By.linkText("Prices")).click();
        this.getPurchasePrice().sendKeys(product.purchasePrice);
        new Select(this.getCurrency()).selectByVisibleText(product.currency);
        this.getPriceUSD().sendKeys(product.priceUSD);
        this.getPriceEUR().sendKeys(product.priceEUR);

        this.getBtnSave().click();
    }

}
