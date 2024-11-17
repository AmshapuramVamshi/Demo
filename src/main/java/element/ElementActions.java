package element;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element extends BaseClass {

    public void click(String locatorText) {
        try {
            WebElement element = getWebElement(locatorText);
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement getWebElement(String locatorText) {
        String[] arr = locatorText.split(";");
        String elementType = arr[arr.length - 1];
        String locator = arr[0];
        switch (elementType) {
            case "xpath":
                return driver.findElement(By.xpath(locator));
            case "id":
                return driver.findElement(By.id(locator));
            case "name":
                return driver.findElement(By.name(locator));
            case "tagName":
                return driver.findElement(By.tagName(locator));

            case "className":
                return driver.findElement(By.className(locator));
            case "linkText":
                return driver.findElement(By.linkText(locator));
            case "partialLinkText":
                return driver.findElement(By.partialLinkText(locator));
            case "cssSelector":
                return driver.findElement(By.cssSelector(locator));
            default:
                System.out.println("invalid locator");

        }
        return null;
    }

}
