package Locators.EnumFactory;

public enum SingleDeclaration {
    XPATH_SEARCH_BAR("//input[@placeholder='Search anything']"),
    XPATH_CLICK_ON_SUBMITTED_SDS("//p[normalize-space()='Submitted'])[2]"),
    XPATH_SEARCH_SD("//input[@placeholder='Search']"),
    XPATH_SD_NUMBER_IN_UPS("//input[@id='input-documnentNumber']"),
    XPATH_SEARCH_BUTTON("//button[normalize-space()='Search']"),
    XPATH_ACTION_BUTTON("//a[@class='mr-2']"),
    XPATH_PD_ACCOUNT_TAB("//span[normalize-space()='PD Account']"),
    XPATH_COLLECTRATE_DROPDOWN_PD_ACCOUNT("//input[@placeholder='Please select Collectorate']"),
    XPATH_CONFIRM_BUTTON("//button[normalize-space()='Confirm']"),
    XPATH_SINGLE_DECLARATION_MENU("(//*[normalize-space()=\"Single Declaration\"])[8]"),
    XPATH_SUBMITTED_SD_BUTTON("//*[@id=\"root\"]//*[@id=\"Export-submitted\"]"),
    XPATH_EXPORT_SD("//p[normalize-space()='Export']"),
    XPATH_AMEND_SD_BUTTON("(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"),
    XPATH_SD_ACTIONS_DROPDOWN("(//*[@class=\"bi bi-three-dots-vertical\"])[1]"),
    XPATH_SD_AMENDMENT_BUTTON("(//*[@class=\"dropdown-item\"]//*[text()='Amend'])[2]"),
    XPATH_EXPAND_SD_INFORMATION("(//*[@class=\"k-hierarchy-cell\"]//*[@class=\"k-icon k-plus\"])[1]"),
    XPATH_FIRST_SD_NUMBER("(//*[@class=\"k-grid-container\"]//td[@data-grid-col-index=\"2\"])[1]"),
    XPATH_CONSIGNNMENT_CATEGORY("//*[@id=\"consignmentCategory\"]"),
    XPATH_CONSIGNNMENT_SELECTION("//input[@placeholder='Select consignment category']"),
    XPATH_DECLARATION_TYPE("//input[@placeholder=\"Select declaration type\"]"),
    XPATH_NTN_WINDOW("//span[@class='k-icon k-i-search position-relative']"),
    XPATH_COLLECTORATE("//input[translate(@placeholder, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'please select collectorate']"),
    XPATH_CONSIGNOR_NAME("//input[@placeholder='Select consignor name']"),
    XPATH_CONSIGNOR_ADDRESS("//input[@placeholder='Select consignor address']"),
    XPATH_CONSIGNMENT("//input[@placeholder='Please select mode of consignment']"),
    XPATH_CONSIGNEE_NAME("//input[@placeholder='Please enter consignee name']"),
    XPATH_CONSIGNEE_ADDRESS("//input[@placeholder='Please enter consignee address']"),
    XPATH_PORT_SHIPMENT("//input[@placeholder='Please select port of shipment']"),
    XPATH_DESTINATION("//input[@placeholder='Please select destination country']"),
    XPATH_DISCHARGE("//input[@placeholder='Please select port of discharge']"),
    XPATH_DELIVERY("//input[@placeholder='Please enter place of delivery']"),
    XPATH_SHIPPING("//input[@placeholder='Please select shipping / air line']"),
    XPATH_GROSS_WEIGHT("//input[@placeholder='Please enter gross weight']"),
    XPATH_NET_WEIGHT("//input[@placeholder='Please enter net weight']"),
    XPATH_MARKS("//input[@placeholder='Please enter marks']"),
    XPATH_LOCATION("//input[@placeholder='Please select shed / location']"),
    XPATH_TERMINAL("//input[@placeholder='Please select terminal']"),
    XPATH_CURRENCY("//input[@placeholder='Please select currency']"),
    XPATH_CONSIGNMENT_MODE("//input[@placeholder='Please select mode of consignment']"),
    XPATH_PORT_DISCHARGE("//input[@placeholder='Please select port of discharge']"),
    XPATH_ARROW("(//span[@class='k-select'])[8]"),
    XPATH_SAVE_AND_PROCEED("//button[normalize-space()='Save & Proceed']"),
    XPATH_IMPORT_SD("//p[normalize-space()='Import']"),
    XPATH_BL_NUMBER("//input[@name='blNumber']"),
    XPATH_CALENDAR_BTN("//a[@class='k-select k-select']"),
    XPATH_TODAY_DATE("//span[@class='k-today']"),
    XPATH_CONSIGN_SCREEN("//*[@class='ConsignmentInfoImport_basicFields__3b1o4 row row-cols-sm-3 row-cols-1']"),
    XPATH_VIR_NUMBER("//*[@id=\"virNumberId\"]"),
    XPATH_VIR_SEARCH_BTN("//span[@class='k-icon k-i-search position-relative']"),
    XPATH_VIR_ROW_SELECT("(//tr[@class='k-master-row'])[1]"),
    XPATH_GET_IGM_INFO("//button[normalize-space()='Get IGM Info']"),
    XPATH_BARTER_QUOTA("//*[@id=\"barterQuotaIdWithModal\"]"),
    XPATH_CONSIGNEE_NAME_SELECT("//input[@placeholder='Select consignee name']"),
    XPATH_BANK("//input[@placeholder='Please select bank name']"),
    XPATH_IBAN("//input[@placeholder='Please select IBAN']"),
    XPATH_MODE_OF_PAYMENT("//input[@placeholder='Please select Mode of Payment']"),
    XPATH_ADD("//button[normalize-space()='Add']"),
    XPATH_FREIGHT("//input[@name=\"freightValue\"]"),
    XPATH_LANDING_CHARGES("//input[@name=\"landingChargesValue\"]"),
    XPATH_ADD_COMMODITY("//button[normalize-space()='Add commodity']"),
    XPATH_HS_CODE("//input[@placeholder='Please enter HS code']"),
    XPATH_DESCRIPTION("//*[@name='declaredDescription']"),
    XPATH_SUPPORTING_INFORMATION("//p[normalize-space()='Supporting Information']"),
    XPATH_QUANTITY_ASSESSMENT_PURPOSE("//input[@name=\"quantityAssPurpose\"]"),
    XPATH_QUANTITY_STATISTICAL_PURPOSE("//input[@name=\"quantityStatisticalPurpose\"]"),
    XPATH_UNIT_VALUE_USD("//input[@name=\"unitValue\"]"),
    XPATH_UNIT_VALUE_INVOICE("//input[@name=\"unitValueInvoice\"]"),
    XPATH_ITEM_IMPORT_TYPE("//input[@placeholder='Item Import Type']"),
    XPATH_ORIGIN("//input[@placeholder='Origin']"),
    XPATH_SAVE_COMMODITIES("(//button[@type=\"submit\"])[3]"),
    XPATH_ITEM_STRUCTURE("//*[@class='CommodityInfoImport_editIcon__3HTQR'][2]"),
    XPATH_DOES_NOT_APPLY("//label[text()='Does Not Apply']/preceding-sibling::input[@class='custom-control-input']"),
    XPATH_YES("//label[text()='Yes ']/preceding-sibling::input[@class='custom-control-input']"),
    XPATH_NO("//label[text()='No']/preceding-sibling::input[@class='custom-control-input']"),
    XPATH_ITEM_STR_SUBMIT("(//button[@type='submit'])[1]"),
    XPATH_PROCEED("(//button[@type='button'])[text()='Proceed']"),
    XPATH_VALIDATE_AND_PROCEED("(//button[@type='button'])[text()='Validate & Proceed']"),
    XPATH_VALIDATE_TITLE("//div[@class=\"swal-title\"]"),
    XPATH_VALIDATE_TEXT("//div[@class=\"swal-text\"]"),
    XPATH_VALIDATE_OK("//button[@class=\"swal-button swal-button--confirm\"]"),
    XPATH_SAVE_AND_SUBMIT("(//button[@type='button'])[text()='Save and Submit']"),
    XPATH_PSID_TEXT("(//p[@class=\"title font-semibold\"])[1]"),
    XPATH_PAYABLE_AMOUNT_TEXT("(//p[@class=\"title font-semibold\"])[2]"),
    XPATH_PD_ACCOUNT("(//span[@class='k-link'])[text()='PD Account']"),
    XPATH_CONFIRM_PAYMENT("//button[@class=\"k-button w-50 rounded-0 py-3 btn btn-primary btn-lg\"]"),
    XPATH_PD_POPUP_CONFIRM("//button[@class=\"swal-button swal-button--confirm swal-button--danger\"]"),
    XPATH_PAYMENT_SUCCESSFUL("//div[normalize-space()='Payment Successful']"),
    XPATH_OK_BUTTON("//button[normalize-space()='OK']"),
    XPATH_DELIVERY_TERM("//input[@placeholder='Select Delivery Term']"),
    XPATH_INSURANCE("//input[@placeholder='Insurance']"),
    XPATH_INSURANCE_PERCENTAGE_CHECK("insurancePercentageCheck"),
    XPATH_ADD_CONTAINER("//button[normalize-space()='Add Container']"),
    XPATH_CONTAINER_NUMBER("//input[@placeholder='Enter container number']"),
    XPATH_QUANTITY("//input[@placeholder='Enter Quantity']"),
    XPATH_PACKAGES("//input[@placeholder='Enter No of Package']"),
    XPATH_NUMBER_OF_PACKAGES("//input[@placeholder='Enter number of packages']"),
    XPATH_PACKAGES_TYPE("//input[@placeholder='Select package type']"),
    XPATH_YES_BUTTON("//button[normalize-space()='Yes']"),
    XPATH_PRODUCT_CODE("//input[@placeholder='Please enter product code']"),
    XPATH_UNIT_VALUE("//*[@name='unitValue']"),
    XPATH_SAVE("//button[contains(text(),'Save')]"),
    XPATH_SUPPORTING_QUANTITY("//*[@name='quantityStatisticalPurpose']"),
    XPATH_OGA_REQUIRED_INFORMATION("//p[contains(text(),'OGA')]"),
    XPATH_PURPOSE_OF_EXPORT("//input[@placeholder='Please select purpose of export']"),
    XPATH_TREATMENT_PROVIDED_COMPANY("//input[@placeholder='Please enter treatment provider company']"),
    XPATH_BOTANICAL_NAME("//input[@placeholder='Please enter botanical name']"),
    XPATH_GET_DOCUMENTARY_REQUIREMENT("//button[normalize-space()='Get Documentary Requirement']"),
    XPATH_DOCUMENT_TYPE("//input[@placeholder='Select Document Type']"),
    XPATH_SELECT_FILE("//div[@class='k-dropzone-hint']"),
    XPATH_SELECT_FILE_UPLOADER("//input[@name='files']"),
    XPATH_CITY("//*[@id=\"cityId\"]"),
    XPATH_SITE("//*[@id=\"agencyId\"]"),
    XPATH_ADD_PACKAGES("//span[@class='k-icon k-i-plus mr-1']"),
    XPATH_IMPORT_CONFIRM("(//button[@type='submit'])[2]"),
    XPATH_QUANTITY_ASSESSMENT("//*[@name='quantityAssPurpose']"),
    XPATH_GENERAL_DESCRIPTION("//*[@name='generalDescriptionOfGoods']"),
    XPATH_CATEGORY("//input[@placeholder='Please select category']"),
    XPATH_QUANTITY_FEE("//input[@name='Quantity']"),
    XPATH_PACKING_UNIT("//input[@placeholder='Please select packing unit (for fee calculation)']"),
    XPATH_TEMPERATURE_TYPE("//input[@placeholder='Please select temperature type']"),
    XPATH_TEMPERATURE_UNIT("//input[@placeholder='Please select temperature unit']"),
    XPATH_PACKAGE_DISTRIBUTION("//textarea[@name='PackageDistribution']"),
    XPATH_REQUIRED_DOCUMENTS("//p[text()='Required Documents ']"),
    XPATH_EXPORT_UPLOAD_DOCUMENT("(//a[@class=\"OGARequiredDocumentsExport_greenIcon__qKShq\"])[2]"),
    XPATH_EXCHANGE_RATE("//input[@name=\"exchangeRate\"]"),
    XPATH_IMPORT_CONSIGNMENT_MODE("//input[@name=\"consignmentMode\"]"),
    XPATH_PURPOSE_OF_IMPORT("//input[@placeholder='Please select purpose of import']"),
    XPATH_SCIENTIFIC_NAME("//input[@name='BotanicalName']"),
    XPATH_IMPORT_CONSENT_1("//input[@name=\"Declaration1\"]"),
    XPATH_IMPORT_CONSENT_2("//input[@name=\"Declaration2\"]"),
    XPATH_UPLOAD_DOCUMENT_BTN("//a[@class=\"OGARequiredDocumentsImport_greenIcon__3VAot\"]"),
    XPATH_NOT_APPLICABLE_1("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[1]"),
    XPATH_NOT_APPLICABLE_2("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[2]"),
    XPATH_NOT_APPLICABLE_3("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[3]"),
    XPATH_NOT_APPLICABLE_4("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[4]"),
    XPATH_NOT_APPLICABLE_5("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[5]"),
    XPATH_NOT_APPLICABLE_6("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[6]"),
    XPATH_NOT_APPLICABLE_7("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[7]"),
    XPATH_NOT_APPLICABLE_8("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[8]"),
    XPATH_NOT_APPLICABLE_9("(//label[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='not applicable']/preceding-sibling::input[@class='custom-control-input'])[9]"),
    XPATH_DRIVER_CNIC("//input[@name=\"driverCNIC\"]"),
    XPATH_DRIVER_PASSPORT_NUMBER("//input[@name=\"vehicleDriverPassportNumber\"]"),
    XPATH_VEHICLE_NUMBER("//input[@name=\"vehicleNumber\"]"),
    XPATH_REGISTRATION_COUNTRY("//input[@placeholder='Select Vehicle Registration Country']"),
    XPATH_REGISTRATION_AUTHORITY("//input[@placeholder='Select Registration Authority']"),
    ;
    private String pageVariables;
    private SingleDeclaration(String pageVariables) {

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