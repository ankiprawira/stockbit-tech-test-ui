package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.nio.file.*;

public class DriverManager {

    public static AndroidDriver driver;

    public static void initializeDriver() {
        try {
            URL resourceUrl = DriverManager.class
                    .getClassLoader()
                    .getResource("app/mda-1.0.13-15.apk");

            if (resourceUrl == null) {
                throw new RuntimeException("APK resource not found in classpath: app/mda-1.0.13-15.apk");
            }

            Path appPath = Paths.get(resourceUrl.toURI());

            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("sdk_gphone64_x86_64");
            options.setUdid("emulator-5554");
            options.setPlatformName("Android");
            options.setPlatformVersion("16");
            options.setAutomationName("UiAutomator2");
            options.setApp(appPath.toString());

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/"),
                    options
            );

        } catch (Exception e) {
            throw new RuntimeException("Driver init failed", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
