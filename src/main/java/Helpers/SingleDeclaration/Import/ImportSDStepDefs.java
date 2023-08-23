package Helpers.SingleDeclaration.Import;

import Helpers.CommonPageFactory;
import Helpers.SingleDeclaration.Export.ExportSingleDeclaration;
import Helpers.Subscription.Login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.sql.Statement;

public class ImportSDStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Login login = new Login();
    ExportSingleDeclaration singleDeclaration = new ExportSingleDeclaration();
    ImportSingleDeclaration importSD = new ImportSingleDeclaration();


    public ImportSDStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    String locatorPageName = "Single Declaration";

    @And("User create Import SD with {string} cat and {string} Declaration with {string} Test Data")
    public void createImportSD(String consignmentCat, String declarationType, String testDataFileName) throws Exception {
        importSD.createImportDeclaration(consignmentCat, declarationType, testDataFileName, locatorPageName);
    }

    @And("User fills Import Consign Info with {string}, {string}, {string} with {string} Test Data")
    public void importConsignmentInformation(String blNUmber, String consignmentMode, String collectorate, String testDataFileName) throws Exception {
        importSD.importConsignmentInformation(blNUmber, consignmentMode, collectorate, testDataFileName, locatorPageName);
    }

    @And("User fills Import Financial Information with {string}, {string} & {string} with {string} Test Data")
    public void importFinancialInformation(String currency, String deliveryTerm, String modeOfPayment,String testDataFileName) throws Exception {
        importSD.importFinancialInformation(currency, deliveryTerm, modeOfPayment, testDataFileName, locatorPageName);
    }

    @And("User fills Import Commodities Info ** GI ** with {string} with {string} Test Data according to {string}")
    public void importCommoditiesInformationGeneralInformation(String hsCode, String testDataFileName, String agencies) throws Exception {
        importSD.importCommoditiesInformationGeneralInformation(hsCode, testDataFileName, locatorPageName, agencies);
    }

    @And("User fills Import Commodities Info ** SI ** with {string}, {string}, {string}, {string} with {string} Test Data")
    public void importCommoditiesInformationSupportingInformation(String quantity, String unitValue, String itemImportType, String origin, String testDataFileName) throws Exception {
        importSD.importCommoditiesInformationSupportingInformation(quantity, unitValue, itemImportType, origin, testDataFileName, locatorPageName);
    }

    @And("User fill Import Commodities Info ** OGA Req Info ** with {string} Test Data")
    public void importCommoditiesInformationOGARequiredInformation(String testDataFileName) throws Exception {
        importSD.importCommoditiesInformationOGARequiredInformation(testDataFileName, locatorPageName);
    }

    @And("User Upload Import Commodities Info ** Req Docs ** {string} with {string}, {string} locator with {string} Test Data")
    public void importCommoditiesInformationRequiredDocuments(String filename,String uploadbutton,String uploader, String testDataFileName) throws Exception {
        importSD.importCommoditiesInformationRequiredDocuments(filename, uploadbutton, uploader, testDataFileName, locatorPageName);
    }

    @And("User Save Import Commodities Info")
    public void importCommoditiesInformationSave() throws Exception {
        importSD.importCommoditiesInformationSave(locatorPageName);
    }

    @And("User Select {string} Item Structure in Import Commodities Info according to {string}")
    public void importCommoditiesInformationItemStructure(String attachItem, String agencies) throws Exception {
        importSD.importCommoditiesInformationItemStructure(attachItem, locatorPageName, agencies);
    }

    @And("User Proceed in Import Documents")
    public void importDocuments() throws Exception {
        importSD.importDocuments(locatorPageName);
    }

    @And("User Click Validate & Proceed in Import Review and Validate with {string}, {string} with {string} Test Data")
    public void importReviewAndValidate(String validateTitle, String validateText, String testDataFileName) throws Exception {
        importSD.importReviewAndValidate(validateTitle, validateText, testDataFileName, locatorPageName);
    }

    @And("User perform Pay Process with {string} Assert {string} with {string} Test Data")
    public void importPaymentProcedure(String paymentType, String validateTitle, String testDataFileName) throws Exception {
        importSD.importPaymentProcedure(paymentType, validateTitle, testDataFileName, locatorPageName);
    }
}
