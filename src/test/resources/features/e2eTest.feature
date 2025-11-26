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