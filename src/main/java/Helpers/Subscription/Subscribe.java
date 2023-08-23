package Helpers.Subscription;

import Helpers.commonActions;
import Setup.Initialization.PropertyLoaderFactory;
import Setup.Initialization.UtilFactory;

import java.util.Properties;

public class Subscribe extends commonActions {

    commonActions actions;

    public Subscribe() throws Exception {
        actions = new commonActions();
    }


    public void subscribeUser(String NTN, String email, String CNIC, String mobileNum, String testDataFileName) throws Exception {

        String locatorPageName = "Subscribe";

        subscriptionInformation(NTN, email, CNIC, mobileNum, testDataFileName, locatorPageName);
        paymentProcess(locatorPageName);
        informationAuthentication(testDataFileName, locatorPageName);
        biometricAPI();

        actions.refreshPageWithAlert();
        resumeSubscriptionAfterBiometricForVerification(email, testDataFileName, locatorPageName);
    }

    public void subscriptionInformation(String NTN, String email, String CNIC, String mobileNum, String testDataFileName, String locatorPageName) throws Exception {
        actions.deleteNTNByQuery(NTN, testDataFileName);
        actions.clickBtn("subscribe", locatorPageName);
        actions.clickBtn("agree", locatorPageName);
        actions.clickBtn("proceed", locatorPageName);
        actions.enterText(NTN, testDataFileName, "NTN", locatorPageName);
        actions.clickBtn("validate", locatorPageName);
        actions.enterText(email, testDataFileName, "Email", locatorPageName);
        actions.enterText(CNIC, testDataFileName, "CNIC Number", locatorPageName);
        actions.enterText(mobileNum, testDataFileName, "Number", locatorPageName);
        actions.enterText("Jazz", testDataFileName, "Selection SIM", locatorPageName);
        actions.clickBtn("Jazz", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Jazz1", locatorPageName);
        actions.postRequestAPI("psw endpoint",
                "psw base",
                "TokenBody",
                "200");
    }

    public void paymentProcess(String locatorPageName) throws Exception {
        actions.clickBtn("Generate Voucher", locatorPageName);
        actions.extractAndSaveText("Payment ID",
                "Subscribe",
                "Subscribe",
                "payment slip");
        actions.extractAndSaveText("Subscription Fee",
                "Subscribe",
                "Subscribe",
                "subscription fee");
        actions.extractAndSaveText("Application ID",
                "Subscribe",
                "Subscribe",
                "Application ID");
        actions.postRequestAPI("psw payment endpoint",
                "psw base",
                "Payment Body",
                "200");
        actions.hardWait(200);
        actions.clickBtn("Refresh", locatorPageName);
        actions.clickBtn("Refresh", locatorPageName);
        actions.clickBtn("proceed", locatorPageName);
        actions.hardWait(200);
    }

    public void informationAuthentication(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Send OTP", locatorPageName);
        actions.hardWait(200);
        actions.fetchValueFromDBWithOneQueryParameter("OTP sms",
                "otpcode",
                "Application ID",
                "Subscribe",
                "TestData/Subscribe");
        actions.fetchValueFromDBWithOneQueryParameter("OTP email",
                "otpcode",
                "Application ID",
                "Subscribe",
                "TestData/Subscribe");
        actions.enterText("OTP sms",
                testDataFileName,
                "Mobile OTP",
                locatorPageName);
        actions.enterText("OTP email",
                testDataFileName,
                "Email OTP",
                locatorPageName);
        actions.clickBtn("Submit OTP", locatorPageName);
    }

    public void biometricAPI() throws Exception {
        actions.postRequestAPI("psw biometric endpoint",
                "psw base",
                "Biometric Verification",
                "200");
    }

    public void reloadPageAfterBiometicAPI() {
        actions.refreshPageWithAlert();
    }

    public void resumeSubscriptionAfterBiometricForVerification(String email, String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Resume Subscription", locatorPageName);
        actions.enterText("Application ID",
                testDataFileName,
                "Application ID Text",
                locatorPageName);
        actions.enterText(email,
                testDataFileName,
                "Alert Email",
                locatorPageName);
        actions.clickBtn("Fetch Application", locatorPageName);
        actions.clickBtn("Done", locatorPageName);
    }
}
