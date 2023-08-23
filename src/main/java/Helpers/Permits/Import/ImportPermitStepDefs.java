package Helpers.Permits.Import;

import Helpers.CommonPageFactory;
import Helpers.SingleDeclaration.Export.ExportSingleDeclaration;
import Helpers.Subscription.Login;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;

import java.sql.Statement;

public class ImportPermitStepDefs {

    CommonPageFactory commonPage;
    private ExtentReports extentReport;
    private ExtentTest extentTest;
    Statement stmt;
    ImportPermit importPermit = new ImportPermit();


    public ImportPermitStepDefs() throws Exception {
        commonPage = new CommonPageFactory();
    }
    String locatorPageName = "Permits";



    @And("User start creating Import Permit")
    public void createImportPermit() throws Exception {
        importPermit.createImportPermit(locatorPageName);
    }

    @And("User fill Import Permit Consignment Info {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} with {string} Test Data")
    public void importPermitConsignmentInfo(String agency,
                                            String destCity,
                                            String agencySites,
                                            String countryOfOrigin,
                                            String importingFrom,
                                            String portOfEntry,
                                            String portOfLoading,
                                            String  meansOfTransportation,
                                            String testDataFileName
    ) throws Exception {
        importPermit.importPermitConsignmentInfo(agency,
                destCity,
                agencySites,
                countryOfOrigin,
                importingFrom,
                portOfEntry,
                portOfLoading,
                meansOfTransportation,
                testDataFileName,
                locatorPageName);
    }

    @And("User fill Import Permit Consignment Info Exporter Details {string}, {string}, {string}, {string}, {string} with {string} Test Data")
    public void importPermitConsignmentInfoExporterInfo(String exporterName,
                                                        String exporterCountry,
                                                        String exporterEmail,
                                                        String exporterCellNo,
                                                        String exporterAdd,
                                                        String testDataFileName
    ) throws Exception {
        importPermit.importPermitConsignmentInfoExporterInfo(exporterName,
                exporterCountry,
                exporterEmail,
                exporterCellNo,
                exporterAdd,
                testDataFileName,
                locatorPageName);
    }

    @And("User Save and Proceed")
    public void importPermitSaveAndProceed() throws Exception {
        importPermit.importPermitSaveAndProceed(locatorPageName);
    }

    @And("User fill Import Permit Commodity Info with HC:{string}, PC:{string}, {string}, {string}, Q:{string}, NOP:{string}, {string}, {string} with {string} Test Data")
    public void importPermitCommodityInfo(String hsCode,
                                          String productCode,
                                          String declaredDescription,
                                          String purposeOfImport,
                                          String quantity,
                                          String noOfPackage,
                                          String packageType,
                                          String plantProduct,
                                          String testDataFileName
    ) throws Exception {
        importPermit.importPermitCommodityInfo(hsCode,
                productCode,
                declaredDescription,
                purposeOfImport,
                quantity,
                noOfPackage,
                packageType,
                plantProduct,
                testDataFileName,
                locatorPageName);
    }

    @And("User uploads Import Permit Doc in Document Info {string} with {string}, {string}, {string} locator with {string} Test Data")
    public void importPermitDocumentInfo(String documentType,
                                         String filename,
                                         String uploadBtn,
                                         String uploader,
                                         String testDataFileName)
            throws Exception {
        importPermit.importPermitDocumentInfo(documentType,
                filename,
                uploadBtn,
                uploader,
                testDataFileName,
                locatorPageName);
    }

    @And("User fill Import Permit Import Condition and Submit")
    public void importPermitImportCondition() throws Exception {
        importPermit.importPermitImportCondition(locatorPageName);
    }

    @And("User perform Import Permit Payment with {string}, {string} and Assert {string} with {string} Test Data")
    public void importPermitPaymentProcedure(String paymentType,
                                       String pdAccountCollectorate,
                                       String validateTitle,
                                       String testDataFileName)
            throws Exception {
        importPermit.importPermitPaymentProcedure(paymentType,
                pdAccountCollectorate,
                validateTitle,
                testDataFileName,
                locatorPageName);
    }

    @And("User fetch officer Username with {string} Test Data")
    public void importPermitFetchOfficerUserName(String testDataFileName)
            throws Exception {
        importPermit.importPermitFetchOfficerUserName(testDataFileName);
    }

    @And("I open Import Permit by Officer with {string} with {string} Test Data")
    public void openImportPermitInOfficer(String documentNo, String testDataFileName)
            throws Exception {
        importPermit.openImportPermitInOfficer(documentNo, testDataFileName, locatorPageName);
    }

}
