package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static constants.SearchResultPageConstants.*;
import static utilitues.Waits.fluentWaitElementClickable;

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
    @FindBy(xpath = STR_CHEAPEST_PRODUCT)
    private WebElement cheapestProduct;

    // == getters ==

    public WebElement getSearchResultPanel() {
        return searchResultPanel;
    }

    public Select getSlctSort() {
        return slctSort;
    }

    // == public methods ==

    public void sortFromCheapToExpensive() {
        slctSort.selectByIndex(0);

        fluentWaitElementClickable(driver, BY_SEARCH_RESULT_PANEL, 5);
    }
}
