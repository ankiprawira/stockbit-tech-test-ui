package stepDefinition;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCartPage;
import pages.ProductPage;

public class e2eTestSteps {

    LandingPage landingPage;
    ProductPage productPage;
    MyCartPage myCartPage;
    LoginPage loginPage;

    @When("User in landing page")
    public void userInLandingPage() {
        landingPage = new LandingPage(DriverManager.driver);
        landingPage.assertLandingPageDisplayed();
    }

    @And("User click product {string}")
    public void userClicksProduct(String productName) {
        landingPage.clickProductByName(productName);
    }

    @Then("User should be able to open Product Page")
    public void productPageShouldBeOpened(){
        productPage = new ProductPage(DriverManager.driver);
        productPage.assertProductPageDisplayed();
    }

    @When("User choose color {string}")
    public void userChooseColor(String colorName){
        productPage.chooseColor(colorName);
    }

    @And("User set quantity to {int}")
    public void userSetQty(Integer qty){
        productPage.setQty(qty);
    }

    @And("User add product to cart")
    public void userAddToCart(){
        productPage.clickAddToCart();
    }

    @Then("User should see cart badge has {int} item")
    public void verifyCartCount(int expectedCount) {
        productPage.assertCartBadgeCount(expectedCount);
    }

    @When("User click cart icon")
    public void uerClickCartIcon(){
        productPage.clickCartIcon();
    }

    @Then("User should see {string} with quantity {int} in the cart")
    public void userSeeCartPage(String productName, Integer expectedQty){
        myCartPage = new MyCartPage(DriverManager.driver);
        myCartPage.assertMyCartPage(productName, expectedQty);
    }

    @When ("User click proceed to checkout button")
    public void userClickProceed(){
        myCartPage.clickProceed();
    }

    @And ("User should be redirected to the Login page")
    public void assertLoginPage(){
        loginPage = new LoginPage(DriverManager.driver);
        loginPage.assertLoginPage();
    }

    @And ("User fill the login form with username {string} and password {string}")
    public void userFillLoginForm(String userName, String password){
        loginPage.insertPasswordAndUsername(userName, password);
    }

    @And ("User click login button")
    public void clickLogin(){
        loginPage.clickLogin();
    }
}
