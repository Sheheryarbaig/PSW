Feature: Subscribe and Registration of Password

  Background:
    Then Setup Database Connection

  @SD_Import_Test_Cases
  Scenario: File FCL SD of Non OGA

    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    And User create Import SD with "Commercial" cat and "Home Consumption" Declaration with "Single Declaration" Test Data
    And User fills Import Consign Info with "BL Number FCL", "Containerized", "Port Qasim Import" with "Single Declaration" Test Data
    And User fills Import Financial Information with "UnitedStates Dollar", "FOB" & "Open Account" with "Single Declaration" Test Data
    And User fills Import Commodities Info ** GI ** with "Import HS Code" with "Single Declaration" Test Data according to "Non-OGA"
    And User fills Import Commodities Info ** SI ** with "Quantity", "Unit Value", "Commercial", "Pakistan" with "Single Declaration" Test Data
    And User Save Import Commodities Info
    And User Select "Does Not Apply" Item Structure in Import Commodities Info according to "Non-OGA"
    And User Proceed in Import Documents
    And User Click Validate & Proceed in Import Review and Validate with "Validate Title", "Validate Text" with "Single Declaration" Test Data
    And User perform Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data

  @SD_Import_Test_Cases
  Scenario: File Air LCL SD of Non OGA

    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    And User create Import SD with "Commercial" cat and "Home Consumption" Declaration with "Single Declaration" Test Data
    And User fills Import Consign Info with "BL Number AirLCL", "Air LCL", "Karachi Air Freight Unit" with "Single Declaration" Test Data
    And User fills Import Financial Information with "UnitedStates Dollar", "FOB" & "Open Account" with "Single Declaration" Test Data
    And User fills Import Commodities Info ** GI ** with "Air LCL HS CODE" with "Single Declaration" Test Data according to "Non-OGA"
    And User fills Import Commodities Info ** SI ** with "Quantity", "Unit Value", "Commercial", "Pakistan" with "Single Declaration" Test Data
    And User Save Import Commodities Info
    And User Select "Does Not Apply" Item Structure in Import Commodities Info according to "Non-OGA"
    And User Proceed in Import Documents
    And User Click Validate & Proceed in Import Review and Validate with "Validate Title", "Validate Text" with "Single Declaration" Test Data
    And User perform Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data

  @SD_Import_Test_Cases
  Scenario: File LCL SD of Non OGA

    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    And User create Import SD with "Commercial" cat and "Home Consumption" Declaration with "Single Declaration" Test Data
    And User fills Import Consign Info with "BL Number LCL", "LCL", "MCC Appraisement Karachi" with "Single Declaration" Test Data
    And User fills Import Financial Information with "UnitedStates Dollar", "FOB" & "Open Account" with "Single Declaration" Test Data
    And User fills Import Commodities Info ** GI ** with "Air LCL HS CODE" with "Single Declaration" Test Data according to "Non-OGA"
    And User fills Import Commodities Info ** SI ** with "Quantity", "Unit Value", "Commercial", "Pakistan" with "Single Declaration" Test Data
    And User Save Import Commodities Info
    And User Select "Does Not Apply" Item Structure in Import Commodities Info according to "Non-OGA"
    And User Proceed in Import Documents
    And User Click Validate & Proceed in Import Review and Validate with "Validate Title", "Validate Text" with "Single Declaration" Test Data
    And User perform Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data

  @SD_Import_Test_Cases
  Scenario: File LCL SD of DPP OGA

    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    And User create Import SD with "Commercial" cat and "Home Consumption" Declaration with "Single Declaration" Test Data
    And User fills Import Consign Info with "BL Number LCL 2", "LCL", "MCC Appraisement Karachi" with "Single Declaration" Test Data
    And User fills Import Financial Information with "UnitedStates Dollar", "FOB" & "Open Account" with "Single Declaration" Test Data
    And User fills Import Commodities Info ** GI ** with "DPP HS Code" with "Single Declaration" Test Data according to "DPP"
    And User fills Import Commodities Info ** SI ** with "Quantity", "Unit Value", "Commercial", "Pakistan" with "Single Declaration" Test Data
    And User fill Import Commodities Info ** OGA Req Info ** with "Single Declaration" Test Data
    And User Upload Import Commodities Info ** Req Docs ** "Invoice.pdf" with "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    And User Save Import Commodities Info
    And User Select "Not Applicable" Item Structure in Import Commodities Info according to "DPP"
    And User Proceed in Import Documents
    And User Click Validate & Proceed in Import Review and Validate with "Validate Title", "Validate Text" with "Single Declaration" Test Data
    And User perform Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data

  @SD_Import_Test_Cases
  Scenario: File AirLCL SD of DPP OGA

    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    And User create Import SD with "Commercial" cat and "Home Consumption" Declaration with "Single Declaration" Test Data
    And User fills Import Consign Info with "BL Number AirLCL 2", "Air LCL", "Karachi Air Freight Unit" with "Single Declaration" Test Data
    And User fills Import Financial Information with "UnitedStates Dollar", "FOB" & "Open Account" with "Single Declaration" Test Data
    And User fills Import Commodities Info ** GI ** with "DPP HS Code" with "Single Declaration" Test Data according to "DPP"
    And User fills Import Commodities Info ** SI ** with "Quantity", "Unit Value", "Commercial", "Pakistan" with "Single Declaration" Test Data
    And User fill Import Commodities Info ** OGA Req Info ** with "Single Declaration" Test Data
    And User Upload Import Commodities Info ** Req Docs ** "Invoice.pdf" with "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    And User Save Import Commodities Info
    And User Select "Not Applicable" Item Structure in Import Commodities Info according to "DPP"
    And User Proceed in Import Documents
    And User Click Validate & Proceed in Import Review and Validate with "Validate Title", "Validate Text" with "Single Declaration" Test Data
    And User perform Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data



