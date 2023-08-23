package Helpers.Subscription;

import Helpers.commonActions;

public class Logout extends commonActions {

    commonActions actions;
    public Logout() throws Exception {
        actions = new commonActions();
    }

    public void logoutApp() throws Exception {
        actions.hardWait(3000);
        actions.clickBtn("Profile", "Logout");
        actions.clickBtn("Logout", "Logout");
        actions.assertion("Login.Text",
                "Login",
                "Login.Text",
                "Logout");
        actions.hardWait(3000);
    }
}
