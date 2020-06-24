package tests.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Retry;
import tests.scenarious.SampleTests;

@Test
public class ChromeSampleTest extends SampleTests {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        createChromeDriver();
        super.setUpMethod();
    }

    @Test(retryAnalyzer = Retry.class)
    public void testCheckLogo() {
        checkLogo();
    }

    @Test(retryAnalyzer = Retry.class)
    public void testCheckUserName() {
        checkUserName();
    }

    @Test(retryAnalyzer = Retry.class)
    public void testBuyCheapestMilk() {
        buyCheapestMilk();
    }
}
