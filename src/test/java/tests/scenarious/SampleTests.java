package tests.scenarious;

import org.apache.log4j.Logger;
import org.testng.Assert;
import tests.TestBase;

public class SampleTests extends TestBase {
    private static final Logger log = Logger.getLogger(SampleTests.class);

    protected void checkLogo() {
        log.info("Open Shufersal login page, check that Shufersal logo exists");

        Assert.assertTrue(loginPage.isLogo(), "Shufersal Logo not found on a login page");
    }
}
