package pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;
    public LoginPage(AndroidDriver driver){ this.driver = driver; }

    private static class Locators {
        public static final By TXT_LOGIN_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/loginTV\"]"
        );

        public static final By FLD_USERNAME = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]"
        );

        public static final By FLD_PASSWORD = By.xpath(
                "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]"
        );

        public static final By BTN_LOGIN = By.xpath(
                "//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]"
        );
    }

    // ===================== ASSERTIONS =====================

    public void assertLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.TXT_LOGIN_TITLE));
        Assert.assertTrue("Text is not displayed", loginTitle.isDisplayed());

        WebElement fieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_USERNAME));
        Assert.assertTrue("Field is not displayed", fieldUsername.isDisplayed());

        WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_PASSWORD));
        Assert.assertTrue("Field is not displayed", fieldPassword.isDisplayed());
    }

    // ===================== ASSERTIONS =====================

    public void insertPasswordAndUsername(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement fieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_USERNAME));
        fieldUsername.clear();
        fieldUsername.sendKeys(userName);

        WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FLD_PASSWORD));
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }


    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BTN_LOGIN)).click();
        System.out.println("Click button login");
    }

}
