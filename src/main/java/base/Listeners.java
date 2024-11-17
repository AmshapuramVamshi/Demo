package Base;

import Utilities.Reusable;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManagerWithListeners extends BaseClass implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println("Test is Started");
    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getMethodName());
        extentTest.log(Status.PASS, result.getName() + " : Successfully Executed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getName() + " : Failed");
        extentTest.log(Status.INFO, result.getThrowable().getMessage());
        try {
            String imgPath = new Reusable().captureScreenshot(result.getName());
            extentTest.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getMethodName());
        extentTest.log(Status.SKIP, result.getName() + " : Skipped");
        extentTest.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test is Finished");
    }


}
