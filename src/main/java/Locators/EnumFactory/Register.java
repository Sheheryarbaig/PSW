package Locators.EnumFactory;

public enum Register {
    XPATH_USER_ID("//*[@id=\"sub-container\"]/div[2]/div[2]/div/form/fieldset/h2"),
    XPATH_PASSWORD_TXT("//input[@placeholder=\"Password\"]"),
    XPATH_CONFIRM_PASSWORD_TXT("//input[@placeholder=\"Confirm Password\"]"),
    XPATH_CREATE_PASSWORD_BTN("//button[@type='submit']"),
    XPATH_LOGIN_PASSWORD_TXT("//input[@name=\"password\"]");

    private String pageVariables;

    private Register(String pageVariables) {

        this.pageVariables = pageVariables;
    }

    public String getValue() {
        return this.pageVariables;
    }

    public String getPageVariables(){return this.pageVariables;}
}
