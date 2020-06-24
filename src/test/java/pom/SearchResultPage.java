package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.SearchResultPageConstants.*;
import static utilitues.Waits.fluentWaitElementClickable;
import static utilitues.Waits.fluentWaitElementExists;

public class SearchResultPage {

    // == private fields ==
    WebDriver driver;

    // == constructors ==
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // == web elements ==
    @FindBy(id = STR_SEARCH_RESULT_PANEL)
    private WebElement searchResultPanel;
    @FindBy(xpath = STR_BTN_SORT)
    private WebElement btnSort;
    @FindBy(xpath = STR_SORTING_FILTERS)
    private List<WebElement> sortingFilters;
    @FindBy(xpath = STR_PRODUCTS)
    private List<WebElement> products;
    @FindBy(xpath = STR_CHEAPEST_PRODUCT)
    private WebElement cheapestProduct;
    @FindBy(xpath = STR_CART_SINGLE_PRODUCT)
    private List<WebElement> productsInCart;
    @FindBy(className = STR_POSTAGE_PRICE)
    private WebElement postagePrice;
    @FindBy(xpath = STR_TOTAL_PRICE)
    private WebElement totalPrice;
    @FindBy(xpath = STR_BTN_DELETE_CART)
    private List<WebElement> btnDeleteCart;
    @FindBy(xpath = STR_BTN_CART_DELETE_AGREE)
    private WebElement btnCleanCartAgree;

    // == getters ==

    public WebElement getSearchResultPanel() {
        return searchResultPanel;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getCheapestProduct() {
        return cheapestProduct;
    }


    public WebElement getBtnSort() {
        return btnSort;
    }

    public List<WebElement> getSortingFilters() {
        return sortingFilters;
    }

    public WebElement getBtnCleanCartAgree() {
        return btnCleanCartAgree;
    }

    public List<WebElement> getProductsInCart() {
        return productsInCart;
    }

    public List<WebElement> getBtnDeleteCart() {
        return btnDeleteCart;
    }

    // == public methods ==

    public void sortFromCheapToExpensive() {

        fluentWaitElementExists(driver, BY_BTN_SORT, 5);

        btnSort.click();

        PageFactory.initElements(driver, this);

        sortingFilters.get(0).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementClickable(driver, BY_SEARCH_RESULT_PANEL, 5);

        PageFactory.initElements(driver, this);
    }

    public double getPrice(WebElement card) {

        String price = card.findElement(BY_PRICE_SUB_ELEMENT_PRODUCT_CARD).getText();

        return Double.parseDouble(price);
    }

    public double getCheapestPrice() {

        return getPrice(cheapestProduct);
    }

    public void moveMouseToCard(WebElement card) {
        Actions builder = new Actions(driver);
        builder.moveToElement(card).build().perform();
    }

    public void moveMouseToCheapestCard() {
        moveMouseToCard(cheapestProduct);
    }

    public void addProductToCart(WebElement card) {
        moveMouseToCard(card);
        card.findElement(BY_ADD_PRODUCT_SUB_ELEMENT_PRODUCT_CARD).click();

        fluentWaitElementExists(driver, BY_CART_SINGLE_PRODUCT, 5);

        PageFactory.initElements(driver, this);
    }

    public void addCheapestProductToCart() {
        addProductToCart(cheapestProduct);
    }

    public double getPriceFirstProductInCart() {
        String price = productsInCart.get(0).findElement(BY_PRICE_FROM_CARD_SUB_ELEMENT_SINGLE_PRODUCT).getText();

        return Double.parseDouble(price);
    }

    public double getPostagePrice() {
        String price = postagePrice.getText();

        return Double.parseDouble(fetchDouble(price));
    }

    public double getTotalPrice() {
        String price = totalPrice.getText();

        return Double.parseDouble(fetchDouble(price));
    }

    /**
     * clean a cart as a precondition for test
     *
     */
    public void cleanCart() {
        if (btnDeleteCart.isEmpty())
            return;

        btnDeleteCart.get(0).click();

        fluentWaitElementExists(driver, BY_BTN_CART_DELETE_AGREE, 5);

        PageFactory.initElements(driver, this);

        btnCleanCartAgree.click();

        PageFactory.initElements(driver, this);

        fluentWaitElementExists(driver, BY_EMPTY_CART, 5);

        PageFactory.initElements(driver, this);
    }

    // == private methods ==
    private String fetchDouble(String price) {
        String regex="([0-9]+[.0-9]*)";

        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(price);


        if (!matcher.find()) {
            System.out.println("NOT FOUND");
            throw new AssertionError("Price Not Found");
        }

        return matcher.group();
    }

}
