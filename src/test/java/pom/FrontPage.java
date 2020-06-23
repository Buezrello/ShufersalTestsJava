package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.FrontPageConstants.STR_SHALOM;

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

    // == getters ==
    public WebElement getTxtShalom() {
        return txtShalom;
    }

    // == public methods ==
    public String getUsername() {
        return txtShalom.getText();
    }
}
