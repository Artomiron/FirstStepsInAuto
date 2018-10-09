package base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListeners extends TestListenerAdapter {
    public void onTestSuccess(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test success");

    }

    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " Test Failure");

    }

    public void onStart(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Starts");

    }

    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Finished");
    }

}
