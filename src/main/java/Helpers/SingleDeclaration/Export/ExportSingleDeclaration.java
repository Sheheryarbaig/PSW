package Helpers.SingleDeclaration.Export;

import Helpers.CommonPageFactory;
import Helpers.commonActions;
import Setup.Initialization.UtilFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ExportSingleDeclaration extends commonActions {

    commonActions actions;

    public ExportSingleDeclaration() throws Exception {
        actions = new commonActions();
    }
    public void ExportSingleDeclaration(String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";
        Export(testDataFileName,locatorPageName);

    }
    public void ExportConsignmentInformation(String ConsignmentMode,String Collectorate,String Shipping,String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";
        Consignment_information(ConsignmentMode,Collectorate,Shipping,testDataFileName,locatorPageName);
        if (ConsignmentMode.equals("LCL") || ConsignmentMode.equals("Air LCL"))
        {
            packages_information(testDataFileName,locatorPageName);
        }


    }



    public void ExportFinancialInformation(String Delivery_Type,String currency,String Mode_of_payment,String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";
        Financial_information(Delivery_Type,currency,Mode_of_payment,testDataFileName,locatorPageName);

    }
    public void ExportCommodityInformation(String Code,String ConsignmentMode,String testDataFileName,String Agencies) throws Exception {

        String locatorPageName = "SingleDeclaration";
        Commodity_information(testDataFileName,locatorPageName);
        if (ConsignmentMode.equals("Containerized"))
        {
            ContainerInformation(testDataFileName,locatorPageName);
        }
        else if  (ConsignmentMode.equals("Open Truck")){
            VehicleInformation(testDataFileName,locatorPageName);
        }
        else {
            Quantity_Assessment(testDataFileName,locatorPageName);

        }

        Commodity_information_OGA(Code,testDataFileName,locatorPageName,Agencies);
        Supporting_Information(testDataFileName,locatorPageName);
        if(Code.equals("NON-OGA Code")){
            SaveAndProceed(locatorPageName);
        }

    }

    public void ExportOGARequiredInformation(String Code,String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";
        if(Code.equals("AQD OGA")){
            OGARequired_Information_AQF(testDataFileName, locatorPageName);
        }
        else {
            OGARequired_Information(testDataFileName, locatorPageName);
            //document(testDataFileName,locatorPageName);
        }
    }
    public void UploadDocument(String filename,String document_type,String uploadbutton,String uploader,String testDataFileName) throws Exception {
        String locatorPageName = "SingleDeclaration";
        document(document_type,testDataFileName,locatorPageName);
        actions.selectFileButton(filename,uploadbutton,uploader,locatorPageName);
       // actions.clickBtn("proceed", locatorPageName);
    }
    public void requiredocuments(String filename,String uploadbutton,String uploader,String testDataFileName) throws Exception {
        String locatorPageName = "SingleDeclaration";
        Required_Document(filename,uploadbutton,uploader,testDataFileName,locatorPageName);
        }

    public void ReviewAndValidate(String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";
        ReviewValidate(testDataFileName,locatorPageName);

    }
    public void Paymentprocedure(String testDataFileName) throws Exception {

        String locatorPageName = "SingleDeclaration";

        procedure(testDataFileName,locatorPageName);

    }
    private void Quantity_Assessment(String testDataFileName, String locatorPageName) throws Exception {
        actions.enterText("Quantity", testDataFileName, "Quantity Assessment", locatorPageName);
    }
    private void packages_information(String testDataFileName, String locatorPageName) throws Exception {
        actions.enterText("comment", testDataFileName, "Marks", locatorPageName);
        actions.enterText("Qasim Freight Station", testDataFileName, "Location", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Add Packages", locatorPageName);
        actions.enterText("No of Packages", testDataFileName, "Number Of Packages", locatorPageName);
        actions.enterText("Package Type", testDataFileName, "Package Type", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Add", locatorPageName);
        actions.clickBtn("Save And Proceed", locatorPageName);

    }
    private void procedure(String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("Save and Submit", locatorPageName);
    }

    private void ReviewValidate(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("proceed", locatorPageName);
        actions.enterText("Karachi", testDataFileName, "City", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Jinnah Airport", testDataFileName, "Site", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Validate & Proceed", locatorPageName);
    }
    void reviewValidate( String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("proceed", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("Validate & Proceed", locatorPageName);
    }

    private void OGARequired_Information(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("OGA Information", locatorPageName);
        actions.hardWait(10000);
        actions.enterText("Consumption", testDataFileName, "Purpose of Export", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.enterText("Fumigation-test", testDataFileName, "Treatment Provided Company", locatorPageName);
        actions.enterText("Plantae", testDataFileName, "Botanical Name", locatorPageName);
        actions.clickBtn("Get Documentary Requirement", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("Save", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("proceed", locatorPageName);
    }
    private void SaveAndProceed(String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("Save", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("proceed", locatorPageName);

    }
    private void OGARequired_Information_AQF(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("OGA Information", locatorPageName);
        actions.hardWait(10000);
        actions.enterText("Animal Product", testDataFileName, "Category", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.clickBtn("Quantity Fee", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText("2000", testDataFileName, "Quantity Fee", locatorPageName);
        actions.enterText("Beef Quarter", testDataFileName, "Packing Unit", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Ambient", testDataFileName, "Temperature Type", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Celsius", testDataFileName, "Temperature Unit", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Description", testDataFileName, "Package Distribution", locatorPageName);
        actions.clickBtn("Get Documentary Requirement", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("Save", locatorPageName);
        actions.hardWait(10000);
//        actions.clickBtn("proceed", locatorPageName);
    }
    private void Required_Document(String fileName, String uploadButton, String uploader, String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("Required Documents", locatorPageName);
        actions.clickBtn("Upload Document Registered Export", locatorPageName);
        actions.hardWait(2000);
        actions.selectFileButton(fileName, uploadButton, uploader, locatorPageName);
        actions.hardWait(2000);
        actions.clickBtn("Save", locatorPageName);
        actions.clickBtn("proceed", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("proceed", locatorPageName);

    }

    private void document(String document_type,String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.enterText(document_type, testDataFileName, "Document Type", locatorPageName);
        UtilFactory.pressEnter();

    }
    private void Commodity_information(String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("Add Commodity", locatorPageName);
        actions.hardWait(10000);
    }
    private void ContainerInformation(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Add Container", locatorPageName);
        actions.enterText("Container Number", testDataFileName, "Container Number", locatorPageName);
        actions.clickBtn("Quantity", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText("Quantity", testDataFileName, "Quantity", locatorPageName);
        actions.enterText("No of Packages", testDataFileName, "Packages", locatorPageName);
        actions.enterText("Package Type", testDataFileName, "Package Type", locatorPageName);
        actions.clickBtn("Add", locatorPageName);
        actions.clickBtn("Yes Button", locatorPageName);
    }
    private void VehicleInformation(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Add Container", locatorPageName);
        actions.enterText("Vehicle driver CNIC", testDataFileName, "Vehicle driver CNIC", locatorPageName);
        actions.clickBtn("Quantity", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText("Quantity", testDataFileName, "Quantity", locatorPageName);
        actions.enterText("No of Packages", testDataFileName, "Packages", locatorPageName);
        actions.enterText("Package Type", testDataFileName, "Package Type", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Vehicle Registration Country", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.clickBtn("Registration Authority", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        actions.enterText("Vehicle driver CNIC", testDataFileName, "Vehicle Number", locatorPageName);
        actions.enterText("Vehicle driver CNIC", testDataFileName, "Vehicle Driver Passport Number", locatorPageName);
        actions.clickBtn("Add", locatorPageName);
        actions.clickBtn("Yes Button", locatorPageName);
    }

    private void Commodity_information_OGA(String Code,String testDataFileName, String locatorPageName,String Agencies) throws Exception {

        actions.enterText(Code, testDataFileName, "HS Code", locatorPageName);
        actions.hardWait(1000);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        if(Agencies.equals("OGA")){
            actions.clickBtn("Product Code", locatorPageName);
//            actions.enterText("Product Code", testDataFileName, "Product Code", locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
            actions.enterText("Description", testDataFileName, "Description", locatorPageName);
            actions.enterText("Unit Value", testDataFileName, "Unit Value", locatorPageName);
        } else if (Agencies.equals("Non-OGA")) {
            actions.enterText("Description", testDataFileName, "Description", locatorPageName);
            actions.enterText("Unit Value", testDataFileName, "Unit Value", locatorPageName);
        }
        else if (Agencies.equals("DPP")) {
            actions.enterText("Product Code", testDataFileName, "Product Code", locatorPageName);
            UtilFactory.pressEnter();
            actions.enterText("Description", testDataFileName, "Description", locatorPageName);
            actions.enterText("Unit Value", testDataFileName, "Unit Value", locatorPageName);
        }


    }
    private void Supporting_Information(String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Supporting Infomation", locatorPageName);
        actions.enterText("Quantity", testDataFileName, "Supporting Quantity", locatorPageName);


    }


    private void Financial_information(String Delivery_Type,String currency,String Mode_of_payment,String testDataFileName, String locatorPageName) throws Exception {
        actions.enterText(currency, testDataFileName, "Currency", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText(Delivery_Type, testDataFileName, "Delivery Term", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Al Baraka Bank", testDataFileName, "Bank", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("IBAN", testDataFileName, "IBAN", locatorPageName);
        UtilFactory.pressEnter();
        actions.hardWait(1000);
        actions.enterText(Mode_of_payment, testDataFileName, "Mode of Payment", locatorPageName);
        actions.hardWait(1000);
        UtilFactory.pressEnter();
        actions.clickBtn("Add", locatorPageName);
        actions.clickBtn("Save And Proceed", locatorPageName);
    }


    private void Consignment_information(String ConsignmentMode,String Collectorate,String Shipping,String testDataFileName, String locatorPageName) throws Exception {
        actions.enterText(Collectorate, testDataFileName, "Collectorate", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Consignment Mode", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText(ConsignmentMode, testDataFileName, "Consignment Mode", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.enterText("Consignor Name", testDataFileName, "Consignor Name", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Consignor Address", testDataFileName, "Consignor Address", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Consignee Name", testDataFileName, "Consignee Name", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Consignee Address", testDataFileName, "Consignee Address", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Port Qasim Export", testDataFileName, "Port Shipment", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Pakistan", testDataFileName, "Destination", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Port Discharge", testDataFileName, "Port Discharge", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.enterText("Consignee Address", testDataFileName, "Delivery", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText(Shipping, testDataFileName, "Shipping", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Gross Weight", testDataFileName, "Gross Weight", locatorPageName);
        actions.enterText("Net Weight", testDataFileName, "Net Weight", locatorPageName);
        if (ConsignmentMode.equals("Air LCL")){
            actions.enterText("DHL", testDataFileName, "Location", locatorPageName);
            UtilFactory.pressEnter();
            actions.enterText("DHL", testDataFileName, "General Description", locatorPageName);
        }
        else if(ConsignmentMode.equals("Open Truck")){
            actions.clickBtn("Location", locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
            actions.clickBtn("Terminal", locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
            actions.enterText("comment", testDataFileName, "Marks", locatorPageName);

        }
        else {
            actions.enterText("Qasim International Container Terminal", testDataFileName, "Location", locatorPageName);
            UtilFactory.pressEnter();
            actions.enterText("Qasim International Container Terminal", testDataFileName, "Terminal", locatorPageName);
            UtilFactory.pressEnter();
        }
        actions.clickBtn("Save And Proceed", locatorPageName);

    }

    public void Export(String testDataFileName,String locatorPageName) throws Exception {
        actions.clickBtn("Single Declaration", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("Export SD", locatorPageName);
        actions.hardWait(10000);
        actions.enterText("Commercial", testDataFileName, "Consignment Category", locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Declaration", testDataFileName, "Declaration Type", locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Confirm", locatorPageName);
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
    public void ExportPaymentProcedure(String paymentType, String validateTitle, String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Save And Submit", locatorPageName);
        actions.hardWait(3000);
        actions.extractAndSaveText("PSID",
                testDataFileName,
                locatorPageName,
                "PSID Text");
        actions.extractAndSaveText("Payable.Amount",
                testDataFileName,
                locatorPageName,
                "Payable Amount Text");

        if(paymentType.equals("PD Account")) {
            actions.clickBtn("PD Account", locatorPageName);
            actions.enterText("Karachi Custom", testDataFileName, "Collectorate", locatorPageName);
            UtilFactory.pressEnter();
            actions.clickBtn("Confirm Payment", locatorPageName);
            actions.clickBtn("PD Popup Confirm", locatorPageName);
            actions.hardWait(1000);
            actions.assertion(validateTitle,
                    testDataFileName,
                    "Payment Successful",
                    locatorPageName);
            actions.clickBtn("Ok", locatorPageName);
        }
        else if (paymentType.equals("ADC")) {
            System.out.println("Currently Nothing to perform");
        }

    }
}
