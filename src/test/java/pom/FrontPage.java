package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.FrontPageConstants.STR_SEARCH;
import static constants.FrontPageConstants.STR_SHALOM;
import static constants.SearchResultPageConstants.BY_SEARCH_RESULT_PANEL;
import static utilitues.Waits.fluentWaitElementExists;

public class FrontPage {

    // == private fields ==
    WebDriver driver;

    // == constructors ==
    public FrontPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // == web elements ==
    @FindBy(xpath = STR_SHALOM)
    private WebElement txtShalom;
    @FindBy(id = STR_SEARCH)
    private WebElement txtSearch;

    // == getters ==
    public WebElement getTxtShalom() {
        return txtShalom;
    }

    public WebElement getTxtSearch() {
        return txtSearch;
    }

    // == public methods ==
    public String getUsername() {
        return txtShalom.getText();
    }

    public void searchProduct(String product) {
        txtSearch.sendKeys(product);
        txtSearch.sendKeys(Keys.ENTER);

        fluentWaitElementExists(driver, BY_SEARCH_RESULT_PANEL, 5);
//        fluentWaitElementExists(driver, BY_SORTING_SELECTOR, 5);
    }
}
