package Helpers;

import Helpers.Subscription.Login;
import Helpers.Subscription.Subscribe;
import Setup.Initialization.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

import static Helpers.CommonPageFactory.ConnectDatabase;

public class CommonStepsDefs extends webdriverInitialization {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Login login = new Login();

    public CommonStepsDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }

//    @Given("User Setup Web Browser Session")
//    public void userSetupWebBrowserSession() throws Exception {
//        serviceFactoryInstance.setDriver(serviceFactoryInstance.getBrowser());
//        deviceName = "WEB";
//        waitFactory = new WaitFactory(ServiceFactory.getDriver());
//        elementFactory = new ElementFactory(ServiceFactory.getDriver());
//    }

    @Given("Setup Database Connection")
    public void databaseSetupConn() throws Exception {
        // Load the JDBC driver
        Properties envVariable = new PropertyLoaderFactory().getEnvironmentPropertyFile("environment.properties");
        HarnessVariables.dbConnectionString = envVariable.getProperty("databaseConnString");
        HarnessVariables.dbUserName = envVariable.getProperty("databaseUsername");
        HarnessVariables.dbPassword = envVariable.getProperty("databasePassword");

        stmt = ConnectDatabase(HarnessVariables.dbConnectionString, HarnessVariables.dbUserName, HarnessVariables.dbPassword);
    }
    @Then("User Navigates to {string} URL")
    public void userNavigatesToURL(String url) throws Exception {
        url = commonPage.getpropertyName(url);
        url = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(url);
        ServiceFactory.getDriver().get(url);
    }

    @Then("User Validates {string} Title")
    public void userValidatesTitle(String expectedTitle) throws Exception {
        expectedTitle = commonPage.getpropertyName(expectedTitle);
        expectedTitle = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(expectedTitle);
        String actualTitle = ServiceFactory.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User Waits")
    public void userwait() throws Exception {
        WaitFactory.staticWait(200);
    }

    @When("User Enters {string} on {string} Field on {string} Page")
    public void user_enters_on_field_on_page(String testData, String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        if(testData.equals("Application ID")) {
            testData = HarnessVariables.applicationid;
        }
        else {
            testData = commonPage.getpropertyName(testData);
            testData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(testData);
        }
        locator = commonPage.getpropertyName(locator);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        commonPage.textEnterField(testData, locator, screenName);
    }

    @And("User Press Down")
    public void userPressDown() throws Exception {
        UtilFactory.pressDown();
    }

    @And("User validate the {string} from {string} Page")
    public void validation(String locator , String screenName) throws Exception {

        screenName = commonPage.removeSpaces(screenName);
        locator=commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = screenName+HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName+".properties").getProperty(locator);
        String actualValue = "";
        actualValue = commonPage.getElementValue(locator,screenName,actualValue);
        if(locator.equals("XPATH_BIOMETRIC_STATUS")){
            HarnessVariables.biometricStatus = actualValue;
            Assert.assertEquals(HarnessVariables.biometricVerifiedStatus, actualValue);
        }
    }

    @Then("User Refresh the PSW Page and Click on Reload page")
    public void refreshPage() {
        try {
            UtilFactory.switchToAlertAccept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @And("User Click on {string} Button on {string} Page")
    public void userClickOnButtonOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = screenName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        try{
            commonPage.clickButton(locator, screenName);
        }catch(Exception e)
        {
            commonPage.clickButton(locator, screenName);
        }
    }

    @And("User Press Enter")
    public void userPressEnter() throws Exception {
        UtilFactory.pressEnter();
    }

    @Then("User Validate {string} Message for {string} on {string} Page")
    public void userValidateMessageForOnPage(String testData, String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        testData = commonPage.getpropertyName(testData);
        testData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(testData);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
            commonPage.validateTextonScreen(testData, locator, screenName);

    }


    @Then("User Validate {string} Field Appeared on {string} Page")
    public void userValidateFieldAppearedOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        String expectedValue = null;
            expectedValue = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(locator);

        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);

        try{
            commonPage.validateFieldonScreen(expectedValue, locator, screenName);
        }catch(Exception e)
        {
            commonPage.validateFieldonScreen(expectedValue, locator, screenName);
        }
    }


    @When("User Hovers on {string} Button on {string} Page")
    public void userHoversOnButtonOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        commonPage.hoverOnButton(locator, screenName);
    }

    @Then("User Validate {string} of {string} Appeared on {string} Page")
    public void userValidateValueAppearedOnPage(String attribute, String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        String expectedValue = null;
        expectedValue = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(locator);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        commonPage.validateValueAttributeScreen(attribute, expectedValue, locator, screenName);
    }

    @Then("User Validates {string} Element Appeared on {string} Page")
    public void userValidatesElementAppearedOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        String testData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(locator);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        commonPage.validateDynamicElementOnScreen(locator, testData, screenName);
    }

    @Then("User Validates {string} Element Displayed on {string} Page")
    public void userValidatesElementDisplayedOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        commonPage.validateElementOnScreen(locator, screenName);
        String Value = "";
        Value = commonPage.getElementValue(locator, screenName, Value);

    }


    @Then("User Validates {string} of {string} On {string} Page")
    public void userValidatesOfOnPage(String childLocator, String dynamicData, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        String expectedValue = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(childLocator);
        childLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(childLocator);
        String parentLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(dynamicData);
        dynamicData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(dynamicData);
        commonPage.validateDynamicString(parentLocator, dynamicData, childLocator, expectedValue, screenName);
    }

    @When("User Clicks on {string} Button of {string} on {string} Page")
    public void userClicksOnButtonOfOnPage(String childLocator, String dynamicData, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        childLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(childLocator);
        String parentLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(dynamicData);
        dynamicData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(dynamicData);

        try {
            commonPage.clickOnDynamicElement(parentLocator, dynamicData, childLocator, screenName);
        }catch(Exception e)
        {
            commonPage.clickOnDynamicElement(parentLocator, dynamicData, childLocator, screenName);
        }
    }

    @Then("User Validates {string} Color On Hover of {string} Button on {string} Page")
    public void userValidatesColorOnHoverOfButtonOnPage(String childLocator, String dynamicData, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        String expectedValue = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(childLocator);
        childLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(childLocator);

        String parentLocator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(dynamicData);
        dynamicData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(dynamicData);
        commonPage.validateDynamicElementColorOnHover(parentLocator, dynamicData, childLocator, expectedValue, screenName);
    }


    @Then("User Validates {string} URL on {string} Page")
    public void userValidatesURLOnPage(String expectedText, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        expectedText = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(expectedText);
        commonPage.validatePageURL(expectedText, screenName);
    }


    @And("User Clicks on {string} Button on {string} Page")
    public void userClicksOnButtonOnPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = screenName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        try {
            commonPage.clickButton(locator, screenName);
        }catch(Exception e)
        {
            commonPage.clickButton(locator, screenName);
        }
    }

    @Then("User Get {string} from {string} Page")
    public void userGetFromPage(String locator, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = screenName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName + ".properties").getProperty(locator);
        String Value = "";
        Value = commonPage.getElementValue(locator, screenName, Value);
    }

    private String endpoint;
    private int expectedHttpCode;
    private Response response;

    @ParameterType(".*?")
    public int httpCode(String code) {
        return Integer.parseInt(code.trim());
    }

    @Given("I should see response code {int} for the requested API {string}")
    public void setEndpointAndExpectedHttpCode(int httpCode, String url) throws Exception {
        url = commonPage.getpropertyName(url);
        url = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(url);
        expectedHttpCode = httpCode;
        endpoint = url;
    }

    @When("I send a GET request to the API")
    public void sendGetRequestToApi() {
        response = RestAssured.get(endpoint);
    }

    @Then("I should receive the expected response code")
    public void verifyResponseCode() {
        int actualHttpCode = response.getStatusCode();
        assert actualHttpCode == expectedHttpCode : "Expected HTTP code: " + expectedHttpCode + ", Actual HTTP code: " + actualHttpCode;
    }

    @And("I send a GET Request to {string} on {string}")
    public void userSendGETRequest(String endPoint, String baseURL) throws Exception {
        //User //QA API Base Url

        String baseUrl = commonPage.getpropertyName(baseURL);
        //QA.API.Base.Url
        baseUrl = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(baseUrl);
        String endpoint = commonPage.getpropertyName(endPoint);
        String url = new PropertyLoaderFactory().getTestDataPropertyFile("EndPoints.properties").getProperty(endpoint);
        CommonPageFactory.GETRequest(baseUrl + url);
    }

    @And("I verify the status code {string}")
    public void userVerifyStatusCode(String statusCode) throws Exception {

        CommonPageFactory.getStatusCode(statusCode);

    }

    @And("I verify {string} with {string}")
    public void userVerifyboth(String actual,String expected) throws Exception {
        actual = commonPage.getpropertyName(actual);
        actual = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(actual);
        try {
            CommonPageFactory.validateFields(actual,expected);
            System.out.println("Assertion Passed: Strings are equal.");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: Strings are not equal.");
        }

    }

    @And("I send a POST Request to {string} on {string} having request body {string}")
    public void userSendPOSTRequest(String endPoint, String baseURL, String requestBody) throws Exception {


        String baseUrl = commonPage.getpropertyName(baseURL);
        String bodyRequest = commonPage.removeSpaces(requestBody);
        baseUrl = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(baseUrl);
        String endpoint = commonPage.getpropertyName(endPoint);
        String url = new PropertyLoaderFactory().getTestDataPropertyFile("EndPoints.properties").getProperty(endpoint);
        if (Objects.equals(endPoint, "psw endpoint")) {
            commonPage.PSWTokenRequest(baseUrl+url,bodyRequest);
        }
        else {
            response= commonPage.POSTRequest(baseUrl + url, bodyRequest);
            ApiResponseUtils.saveResponseToJsonFile(response, bodyRequest);
        }
    }

    @And("I send a PATCH Request to {string} on {string} having request body {string}")
    public void userSendPATCHRequest(String endPoint , String baseURL , String requestBody) throws Exception {


        String baseUrl = commonPage.getpropertyName(baseURL);
        String bodyRequest = commonPage.removeSpaces(requestBody);
        baseUrl = new PropertyLoaderFactory().getPropertyFile(HarnessVariables.runPropFile).getProperty(baseUrl);
        String endpoint = commonPage.getpropertyName(endPoint);
        String url = new PropertyLoaderFactory().getTestDataPropertyFile("EndPoints.properties").getProperty(endpoint);
        response =commonPage.PATCHRequest(baseUrl+url,bodyRequest);
        ApiResponseUtils.saveResponseToJsonFile(response, "testing");
    }

    @And("Validate {string} from {string} JSON with {string} from {string} Page")
    public void loadDataFromJSON(String jsonPath , String requestBody, String testData, String screenName) throws Exception {

        screenName = commonPage.removeSpaces(screenName);
        testData = commonPage.getpropertyName(testData);
        String expectedValueOnScreen = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(testData);

        String jsonKeyValue = commonPage.getpropertyName(jsonPath);
        String jsonBodyPath = commonPage.removeSpaces(requestBody);
        // HarnessVariables.fbrSTRN is the variable if you want to reflect the result for it.
        String actualValueFromAPI = ApiResponseUtils.loadDataFromJson(jsonKeyValue, jsonBodyPath);
        System.out.println(actualValueFromAPI);

        Assert.assertEquals(expectedValueOnScreen, actualValueFromAPI);
    }

    @And("I Load data {string} from {string} JSON")
    public void loadDataFromJSON(String jsonPath , String requestBody) throws Exception {

        String jsonKeyValue = commonPage.getpropertyName(jsonPath).toUpperCase();
        String jsonBodyPath = commonPage.removeSpaces(requestBody);
        // HarnessVariables.fbrSTRN is the variable if you want to reflect the result for it.
        ApiResponseUtils.loadDataFromJson(jsonKeyValue, jsonBodyPath);
    }
    @And("Save {string} on {string}")
    public void saveText(String locator,String screenName) throws Exception {

        screenName = commonPage.removeSpaces(screenName);
        locator=commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = screenName+HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(screenName+".properties").getProperty(locator);
        String Value = "";
        Value = commonPage.getElementValue(locator,screenName,Value);
        if(locator.equals("XPATH_PAYMENT_SLIP")){
            HarnessVariables.paymentid = Value;
            commonPage.extractDataAndSaveInFile("Payment.ID",
                    Value,
                    "src/main/java/TestData/Subscribe.properties");
        }
        if(locator.equals("XPATH_APPLICATION_ID")){
            HarnessVariables.applicationid = Value;
            commonPage.extractDataAndSaveInFile("Application.ID",
                    Value,
                    "src/main/java/TestData/Subscribe.properties");
        }
        if(locator.equals("XPATH_USER_ID")){
            HarnessVariables.userid = Value;
            commonPage.extractDataAndSaveInFile("Username",
                    HarnessVariables.userid,
                    "src/main/java/TestData/Login.properties");
            }
        if(locator.equals("XPATH_STRN")){
            commonPage.extractDataAndSaveInFile("Fbr.Strn",
                    Value,
                    "src/main/java/TestData/Subscribe.properties");
        }
        if(locator.equals("XPATH_PRINCIPAL_ACTIVITY")){
            commonPage.extractDataAndSaveInFile("Principal.Activity",
                    Value,
                    "src/main/java/TestData/Subscribe.properties");
        }
    }
    @And("Fetch {string} from Database")
    public void DB_Query(String item) throws Exception {
        item = commonPage.getpropertyName(item);
        Properties queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
        String query = String.format(queries.getProperty(item), HarnessVariables.applicationid);
        // Execute the query and retrieve the results
        ResultSet rs = stmt.executeQuery(query);
        if (item.equals("OTP.sms")) {
            while (rs.next()) {
                String data = rs.getString("otpcode");
                AES obj1 = new AES("#PSW-OTP-KEY-123");
                HarnessVariables.SMS_OTP = obj1.soften(data);
                commonPage.extractDataAndSaveInFile("SMS.OTP",
                        HarnessVariables.SMS_OTP,
                        "src/main/java/TestData/Subscribe.properties");
            }
        }
        else if (item.equals("OTP.email")) {
            while (rs.next()) {
                String data = rs.getString("otpcode");
                AES obj1 = new AES("#PSW-OTP-KEY-123");
                HarnessVariables.Email_OTP = obj1.soften(data);
                commonPage.extractDataAndSaveInFile("Email.OTP",
                        HarnessVariables.Email_OTP,
                        "src/main/java/TestData/Subscribe.properties");
            }
        }
        else if (item.equals("Activation.URL")) {
            queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
            query = String.format(queries.getProperty(item), HarnessVariables.applicationid);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                HarnessVariables.Activation_URL = rs.getString("ActivationURL");
                commonPage.extractDataAndSaveInFile("Activation.URL",
                        HarnessVariables.Activation_URL,
                        "src/main/java/Configuration/run.properties");
                System.out.print("Activation URL:" + HarnessVariables.Activation_URL);
            }
        }
        else if (item.equals("Verification.Flag")) {
            queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
            query = String.format(queries.getProperty(item), HarnessVariables.NTN);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                HarnessVariables.Verification_Flag = rs.getString("VerificationFlag");
                commonPage.extractDataAndSaveInFile("Verification.Flag",
                        HarnessVariables.Verification_Flag,
                        "src/main/java/Configuration/run.properties");
                System.out.print("VERIFICATION FLAG:" + HarnessVariables.Verification_Flag);
            }
        }
    }

    @And("Update {string} from Database")
    public void DB_Update_Query(String item) throws Exception {
        item = commonPage.getpropertyName(item);
        Properties queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
        // Execute the query and retrieve the results
        if (item.equals("PSID.Date.Update")) {
            String trimmedPSID = commonPage.removeSixDigits(HarnessVariables.paymentid);
            String query = String.format(queries.getProperty(item), trimmedPSID);
            stmt.executeUpdate(query);
        }
        else {
            System.out.println("Update Query Execution Failed");
        }
    }

    @Given("User deletes a record from database for {string} for {string}")
    public void DeleteApplicationIDFromDataBase(String testData, String screenName) throws Exception {
        screenName = commonPage.removeSpaces(screenName);

        testData = commonPage.getpropertyName(testData);
        testData = new PropertyLoaderFactory().getTestDataPropertyFile(screenName + ".properties").getProperty(testData);
        HarnessVariables.NTN = testData;
        Properties queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
        String SQL = queries.getProperty("delete.records");
        SQL = String.format(SQL, HarnessVariables.NTN);

        try {
            stmt.executeUpdate(SQL);
        }
        catch(SQLException e){
            System.out.println("Not successful");
        }
    }
}
