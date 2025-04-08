# 🧪 Advanced Search UI Automation (Applitools + TestNG + Selenium)

This project performs **UI testing** for the advanced search functionality of the [nopCommerce demo store](https://demo.nopcommerce.com) using:
- ✅ Selenium WebDriver
- ✅ TestNG
- ✅ Applitools Eyes (for visual testing)
- ✅ ExtentReports (for test reporting)
- ✅ Page Object Model (POM) architecture

---

## 🚀 Features

- UI TEST with different combinations of:
  - **Keyword**
  - **Category**
  - **Sub-category checkbox**
  - **Manufacturer**
  - **Description check**
  
- Test data is read via **Data Provider** from Excel file.

- Follows a proper **Page Object Model** design.

- Performs **Visual UI check using Applitools**, saves a **baseline screenshot**, and tracks visual diffs.

- Generates a rich **HTML report using ExtentReports** stored in the `/reports` folder.

- Takes **screenshots of failed test cases** automatically.

---

## 🧑‍💻 Why this version?

This is a **cleaner and toned-down version** of the original project which had full validations, but ran into issues with **Cloudflare blocking test results after clicking Search**.

> ⚠️ Due to Cloudflare restrictions, **search result verification was not possible**.  
So this version focuses purely on **front-end UI testing and layout validation using Applitools**, without verifying dynamic content in search results.

---

## 🧰 Required Tools & Dependencies

Make sure the following are installed:

- Java 8 or higher
- Maven
- IntelliJ IDEA (recommended)
- WebDriverManager
- Chrome, Firefox, or Edge browser
- Internet connection (for Applitools API and demo site)

---

## 📦 Libraries Used

These are defined in the `pom.xml`:

- `org.seleniumhq.selenium:selenium-java`
- `org.testng:testng`
- `com.applitools:eyes-selenium-java5`
- `com.aventstack:extentreports`
- `org.apache.poi:poi` (for Excel reading)
- `io.github.bonigarcia:webdrivermanager`

---

## 📂 Project Structure

<pre>src/test/java/ 
├── com.personal.advancedsearch.pageObjects # Page Object classes 
├── com.personal.advancedsearch.testCases # Test classes (TestNG) 
├── com.personal.advancedsearch.dataproviders # Excel DataProvider class 
├── com.personal.advancedsearch.testBase # BaseTest setup/teardown 
├── com.personal.advancedsearch.utilities # Configs, screenshots, reports</pre>

🧪 How to Run the Tests

1. git clone https://github.com/LennyFerns/AdlibAdvancedsearchautomationUI.git
2. Open in IntelliJ IDEA

* Open the project in IntelliJ.

*  Ensure Maven/Gradle sync completes.

*  Install required dependencies if prompted.

3. Required Libraries and Packages

- Java 11 or above

- Maven (Project uses pom.xml)

- Selenium WebDriver

- TestNG

- Apache POI (for Excel-based data)

- Applitools Eyes SDK

- WebDriverManager (for managing drivers)

- ExtentReports (for HTML reports)

4. To Run the Tests

- Navigate to the testng.xml file in src/test/resources.

- Right-click on testng.xml → Run with TestNG.

- You can uncomment test cases or browser configs based on your preference.

⚙️ Browsers Supported:

- Parallel tests can run on Chrome, Firefox, and Edge.

✅ What This Project Does
Performs UI validation tests using data-driven approach.

- Tests different combinations of keyword, category, sub-category checkbox, manufacturer, and description checkbox.

- Uses Page Object Model (POM) design pattern.

- Takes automated screenshots of failed test cases.

- Generates HTML reports with screenshots under the reports/ folder.

- Integrates with Applitools for visual testing:

- Captures and saves baseline screenshots for comparison.

- Applitools result link is also embedded in the HTML report (if run completes successfully)


📌 Note

> This is a cleaner version of the UI automation suite.
It was created as a workaround for the Cloudflare issue blocking results after clicking search on the original site.
Hence, this version focuses more on UI validation checks and generates reliable test output consistently.
