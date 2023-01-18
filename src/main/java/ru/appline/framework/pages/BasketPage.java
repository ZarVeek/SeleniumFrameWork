package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.products.Products;

import java.util.List;

public class BasketPage extends BasePage{
    @FindBy(xpath = "//span[@class=\"price__current\"]")
    List<WebElement> listPrices;
    @FindBy(xpath = "//i[@class=\"count-buttons__icon count-buttons__icon-minus\"]")
    List<WebElement> listMinuses;
    @FindBy(xpath = "//i[@class=\"count-buttons__icon count-buttons__icon-plus\"]")
    List<WebElement> listPlus;

    @FindBy(xpath = "//span[@class=\"buttons__link-price cart-link-counter__price\"]")
    WebElement cart;
    @FindBy(xpath = "//span[@class=\"restore-last-removed\"]")
    List<WebElement> removed;

    public BasketPage ckeckProducts() {
        Assert.assertEquals("неправильная цена", ToInt(listPrices.get(0).getText()), Products.getProducts().getPriceIphone());
        Assert.assertEquals("неправильная цена", ToInt(listPrices.get(1).getText()), Products.getProducts().getPriceAirpods());
        Assert.assertEquals("неправильная цена", ToInt(listPrices.get(2).getText()), Products.getProducts().getSum());
        return this;
    }
    public BasketPage deleteAirpods(){
        listMinuses.get(1).click();
        return this;
    }

    public BasketPage ckeckDeletedAirPods() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("не удалился", Products.getProducts().getSum()-Products.getProducts().getPriceAirpods(), ToInt(cart.getText()));
        return this;
    }
    public BasketPage addIphone(){
        waitUtilElementToBeClickable(listPlus.get(0));
        listPlus.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        listPlus.get(0).click();
        return this;
    }

    public BasketPage ckeckSum() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int sum = (Products.getProducts().getPriceIphone()+Products.getProducts().getWarrantyIphone())*3;
        Assert.assertEquals("сумма не равна 3 айфонам", ToInt(cart.getText()), sum);
        return this;
    }

    public BasketPage restoreRemoved() {
        removed.get(1).click();
        return this;
    }

    public void ckeckSumIsMoreByAirpods() {
        int sum = (Products.getProducts().getPriceIphone()+Products.getProducts().getWarrantyIphone())*3+Products.getProducts().getPriceAirpods();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("airpods не вернулись", sum, ToInt(cart.getText()));
    }
}
