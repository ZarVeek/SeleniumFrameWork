package ru.appline.framework.managers;

import ru.appline.framework.pages.*;
import ru.appline.framework.products.*;
import ru.appline.framework.products.Products;


public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }
}
