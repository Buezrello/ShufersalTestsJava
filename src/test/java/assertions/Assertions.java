package assertions;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Locale;

public class Assertions {
    private static final Logger log = Logger.getLogger(Assertions.class);

    // == constructors ==
    private Assertions() { }

    // == public methods ==
    public static void assertTextContainsSubstring(String text, String substring,
                                                   String... additionalInfo) {
        log.debug("Checking that text contains substring");

        Assert.assertTrue(containsSubstring(text, substring),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertTextNotContainsSubstring(String text, String substring,
                                                      String... additionalInfo) {
        log.debug("Checking that text not contains substring");

        Assert.assertFalse(containsSubstring(text, substring),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertTwoNumbersAreEqual(Number actualNumber, Number expectedNumber, String... additionalInfo) {
        Assert.assertEquals(actualNumber, expectedNumber,
                String.join(" ", additionalInfo));
    }

    // == private methods ==
    private static boolean containsSubstring(String text, String substring) {
        text = StringUtils.normalizeSpace(text);
        substring = StringUtils.normalizeSpace(substring);

        Locale locale = new Locale("he");

        return text.toLowerCase(locale).contains(substring.toLowerCase(locale));
    }
}
