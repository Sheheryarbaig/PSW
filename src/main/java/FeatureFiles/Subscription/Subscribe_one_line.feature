Feature: Subscribe and Registration of Password

  Background:
    Then Setup Database Connection

  @LoginOneLine
  Scenario: Login

    When User Navigates to "Psw Website" URL
    And I Login Application with "Username" and "Password"

  @SubscribeOneLine
  Scenario: Subscription by One line
    When User Navigates to "Psw Website" URL
    And User performs subscription with "NTN Number", "Email", "CNIC Number" & "Number" with "Subscribe" Test Data

  @SubscribeByScreen
  Scenario: Performing Subscription by Screen
    When User Navigates to "Psw Website" URL
    And User Fill Subscription Info with "NTN Number", "Email", "CNIC Number" & "Number" with "Subscribe" Test Data
    Then User Process the Payment
    Then User performs the Info Auth with "Subscribe" Test Data
    Then User hit Biometric API for Verification
    Then User Reload the Page After Biometric API
    And User Resume Application with "Email" from "Subscribe" Test Data

