package Locators.EnumFactory;

public enum Permits {
    XPATH_LPCO_BTN("(//*[normalize-space()=\"LPCO\"])[8]"),
    XPATH_IMPORT_PERMIT_BTN("(//*[normalize-space()=\"Import Permits\"])[8]"),
    XPATH_CREATE_IMPORT_PERMIT_BTN("(//button[@type=\"button\"])[text()='Create Import Permit']"),
    XPATH_PAGE_HEADING("//p[@class=\"base-lg font-semibold\"]"),
    XPATH_CONSIGNMENT_INFO_TAB("//li[@class=\"k-item k-state-active k-tab-on-top\"]//span[text()='Consignment Information']"),
    XPATH_AGENCY("//input[@id=\"agency\"]"),
    XPATH_DESTINATION_CITY("//input[@id=\"demographicDestinationCity\"]"),
    XPATH_AGENCY_SITE("//input[@placeholder=\"Select Agency Site\"]"),
    XPATH_IMPORTER_NAME("//input[@id=\"importerConsigneeName\"]"),
    XPATH_IMPORTER_ADDRESS("//input[@id=\"importerConsigneeAddress\"]"),
    XPATH_EXPORTER_NAME("//input[@name=\"exporterName\"]"),
    XPATH_EXPORTER_COUNTRY("//input[@id=\"exporterCountry\"]"),
    XPATH_EXPORTER_EMAIL("//input[@id=\"exporterEmail\"]"),
    XPATH_EXPORTER_CELL_NUMBER("//input[@class=\"PhoneInputInput\"]"),
    XPATH_EXPORTER_ADDRESS("//input[@id=\"exporterAddress\"]"),
    XPATH_COUNTRY_OF_ORIGIN("//input[@id=\"countryLocalityOfOrigin\"]"),
    XPATH_IMPORTING_FROM("//input[@id=\"importedFrom\"]"),
    XPATH_PORT_OF_ENTRY("//input[@id=\"demographicPortOfEntry\"]"),
    XPATH_PORT_OF_LOADING("//input[@id=\"portOfForeginShipment\"]"),
    XPATH_MEANS_OF_TRANSPORTATION("//input[@id=\"meansOfImportation\"]"),
    XPATH_SAVE_AND_PROCEED("(//button[@type=\"button\"])[contains(text(),'Save & Proceed')]"),
    XPATH_HS_CODE("//input[@id=\"hsCode\"]"),
    XPATH_PRODUCT_CODE("//input[@id=\"pctCode\"]"),
    XPATH_DECLARED_DESCRIPTION("//input[@id=\"otherDescription\"]"),
    XPATH_PURPOSE_OF_IMPORT("//input[@id=\"purposeOfImport\"]"),
    XPATH_QUANTITY("//input[@id=\"quantity\"]"),
    XPATH_NO_OF_PACKAGES("//input[@id=\"noOfPackages\"]"),
    XPATH_PACKAGE_TYPE("//input[@id=\"typeOfPackages\"]"),
    XPATH_PLANT_PRODUCT("//input[@id=\"plantorPlantProducts\"]"),
    XPATH_DOCUMENT_TYPE("//input[@id=\"documentType\"]"),
    XPATH_SELECT_FILE("//div[@class='k-dropzone-hint']"),
    XPATH_SELECT_FILE_UPLOADER("//input[@name='files']"),
    XPATH_CONSENT("//input[@id=\"checkbox\"]"),
    XPATH_SUBMIT_BTN("//button[@type=\"submit\"]"),
    XPATH_YES_BTN("//button[@class=\"border-top k-button border-left\"]"),
    XPATH_PSID_TEXT("(//p[@class=\"title font-semibold\"])[1]"),
    XPATH_DOCUMENT_NO_TEXT("(//strong[@class=\"text-dark text-break\"])[3]"),
    XPATH_PAYABLE_AMOUNT_TEXT("(//p[@class=\"title font-semibold\"])[2]"),
    XPATH_PD_ACCOUNT_TAB("(//span[@class='k-link'])[text()='PD Account']"),
    XPATH_PD_ACCOUNT_COLLECTORATE("//input[@placeholder=\"Please select Collectorate\"]"),
    XPATH_CONFIRM_PAYMENT("//button[@class=\"k-button w-50 rounded-0 py-3 btn btn-primary btn-lg\"]"),
    XPATH_PD_POPUP_CONFIRM("//button[@class=\"swal-button swal-button--confirm swal-button--danger\"]"),
    XPATH_PAYMENT_SUCCESSFUL("//div[normalize-space()='Payment Successful']"),
    XPATH_OK_BUTTON("//button[normalize-space()='OK']"),
    XPATH_OFFICER_MENU("//button[@class=\"menu-toggle role-toggler pr-2 bg-light rounded-0 dropdown-toggle btn btn-flat\"]"),
    XPATH_ENTOMOLOGIST("(//span[@class=\"k-link k-menu-link\"])[text()='Entomologist']"),
    XPATH_OFFICER_IMPORT_PERMIT_BTN("(//p[@class='text-white'])[text()=\"Import Permits\"]"),
    XPATH_SEARCH_BOX("//input[@id=\"search-box\"]"),
    XPATH_ASSERT_SEARCH_RESULT_OFFICER("//tr[@class=\"k-master-row\"]/td[3]"),
    XPATH_ASSERT_SEARCH_RESULT_TRADER("//tr[@class=\"k-master-row\"]/td[4]"),
    XPATH_FIRST_ROW("//tr[@class=\"k-master-row\"]"),






    ;
    private String pageVariables;
    private Permits(String pageVariables) {

        this.pageVariables = pageVariables;
    }

    public String getValue() {
        return this.pageVariables;
    }

    public String getPageVariables()
    {
        return this.pageVariables;
    }
}
