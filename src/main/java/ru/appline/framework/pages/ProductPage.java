package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.products.Products;

import java.util.HashMap;
import java.util.Map;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[text()=\"Сравнить\"]")
    private WebElement frameProduct;
    @FindBy(xpath = "//div[@class=\"additional-sales-tabs__title\" and text() =\"Гарантия: 12 мес.\"]")
    private WebElement warranty;
    @FindBy(xpath = "//div[contains(@class,\"product-buy__price\") and text()]")
    private WebElement price;

    @FindBy(xpath = "//span[text() =\"Доп. гарантия\"]")
    private WebElement additionalWarranty;
    @FindBy(xpath = "//button[contains(@class, \"button-ui buy-btn button\")]")
    private WebElement buy;
    @FindBy(xpath = "//span[@class=\"buttons__link-price cart-link-counter__price\"]")
    private WebElement cart;


    public ProductPage checkOpenPage(){
        Assert.assertEquals("Не удалось откыть страницу товара", frameProduct.getText().trim(), "Сравнить");
        return this;
    }
    public ProductPage getPrice(String product) {
        waitUtilElementToBeVisible(price);
        if (product.equals("iphone")) {
            Products.getProducts().setPriceIphone(ToInt(price.getText()));
            return this;
        }
        else if (product.equals("airpods")){
            Products.getProducts().setPriceAirpods(ToInt(price.getText()));
            return this;
        }
        return this;
    }
    public ProductPage getWarranty(){
        waitUtilElementToBeClickable(warranty);
        warranty.click();
        waitUtilElementToBeClickable(additionalWarranty);
        additionalWarranty.click();
        waitUtilElementToBeVisible(price.findElement(By.xpath
                ("./../div[@class=\"product-buy__price product-buy__price_active\"]")));
        Products.getProducts().setWarrantyIphone(ToInt(additionalWarranty.findElement(By.xpath
                (".//../span[contains(@class, \"price\")]")).getText()));
        return this;
    }

    public HomePage buy() {
        buy.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pageManager.getHomePage();
    }
    public ProductPage CheckPriceOfCart(){
        int sum = Products.getProducts().getPriceIphone() + Products.getProducts().getPriceAirpods() + Products.getProducts().getWarrantyIphone();
        Products.getProducts().setSum(sum);
        Assert.assertEquals("сумма продуктов не равна значению карзины", sum, ToInt(cart.getText()));
        return this;
    }

    public BasketPage goToBasketPage() {
        return pageManager.getBasketPage();
    }

    public BasketPage goToCart() {
        cart.click();
        return pageManager.getBasketPage();
    }
}
