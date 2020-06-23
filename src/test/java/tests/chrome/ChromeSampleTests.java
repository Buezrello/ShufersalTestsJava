package tests.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.scenarious.SampleTests;

@Test
public class ChromeSampleTests extends SampleTests {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        createChromeDriver();
        super.setUpMethod();
    }

    public void testCheckLogo() {
        checkLogo();
    }

    public void testCheckUserName() {
        checkUserName();
    }
}
