package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//  1) Capture the title of the page.
//  2) Capture the current URL.
//  3) Check First Name & Last Name text boxes presence and enabled or not.
//  4) Select gender male/female then check the status selected or not.
//  5) Close browser.
public class UsingNavigationCommands {
    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://goo.gl/RVdKM9");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //  1) Capture the title of the page.
        String title = driver.getTitle();
        System.out.println("Title of the Page is : " + title);

        //  2) Capture the current URL.
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL of the Page is : " + currentURL);

        //  3) Check First Name & Last Name text boxes presence and enabled or not.
        String inputFields = "//label[@class=\"question top_question\"]";
        getElements(inputFields);

        //  4) Select gender male/female then check the status selected or not.
        getCheckBoxes("//input[@type=\"radio\"]/following::label");

        driver.close();
        driver.quit();
    }


    public static void getElements(String locator) {
        List<WebElement> list = driver.findElements(By.xpath(locator));
        System.out.println();
        List<String> texts = new ArrayList<>();
        System.out.println("No of Input fields on WebPage : " + list.size());
        for (WebElement element : list) {
            if (element.isEnabled()) {
                texts.add(element.getText());
            }
        }
        System.out.println("Enable elements is : " + texts);
    }

    public static void getCheckBoxes(String locator) {
        List<WebElement> list = driver.findElements(By.xpath(locator));
        System.out.println("No of Check Boxes on WebPage : " + list.size());
        List<String> texts = new ArrayList<>();
        for (WebElement element : list) {
            texts.add(element.getText());
            if (texts.equals("Male")) {
                element.click();
            }
        }
        System.out.println("Check Boxes : "+ texts);
    }
}
