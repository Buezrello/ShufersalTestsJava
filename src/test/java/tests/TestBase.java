package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import pom.LoginPage;
import utilitues.Helpers;

public abstract class TestBase {
    private static final Logger log = Logger.getLogger(TestBase.class);

    protected static String email;
    protected static String password;
    protected static String shufersalUrl;

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeSuite (alwaysRun = true)
    public void setUpSuite() {
        email = Helpers.getPropFromResources("global.properties").getProperty("email");
        password = Helpers.getPropFromResources("global.properties").getProperty("password");
        shufersalUrl = Helpers.getPropFromResources("global.properties").getProperty("shufersalUrl");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null)
            driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null)
            driver.quit();
    }

    protected void createChromeDriver() {
        log.info("Create Chrome driver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
    }

    protected void setUpMethod() {
        goToLoginPage();
        loginPage = new LoginPage(driver);
    }

    protected void goToLoginPage() {
        log.info(String.format("Open a browser, go to %s", shufersalUrl));
        driver.get(shufersalUrl);
        driver.manage().window().maximize();
    }
}
