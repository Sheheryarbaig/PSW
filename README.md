# BDD Cucumber Framework - README

This README file provides an overview and instructions for using the BDD Cucumber Framework for automated testing. The framework is designed for testing scenarios using Cucumber, Java, Selenium WebDriver, and automated API testing using JSON files. It follows a Behavior-Driven Development (BDD) approach.

## Framework Structure

The BDD Cucumber Framework has the following directory structure:


bdd-cucumber-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── EnumFactory/
│   │   │   │   ├── WebShop/             # Enum classes reside here
│   │   │   ├── PageObjectFactory/       # Page Object Model (POM) classes reside here
│   │   │   ├── UtilitiesFactory/        # Utility classes reside here
├── test/
│   ├── java/
│   │   ├── com.cucumber.stepdefinitions/  # Step definition classes reside here
│   │   ├── Runner/                  # TestRunner classes reside here
├── Resources/
│   ├── APIsJSONs/
│   │   ├── Requests/                # JSON files for automated API testing (requests) reside here
│   │   ├── Responses/               # JSON files for automated API testing (responses) reside here
│   ├── ExecutionVideo/             # Videos of test executions reside here (optional)
│   ├── FeatureFiles/               # Gherkin feature files reside here
│   ├── Properties/
│   │   ├── Locators/                # Locator files reside here
│   │   ├── TestData/                # Test data files reside here



## Prerequisites

Before running the tests, ensure you have the following installed:

1. Java Development Kit (JDK) - version 18
2. Apache Maven

## Setup Instructions

1. Clone the repository: `git clone https://git.psw.gov.pk/qa/BDDAutomationFramework`
2. Navigate to the project root directory: `cd BDDAutomationFramework`

## Running Tests

To run the automated tests, follow these steps:

### Automated UI Tests

1. Ensure you have all the necessary test data and locator files in the `src/test/Resources/Properties/TestData` and `src/test/Resources/Properties/Locators` directories, respectively.
2. Navigate to the `src/test/java/com.cucumber.stepdefinitions` directory.
3. Run the `Runner` class (Right-click and select "Run Runner" or use Maven).

### Automated API Tests

1. Ensure you have the necessary API request and response JSON files in the `src/test/Resources/APIsJSONs/Requests` and `src/test/Resources/APIsJSONs/Responses` directories, respectively.
2. Navigate to the `src/test/java/com.cucumber.stepdefinitions` directory.
3. Run the `testRunner.xml` class (Right-click and select "Run testRunner.xml" or use Maven).

## Test Data

Test data for the automated UI tests is available in the `src/test/Resources/Properties/TestData` directory. You can modify the test data files as needed for different test scenarios.

## Reporting

The framework generates Cucumber HTML reports after test execution. You can find the reports in the `target/executionReports` directory.

## Execution Video (Optional)

If you want to record videos of test executions, the framework saves them in the `src/test/Resources/ExecutionVideo` directory.

## Contributing

We welcome contributions to enhance this framework. To contribute, please follow these guidelines:

- Fork the repository and create a new branch.
- Make your changes and submit a pull request.
- Ensure that your code passes all existing tests and add new tests for any new features.

Thank you for using the BDD Cucumber Framework! Happy testing!
