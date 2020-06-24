package constants;

import org.openqa.selenium.By;

public class SearchResultPageConstants {

    private SearchResultPageConstants() { }

    // == String ==
    public static final String STR_SEARCH_RESULT_PANEL = "changeView";
    public static final String STR_SORTING_SELECTOR = "sortOptions1";
    public static final String STR_PRODUCTS = "//*[@id='mainProductGrid']/li";
    public static final String STR_CHEAPEST_PRODUCT = STR_PRODUCTS + "[1]";
    public static final String STR_PRICE = "//*[@class='number']";
    public static final String STR_ADD_PRODUCT = "//button[contains(@class, 'js-add-to-cart')]";
    public static final String STR_CART_CONTAINER = "//*[@id='cartMiddleContent']";
    public static final String STR_CART_SINGLE_PRODUCT = "//*[contains(@class, 'miglog-cart-summary-prod-wrp')]";
    public static final String STR_PRICE_FROM_CART = STR_CART_SINGLE_PRODUCT + "//*[contains(@class, 'miglog-prod-totalPrize')]/span[1]";
    public static final String STR_POSTAGE_PRICE = "infoSubText";
    public static final String STR_TOTAL_PRICE = "//*[@class='btnToggleCart']//*[@class='currency']";

    // == By =
    public static final By BY_SEARCH_RESULT_PANEL = By.id(STR_SEARCH_RESULT_PANEL);
    public static final By BY_CART_SINGLE_PRODUCT = By.xpath(STR_CART_SINGLE_PRODUCT);

    // == sub-element ==
    public static final By BY_PRICE_SUB_ELEMENT_PRODUCT_CARD = By.xpath("." + STR_PRICE);
    public static final By BY_ADD_PRODUCT_SUB_ELEMENT_PRODUCT_CARD = By.xpath("." + STR_ADD_PRODUCT);
    public static final By BY_PRICE_FROM_CARD_SUB_ELEMENT_SINGLE_PRODUCT = By.xpath("." + STR_PRICE_FROM_CART);
}
