package Base;

import PageObjects.ObjectFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static ObjectFactory objectFactory;
    public static String parentWindow;
    public static Properties properties;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest extentTest;
    String reportName;

    @BeforeSuite

    public void beforeSuite() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "ExtentReport-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\Reports/" + reportName);

        sparkReporter.config().setDocumentTitle("Automation Testing Practice");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application", "TestAutomationPractice");
        extentReports.setSystemInfo("Environment", "TestEnvironment");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser Name", "Chrome");
    }


    @BeforeClass
    public void beforeClass() {
        try {
            WebDriverManager.chromedriver().setup();
            FileInputStream fis = new FileInputStream("./config.properties");
            properties = new Properties();
            properties.load(fis);

            driver = new ChromeDriver();
            driver.get(properties.getProperty("URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            parentWindow = driver.getWindowHandle();
            objectFactory = new ObjectFactory();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
        String extentPath = System.getProperty("user.dir") + ".\\Reports/" + reportName;
        File extentFile = new File(extentPath);
        try {
            Desktop.getDesktop().browse(extentFile.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
