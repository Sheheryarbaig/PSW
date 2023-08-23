package Locators.EnumFactory;

public enum Login {
    XPATH_USERNAME_TXT("//input[@name=\"userName\"]"),
    XPATH_PASSWORD_TXT("//input[@name=\"password\"]"),
    XPATH_LOGIN_BTN("(//button[contains(text(), 'Login')])[1]"),
    XPATH_CIRCLE_LOADER("//*[@attributeName='r']"),
    XPATH_DOTS_LOADER("//*[@attributeName='transform']");
    private String pageVariables;
    private Login(String pageVariables) {

        this.pageVariables = pageVariables;
    }

    public String getValue() {
        return this.pageVariables;
    }

    public String getPageVariables(){return this.pageVariables;}
}
