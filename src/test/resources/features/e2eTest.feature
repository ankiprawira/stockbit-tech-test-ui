Feature:
  As a user
  I want to buy products from Sauce Demo
  So that I can complete an online purchase successfully

  Background:
    Given the app is launched

    Scenario: User buy 2 Sauce Lab Bolt T-Shirt
      When User in landing page
      And  User click product "Sauce Lab Back Packs"
      Then User should be able to open Product Page

      When User choose color "Red"
      And User set quantity to 2
      And User add product to cart
      Then User should see cart badge has 2 item

      When User click cart icon
      Then User should see "Sauce Lab Back Packs" with quantity 2 in the cart

      When User click proceed to checkout button
      And User should be redirected to the Login page
      And User fill the login form with username "bod@example.com" and password "10203040"
      And User click login button
      Then User should be redirected to Checkout page

      When User fill in shipping form with:
        | FullName       | John Doe       |
        | Address Line 1 | Liberty Street |
        | Address Line 2 | Freedom Alley  |
        | City           | JNY City       |
        | State/Region   | New York       |
        | Zip Code       | 12345          |
        | Country        | USA            |
      And User click on to payment button
      Then User should be redirected to the Payment page

      When User fill in payment method form
        | FullName       | John Doe        |
        | Card Number    | 123456789123456 |
        | Expiration Date| 05/26           |
        | Security Code  | 2500            |
      And User click on Review Order button
      Then User should be redirected to the Review Order page

      When User click on Place Order button
      Then User should be redirected to the Checkout Complete page
