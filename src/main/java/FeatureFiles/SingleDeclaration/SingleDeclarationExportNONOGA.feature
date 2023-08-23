Feature: Export SD creation without permit NON OGA

  Background:
    Then Setup Database Connection

  @NONOGA_FCL_without_import_permit
  Scenario: File Containerized SD of NON OGA with Port Qasim (exports), karachi, LCL, Free On Board (FOB), Open Account, 7501.1000, Payment Through PD account
    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    Then User performs Export Single Declaration with "Single Declaration" Test Data
    Then User fills Export Consignment Information with "Containerized" and "Port Qasim Export" and "A ENTERPRISES" with "Single Declaration" Test Data
    Then User fills Export Financial Information with "FOB","UnitedStates Dollar" & "Open Account" with "Single Declaration" Test Data
    Then User fills Commodity Information with "NON-OGA Code" "Containerized" with "Single Declaration" Test Data with "Non-OGA"
    And User uploads Document "Invoice.pdf" with "Invoice", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    And User uploads Document "Invoice.pdf" with "Packing", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    Then User review and validates with "Single Declaration" Test Data with NON-OGA
    And User perform Export Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data


  @NONOGA_LCL_without_import_permit
  Scenario: File LCL SD of NON OGA with Port Qasim (exports), karachi, LCL, Free On Board (FOB), Open Account, 7501.1000, Payment Through PD account
    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    Then User performs Export Single Declaration with "Single Declaration" Test Data
    Then User fills Export Consignment Information with "LCL" and "Port Qasim Export" and "A ENTERPRISES" with "Single Declaration" Test Data
    Then User fills Export Financial Information with "FOB","UnitedStates Dollar" & "Open Account" with "Single Declaration" Test Data
    Then User fills Commodity Information with "NON-OGA Code" "LCL" with "Single Declaration" Test Data with "Non-OGA"
    And User uploads Document "Invoice.pdf" with "Invoice", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    And User uploads Document "Invoice.pdf" with "Packing", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    Then User review and validates with "Single Declaration" Test Data with NON-OGA
    And User perform Export Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data


  @NONOGA_AirLCL_without_import_permit
  Scenario: File AirLCL SD of NON OGA with Karachi Air  Fright Unit, LCL, Free On Board (FOB), Open Account, 7501.1000, Payment Through PD account
    When User Navigates to "Psw Website" URL
    And I Login Application with "Trader Username" and "Trader Password"
    Then User performs Export Single Declaration with "Single Declaration" Test Data
    Then User fills Export Consignment Information with "Air LCL" and "Karachi Air Feight" and "Air Blue" with "Single Declaration" Test Data
    Then User fills Export Financial Information with "FOB","UnitedStates Dollar" & "Open Account" with "Single Declaration" Test Data
    Then User fills Commodity Information with "NON-OGA Code" "Air LCL" with "Single Declaration" Test Data with "Non-OGA"
    And User uploads Document "Invoice.pdf" with "Invoice", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    And User uploads Document "Invoice.pdf" with "Packing", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
    Then User review and validates with "Single Declaration" Test Data with NON-OGA
    And User perform Export Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data


#  @OGA_FCL_without_import_permit_AQD_LCL_OPENTRUCK
#  Scenario: File Containerized SD of DPP OGA with Port Qasim (exports), karachi, LCL, Free On Board (FOB), Open Account, 0710.1000, Payment Through PD account
#    When User Navigates to "Psw Website" URL
#    And I Login Application with "Trader Username" and "Trader Password"
#    Then User performs Export Single Declaration with "Single Declaration" Test Data
#    Then User fills Export Consignment Information with "Open Truck" and "Taftan" and "A ENTERPRISES" with "Single Declaration" Test Data
#    Then User fills Export Financial Information with "FOB","UnitedStates Dollar" & "Open Account" with "Single Declaration" Test Data
#    Then User fills Commodity Information with "AQD OGA" "Open Truck" with "Single Declaration" Test Data with "OGA"
#    And User fills OGA Required Information with "AQD OGA" "Single Declaration" Test Data
#    And User Upload Export Commodities Info ** Req Docs ** "Invoice.pdf" with "Select File", "Select File uploader" locator with "Single Declaration" Test Data
#    And User uploads Document "Invoice.pdf" with "Invoice", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
#    And User uploads Document "Invoice.pdf" with "Packing", "Select File", "Select File uploader" locator with "Single Declaration" Test Data
#    Then User review and validates with "Single Declaration" Test Data
##    And User completes Payment procedure with "Single Declaration" Test Data
#    And User perform Export Pay Process with "PD Account" Assert "Pay Success Msg" with "Single Declaration" Test Data