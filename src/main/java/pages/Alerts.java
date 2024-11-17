package Pages;

import Base.BaseClass;

public class Alerts extends BaseClass {
    public static final String ALERTS_AND_POPUPS_XPATH = "//h2[text()=\"Alerts & Popups\"];xpath";
    public static final String SIMPLE_ALERT_XPATH = "//button[text()=\"Simple Alert\"];xpath";
    public static final String CONFIRMATION_ALERT_XPATH = "//button[text()=\"Confirmation Alert\"];xpath";
    public static final String PROMPT_ALERT_XPATH = "//button[text()=\"Prompt Alert\"];xpath";

    public void acceptSingleAlert() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(ALERTS_AND_POPUPS_XPATH);
            objectFactory.getReusable().clickElement(SIMPLE_ALERT_XPATH);
            Thread.sleep(5000);

            objectFactory.getReusable().handlingAlerts("ACCEPT");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancelConfirmationAlert() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(ALERTS_AND_POPUPS_XPATH);
            objectFactory.getReusable().clickElement(CONFIRMATION_ALERT_XPATH);
            Thread.sleep(5000);
            objectFactory.getReusable().handlingAlerts("DISMISS");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptConfirmationAlert() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(ALERTS_AND_POPUPS_XPATH);
            objectFactory.getReusable().clickElement(CONFIRMATION_ALERT_XPATH);
            Thread.sleep(5000);
            objectFactory.getReusable().handlingAlerts("ACCEPT");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void promAlert() {
        try {
            objectFactory.getReusable().scrollIntoViewUsingJSE(ALERTS_AND_POPUPS_XPATH);
            objectFactory.getReusable().clickElement(PROMPT_ALERT_XPATH);
            Thread.sleep(5000);
            objectFactory.getReusable().sendKeysIntoAlert("Testing");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
