package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MyCartPage {
    private final AndroidDriver driver;
    public MyCartPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        public static final By TXT_CART_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV']"
        );

        public static final By IMG_PRODUCT = By.xpath(
                "//android.widget.ImageView[@content-desc=\"Displays selected product\"]"
        );

        public static final By TXT_PRODUCT_PRICE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]"
        );

        public static final By TXT_PRODUCT_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]"
        );

        public static final By TXT_PRODUCT_QUANTITY = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]"
        );

        public static final By BTN_PROCEED = By.xpath(
                "//android.widget.Button[@content-desc=\"Confirms products for checkout\"]"
        );

    }

    // ===================== ASSERTIONS =====================

    public void assertMyCartPage(String productName, Integer expectedQuantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_TITLE))
                .getText()
                .trim();
        Assert.assertTrue("Product title does not contain expected name. Expected: " + productName + " but was: " + actualTitle, actualTitle.contains(productName));

        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.IMG_PRODUCT));
        Assert.assertTrue("Product image is not displayed", productImage.isDisplayed());

        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_PRICE));
        Assert.assertTrue("Product price is not displayed", priceElement.isDisplayed());

        String qtyText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_QUANTITY))
                .getText()
                .trim();
        int actualQuantity = Integer.parseInt(qtyText);
        Assert.assertEquals("Product quantity mismatch", expectedQuantity.intValue(), actualQuantity);
    }

    // ===================== FUNCTIONS =====================

    public void clickProceed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_PROCEED)).click();
        System.out.println("Click proceed");
    }
}
