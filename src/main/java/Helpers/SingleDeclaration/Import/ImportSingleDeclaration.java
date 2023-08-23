package Helpers.SingleDeclaration.Import;

import Helpers.CommonPageFactory;
import Helpers.commonActions;
import Setup.Initialization.UtilFactory;
import org.apache.tools.ant.types.selectors.SelectSelector;

public class ImportSingleDeclaration extends commonActions {

    commonActions actions;

    public ImportSingleDeclaration() throws Exception {
        actions = new commonActions();
    }

    public void createImportDeclaration(String consignmentCat, String declarationType, String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Single Declaration", locatorPageName);
        actions.hardWait(10000);
        actions.clickBtn("Import SD", locatorPageName);
        actions.hardWait(20);
        actions.enterText(consignmentCat,
                testDataFileName,
                "Consignment Category",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText(declarationType,
                testDataFileName,
                "Declaration Type",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Import Confirm", locatorPageName);
    }

    public void importConsignmentInformation(String blNo, String consignmentMode, String collectorate, String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(6000);
        actions.enterText(blNo,
                testDataFileName,
                "BL Number",
                locatorPageName);
        actions.clickBtn("Calendar", locatorPageName);
        actions.clickBtn("Today Date", locatorPageName);
        actions.clickBtn("VIR Search", locatorPageName);
        actions.clickBtn("VIR Row", locatorPageName);
        actions.clickBtn("Get IGM Info", locatorPageName);
        actions.clickBtn("Barter Quota", locatorPageName);
        if(consignmentMode.equals("Containerized")) {
            actions.enterText(collectorate,
                    testDataFileName,
                    "Collectorate",
                    locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
        }
        else if(consignmentMode.equals("Air LCL")){
            actions.enterText(collectorate,
                    testDataFileName,
                    "Collectorate",
                    locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
        }
        else if(consignmentMode.equals("LCL")){
            actions.enterText(collectorate,
                    testDataFileName,
                    "Collectorate",
                    locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
        }
        actions.clickBtn("Consignee Name Select", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.assertionByAttributValue(consignmentMode,
                "Equals To",
                "value",
                "Import Consignment Mode",
                locatorPageName);
        actions.clickBtn("Save And Proceed", locatorPageName);
    }

    public void importFinancialInformation(String currency, String deliveryTerm, String modeOfPayment, String testDataFileName, String locatorPageName) throws Exception {
        actions.enterText(currency,
                testDataFileName,
                "Currency",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.hardWait(3000);
        actions.assertionByAttributValue("1",
                "Greater Than",
                "value",
                "Exchange Rate",
                locatorPageName);
        actions.enterText(deliveryTerm,
                testDataFileName,
                "Delivery Term",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("Al Baraka Bank",
                testDataFileName,
                "Bank",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText("IBAN",
                testDataFileName,
                "IBAN",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.enterText(modeOfPayment,
                testDataFileName,
                "Mode of Payment",
                locatorPageName);
        UtilFactory.pressEnter();
        actions.clickBtn("Add", locatorPageName);
        actions.enterText("Freight",
                testDataFileName,
                "Freight",
                locatorPageName);
        actions.enterText("Landing Charges",
                testDataFileName,
                "Landing Charges",
                locatorPageName);
        actions.hardWait(60);
        UtilFactory.scrollToTop();
        actions.clickBtn("Save And Proceed", locatorPageName);
    }

    public void importCommoditiesInformationGeneralInformation(String hsCode, String testDataFileName, String locatorPageName, String agencies) throws Exception {
        actions.hardWait(5000);
        actions.clickBtn("Add Commodity", locatorPageName);
        actions.enterText(hsCode,
                testDataFileName,
                "HS Code",
                locatorPageName);
        UtilFactory.pressEnter();
        if (agencies.equals("Non-OGA")) {
            actions.hardWait(500);
            actions.enterText("Description",
                    testDataFileName,
                    "Description",
                    locatorPageName);
        } else if(agencies.equals("DPP")){
            actions.hardWait(500);
            actions.clickBtn("Product Code", locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();
            actions.enterText("Description",
                    testDataFileName,
                    "Description",
                    locatorPageName);
        }
    }

    public void importCommoditiesInformationSupportingInformation(String quantity, String unitValue, String itemImportType, String origin, String testDataFileName, String locatorPageName) throws Exception {
            actions.hardWait(5000);
            actions.enterText("Description",
                    testDataFileName,
                    "Description",
                    locatorPageName);
            actions.hardWait(500);
            actions.clickBtn("Supporting Information", locatorPageName);
            actions.enterText(quantity,
                    testDataFileName,
                    "Quantity Assessment Purpose",
                    locatorPageName);
            actions.enterText(quantity,
                    testDataFileName,
                    "Quantity Statistical Purpose",
                    locatorPageName);
            actions.enterText(unitValue,
                    testDataFileName,
                    "Unit Value USD",
                    locatorPageName);
            actions.enterText(unitValue,
                    testDataFileName,
                    "Unit Value Invoice",
                    locatorPageName);
            actions.enterText(itemImportType,
                    testDataFileName,
                    "Item Import Type",
                    locatorPageName);
            UtilFactory.pressEnter();
            actions.enterText(origin,
                    testDataFileName,
                    "Origin",
                    locatorPageName);
            UtilFactory.pressEnter();
    }

    public void importCommoditiesInformationOGARequiredInformation(String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(5000);
        actions.clickBtn("OGA Information", locatorPageName);
        actions.enterText("Consumption", testDataFileName, "Purpose Of Import", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.enterText("Plantae", testDataFileName, "Scientific Name", locatorPageName);
        actions.checkboxBtn("Import Consent 1", locatorPageName);
        actions.checkboxBtn("Import Consent 2", locatorPageName);
        actions.clickBtn("Get Documentary Requirement", locatorPageName);
        actions.clickBtn("Save", locatorPageName);
        actions.hardWait(5000);
    }

    public void importCommoditiesInformationRequiredDocuments(String fileName, String uploadButton, String uploader, String testDataFileName, String locatorPageName) throws Exception {
        actions.clickBtn("Required Documents", locatorPageName);
        actions.clickBtn("Upload Document Btn", locatorPageName);
        actions.hardWait(2000);
        actions.selectFileButton(fileName, uploadButton, uploader, locatorPageName);
        actions.hardWait(2000);
    }

    public void importCommoditiesInformationSave(String locatorPageName) throws Exception {
            actions.hardWait(5000);
            actions.clickBtn("Save", locatorPageName);
    }

    public void importCommoditiesInformationItemStructure(String attachItem, String locatorPageName, String agencies) throws Exception {
        actions.hardWait(5000);
        if (agencies.equals("Non-OGA")) {
            actions.clickBtn("Item Structure", locatorPageName);
            actions.hardWait(5000);
            actions.checkboxBtn(attachItem, locatorPageName);
            actions.clickBtn("Submit Item Structure", locatorPageName);
        }
        else if(agencies.equals("DPP")) {
            actions.clickBtn("Item Structure", locatorPageName);
            actions.hardWait(5000);
            if(attachItem.equals("Not Applicable")) {
                actions.checkboxBtn("Not Applicable 1", locatorPageName);
                actions.checkboxBtn("Not Applicable 2", locatorPageName);
                actions.checkboxBtn("Not Applicable 3", locatorPageName);
                actions.checkboxBtn("Not Applicable 4", locatorPageName);
                actions.checkboxBtn("Not Applicable 5", locatorPageName);
                actions.checkboxBtn("Not Applicable 6", locatorPageName);
                actions.checkboxBtn("Not Applicable 7", locatorPageName);
                actions.checkboxBtn("Not Applicable 8", locatorPageName);
                actions.checkboxBtn("Not Applicable 9", locatorPageName);
                actions.clickBtn("Submit Item Structure", locatorPageName);
            }
            else {
                System.out.println("Nothing for Item Structure");
            }
        }
        actions.clickBtn("Proceed", locatorPageName);
    }

    public void importDocuments(String locatorPageName) throws Exception {
        actions.clickBtn("Proceed", locatorPageName);
    }

    public void importReviewAndValidate(String validateTitle, String validateText, String testDataFileName, String locatorPageName) throws Exception {
        actions.hardWait(10000);
        actions.clickBtn("Validate And Proceed", locatorPageName);
        actions.hardWait(3000);
        actions.assertion(validateTitle,
                testDataFileName,
                "Validate Title",
                locatorPageName);
        actions.assertion(validateText,
                testDataFileName,
                "Validate Text",
                locatorPageName);
        actions.clickBtn("Validate Ok", locatorPageName);
        actions.hardWait(3000);
    }

    public void importPaymentProcedure(String paymentType, String validateTitle, String testDataFileName, String locatorPageName) throws Exception {
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
