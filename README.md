# OrangeHRM Selenium Automation Testing Project

## 📌 Project Overview

This project is a UI test automation framework developed for the OrangeHRM demo web application.

The framework is built using **Java, Selenium WebDriver, TestNG, Maven, Allure Reports, and Log4j2**, following the **Page Object Model (POM)** design pattern.

The project automates several OrangeHRM business scenarios, including authentication, employee management, admin functionality, dashboard validation, navigation, and UI verification.

The main goal of this project is to demonstrate the design and implementation of a maintainable and reusable web automation testing framework.

---

## 🌐 Application Under Test

**OrangeHRM Open Source Demo**

https://opensource-demo.orangehrmlive.com/

OrangeHRM is a Human Resource Management (HRM) application that provides functionality for managing employees, users, recruitment, leave, performance, and other HR operations.

---

## 🛠 Technologies & Tools

- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Reports
- Log4j2
- Jackson
- Page Object Model (POM)
- JSON Test Data
- IntelliJ IDEA
- Git & GitHub

---

## 🏗 Framework Design

The automation framework follows the **Page Object Model (POM)** design pattern.

Page-specific locators and actions are separated from the test classes, improving:

- Code reusability
- Test readability
- Maintainability
- Separation of test logic and page interaction logic

The framework also contains reusable utilities and configuration files for managing test execution.

---

## 📁 Project Structure

```text
src
├── main
│   └── java
│       ├── Base
│       ├── Pages
│       ├── Utilities
│       └── Listeners
│
└── test
    ├── java
    │   └── Tests
    └── resources
        ├── TestData
        └── Configuration
```

The exact package names may differ depending on the current project structure.

---

## 🧪 Automated Test Scenarios

The project includes automated test cases covering several OrangeHRM features.

### Login

- Verify successful login using valid credentials
- Verify login using invalid credentials
- Verify validation messages for required fields
- Verify navigation to the Dashboard after successful login

### PIM / Employee Management

- Navigate to the PIM module
- Search for existing employees
- Search for non-existing employees
- Validate employee search results
- Add employee information
- Validate employee data

### Admin

- Navigate to the Admin module
- Access user management functionality
- Validate Add User page elements
- Validate required fields and controls

### Dashboard & Navigation

- Verify Dashboard navigation
- Verify sidebar menu items
- Validate available modules
- Verify OrangeHRM footer/branding
- Open the OrangeHRM website from the footer link
- Handle and validate a newly opened browser tab

---

## 🔍 Automation Concepts Demonstrated

The project demonstrates the use of:

- Page Object Model
- Explicit waits
- Dynamic element handling
- XPath and CSS selectors
- TestNG assertions
- TestNG groups
- Test priorities
- Data-driven testing
- DataProviders
- JSON test data
- Multiple browser windows/tabs
- Browser navigation
- Reusable page methods
- Test listeners
- Screenshot capture
- Logging
- Parallel test execution
- Configuration management

---

## 📊 Data-Driven Testing

TestNG `DataProvider` is used to execute test cases using multiple sets of test data.

Examples include:

- Valid login credentials
- Invalid login credentials
- Existing employee data
- Non-existing employee data

Test data is separated from the test logic to improve maintainability and reusability.

---

## ⚡ Parallel Test Execution

The framework supports parallel test execution using TestNG.

Example configuration:

```xml
<suite name="AutomationOrangeHRM"
       parallel="tests"
       thread-count="2">
```

This allows multiple tests to execute concurrently and can reduce the overall execution time of the test suite.

---

## 🧩 TestNG

TestNG is used for:

- Test execution
- Assertions
- Test grouping
- Test priorities
- DataProviders
- Parallel execution
- Test suite management
- Test lifecycle management

Tests are organized into groups such as:

```text
Smoke
Regression
```

The test suite can be configured and executed through `testng.xml`.

---

## 📊 Allure Reporting

Allure Report is integrated into the framework to provide detailed and readable test execution reports.

Allure reporting includes:

- Epic
- Feature
- Test description
- Severity
- Test owner
- Test steps
- Pass/fail status
- Failure details
- Screenshots

Example:

```java
@Epic("OrangeHRM Automation")
@Feature("Login Feature")
@Description("Verify successful login using valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("Yousef Mohsen")
@Test(groups = "smoke")
```

---

## 📸 Screenshot Capture

Screenshots are used to provide additional information about test execution and failures.

Screenshots can be attached to Allure reports to make debugging failed test cases easier.

The framework also captures screenshots when test failures occur.

---

## 📝 Logging

**Log4j2** is integrated into the automation framework for logging important events during test execution.

Logging helps track:

- Test execution flow
- Browser actions
- Page interactions
- Test failures
- Debugging information

---

## ⚙️ Configuration Management

Framework configuration is separated from the test code using configuration files.

Configuration can include values such as:

```properties
base.url=https://opensource-demo.orangehrmlive.com/
browser=chrome
explicit.wait=10
```

This makes it easier to modify execution settings without changing the test implementation.

---

## ▶️ How to Run the Project

### Prerequisites

Make sure the following are installed:

- Java JDK
- Maven
- Google Chrome
- Git
- Allure Commandline (optional, for viewing Allure reports)

### Clone the Repository

```bash
git clone <your-repository-url>
```

Navigate to the project directory:

```bash
cd <repository-name>
```

### Run the Tests

Using Maven:

```bash
mvn clean test
```

Tests can also be executed directly using the configured:

```text
testng.xml
```

---

## 📊 Generate Allure Report

After running the tests, generate the Allure report using:

```bash
allure serve target/allure-results
```

Depending on the Maven configuration, the report may also be generated using:

```bash
mvn allure:serve
```

---

## 🎯 Project Objectives

The main objectives of this project are to:

- Design a maintainable Selenium automation framework
- Apply the Page Object Model design pattern
- Automate real-world HR management scenarios
- Implement reusable page actions
- Apply explicit synchronization
- Implement data-driven testing
- Organize Smoke and Regression test suites
- Execute tests in parallel
- Generate detailed Allure reports
- Implement logging and screenshot capture
- Improve test maintainability and scalability

---

## 🚀 Future Improvements

Possible future improvements include:

- Cross-browser execution
- CI/CD integration using GitHub Actions or Jenkins
- Additional OrangeHRM modules and test scenarios
- Improved test data management
- Retry mechanism for selected test failures
- Automated Allure report publishing

---

## 👤 Author

**Yousef Mohsen**

Software Testing / QA Engineer  
ISTQB Foundation Level Certified
