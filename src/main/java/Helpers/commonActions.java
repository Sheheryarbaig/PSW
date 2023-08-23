package Helpers;

import Setup.Initialization.*;
import io.restassured.response.Response;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class commonActions extends CommonPageFactory {

    CommonPageFactory commonPage;
    Statement stmt;

    private String endpoint;
    private int expectedHttpCode;
    Response response;

    public commonActions() throws Exception {
        commonPage = new CommonPageFactory();
    }

    public void databaseSetupConn() throws Exception {
        // Load the JDBC driver
        Properties envVariable = new PropertyLoaderFactory().getEnvironmentPropertyFile("environment.properties");
        HarnessVariables.dbConnectionString = envVariable.getProperty("databaseConnString");
        HarnessVariables.dbUserName = envVariable.getProperty("databaseUsername");
        HarnessVariables.dbPassword = envVariable.getProperty("databasePassword");

        stmt = ConnectDatabase(HarnessVariables.dbConnectionString, HarnessVariables.dbUserName, HarnessVariables.dbPassword);
    }

    public void clickBtn(String locator, String locatorPageName) throws Exception {
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = locatorPageName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);
        try{
            commonPage.clickButton(locator, locatorPageName);
        }catch(Exception e)
        {
            commonPage.clickButton(locator, locatorPageName);
        }
    }

    public void enterText(String testData, String testDataPageName, String locator, String locatorPageName) throws Exception {
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        testDataPageName = commonPage.removeSpaces(testDataPageName);

        testData = commonPage.getpropertyName(testData);
        testData = new PropertyLoaderFactory().getTestDataPropertyFile(testDataPageName + ".properties").getProperty(testData);

        locator = commonPage.getpropertyName(locator);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);

        commonPage.textEnterField(testData, locator, locatorPageName);
    }

    public void assertion(String testData, String testDataPageName, String locator, String locatorPageName) throws Exception {
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        testDataPageName = commonPage.removeSpaces(testDataPageName);
        locator = commonPage.getpropertyName(locator);
        testData = commonPage.getpropertyName(testData);
        testData = new PropertyLoaderFactory().getTestDataPropertyFile(testDataPageName + ".properties").getProperty(testData);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);
        validateTextonScreen(testData, locator, locatorPageName);
    }

    public void checkboxBtn(String locator, String locatorPageName) throws Exception {
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = locatorPageName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);
        try{
            commonPage.checkboxButton(locator, locatorPageName);
        }catch(Exception e)
        {
            commonPage.checkboxButton(locator, locatorPageName);
        }
    }

    public void assertionByAttributValue(String valueToCheck, String natureOfValueAttribute, String attributeName, String locator, String locatorPageName) throws Exception {
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        locator = commonPage.getpropertyName(locator);
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);
        validateByValueAttribute(valueToCheck,
                natureOfValueAttribute,
                attributeName,
                locator,
                locatorPageName);
    }

    public void selectFileButton(String filename,String locator,String uploader,String locatorPageName) throws Exception{
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        uploader=commonPage.getpropertyName(uploader);
        locator = commonPage.getpropertyName(locator);
        HarnessVariables.kWebprop = locatorPageName + HarnessVariables.kWebprop;
        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(locator);
        uploader = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName + ".properties").getProperty(uploader);
        try{
            commonPage.clickButton(locator, locatorPageName);
        }catch(Exception e)
        {
            commonPage.clickButton(locator, locatorPageName);
        }
        commonPage.SelectFile(filename,locator,uploader,locatorPageName);

    }

    public void deleteNTNByQuery(String NTNNumber, String testDataPageName) throws Exception {
        databaseSetupConn();
        testDataPageName = commonPage.removeSpaces(testDataPageName);

        NTNNumber = commonPage.getpropertyName(NTNNumber);
        NTNNumber = new PropertyLoaderFactory().getTestDataPropertyFile(testDataPageName + ".properties").getProperty(NTNNumber);
        HarnessVariables.NTN = NTNNumber;
        Properties queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
        String SQL = queries.getProperty("delete.records");
        SQL = String.format(SQL, HarnessVariables.NTN);

        try {
            stmt.executeUpdate(SQL);
            System.out.println("NTN Delete Query Successfully Executed.");
        }
        catch(SQLException e){
            System.out.println("NTN Delete Query Execution Failed");
        }
        stmt.close();
    }

    public void postRequestAPI(String endPoint, String baseURL, String requestBody, String statusCode) throws Exception {
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
        CommonPageFactory.getStatusCode(statusCode);
    }

    public void extractAndSaveText(String keyForSavingData, String testDataFilePathForSaving, String locatorPageName, String locator) throws Exception {
        testDataFilePathForSaving = commonPage.removeSpaces(testDataFilePathForSaving);
        locatorPageName = commonPage.removeSpaces(locatorPageName);
        locator=commonPage.getpropertyName(locator);
        keyForSavingData = commonPage.getpropertyName(keyForSavingData);

        locator = new PropertyLoaderFactory().getLocatorPropertyFile(locatorPageName+".properties").getProperty(locator);
        String extractedValueFromWeb = "";
        extractedValueFromWeb = commonPage.getElementValue(locator, locatorPageName, extractedValueFromWeb);
        commonPage.extractDataAndSaveInFile(keyForSavingData, extractedValueFromWeb,
                    "src/main/java/TestData/"+testDataFilePathForSaving+".properties");
    }

    public void hardWait(int waitTime) throws Exception {
        WaitFactory.staticWait(waitTime);
    }

    public void fetchValueFromDBWithOneQueryParameter(String queryFetchKey, String columnLabel, String queryParameter, String testDataPageName, String testDataFilePathForSaving) throws Exception {
        databaseSetupConn();
        queryFetchKey = commonPage.getpropertyName(queryFetchKey);
        queryParameter = commonPage.getpropertyName(queryParameter);

        Properties queries = new PropertyLoaderFactory().getSQLPropertyFile("queries.properties");
        queryParameter = new PropertyLoaderFactory().getTestDataPropertyFile(testDataPageName+".properties").getProperty(queryParameter);

        String query = String.format(queries.getProperty(queryFetchKey), queryParameter);
        // Execute the query and retrieve the results

        try {
            ResultSet rs = stmt.executeQuery(query);
            if(queryFetchKey.contains("OTP")) {
                while (rs.next()) {
                    String data = rs.getString(columnLabel);
                    AES obj1 = new AES("#PSW-OTP-KEY-123");
                    String fetchedValue = obj1.soften(data);
                    hardWait(200);
                    commonPage.extractDataAndSaveInFile(queryFetchKey, fetchedValue,
                            "src/main/java/" + testDataFilePathForSaving + ".properties");
                }
            }
            else {
                while (rs.next()) {
                    String fetchedValue = rs.getString(columnLabel);
                    hardWait(200);
                    commonPage.extractDataAndSaveInFile(queryFetchKey, fetchedValue,
                            "src/main/java/" + testDataFilePathForSaving + ".properties");
                }
            }
            hardWait(200);
            System.out.println(queryFetchKey + " Query Successfully Executed.");

        }
        catch(SQLException e){
            System.out.println(queryFetchKey + " Query Execution Failed");
        }
        stmt.close();
    }

    public void refreshPageWithAlert(){
        try {
            UtilFactory.switchToAlertAccept();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
