package Tests;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass extends BaseClass {
    @Test
    public void handlingAlertsOnWebPage() throws IOException {
        objectFactory.getAlerts().acceptSingleAlert();
        objectFactory.getAlerts().acceptConfirmationAlert();
        objectFactory.getAlerts().cancelConfirmationAlert();
        objectFactory.getAlerts().promAlert();

    }

    @Test
    public void handlingWebTablesOnWebPage() {
        objectFactory.getWebTables().getHeadersFromTable();
        objectFactory.getWebTables().getRowsFromTable();
        objectFactory.getWebTables().getAuthorsFromTables();

        objectFactory.getWebTables().getAllBoxesFromTable();
    }

    @Test
    public void handlingInputFields() {
        objectFactory.getInputFields().dropDown();
        objectFactory.getInputFields().handlingRadioButtons();
        objectFactory.getInputFields().sendKeysIntoFields();

    }
}
