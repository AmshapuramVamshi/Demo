package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class activeLinks {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getAllActiveLinks();
        driver.close();
        driver.quit();
    }

    public static void getAllActiveLinks() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Size of all Active and Non-Active Links on WebPage: " + allLinks.size());
        List<WebElement> activeLinks = new ArrayList<>();
        for (int i = 0; i < allLinks.size(); i++) {
            if (allLinks.get(i).getAttribute("href") != null) {
                System.out.println(allLinks.get(i).getText());
                activeLinks.add(allLinks.get(i));
            }
        }
        System.out.println("Size of all Active Links on WebPage : " + activeLinks.size());
    }

}
