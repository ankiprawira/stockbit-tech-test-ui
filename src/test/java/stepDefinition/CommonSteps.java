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

