package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebTables extends BaseClass {
    public static final String STATIC_WEB_TABLE_XPATH = "//h2[text()=\"Static Web Table\"];xpath";
    public static final String TABLE_XPATH = "//table[@name=\"BookTable\"]//th";
    public static final String HEADERS_IN_THE_TABLE_XPATH = "//table[@name=\"BookTable\"]//th";
    public static final String ROWS_IN_THE_TABLE_XPATH = "//table[@name=\"BookTable\"]//tr";
    public static final String BOXES_IN_THE_TABLE_XPATH = "//table[@name=\"BookTable\"]//tr//td";
    public static final String AUTHORS_COLUMN_FROM_TABLE = "//table[@name=\"BookTable\"]//tr//td[2]";

    public void getElementsFromTable(String webElementList, String expectedValue) {
        objectFactory.getReusable().scrollIntoViewUsingJSE(STATIC_WEB_TABLE_XPATH);
        List<WebElement> headersList = driver.findElements(By.xpath(webElementList));
        System.out.println("No of Elements in the Table is : " + headersList.size());
        boolean status = false;
        for (WebElement element : headersList) {
            String value = element.getText();
            System.out.println(value);
            if (value.contains(expectedValue)) {
                System.out.println(" : Matched");
                status = true;
            }
        }
        Assert.assertTrue(status, "Expected Value is not Matched in the Table");
    }

    public void getHeadersFromTable() {
        String expectedText = "Author";
        System.out.println("Getting No of Headers from Table and Verifying " + expectedText + " is Preset or not");
        objectFactory.getWebTables().getElementsFromTable(HEADERS_IN_THE_TABLE_XPATH, expectedText);
    }

    public void getRowsFromTable() {
        String expectedText = "Learn Selenium";
        System.out.println("Getting No of Rows from Table and Verifying " + expectedText + " is Preset or not");
        objectFactory.getWebTables().getElementsFromTable(ROWS_IN_THE_TABLE_XPATH, expectedText);
    }

    public void getAllBoxesFromTable() {
        String expectedText = "JAVA";
        System.out.println("Getting No of Boxes from Table and Verifying " + expectedText + " is Preset or not");
        objectFactory.getWebTables().getElementsFromTable(BOXES_IN_THE_TABLE_XPATH, expectedText);
    }

    public void getAuthorsFromTables() {
        String expectedText = "Mukesh";
        System.out.println("Getting No of Authors from Table and Verifying " + expectedText + " is Preset or not");
        objectFactory.getWebTables().getElementsFromTable(AUTHORS_COLUMN_FROM_TABLE, expectedText);

    }
}
