Feature: Subscribe and Registration of Password

  Background:
    Then Setup Database Connection

#  @Import_Permit_Test_Cases
#  Scenario: DPP Import Permit
#
#    When User Navigates to "Psw Website" URL
#    And I Login Application with "Trader Username" and "Trader Password"
#    And User start creating Import Permit
#    And User fill Import Permit Consignment Info "DPP", "Karachi", "Sea Port Outpost KHI", "UAE", "UAE", "Karachi Container Terminal", "Dubai", "Sea" with "Permits" Test Data
#    And User fill Import Permit Consignment Info Exporter Details "Ahad", "UAE", "Email", "Number", "Address" with "Permits" Test Data
#    And User Save and Proceed
#    And User fill Import Permit Commodity Info with HC:"0702 0000", PC:"0000", "Declared Description", "Consumption", Q:"2000", NOP:"2000", "Bags", "Plant Product" with "Permits" Test Data
#    And User Save and Proceed
#    And User uploads Import Permit Doc in Document Info "M Proforma Invoice" with "TestFile.pdf", "Select File", "Select File uploader" locator with "Permits" Test Data
#    And User Save and Proceed
#    And User fill Import Permit Import Condition and Submit
#    And User perform Import Permit Payment with "PD Account", "Karachi Custom" and Assert "Pay Success Msg" with "Permits" Test Data


  @Import_Permit_Test_Cases
  Scenario: Approve DPP IP from the Officer

    When User Navigates to "Psw Website" URL
#    And I Login Application with "Trader Username" and "Trader Password"
#    And User start creating Import Permit
#    And User fill Import Permit Consignment Info "DPP", "Karachi", "Sea Port Outpost KHI", "UAE", "UAE", "Karachi Container Terminal", "Dubai", "Sea" with "Permits" Test Data
#    And User fill Import Permit Consignment Info Exporter Details "Ahad", "UAE", "Email", "Number", "Address" with "Permits" Test Data
#    And User Save and Proceed
#    And User fill Import Permit Commodity Info with HC:"0702 0000", PC:"0000", "Declared Description", "Consumption", Q:"2000", NOP:"2000", "Bags", "Plant Product" with "Permits" Test Data
#    And User Save and Proceed
#    And User uploads Import Permit Doc in Document Info "M Proforma Invoice" with "TestFile.pdf", "Select File", "Select File uploader" locator with "Permits" Test Data
#    And User Save and Proceed
#    And User fill Import Permit Import Condition and Submit
#    And User perform Import Permit Payment with "PD Account", "Karachi Custom" and Assert "Pay Success Msg" with "Permits" Test Data
#    And User fetch officer Username with "Permits" Test Data
##    Then I Logout Application
    And I Login Application with "Officer Username" and "Officer Password"
    And I open Import Permit by Officer with "Document No" with "Permits" Test Data






