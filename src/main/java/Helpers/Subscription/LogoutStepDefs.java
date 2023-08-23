package Helpers.Subscription;

import Helpers.CommonPageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Then;

import java.sql.Statement;

public class LogoutStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Logout logoutApplication = new Logout();

    public LogoutStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    @Then("I Logout Application")
    public void userLogin() throws Exception {
        logoutApplication.logoutApp();
    }
}
