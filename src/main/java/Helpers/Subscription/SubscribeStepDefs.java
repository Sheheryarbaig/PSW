package Helpers.Subscription;

import Helpers.CommonPageFactory;
import Helpers.HarnessVariables;
import Setup.Initialization.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Statement;

public class SubscribeStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Login login = new Login();
    Subscribe subscription = new Subscribe();


    public SubscribeStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    String locatorPageName = "Subscribe";

    @And("User performs subscription with {string}, {string}, {string} & {string} with {string} Test Data")
    public void subscriptionFlow(String NTN, String email, String CNIC, String mobileNum, String testDataFileName) throws Exception {
        subscription.subscribeUser(NTN, email, CNIC, mobileNum, testDataFileName);
    }

    @And("User Fill Subscription Info with {string}, {string}, {string} & {string} with {string} Test Data")
    public void subscriptionInfo(String NTN, String email, String CNIC, String mobileNum, String testDataFileName) throws Exception {
        subscription.subscriptionInformation(NTN, email, CNIC, mobileNum, testDataFileName, locatorPageName);
    }

    @Then("User Process the Payment")
    public void paymentFlow() throws Exception {
        subscription.paymentProcess(locatorPageName);
    }

    @Then("User performs the Info Auth with {string} Test Data")
    public void infoAuth(String testDataFileName) throws Exception {
        subscription.informationAuthentication(testDataFileName, locatorPageName);
    }

    @Then("User hit Biometric API for Verification")
    public void biometricVerification() throws Exception {
        subscription.biometricAPI();
    }

    @Then("User Reload the Page After Biometric API")
    public void pageReload() throws Exception {
        subscription.reloadPageAfterBiometicAPI();
    }

    @And("User Resume Application with {string} from {string} Test Data")
    public void finalizeSubscription(String email, String testDataFileName) throws Exception {
        subscription.resumeSubscriptionAfterBiometricForVerification(email, testDataFileName, locatorPageName);
    }
}
