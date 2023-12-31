package Helpers;

import Setup.Initialization.PropertyLoaderFactory;
import Setup.Initialization.UtilFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.core.gherkin.messages.internal.gherkin.GherkinDocumentBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

import static Setup.Initialization.PropertyLoaderFactory.convertJsonToFormParameters;
import static io.restassured.RestAssured.given;

import javax.swing.text.html.parser.Parser;
import java.io.FileReader;
import java.io.IOException;

public class CommonPageFactory extends UtilFactory {

    public static String EnumDirectory = "Locators.EnumFactory.*";
    public static String PageName;
    static Response Response;
    static Response POSTResponse;
    static String accessToken;
    static String PSID;

    static String NTN;

    static String APPID;
    static String amount;

    public CommonPageFactory() throws Exception {
    }

    //T0 Do Update Screen Name as to Read Properties
    Properties envVariable = new PropertyLoaderFactory().getEnvironmentPropertyFile("environment.properties");
    int passFlag = Integer.parseInt(envVariable.getProperty("passScreenshotEnable"));
    int failFlag = Integer.parseInt(envVariable.getProperty("failScreenshotEnable"));

    public String removeSpaces(String ScreenName) {
        PageName = ScreenName;
        String propertyFileName = ScreenName.replace(" ", "");
        return propertyFileName;
    }

    public String getpropertyName(String fieldProperty) {
        String propertyFileName = fieldProperty.replace(" ", ".");
        return propertyFileName;
    }

    public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public void textEnterField(String textToEnter, String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            if (!Locator.equals("XPATH_CHANNEL_REFERENCE_SEARCH")) {
                clearField(locator);
            }
            enterString(locator, textToEnter);
            LoggWithOrWithoutScreenshotFlag("Entered: " + getLocatorNameforLog(textToEnter) + " in " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");

        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Enter: " + getLocatorNameforLog(textToEnter) + " on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }
    }

    public void clickButton(String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitForPageLoad();
            waitFactory.waitForElementToBeClickable(locator);
            click(locator);
            LoggWithOrWithoutScreenshotFlag("Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }
    }

    public void SelectFile(String filename, String Locator, String uploader, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        uploader = locatorXpath(ScreenName, uploader);
        try {
            waitForPageLoad();
            waitFactory.waitForElementToBeClickable(locator);
            click(locator);
            uploadfile(filename, locator, uploader);
            LoggWithOrWithoutScreenshotFlag("Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }


    }

    public void checkboxButton(String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitForPageLoad();
            click(locator);
            LoggWithOrWithoutScreenshotFlag("Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }
    }

    public void JsclickButton(String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            jsClick(locator);
            LoggWithOrWithoutScreenshotFlag("Clicked on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }
    }

    public void validateFieldonScreen(String textToValidate, String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            String actualText = getText(locator);
            System.out.println("Expected" + textToValidate + "Actual" + actualText);
            Assert.assertEquals(textToValidate, actualText);
            LoggWithOrWithoutScreenshotFlag("Validated: " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Failed to Validate " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Fail");
            throw e;
        }
    }

    public void validateTextonScreen(String textToValidate, String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            String actualText = getTextFromElement(locator);
            Assert.assertEquals(textToValidate, actualText);
            LoggWithOrWithoutScreenshotFlag("Validated: " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Failed to Validate " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Fail");
            throw e;
        }
    }


    public void hoverOnButton(String Locator, String ScreenName) throws ClassNotFoundException, Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeVisible(locator);
            hover(locator);
            scenarioDef.log(Status.PASS, getLocatorNameforLog(Locator) + " is visible " + " on " + PageName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, getLocatorNameforLog(Locator) + " is not visible " + " on " + PageName + " Page.");
            throw e;
        }
    }

    public void validateValueAttributeScreen(String attribute, String textToValidate, String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            String actualText = getAttribute(locator, attribute);
            Assert.assertEquals(textToValidate, actualText);
            scenarioDef.log(Status.PASS, "Validated: " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, "Failed to Validate " + getLocatorNameforLog(textToValidate) + " visible as " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.");
            throw e;
        }
    }

    public void validateDynamicElementOnScreen(String Locator, String testData, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator) + testData + "')]";
        try {
            waitFactory.waitForElementToBeVisible(locator);
            scenarioDef.log(Status.PASS, getLocatorNameforLog(Locator) + " is visible  on " + ScreenName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, getLocatorNameforLog(Locator) + " is not visible  on " + ScreenName + " Page.");
            throw e;
        }
    }

    public static void validateFields(String expected, String actual) throws Exception {

        Assert.assertEquals(expected, actual);

    }

    public void validateElementOnScreen(String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeVisible(locator);
            scenarioDef.log(Status.PASS, getLocatorNameforLog(Locator) + " is visible  on " + ScreenName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, getLocatorNameforLog(Locator) + " is not visible  on " + ScreenName + " Page.");
            throw e;
        }
    }

    public void validateDynamicString(String productNameLocator, String productName, String productPrice, String expectedValue, String ScreenName) throws Exception {
        String Locator = locatorXpath(ScreenName, productNameLocator) + productName + "')]";
        Locator = Locator + locatorXpath(ScreenName, productPrice);
        try {
            waitFactory.waitForElementToBeVisible(Locator);
            String actualText = getText(Locator);
            if (actualText.contains(expectedValue)) {
                scenarioDef.log(Status.PASS, "Validated Dollar Symbol in Product Price " + actualText + " on " + ScreenName + "Page.");
            } else {
                scenarioDef.log(Status.PASS, "Dollar Symbol is not visible in Product Price " + actualText + " on " + PageName);
            }
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, getLocatorNameforLog(Locator) + " is not visible  on " + PageName + " Page.");
            throw e;
        }

    }

    public void clickOnDynamicElement(String Locator1, String dynamicData, String Locator2, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator1) + dynamicData + "')]";
        locator = locator + locatorXpath(ScreenName, Locator2);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            click(locator);
            scenarioDef.log(Status.PASS, "Clicked on " + getLocatorNameforLog(Locator2) + " Field on " + PageName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, "Could not Click on " + getLocatorNameforLog(Locator2) + " Field on " + PageName + " Page.");
            throw e;
        }
    }

    public void validateDynamicElementColorOnHover(String Locator1, String dynamicData, String Locator2, String colorToValidate, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator1) + dynamicData + "')]";
        locator = locator + locatorXpath(ScreenName, Locator2);
        try {
            waitFactory.waitForElementToBeVisible(locator);
            hover(locator);
            Thread.sleep(5000);
            String actualColor = getCSS(locator, "background-color");
            System.out.println(actualColor);
            Assert.assertEquals(colorToValidate, actualColor);
            scenarioDef.log(Status.PASS, "Validated Color of " + getLocatorNameforLog(Locator2) + " Element on Hovering  at " + PageName + " Page.");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, "Could not validate color of " + getLocatorNameforLog(Locator2) + " Element on Hovering  at " + PageName + " Page.");
            throw e;
        }
    }

    public void validatePageURL(String expectedText, String screenName) {
        try {
            validateURL(expectedText);
            scenarioDef.log(Status.PASS, "Navigated to " + PageName + " Page");
        } catch (Exception e) {
            failureException = e.toString();
            scenarioDef.log(Status.FAIL, "Could not navigate to " + PageName + " Page");
            throw e;
        }

    }

    public String getElementValue(String Locator, String ScreenName, String Value) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            waitFactory.waitForElementToBeClickable(locator);
            Value = getText(locator);

            if (locator.equals("//*[@id=\"sub-fee-slip-subscriptionFees-data\"]/strong")) {
                PSID = Value;
            }
            if (locator.equals("(//*[@id=\"sub-fee-slip-subscriptionFees-data\"])[2]")) {
                amount = Value;
                amount = convertamount(amount);
            }
            if (locator.equals("(//*[@id=\"sub-fee-slip-applicationID-data\"])[1]")) {
                APPID = Value;
            }
            LoggWithOrWithoutScreenshotFlag("Clicked on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Could not Click on " + getLocatorNameforLog(Locator) + " Field on " + PageName + " Page.", "Fail");
            throw e;
        }
        return Value;
    }

    public static String convertamount(String input) {
        // Remove "PKR" and spaces from the input
        String numberString = input.replaceAll("[^0-9]", "");

        // Convert the number string to an integer
        int number = Integer.parseInt(numberString);

        // Calculate the length of the number string
        int length = numberString.length();

        // Determine the number of prefix zeros based on the length
        int prefixZeros = 15 - length - 4; // Total length is 15 (2 suffix zeros + 1 for digit + 12 prefix zeros)

        // Create the output string with prefix zeros, number, and suffix zeros
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < prefixZeros; i++) {
            output.append("0");
        }
        output.append(number);
        output.append("00"); // Add two suffix zeros

        return output.toString();
    }

    public static String removeSixDigits(String input) {
        if (input.length() <= 6) {
            return "";
        }
        return input.substring(6);
    }

    // [1:08 PM] Muhammed Hamza Shahab

    public static Response GETRequest(String APIUrl) throws IOException {
        Response =
                given().
                        when().
                        get(APIUrl);
        ResponseBody body = Response.getBody();
        return Response;
    }

    public static void getStatusCode(String code) throws IOException {
        int get_response = Response.getStatusCode();
        int status = Integer.parseInt(code);
        Assert.assertEquals(status, get_response);

    }

    public static Response POSTRequest(String APIUrl, String APIBody) throws Exception {
        JSONObject requestBody = PropertyLoaderFactory.getRequestFile(APIBody);
        // Retrieve the inner JSON object 'data'
        if (APIUrl.equals("http://qa.psw.gov.pk/api/ups/PSID/secure")) {
            JSONObject dataObject = (JSONObject) requestBody.get("data");

            // Update the 'psid' value in the 'data' object
            dataObject.put("psid", PSID);
            dataObject.put("transaction_amount", amount);
        }
        if (APIUrl.equals("http://qa.psw.gov.pk/api/auth/EDI/open")) {
            JSONObject dataObject = (JSONObject) requestBody.get("data");

            // Update the 'psid' value in the 'data' object
            dataObject.put("applicationId", APPID);
        }
        if (APIUrl.equals("https://gw.fbr.gov.pk/psw/1/details")) {
            requestBody.put("IDENTIFICATION_NO", HarnessVariables.NTN);
            String bearerToken = new PropertyLoaderFactory().getPropertyFile("environment.properties").getProperty("fbr.strn.token");
            accessToken = bearerToken;
        }

        Response =
                given().
                        header("Content-type", "application/json").
                        header("Authorization", "Bearer " + accessToken).
                        body(requestBody).
                        when().
                        post(APIUrl);
        return Response;
    }

    public static Response PSWTokenRequest(String APIUrl, String APIBody) throws Exception {
        JSONObject requestBody = PropertyLoaderFactory.getRequestFile(APIBody);
        String requestbody = convertJsonToFormParameters(requestBody);
        Response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=utf-8")
                        .body(requestbody)
                        .when().
                        post(APIUrl);
        String responseBody = Response.getBody().asString();
        accessToken = Response.jsonPath().getString("access_token");
        ResponseBody body1 = Response.getBody();
        return Response;
    }

    public static Response PATCHRequest(String APIUrl, String APIBody) throws Exception {
        JSONObject requestBody = PropertyLoaderFactory.getRequestFile(APIBody);

        Response =
                given().
//                        header("Content-type", "application/json").
        body(requestBody).
                        when().
                        patch(APIUrl);
        ResponseBody body = Response.getBody();
        return Response;
    }

    public static void extractDataAndSaveInFile(String keyToUpdate, String valueSave, String filePath) throws Exception {
        // Create Properties object
        Properties properties = new Properties();

        // Load existing properties from the file
        properties.setProperty(keyToUpdate, valueSave);

        File file = new File(filePath);
        File tempFile = new File(filePath + ".tmp");
        Thread.sleep(400);

        try (InputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
        }

        properties.setProperty(keyToUpdate, valueSave);
        Thread.sleep(400);


        try (OutputStream outputStream = new FileOutputStream(tempFile)) {
            Thread.sleep(400);
            for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements(); ) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                outputStream.write((key + "=" + value + System.lineSeparator()).getBytes());
            }
        }

        if (!file.delete() || !tempFile.renameTo(file)) {
            throw new IOException("Failed to update property in the file");
        }
    }

    public static Statement ConnectDatabase(String ConnectionString, String username, String Password)
            throws SQLException {
        Statement stmt = null;

        String connectionUrl = "jdbc:sqlserver://" + ConnectionString + ";databaseName=AUTH;user=" + username
                + ";password=" + Password;
        Connection con = DriverManager.getConnection(connectionUrl);
        stmt = con.createStatement();
        if (stmt != null) {
            System.out.println("Database Connection Sucessfull");
        }
        return stmt;
    }

    public void LoggWithOrWithoutScreenshotFlag(String message, String status) throws Exception {
        if (passFlag == 1 && status.equals("Pass")) {
            scenarioDef.log(Status.PASS, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
        } else if (passFlag == 0 && status.equals("Pass")) {
            scenarioDef.log(Status.PASS, message);
        } else if (failFlag == 1 && status.equals("Fail")) {
            scenarioDef.log(Status.FAIL, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
        } else if (failFlag == 0 && status.equals("Fail")) {
            scenarioDef.log(Status.FAIL, message);
        }
    }

    public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));

    }

    public void validateByValueAttribute(String valueToCheck, String natureOfValueAttribute, String attributeName, String Locator, String ScreenName) throws Exception {
        String locator = locatorXpath(ScreenName, Locator);
        try {
            String extractedAttributeValue = getAttributeFromElement(locator, attributeName);
            if(natureOfValueAttribute.equals("Greater Than") || natureOfValueAttribute.equals(">")) {
                double attributeValue = Double.parseDouble(extractedAttributeValue);
                double convertedValue = Double.parseDouble(valueToCheck);
                Assert.assertTrue("Value should be greater than "+valueToCheck, attributeValue > convertedValue);
            }
            else if(natureOfValueAttribute.equals("Less Than") || natureOfValueAttribute.equals("<")) {
                double attributeValue = Double.parseDouble(extractedAttributeValue);
                double convertedValue = Double.parseDouble(valueToCheck);
                Assert.assertTrue("Value should be less than "+valueToCheck, attributeValue < convertedValue);
            }
            else if(natureOfValueAttribute.equals("Equals To") || natureOfValueAttribute.equals("=")) {
                Assert.assertEquals(valueToCheck, extractedAttributeValue);
            }
            LoggWithOrWithoutScreenshotFlag("Validated: " + getLocatorNameforLog(attributeName) + " has correct " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Pass");
        } catch (Exception e) {
            failureException = e.toString();
            LoggWithOrWithoutScreenshotFlag("Failed to Validate " + getLocatorNameforLog(attributeName) + " has correct " + getLocatorNameforLog(Locator) + " on " + PageName + " Page.", "Fail");
            throw e;
        }

    }
}

