package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PaymentPage {
    private final AndroidDriver driver;
    public PaymentPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        public static final By TXT_PAYMENT_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/enterPaymentTitleTV\"]"
        );

        public static final By FLD_NAME = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]"
        );

        public static final By FLD_CARD = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/cardNumberET\"]"
        );

        public static final By FLD_EXP = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/expirationDateET\"]"
        );

        public static final By FLD_CVV = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/securityCodeET\"]"
        );

        public static final By BTN_REVIEW = By.xpath(
                "//android.widget.Button[@content-desc=\"Saves payment info and launches screen to review checkout data\"]"
        );

    }

    // ===================== ASSERTIONS =====================

    public void assertPaymentPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement paymentTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PAYMENT_TITLE));
        Assert.assertTrue("Payment title is not displayed", paymentTitle.isDisplayed());

        WebElement fieldName = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_NAME));
        Assert.assertTrue("Name field is not displayed", fieldName.isDisplayed());
    }

    // ===================== FUNCTIONS =====================

    public void insertCreditCard(String name, String cardNumber, String expiry, String cvv) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement fldName = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_NAME));
        fldName.clear();
        fldName.sendKeys(name);

        WebElement fldCard = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_CARD)
        );
        fldCard.clear();
        fldCard.sendKeys(cardNumber);

        WebElement fldExp = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_EXP));
        fldExp.clear();
        fldExp.sendKeys(expiry);

        WebElement fldCvv = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_CVV));
        fldCvv.clear();
        fldCvv.sendKeys(cvv);
    }

    public void clickReviewOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_REVIEW)).click();
        System.out.println("Click button Review Order");
    }

}
