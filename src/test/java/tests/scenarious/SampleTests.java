package tests.scenarious;

import assertions.Assertions;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.FrontPage;
import pom.SearchResultPage;
import tests.TestBase;

import static constants.EnglishHebrewConstants.IGOR;
import static constants.EnglishHebrewConstants.MILK;

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

    protected void buyCheapestMilk() {
        log.info("Open Shufersal home page, login, buy cheapest milk product, check price");

        login();

        FrontPage frontPage = new FrontPage(driver);

        // find milk
        frontPage.searchProduct(MILK);

        SearchResultPage searchResultPage = new SearchResultPage(driver);

        // sort from cheap to expensive
        searchResultPage.sortFromCheapToExpensive();

        // get a price of a cheapest product
        double basePrice = searchResultPage.getCheapestPrice();

        // add the product to a cart
        searchResultPage.addCheapestProductToCart();

        // get a base price from a cart, compare with a base price found before
        double basePriceFromCart = searchResultPage.getPriceFirstProductInCart();

        Assertions.assertTwoNumbersAreEqual(basePriceFromCart, basePrice,
                String.format("Not cheapest product added to a cart, expected %f NIS, added %f NIS",
                        basePrice, basePriceFromCart));

        // find postage price
        double postagePrice = searchResultPage.getPostagePrice();

        // find totalPrice
        double actualTotalPrice = searchResultPage.getTotalPrice();

        // compare the total price with expected
        double expectedTotalPrice = basePriceFromCart + postagePrice;

        Assertions.assertTwoNumbersAreEqual(actualTotalPrice, expectedTotalPrice,
                String.format("Total price incorrect, expected %f NIS, found %f NIS",
                        expectedTotalPrice, actualTotalPrice));

        System.out.println(String.format("Total price %f NIS", actualTotalPrice));
    }
}
