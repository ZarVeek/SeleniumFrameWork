package ru.appline.framework.tests;

import org.junit.Test;
import ru.appline.framework.basetestsclass.BaseTests;


public class FirstTest extends BaseTests {

    @Test
    public void startTest() {
        app.getHomePage()
                .selectSearch()
                .search("iphone")
                .clickSearch()
                .checkOpenSearchPage()
                .findByCatalogProductCode("5072935")
                .checkOpenPage()
                .getPrice("iphone")
                .getWarranty()
                .buy()
                .selectSearch()
                .search("Apple AirPods Pro 2")
                .clickSearch()
                .goToProduct()
                .getPrice("airpods")
                .buy()
                .goToProductPage()
                .CheckPriceOfCart()
                .goToCart()
                .ckeckProducts()
                .deleteAirpods()
                .ckeckDeletedAirPods()
                .addIphone()
                .ckeckSum()
                .restoreRemoved()
                .ckeckSumIsMoreByAirpods();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


