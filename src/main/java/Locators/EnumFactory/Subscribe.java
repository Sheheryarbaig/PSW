package Locators.EnumFactory;

public enum Subscribe {
    XPATH_SUBSCRIBE("//a[contains(@href,'/app/subscription')] | //a[normalize-space()='Subscribe']"),//div[@id='carouselExampleIndicators1']/div[2]/div/div/div/div/div/div/div[2]/a/button
    XPATH_AGREE("//input[@class='k-checkbox']"),
    XPATH_PROCEED("//button[@type='submit']"),
    XPATH_VALIDATE("//button[@id='sub-info-button-validate']"),
    XPATH_NTN("//input[@id='input-ntn']"),
    XPATH_EMAIL("//input[@id='input-email']"),
    XPATH_NUMBER("//input[@id='input-cell']"),
    XPATH_CNIC("//input[@id='input-cnic']"),
    XPATH_SELECT_NUMBER("//input[@placeholder='Select Network']"),
    XPATH_JAZZ1("//*[@id=\"payment-process\"]/div[2]/form/fieldset/div[2]/div[2]"),
    XPATH_GENERATE_VOUCHER("//button[normalize-space()='Generate Voucher'] | //button[@xpath='1']"),
    XPATH_JAZZ("//*[@id=\"validate-response-container\"]/div[3]/div/div[2]/div[2]/div/span/span/span[2]"),
    XPATH_PAYMENT_SLIP("//*[@id=\"sub-fee-slip-subscriptionFees-data\"]/strong"),
    XPATH_SUBSCRIPTION_FEE("(//*[@id=\"sub-fee-slip-subscriptionFees-data\"])[2]"),
    XPATH_REFRESH("//p[@class='d-inline']//*[local-name()='svg'] | //p[@xpath='1']//*[local-name()='svg']"),
    XPATH_APPLICATION_ID("(//*[@id=\"sub-fee-slip-applicationID-data\"])[1]"),
    XPATH_SEND_OTP("//*[@id=\"sub-info-button-sendOTP\"]"),
    XPATH_MOBILE_OTP("//input[@name='cellOTP'] | //input[@placeholder='Enter Mobile OTP'] | //input[@value='Test@1']"),
    XPATH_EMAIL_OTP("//input[@name='emailOTP'] | //input[@placeholder='Enter Email OTP'] | //input[@xpath='1']"),
    XPATH_SUBMIT_OTP("//button[@xpath='1'] | //button[@type='submit'] | //button[normalize-space()='Submit']"),
    XPATH_BIOMETRIC_STATUS("//*[@id='sub-fee-slip-biometericstatus-data']"),
    XPATH_DONE_BTN("//*[@id=\"steps\"]/div/div/div/div/div/h4/button"),
    XPATH_RESUME_SUBSCRIPTION("//button[normalize-space()='Resume Subscription'] | //button[@type='button'] | //button[@xpath='1']"),
    XPATH_APPLICATIONID_TEXT("//input[@placeholder=\"Enter Application ID\"]"),
    XPATH_ALERT_EMAIL("//input[@placeholder=\"Enter Email\"]"),
    XPATH_FETCH_APPLICATION_BTN("//button[normalize-space()='Fetch Application']"),
    XPATH_CANCEL_BTN("//h6[@id='sub-info-subtext-cancel'] | //strong[normalize-space()='Click here'] "),
    XPATH_STRN("//*[@id=\"validate-response-strn-data\"]"),
    XPATH_ALREADY_SUBSCIRBED("//*[@id=\"payment-process\"]/div[2]/div"),
    XPATH_PRINCIPAL_ACTIVITY("//*[@id=\"validate-response-princpalActivity-data\"]/span[1]");

    private String pageVariables;
    private Subscribe(String pageVariables) {

        this.pageVariables = pageVariables;
    }

    public String getValue() {
        return this.pageVariables;
    }

    public String getPageVariables(){return this.pageVariables;}

}
