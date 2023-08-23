package Locators.EnumFactory;

public enum Logout {
    XPATH_PROFILE_BTN("(//button[@class=\"menu-toggle pr-2 bg-light rounded-0 dropdown-toggle btn btn-flat\"])[2]"),
    XPATH_LOGOUT_BTN("(//a[@class=\"py-3 dropdown-item\"])[text()='Logout']"),
    XPATH_LOGIN_TEXT("(//h5)[1]"),
    ;
    private String pageVariables;
    private Logout(String pageVariables) {

        this.pageVariables = pageVariables;
    }

    public String getValue() {
        return this.pageVariables;
    }

    public String getPageVariables(){return this.pageVariables;}
}
