package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class ProductPage {
    private final AndroidDriver driver;
    public ProductPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        static final By NAVBAR = By.xpath(
                "//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/header\"]"
        );

        static final By TXT_PRODUCT_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]"
        );

        public static By TXT_PRODUCT_TITLE_BY_NAME (String productTitle) {
            return By.xpath(
                    "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV' and contains(@text,'" + productTitle + "')]"
            );
        }

        static final By IMG_PRODUCT = By.xpath(
                "//android.widget.ImageView[@content-desc=\"Displays selected product\"]"
        );

        static final By TXT_PRODUCT_PRICE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]"
        );

        static final By VIEW_PRODUCT_RATING = By.xpath(
                "//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/rattingV\"]/android.widget.LinearLayout"
        );

        static final By VIEW_PRODUCT_COLOR = By.xpath(
                "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays available colors of selected product\"]"
        );

        static final By BTN_ADD_CART = By.xpath(
                "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]"
        );

        static final By TXT_PRODUCT_HIGHLIGHTS = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productHeightLightsTV\"]"
        );

        static final By BTN_QTY_INC = By.xpath(
                "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]"
        );

        static final By BTN_QTY_DEC = By.xpath(
                "//android.widget.ImageView[@content-desc=\"Decrease item quantity\"]"
        );

        public static By BTN_COLOR(String colorName) {
            return By.xpath(
                    "//android.widget.ImageView[@content-desc='" + colorName + " color']"
            );
        }

        static final By TXT_CART_BADGE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/cartTV\"]"
        );

        static final By BTN_CART_ICON = By.xpath(
                "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]"
        );
    }

    // ===================== ASSERTIONS =====================

    public void assertProductPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NAVBAR));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_TITLE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.IMG_PRODUCT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_PRICE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.VIEW_PRODUCT_RATING));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.VIEW_PRODUCT_COLOR));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.BTN_ADD_CART));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_PRODUCT_HIGHLIGHTS));
        System.out.println("Product Page displayed correctly");
    }

    public void assertCartBadgeCount(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_CART_BADGE))
                .getText()
                .trim();
        int actualCount = Integer.parseInt(countText);

        Assert.assertEquals("Cart badge count mismatch", expectedCount, actualCount);
    }


    // ===================== FUNCTIONS =====================

    public void chooseColor(String colorName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_COLOR("Red"))).click();
        System.out.println("Click "+ colorName + " Color");
    }

    public void setQty(Integer quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_QTY_DEC)).click();
        for (int i = 0; i < quantity; i++){
            wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_QTY_INC)).click();
        }
        System.out.println("Click quantiy" + quantity + " times");
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_ADD_CART)).click();
        System.out.println("Click add to cart");
    }

    public void clickCartIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_CART_ICON)).click();
        System.out.println("Click cart icon");
    }

}
