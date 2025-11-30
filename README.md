# Stockbit Tech Test UI Automation

This repository contains the UI automation test project for the Stockbit
technical test.\
The project uses **Java**, **Cucumber**, **Appium**, and **Android
automation**.

------------------------------------------------------------------------

## 📦 Tech Stack & Tools Required

Before running the project, ensure you have installed the following:

### 1. **Java Development Kit (JDK) 17+**

Check installation:

``` bash
java -version
```

### 2. **Apache Maven**

Check installation:

``` bash
mvn -version
```

### 3. **Android Studio**

Required to: - Install SDK Platforms - Configure emulators (AVD) -
Install platform tools & adb

Download: https://developer.android.com/studio

### 4. **Appium**

Appium server required to run Android automation.

Install Appium via Node.js:

``` bash
npm install -g appium
npm install -g appium-doctor
```

Verify:

``` bash
appium-doctor --android
```

### 5. **Android Device or Emulator**

You can use: - Physical Android phone (USB debugging enabled) - Android
Emulator (AVD) from Android Studio

Check connected devices:

``` bash
adb devices
```

------------------------------------------------------------------------

## 📁 Project Structure

    src
     ├── test
     │   ├── java
     │   │   └── stepDefinition
     │   ├── resources
     │   │   ├── features
     │   │   └── app
     ├── pom.xml

-   **features/** -- Contains Cucumber Gherkin test scenarios\
-   **stepDefinition/** -- Java step implementations\
-   **app/** -- APK file under test\
-   **pom.xml** -- Maven project configuration

------------------------------------------------------------------------

## ⚙️ Project Setup

### 1. Clone this repository

``` bash
git clone https://github.com/ankiprawira/stockbit-tech-test-ui.git
cd stockbit-tech-test-ui
```

### 2. Install Dependencies

``` bash
mvn clean install
```

### 3. Start Appium Server

``` bash
appium
```

### 4. Start Android Emulator (if using AVD)

``` bash
adb devices
```

------------------------------------------------------------------------

## ▶️ Running the Tests

Run all tests:

``` bash
mvn test
```

------------------------------------------------------------------------

## 📄 Test Reports

After execution, test reports will be generated under:

    target/cucumber-reports/

HTML Report:

    target/cucumber-reports/cucumber-html-report.html

------------------------------------------------------------------------

## 🧪 Test Scenario (E2E)

This UI test automates the end-to-end flow of buying a product and completing the checkout:

1. **Open landing page**
2. **Choose a product**
3. **Verify user is redirected to the Product Detail page**
4. **Choose color**
5. **Set product quantity**
6. **Add product to cart**
7. **Open cart page**
8. **Verify product name & quantity in the cart**
9. **Proceed to checkout**
10. **Verify user is redirected to login page**
11. **Log in using provided credentials**
12. **Verify user is redirected to the Checkout page**
13. **Fill shipping form**
14. **Tap “Finish” to complete the order**
15. **Verify the “Checkout Complete” page**
16. **Tap “Continue Shopping” to return to the product catalog**
------------------------------------------------------------------------
