package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    @FindBy(id = STR_SORTING_SELECTOR)
    private Select slctSort;
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

    public Select getSlctSort() {
        return slctSort;
    }

    // == public methods ==

    public void sortFromCheapToExpensive() {
        slctSort.selectByIndex(0);

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

        return Double.parseDouble(price);
    }
    
    public double getTotalPrice() {
        String price = totalPrice.getText();

        return Double.parseDouble(price);
    }

}
