package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Arkadiy_Alaverdyan
 * Класс описывающий страничку страхование путешественников
 */
public class SearchPage extends BasePage {

    @FindBy(xpath = "//h1[text ()= \"Найдено:\"]")
    private WebElement title;


    @FindBy(xpath = "//div[@class=\"catalog-product__image\"]")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@class=\"catalog-product__code\"]")
    private WebElement codeElement;

    public SearchPage checkOpenSearchPage() {
        Assert.assertEquals("Заголовок отсутствует/не соответствует требуемому",
                "Найдено:", title.getText());
        return this;
    }


    public ProductPage findByCatalogProductCode(String code) {
        for (WebElement product :listOfProducts) {
            action.moveToElement(product).perform();
            waitUtilElementToBeVisible(codeElement);
            if (codeElement.getText().equals(code)){
                product.findElement(By.xpath(".//../a/span")).click();
                return pageManager.getProductPage();
            }
        }
        Assert.fail("Не удалось найти по введенному коду");
        return pageManager.getProductPage();
    }
    public ProductPage goToProduct() {
        return pageManager.getProductPage();
    }

}
