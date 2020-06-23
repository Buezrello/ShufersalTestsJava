package constants;

import org.openqa.selenium.By;

public class SearchResultPageConstants {

    private SearchResultPageConstants() { }

    // == String ==
    public static final String STR_SEARCH_RESULT_PANEL = "changeView";
    public static final String STR_SORTING_SELECTOR = "sortOptions1";
    public static final String STR_CHEAPEST_PRODUCT = "//*[@id='mainProductGrid']/li[1]";

    // == By =
    public static final By BY_SEARCH_RESULT_PANEL = By.id(STR_SEARCH_RESULT_PANEL);
}
