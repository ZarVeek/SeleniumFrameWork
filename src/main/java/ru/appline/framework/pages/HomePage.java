package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Arkadiy_Alaverdyan
 * Стартовая страница приложения
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, \"presearch__input\")]")
    private WebElement search;

    @FindBy(xpath = "//span[@class=\"presearch__icon-search\"]")
    private WebElement searchClick;

    public HomePage selectSearch() {
        try {
            search.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Меню поиска не было найдено на стартовой странице!");
        }
        return this;
    }
    public HomePage search(String product) {
        search.sendKeys(product);
        return this;
    }

    public SearchPage clickSearch() {
        try {
            searchClick.click();
        }catch (NoSuchElementException e){
            Assert.fail("Кнопка поиска не была найдена на стартовой странице!");
        }
        return pageManager.getSearchPage();
    }
    public ProductPage goToProductPage() {
        return pageManager.getProductPage();
    }
}
