package pages;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ReviewOrderPage {
    private final AndroidDriver driver;
    public ReviewOrderPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        public static final By TXT_REVIEW_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/enterShippingAddressTV\"]"
        );

        public static final By TXT_PRODUCT_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]"
        );

        public static final By BTN_PLACE_ORDER = By.xpath(
                "//android.widget.Button[@content-desc=\"Completes the process of checkout\"]"
        );

        public static final By TXT_METHOD_TITLE = By.xpath(
                "//android.widget.TextView[@text=\"Payment Method\"]"
        );

        public static final By TXT_COMPLETE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/completeTV\"]\n"
        );


    }

    // ===================== ASSERTIONS =====================

    public void assertReviewPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement reviewTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.TXT_REVIEW_TITLE)
        );
        Assert.assertTrue("Review Order title is not displayed", reviewTitle.isDisplayed());

        WebElement paymentMethod = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.TXT_METHOD_TITLE)
        );
        Assert.assertTrue("Payment method section not displayed", paymentMethod.isDisplayed());
    }

    public void assertCompletePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement completeTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.TXT_COMPLETE)
        );
        Assert.assertTrue("Review Order title is not displayed", completeTitle.isDisplayed());
    }

    // ===================== FUNCTIONS =====================

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_PLACE_ORDER)).click();
        System.out.println("Click button Place Order");
    }

}
