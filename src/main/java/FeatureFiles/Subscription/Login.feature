Feature: Login PSW

  Background:
    Then Setup Database Connection

  @Login
  Scenario: Login Application

    When User Navigates to "Psw Website" URL
    Then User Click on "Login" Button on "Login" Page
    And User Enterss "Username" on "Username" Field on "Login" Page
    And User Enterss "Password" on "Password" Field on "Login" Page
    Then User Click on "Login" Button on "Login" Page
