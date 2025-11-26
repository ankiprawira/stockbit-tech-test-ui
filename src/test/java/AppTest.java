import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

    static AppiumDriver driver;

    public static void main(String[] args){
        openMobileApp();
    }

    public static void openMobileApp() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("sdk_gphone64_x86_64");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.saucelabs.mydemoapp.android");
        options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AppiumDriver(url, options);
        System.out.println("✅ App launched successfully!");

    }
}
