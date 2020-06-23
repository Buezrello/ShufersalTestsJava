package constants;

import org.openqa.selenium.By;

public class LoginPageConstants {

    private LoginPageConstants() {
    }

    // = String ==
    public static final String STR_IMG_LOGO = "//*[@id='corporateHeader']//img[@alt='beharaza.png']";
    public static final String STR_BTN_LOGIN = "//*[@id='loginDropdownContainer']/button";
    public static final String STR_EMAIL = "j_username";
    public static final String STR_PASSWORD = "j_password";
    public static final String STR_BTN_ENTER = "//*[@id='loginForm']//button[@type='submit']";

    // == By ==
    public static final By BY_BTN_LOGIN = By.xpath(STR_BTN_LOGIN);
}
