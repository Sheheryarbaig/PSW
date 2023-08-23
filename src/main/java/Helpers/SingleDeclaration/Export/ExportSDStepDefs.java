package Helpers.SingleDeclaration.Export;

import Helpers.CommonPageFactory;
import Helpers.SingleDeclaration.Import.ImportSingleDeclaration;
import Helpers.Subscription.Login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.sql.Statement;

public class ExportSDStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    Login login = new Login();
    ExportSingleDeclaration singleDeclaration = new ExportSingleDeclaration();
    ImportSingleDeclaration importSD = new ImportSingleDeclaration();


    public ExportSDStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    String locatorPageName = "Single Declaration";

    @And("User performs Export Single Declaration with {string} Test Data")
    public void CreateExportSingleDeclaration(String testDataFileName) throws Exception {
    singleDeclaration.ExportSingleDeclaration(testDataFileName);
    }

    @Then("User fills Export Consignment Information with {string} and {string} and {string} with {string} Test Data")
    public void ExportConsignmentInformation(String ConsignmentMode,String Collectorate,String Shipping,String testDataFileName) throws Exception {
        singleDeclaration.ExportConsignmentInformation(ConsignmentMode,Collectorate,Shipping,testDataFileName);
    }
    @And("User fills Export Financial Information with {string},{string} & {string} with {string} Test Data")
    public void ExportFinancialInformation(String Delivery_Type,String currency,String Mode_of_payment,String testDataFileName) throws Exception {
        singleDeclaration.ExportFinancialInformation(Delivery_Type,currency,Mode_of_payment,testDataFileName);
    }
    @And("User fills Commodity Information with {string} {string} with {string} Test Data with {string}")
    public void ExportCommodityInformation(String Code,String ConsignmentMode,String testDataFileName,String Agencies) throws Exception {
        singleDeclaration.ExportCommodityInformation(Code,ConsignmentMode,testDataFileName,Agencies);
    }
    @And("User fills OGA Required Information with {string} {string} Test Data")
    public void ExportOGARequiredInformation(String Code,String testDataFileName) throws Exception {
        singleDeclaration.ExportOGARequiredInformation(Code,testDataFileName);
    }
    @And("User Upload Export Commodities Info ** Req Docs ** {string} with {string}, {string} locator with {string} Test Data")
    public void ExportCommoditiesInformationRequiredDocuments(String filename,String uploadbutton,String uploader, String testDataFileName) throws Exception {
        singleDeclaration.requiredocuments(filename, uploadbutton, uploader, testDataFileName);
    }
    @And("User uploads Document {string} with {string}, {string}, {string} locator with {string} Test Data")
    public void UploadDocument(String filename,String document_type,String uploadbutton,String uploader, String testDataFileName) throws Exception {
        singleDeclaration.UploadDocument(filename,document_type,uploadbutton,uploader,testDataFileName);
    }
    @Then("User review and validates with {string} Test Data")
    public void ReviewAndValidate( String testDataFileName) throws Exception {
        singleDeclaration.ReviewAndValidate(testDataFileName);
    }
    @Then("User review and validates with {string} Test Data with NON-OGA")
    public void ReviewValidate(String testDataFileName) throws Exception {
        singleDeclaration.reviewValidate(testDataFileName);
    }
    @Then("User completes Payment procedure with {string} Test Data")
    public void Paymentprocedure( String testDataFileName) throws Exception {
        singleDeclaration.Paymentprocedure(testDataFileName);
    }
    @And("User perform Export Pay Process with {string} Assert {string} with {string} Test Data")
    public void ExportPaymentProcedure(String paymentType, String validateTitle, String testDataFileName) throws Exception {
        singleDeclaration.ExportPaymentProcedure(paymentType, validateTitle, testDataFileName, locatorPageName);
    }
}
