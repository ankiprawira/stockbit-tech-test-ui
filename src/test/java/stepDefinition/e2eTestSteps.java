package stepDefinition;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.*;

import java.util.Map;

import static base.DriverManager.driver;

public class e2eTestSteps {

    LandingPage landingPage;
    ProductPage productPage;
    MyCartPage myCartPage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @When("User in landing page")
    public void userInLandingPage() {
        landingPage = new LandingPage(driver);
        landingPage.assertLandingPageDisplayed();
    }

    @And("User click product {string}")
    public void userClicksProduct(String productName) {
        landingPage.clickProductByName(productName);
    }

    @Then("User should be able to open Product Page")
    public void productPageShouldBeOpened(){
        productPage = new ProductPage(driver);
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
        myCartPage = new MyCartPage(driver);
        myCartPage.assertMyCartPage(productName, expectedQty);
    }

    @When ("User click proceed to checkout button")
    public void userClickProceed(){
        myCartPage.clickProceed();
    }

    @And ("User should be redirected to the Login page")
    public void assertLoginPage(){
        loginPage = new LoginPage(driver);
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

    @Then ("User should be redirected to Checkout page")
    public void assertCheckoutPage(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.assertCheckoutPage();
    }

    @When("User fill in shipping form with:")
    public void userFillShippingForm(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        checkoutPage.insertShipping(
                data.get("FullName"),
                data.get("Address Line 1"),
                data.get("Address Line 2"),
                data.get("City"),
                data.get("State/Region"),
                data.get("Zip Code"),
                data.get("Country")
        );
    }

    @And("User click on to payment button")
    public void userClickToPayment() {
        checkoutPage.clickToPayment();
    }
}
