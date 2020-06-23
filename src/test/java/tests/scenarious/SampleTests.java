package tests.scenarious;

import assertions.Assertions;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.FrontPage;
import tests.TestBase;

import static constants.EnglishHebrewConstants.IGOR;

public class SampleTests extends TestBase {
    private static final Logger log = Logger.getLogger(SampleTests.class);

    protected void checkLogo() {
        log.info("Open Shufersal home page, check that Shufersal logo exists");

        Assert.assertTrue(loginPage.isLogo(), "Shufersal Logo not found on a login page");
    }

    protected void checkUserName() {
        log.info("Open Shufersal home page, login, check that name of user displaying correctly");

        login();

        FrontPage frontPage = new FrontPage(driver);

        String username = frontPage.getUsername();

        Assertions.assertTextContainsSubstring(username, IGOR, String.format("The string '%s' does not contains the username '%s'",
                username, IGOR));
    }
}
