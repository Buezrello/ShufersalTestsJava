package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static constants.LoginPageConstants.*;
import static utilitues.Waits.fluentWaitElementDisappeared;

public class LoginPage {

    // == private fields ==
    WebDriver driver;

    // == constructors ==
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // == web-elements ==
    @FindBy(xpath = STR_IMG_LOGO)
    private List<WebElement> imgLogo;
    @FindBy(xpath = STR_BTN_LOGIN)
    private WebElement btnLogin;
    @FindBy(id = STR_EMAIL)
    private WebElement txtEmail;
    @FindBy(id = STR_PASSWORD)
    private WebElement txtPassword;
    @FindBy(xpath = STR_BTN_ENTER)
    private WebElement btnEnter;

    // == getters ==
    public List<WebElement> getImgLogo() {
        return imgLogo;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getBtnEnter() {
        return btnEnter;
    }

    // == public methods ==

    public boolean isLogo() {
        return !imgLogo.isEmpty();
    }

    public void clickBtnLogin() {
        btnLogin.click();

        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickBtnEnter() {
        btnEnter.click();

        fluentWaitElementDisappeared(driver, BY_BTN_LOGIN, 5);
    }
}
