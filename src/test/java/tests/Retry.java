package tests;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private static final Logger log = Logger.getLogger(Retry.class);

    private int counter = 0;
    private static int retryLimit = 3;

    @Override
    public boolean retry(ITestResult result) {

        String errorMessage = result.getThrowable().getMessage();
        log.debug("ERROR MESSAGE [ " + errorMessage + " ]");

        if (!result.isSuccess()) {
            if (counter < retryLimit) {
                counter++;
                result.setStatus(ITestResult.SKIP);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        }

        return false;
    }
}
