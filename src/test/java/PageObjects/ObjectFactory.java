package PageObjects;

import Base.BaseClass;
import Pages.Alerts;
import Pages.WebTables;
import Pages.InputFields;
import Utilities.Reusable;

public class ObjectFactory extends BaseClass {
    public Reusable reusable;
    public InputFields inputFields;
    public WebTables webTables;
    public Alerts alerts;

    public ObjectFactory() {
        reusable = new Reusable();
        inputFields = new InputFields();
        webTables = new WebTables();
        alerts = new Alerts();

    }

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }


    public WebTables getWebTables() {
        return webTables;
    }

    public void setWebTables(WebTables webTables) {
        this.webTables = webTables;
    }

    public Reusable getReusable() {
        return reusable;
    }

    public void setReusable(Reusable reusable) {
        this.reusable = reusable;
    }

    public InputFields getInputFields() {
        return inputFields;
    }

    public void setInputFields(InputFields inputFields) {
        this.inputFields = inputFields;
    }

}
