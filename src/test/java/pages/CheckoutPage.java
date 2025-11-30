package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage {
    private final AndroidDriver driver;
    public CheckoutPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        public static final By TXT_CHECKOUT_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/checkoutTitleTV\"]"
        );

        public static final By FLD_ADDRESS_1 = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/address1ET\"]"
        );

        public static final By FLD_ADDRESS_2 = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/address2ET\"]"
        );

        public static final By FLD_CITY = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/cityET\"]"
        );

        public static final By FLD_STATE = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/stateET\"]"
        );

        public static final By FLD_ZIP = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/zipET\"]"
        );

        public static final By FLD_COUNTRY = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/countryET\"]"
        );

        public static final By FLD_FULLNAME = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/fullNameET\"]"
        );

        public static final By BTN_TO_PAYMENT = By.xpath(
                "//android.widget.Button[@content-desc=\"Saves user info for checkout\"]"
        );


    }

    // ===================== ASSERTIONS =====================

    public void assertCheckoutPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkoutTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_CHECKOUT_TITLE));
        Assert.assertTrue("Text is not displayed", checkoutTitle.isDisplayed());

        WebElement fieldFullname = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_FULLNAME));
        Assert.assertTrue("Field is not displayed", fieldFullname.isDisplayed());

    }

    // ===================== ACTIONS =====================

    public void insertShipping(String fullName,
                               String address1,
                               String address2,
                               String city,
                               String state,
                               String zip,
                               String country) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement fldFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_FULLNAME));
        fldFullName.clear();
        fldFullName.sendKeys(fullName);

        WebElement fldAddress1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_ADDRESS_1));
        fldAddress1.clear();
        fldAddress1.sendKeys(address1);

        WebElement fldAddress2 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_ADDRESS_2));
        fldAddress2.clear();
        fldAddress2.sendKeys(address2);

        WebElement fldCity = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_CITY));
        fldCity.clear();
        fldCity.sendKeys(city);

        WebElement fldState = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_STATE));
        fldState.clear();
        fldState.sendKeys(state);

        WebElement fldZip = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_ZIP));
        fldZip.clear();
        fldZip.sendKeys(zip);

        WebElement fldCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_COUNTRY));
        fldCountry.clear();
        fldCountry.sendKeys(country);
    }

    // ===================== FUNCTIONS =====================

    public void clickToPayment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_TO_PAYMENT)).click();
        System.out.println("Click button To Payment");
    }

}
