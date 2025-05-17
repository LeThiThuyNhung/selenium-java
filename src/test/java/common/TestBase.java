package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import static utils.Browser.captureScreenShot;

public class TestBase {
    @AfterMethod(alwaysRun = true)
    protected void takeScreenShortWhenFail(ITestResult testResult) {
        if(!testResult.isSuccess())
        {
            captureScreenShot(testResult.getName());
        }
    }
}
