package ru.appline.framework.products;

import lombok.Data;
import ru.appline.framework.pages.SearchPage;

@Data
public class Products {
    private static Products products;
    private Products() {
    }
    public static Products getProducts() {
        if (products == null) {
            products = new Products();
        }
        return products;
    }
    private int priceIphone;
    private int priceAirpods;
    private int WarrantyIphone;
    private int Sum;
}
