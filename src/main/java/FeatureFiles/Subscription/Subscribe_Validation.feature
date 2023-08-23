Feature: Subscribe and Registration of Password

  Background:
    Then Setup Database Connection

  @Subscription_Validation_Test_Cases
  Scenario Outline: STRN validate from FBR API, Fbr Validation Principle Activity

    When User Navigates to "Psw Website" URL
    And User deletes a record from database for "NTN Number" for "Subscribe"
    And User Click on "subscribe" Button on "Subscribe" Page
    And User Click on "agree" Button on "Subscribe" Page
    And User Click on "proceed" Button on "Subscribe" Page
    And User Enters "NTN Number" on "NTN" Field on "Subscribe" Page
    And User Click on "validate" Button on "Subscribe" Page
    And Save "Fbr Strn" on "Subscribe"
    And Save "Principal Activity" on "Subscribe"
    When I send a POST Request to "<Endpoint>" on "<Base URL>" having request body "<Request Body>"
    And I verify the status code "<http_code>"
    And Validate "PROFILE STRN" from "Fbr Strn Body" JSON with "Fbr Strn" from "Subscribe" Page
    And Validate "BUSINESS PRINCIPAL_BUSINESS_ACTIVITY" from "Fbr Strn Body" JSON with "Principal Activity" from "Subscribe" Page

    Examples:
      | Endpoint     | http_code | Base URL | Request Body |
      | psw fbr endpoint | 200   | psw fbr  | Fbr Strn Body   |


  @Subscription_Validation_Test_Cases
  Scenario Outline: When Verification Flag is 1, 9, 73, 89, 125

    When User Navigates to "Psw Website" URL
    And User deletes a record from database for "NTN Number" for "Subscribe"
    And User Click on "subscribe" Button on "Subscribe" Page
    And User Click on "agree" Button on "Subscribe" Page
    And User Click on "proceed" Button on "Subscribe" Page
    And User Enters "NTN Number" on "NTN" Field on "Subscribe" Page
    And User Click on "validate" Button on "Subscribe" Page
    And User Enters "Email" on "Email" Field on "Subscribe" Page
    And User Enters "CNIC Number" on "CNIC Number" Field on "Subscribe" Page
    And User Enters "Number" on "Number" Field on "Subscribe" Page
    And User Enters "Jazz" on "Selection SIM" Field on "Subscribe" Page
    Then User Click on "Jazz" Button on "Subscribe" Page
    And User Press Enter
    Then User Click on "Jazz1" Button on "Subscribe" Page
    And Fetch "Verification Flag" from Database
    And I verify "Verification Flag" with "1"
    When I send a POST Request to "<Endpoint>" on "<Base URL>" having request body "<Request Body>"
    And I verify the status code "<http_code>"
    Then User Click on "Generate Voucher" Button on "Subscribe" Page
    And Save "payment slip" on "Subscribe"
    And Save "subscription fee" on "Subscribe"
    And Save "Application ID" on "Subscribe"
    Then User Refresh the PSW Page and Click on Reload page
    And User Click on "Resume Subscription" Button on "Subscribe" Page
    And User Enters "Application ID" on "Application ID Text" Field on "Subscribe" Page
    And User Enters "Email" on "Alert Email" Field on "Subscribe" Page
    And User Click on "Fetch Application" Button on "Subscribe" Page
    And Fetch "Verification Flag" from Database
    And I verify "Verification Flag" with "9"
    When I send a POST Request to "psw payment endpoint" on "<Base URL>" having request body "Payment Body"
    And I verify the status code "<http_code>"
    And User Waits
    Then User Click on "Refresh" Button on "Subscribe" Page
    And User Waits
    Then User Click on "Refresh" Button on "Subscribe" Page
    Then User Click on "proceed" Button on "Subscribe" Page
    And User Waits
    Then User Click on "Send OTP" Button on "Subscribe" Page
    And User Waits
    And Fetch "OTP sms" from Database
    And Fetch "OTP email" from Database
    And User Waits
    And Fetch "Verification Flag" from Database
    And I verify "Verification Flag" with "73"
    Then User Enters "SMS OTP" on "Mobile OTP" Field on "Subscribe" Page
    And User Enters "Email OTP" on "Email OTP" Field on "Subscribe" Page
    Then User Click on "Submit OTP" Button on "Subscribe" Page
    And User Waits
    And User Waits
    And User Waits
    And Fetch "Verification Flag" from Database
    And I verify "Verification Flag" with "89"
    When I send a POST Request to "psw biometric endpoint" on "<Base URL>" having request body "Biometric Verification"
    And I verify the status code "<http_code>"
    Then User Refresh the PSW Page and Click on Reload page
    And User Click on "Resume Subscription" Button on "Subscribe" Page
    And User Enters "Application ID" on "Application ID Text" Field on "Subscribe" Page
    And User Enters "Email" on "Alert Email" Field on "Subscribe" Page
    And User Click on "Fetch Application" Button on "Subscribe" Page
    And User Click on "Done" Button on "Subscribe" Page
    And Fetch "Verification Flag" from Database
    And I verify "Verification Flag" with "125"
    Examples:
      | Endpoint     | http_code | Base URL | Request Body |
      | psw endpoint | 200       | psw base | Token Body   |