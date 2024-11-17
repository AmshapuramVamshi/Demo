package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

//    Open Web Browser.
//    Open URL
//    Capture title of the home page
//    Capture title of the home page

public class VerifyTitle {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getTitle();
        driver.close();
        driver.quit();
    }
    public static void getTitle(){
        String actualTitle = "Automation Testing Practice";
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        if(currentTitle.equals(actualTitle)){
            System.out.println("Title is Matched : PASS");
        }else {
            System.out.println("Title not Matched : FAIL");
        }
    }
}
