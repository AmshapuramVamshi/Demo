package Utilities;

import Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Reusable extends BaseClass {
    public static JavascriptExecutor javascriptExecutor;
    public static FileInputStream fileInputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet sheet;

    //Working
    public void clickElement(String element) {
        WebElement element1 = getWebElement(element);
        if (element1 != null) {
            element1.click();
        }
    }

    //Working
    public void sendKeys(String element, String input) {
        WebElement element1 = getWebElement(element);
        if (element1 != null) {
            element1.sendKeys(input);
        }
    }

    //Working
    public WebElement getWebElement(String element) {
        String[] stringArray = element.split(";");
        switch (stringArray[1]) {
            case "xpath":
                return driver.findElement(By.xpath(stringArray[0]));
            case "id":
                return driver.findElement(By.id(stringArray[0]));
            default:
                System.out.println("Invalid Element");
        }
        return null;
    }

    //Working
    public String captureScreenshot(String fileName) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File deskFile = new File(".\\screenShots/" + fileName + timeStamp + ".jpg");
            FileUtils.copyFile(sourceFile, deskFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    //Working
    public Set<String> gerSingleWebElementText(String element) {
        WebElement element1 = getWebElement(element);
        if (element1 != null) {
            element1.getText();
        }
        return null;
    }

    //Working
    public void scrollIntoViewUsingJSE(String element) {
        WebElement element1 = getWebElement(element);
        javascriptExecutor = (JavascriptExecutor) driver;
        if (element1 != null) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element1);
        }
    }

    // Working
    public void scrollWebPageTillEndUsingJSE(String webElement) {
        WebElement element1 = getWebElement(webElement);
        javascriptExecutor = (JavascriptExecutor) driver;
        if (element1 != null) {
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

    //Working
    public WebElement getWebElements(String element) {
        String[] stringArray = element.split(";");
        switch (stringArray[1]) {
            case "xpath":
                return (WebElement) driver.findElements(By.xpath(stringArray[0]));
            case "id":
                return (WebElement) driver.findElements(By.id(stringArray[0]));
            default:
                System.out.println("Invalid Element");
        }
        return null;
    }

    public void getOptionsFromDropDownDataUsingSelect(String element) {
        WebElement element1 = getWebElements(element);
        if (element1 != null) {
            Select select = new Select(element1);
            List<WebElement> options = select.getOptions();
            System.out.println("get the size of Options in Drop_Down: " + options);
            for (int i = 0; i <= options.size(); i++) {
                options.get(i).getText();
            }
        }
    }

    public void getELementsText(String comment, String path) {
        try {
            List<WebElement> list = driver.findElements(By.xpath(path));
            List<String> stringList = new ArrayList<>();
            System.out.println(comment);
            for (WebElement s : list) {
                stringList.add(s.getText());
                Thread.sleep(5000);
            }
            System.out.println(stringList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Working
    public boolean isAlertPresentOrNot() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    //Working
    public boolean sendKeysIntoAlert(String inputText) {
        try {
            if (driver.switchTo().alert() != null) {
                System.out.println("Sent Key into Alert" + inputText);
                driver.switchTo().alert().sendKeys(inputText);
                driver.switchTo().alert().accept();
            }
        } catch (NoAlertPresentException Ex) {
            Ex.printStackTrace();
            return false;
        }
        return false;
    }

    //Working
    public void handlingAlerts(String perform) {
        String str = perform.toLowerCase();
        Alert alert = driver.switchTo().alert();
        switch (str) {
            case "accept":
                alert.accept();
                System.out.println("Alert is Accepted");
                break;
            case "dismiss":
                alert.dismiss();
                System.out.println("Alert is Dismissed");
                break;
            case "getText":
                String alertText = alert.getText();
                System.out.println("Get Text from Alert: " + alertText);
                break;
            default:
                System.out.println("Alert Not Present");
        }
    }

    public String getRowCount(String sheetPath, String sheetName) {
        try {
            fileInputStream = new FileInputStream(sheetPath);
            workBook = new XSSFWorkbook(fileInputStream);
            sheet = workBook.getSheet(sheetName);
            int rowSize = sheet.getLastRowNum();
            return "No.of Rows is : " + rowSize;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellCount(String excelPath, String sheetName, int rowNumber) {
        try {
            fileInputStream = new FileInputStream(excelPath);
            workBook = new XSSFWorkbook(fileInputStream);
            sheet = workBook.getSheet(sheetName);
            int cellSize = sheet.getRow(rowNumber).getLastCellNum();
            return "No.of Cells is : " + cellSize;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> getWindowHandles() {
        Set<String> set = driver.getWindowHandles();
        List<String> list = new ArrayList<>(set);

        return list;
    }

    public boolean switchToWindow(String windowTitle) {
        boolean status = false;
        for (String e : getWindowHandles()) {
            String title = driver.switchTo().window(e).getTitle();
            System.out.println(title);
            if (windowTitle.contains(title)) {
                status = true;
                return true;
            }
        }
        Assert.assertTrue(status, "Assert Fail");
        return false;
    }

    public void switchToParentWindow() {
        driver.switchTo().window(parentWindow);
    }

    public void closeAllWindowsExpectParentWindow() {
        for (String e : getWindowHandles()) {
            if (!e.contains(parentWindow)) {
                driver.switchTo().window(e).close();
            }
        }
    }
}
