//package stepDefinition;
//
//import base.DriverManager;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.cucumber.java.en.Given;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import static org.junit.Assert.*;
//
//public class CommonSteps {
//    static AppiumDriver driver;
//
//
//    @Given("the app is launched")
//    public void the_app_is_launched() {
//        UiAutomator2Options options = new UiAutomator2Options();
//
//        options.setDeviceName("sdk_gphone64_x86_64");
//        options.setUdid("emulator-5554");
//        options.setPlatformName("Android");
//        options.setPlatformVersion("16");
//        options.setAutomationName("UiAutomator2");
//        options.setAppPackage("com.saucelabs.mydemoapp.android");
//        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
//        URL url = null;
//        try {
//            url = new URL("http://127.0.0.1:4723/");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        driver = new AppiumDriver(url, options);
//        System.out.println("✅ App launched successfully!");
//    }
//}

package stepDefinition;

import base.DriverManager;
import io.cucumber.java.en.Given;

import static org.junit.Assert.assertNotNull;

public class CommonSteps {

    @Given("the app is launched")
    public void the_app_is_launched() {
        DriverManager.initializeDriver();

        assertNotNull(
                "Driver should be initialized by DriverManager",
                DriverManager.driver
        );

        System.out.println("App launched successfully!");
    }
}

