package Helpers.Subscription;

import Helpers.CommonPageFactory;
import Helpers.HarnessVariables;
import Setup.Initialization.PropertyLoaderFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Statement;

public class LoginStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Login login = new Login();
    Subscribe subscription = new Subscribe();


    public LoginStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    @Then("I Login Application with {string} and {string}")
    public void userLogin(String userName, String password) throws Exception {
        login.loginApp(userName, password);
    }
}
