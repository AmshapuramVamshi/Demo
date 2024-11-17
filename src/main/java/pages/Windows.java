package Pages;

import Base.BaseClass;
import org.testng.annotations.Test;


public class Windows extends BaseClass {
    public static final String NEW_TAB_XPATH = "//button[text()=\"New Tab\"];xpath";
    public static final String POP_UP_WINDOW_XPATH = "//button[text()=\"Popup Windows\"];xpath";

    @Test
    public void selectWindow() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(NEW_TAB_XPATH);
            objectFactory.getReusable().clickElement(NEW_TAB_XPATH);
            objectFactory.getReusable().switchToWindow(properties.getProperty("selectWindowTitle"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void popUpWindow() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(POP_UP_WINDOW_XPATH);
            objectFactory.getReusable().clickElement(POP_UP_WINDOW_XPATH);
            objectFactory.getReusable().switchToWindow(properties.getProperty("popUpWindowTitle"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
