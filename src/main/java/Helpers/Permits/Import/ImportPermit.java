package Helpers.Permits.Import;

import Helpers.commonActions;
import Setup.Initialization.UtilFactory;

public class ImportPermit extends commonActions {

    commonActions actions;

    public ImportPermit() throws Exception {
        actions = new commonActions();
    }

    public void createImportPermit(String locatorPageName) throws Exception {
        actions.clickBtn("LPCO", locatorPageName);
        actions.clickBtn("Import Permit", locatorPageName);
        actions.assertion("Import Permit Text",
                "Permits",
                "Page Heading",
                locatorPageName);
        actions.clickBtn("Create Import Permit", locatorPageName);
        actions.assertion("Create Import Text",
                "Permits",
                "Page Heading",
                locatorPageName);
    }

    public void importPermitConsignmentInfo(String agency,
                                            String destCity,
                                            String agencySites,
                                            String countryOfOrigin,
                                            String importingFrom,
                                            String portOfEntry,
                                            String portOfLoading,
                                            String  meansOfTransportation,
                                            String testDataFileName,
                                            String locatorPageName)
            throws Exception {
        //agency selection
        actions.enterText(agency,
                testDataFileName,
                "Agency",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //city selection
        actions.enterText(destCity,
                testDataFileName,
                "Destination City",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.hardWait(500);

        //agency sites selection
        actions.clickBtn("Agency Sites", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText(agencySites,
                testDataFileName,
                "Agency Sites",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //Importer Name
        actions.clickBtn("Importer Name", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //Importer Address
        actions.clickBtn("Importer Address", locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //Country of origin
        actions.enterText(countryOfOrigin,
                testDataFileName,
                "Country Of Origin",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //Importing From
        actions.enterText(importingFrom,
                testDataFileName,
                "Importing From",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //port Of Entry
        actions.enterText(portOfEntry,
                testDataFileName,
                "Port Of Entry",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //port Of Loading
        actions.enterText(portOfLoading,
                testDataFileName,
                "Port Of Loading",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //Means of Transportation
        actions.enterText(meansOfTransportation,
                testDataFileName,
                "Means Of Transportation",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
    }

    public void importPermitConsignmentInfoExporterInfo(String exporterName,
                                            String exporterCountry,
                                            String exporterEmail,
                                            String exporterCellNo,
                                            String exporterAdd,
                                            String testDataFileName,
                                            String locatorPageName)
            throws Exception {
        //Exporter Name
        actions.enterText(exporterName,
                testDataFileName,
                "Exporter Name",
                locatorPageName);

        //exporter Country
        actions.enterText(exporterCountry,
                testDataFileName,
                "Exporter Country",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();
        actions.hardWait(500);

        //exporter Email
        actions.enterText(exporterEmail,
                testDataFileName,
                "Exporter Email",
                locatorPageName);

        //exporter cell number
        actions.enterText(exporterCellNo,
                testDataFileName,
                "Exporter Cell Number",
                locatorPageName);

        //exporter address
        actions.enterText(exporterAdd,
                testDataFileName,
                "Exporter Address",
                locatorPageName);
    }

    public void importPermitSaveAndProceed(String locatorPageName)
            throws Exception {
        actions.clickBtn("Save And Proceed", locatorPageName);
        actions.hardWait(7000);
    }

    public void importPermitCommodityInfo(String hsCode,
                                          String productCode,
                                          String declaredDescription,
                                          String purposeOfImport,
                                          String quantity,
                                          String noOfPackage,
                                          String packageType,
                                          String plantProduct,
                                          String testDataFileName,
                                          String locatorPageName)
            throws Exception {
        //select hs code
        actions.enterText(hsCode,
                testDataFileName,
                "HS Code",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //select product code
        actions.enterText(productCode,
                testDataFileName,
                "Product Code",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //fill declared description
        actions.enterText(declaredDescription,
                testDataFileName,
                "Declared Description",
                locatorPageName);

        //select purpose of import
        actions.clickBtn("Purpose Of Import", locatorPageName);
        UtilFactory.ControlA();
        actions.enterText(purposeOfImport,
                testDataFileName,
                "Purpose Of Import",
                locatorPageName);

        //fill quantity
        actions.enterText(quantity,
                testDataFileName,
                "Quantity",
                locatorPageName);

        //fill no of package
        actions.enterText(noOfPackage,
                testDataFileName,
                "No Of Package",
                locatorPageName);

        //select package type
        actions.enterText(packageType,
                testDataFileName,
                "Package Type",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //fill plant product
        actions.enterText(plantProduct,
                testDataFileName,
                "Plant Product",
                locatorPageName);
    }

    public void importPermitDocumentInfo(String documentType,
                                          String filename,
                                          String uploadBtn,
                                          String uploader,
                                          String testDataFileName,
                                          String locatorPageName)
            throws Exception {
        //select document type
        actions.enterText(documentType,
                testDataFileName,
                "Document Type",
                locatorPageName);
        UtilFactory.pressDown();
        UtilFactory.pressEnter();

        //upload file
        actions.selectFileButton(filename,
                uploadBtn,
                uploader,
                locatorPageName);
        actions.hardWait(3000);
    }


    public void importPermitImportCondition(String locatorPageName)
            throws Exception {
        //check consent
        actions.clickBtn("Consent", locatorPageName);
        actions.clickBtn("Submit", locatorPageName);
        actions.clickBtn("Yes", locatorPageName);
        actions.hardWait(3000);
    }

    public void importPermitPaymentProcedure(String paymentType,
                                             String pdAccountCollectorate,
                                             String validateTitle,
                                             String testDataFileName,
                                             String locatorPageName)
            throws Exception {

        //saving psid
        actions.extractAndSaveText("PSID",
                testDataFileName,
                locatorPageName,
                "PSID Text");

        //saving amount
        actions.extractAndSaveText("Payable.Amount",
                testDataFileName,
                locatorPageName,
                "Payable Amount Text");

        //saving document number
        actions.extractAndSaveText("Document.No",
                testDataFileName,
                locatorPageName,
                "Document No Text");

        //checking what is the payment mode
        if(paymentType.equals("PD Account")) {
            actions.clickBtn("PD Account Tab", locatorPageName);

            //selecting PD Account collectorate
            actions.enterText(pdAccountCollectorate,
                    testDataFileName,
                    "PD Account Collectorate",
                    locatorPageName);
            UtilFactory.pressDown();
            UtilFactory.pressEnter();

            actions.clickBtn("Confirm Payment", locatorPageName);
            actions.clickBtn("PD Popup Confirm", locatorPageName);
            actions.hardWait(1000);

            //validating message of successful payment
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

    public void importPermitFetchOfficerUserName(String testDataFileName)
            throws Exception {
        actions.hardWait(5000);
        //fetch officer username with query
        actions.fetchValueFromDBWithOneQueryParameter("Officer.Username",
                "UserName",
                "Document No",
                testDataFileName,
                "TestData/Login");
    }

    public void openImportPermitInOfficer(String documentNo, String testDataFileName,String locatorPageName) throws Exception {
        //select officer role
        actions.clickBtn("Officer Menu", locatorPageName);
        actions.clickBtn("Entomologist", locatorPageName);

        //open import permit screen
        actions.clickBtn("LPCO", locatorPageName);
        actions.clickBtn("Officer Import Permit", locatorPageName);
        actions.assertion("Import Permit Text",
                "Permits",
                "Page Heading",
                locatorPageName);

        //search import permit doc no
        actions.enterText(documentNo,
                testDataFileName,
                "Search Box",
                locatorPageName);

        //assert import permit doc no
        actions.assertion(documentNo,
                testDataFileName,
                "Assert Search Result Officer",
                locatorPageName);

        //open import permit by doc no
        actions.clickBtn("First Row", locatorPageName);
    }


}
