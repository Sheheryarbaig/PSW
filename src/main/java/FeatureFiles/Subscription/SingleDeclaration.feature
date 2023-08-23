Feature: Subscribe and Registration of Password

  Background:
    Then Setup Database Connection

  @Consignment_Information
  Scenario: Subscribe Module

    When User Navigates to "Psw Website" URL
    Then User Click on "Login" Button on "Login" Page
    And User Enters "Trader Username" on "Username" Field on "Login" Page
    And User Enters "Trader Password" on "Password" Field on "Login" Page
    Then User Click on "Login" Button on "Login" Page
    And User Click on "Single Declaration" Button on "Single Declaration" Page
    And User Click on "Export SD" Button on "Single Declaration" Page
    And User Waits
    And User Waits
    And User Waits
    And User Click on "Consignment Category" Button on "Single Declaration" Page
    And User Enters "Commercial" on "Consignment Category" Field on "Single Declaration" Page
    And User Click on "Consignment Selection" Button on "Single Declaration" Page
    And User Press Enter
    And User Click on "Declaration Type" Button on "Single Declaration" Page
    And User Enters "Declaration" on "Declaration Type" Field on "Single Declaration" Page
    And User Press Enter
    And User Click on "Confirm" Button on "SingleDeclaration" Page
    And User Press Enter
    And User Enters "Port Qasim Export" on "Collectrate" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Consignment Mode" on "Consignment Mode" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Consignor Name" on "Consignor Name" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Consignor Address" on "Consignor Address" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Consignee Name" on "Consignee Name" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Consignee Address" on "Consignee Address" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Port Qasim Export" on "Port Shipment" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Pakistan" on "Destination" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Port Discharge" on "Port Discharge" Field on "Single Declaration" Page
    And User Press Down
    And User Press Enter
#    And User Click on "Arrow" Button on "SingleDeclaration" Page
    And User Enters "Consignee Address" on "Delivery" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Shipping" on "Shipping" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Gross Weight" on "Gross Weight" Field on "Single Declaration" Page
    And User Enters "Net Weight" on "Net Weight" Field on "Single Declaration" Page
    And User Enters "Qasim International Container Terminal" on "Location" Field on "Single eDeclaration" Page
    And User Press Enter
    And User Enters "Qasim International Container Terminal" on "Terminal" Field on "Single Declaration" Page
    And User Press Enter
    And User Click on "Save And Proceed" Button on "Single Declaration" Page
    And User Enters "UnitedStates Dollar" on "Currency" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "CIF" on "Delivery Term" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Al Baraka Bank" on "Bank" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "IBAN" on "IBAN" Field on "Single Declaration" Page
    And User Press Enter
    And User Enters "Open Account" on "Mode of Payment" Field on "Single Declaration" Page
    And User Press Enter


