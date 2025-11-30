package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LandingPage {
    private final AndroidDriver driver;
    public LandingPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        static final By NAVBAR = By.xpath(
                "//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/header\"]"
        );
        static final By CARD_SECTION = By.xpath(
                "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup"
        );
        static final By FIRST_PRODUCT_CARD = By.xpath(
                "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[1]"
        );
        static By productCardByName(String productName) {
            return By.xpath(
                    "//android.widget.ImageView[@content-desc='" + productName + "']"
            );
        }

    }

    // ===================== ASSERTIONS =====================

    public void assertLandingPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbar = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NAVBAR));
        Assert.assertTrue("Navbar is not displayed", navbar.isDisplayed());

        WebElement cardSection = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CARD_SECTION));
        Assert.assertTrue("Card Section is not displayed", cardSection.isDisplayed());

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FIRST_PRODUCT_CARD));
        Assert.assertTrue("Product Card is not displayed", productCard.isDisplayed());

        System.out.println("Landing Page displayed correctly");
    }

    // ===================== FUNCTIONS =====================

    public void clickProductByName(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productCardByName(productName)));
        assertTrue("Product with name '" + productName + "' should be displayed", productTitle.isDisplayed());
        productTitle.click();
        System.out.println("Click Product " + productName);
    }


}
