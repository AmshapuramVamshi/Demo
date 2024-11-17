package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InputFields extends BaseClass {
    public static final String NAME_XPATH = "//input[@id=\"name\"];xpath";
    public static final String EMAIL_ID = "email;id";
    public static final String PHONE_ID = "phone;id";
    public static final String ADDRESS_ID = "textarea;id";
    public static final String GENDER_XPATH = "//input[@type=\"radio\"]/..";
    public static final String DROPDOWN_XPATH = "(//h2[text()=\"Scrolling DropDown\"]/following::input)[1];xpath";

    public void sendKeysIntoFields() {
        try {
            objectFactory.getReusable().sendKeys(NAME_XPATH, "Vamshi");
            objectFactory.getReusable().sendKeys(EMAIL_ID, "test@gmail.com");
            objectFactory.getReusable().sendKeys(PHONE_ID, "12345");
            objectFactory.getReusable().sendKeys(ADDRESS_ID, "Hyderabad");
            objectFactory.getReusable().captureScreenshot("inPutElements");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlingRadioButtons() {
        try {

            List<WebElement> list = driver.findElements(By.xpath(GENDER_XPATH));
            List<String> stringList = new ArrayList<>();
            System.out.println("Gender");
            for (WebElement s : list) {
                stringList.add(s.getText());
                Thread.sleep(5000);
            }
            System.out.println(stringList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dropDown() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(DROPDOWN_XPATH);
            objectFactory.getReusable().clickElement(DROPDOWN_XPATH);
            Thread.sleep(5000);
            List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\"dropdown\"]"));
            for (WebElement element : elements) {
                String elementsTexts = element.getText();
                System.out.println(elementsTexts);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
