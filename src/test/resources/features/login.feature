Feature: Login My Demo App

    Background:
        Given user opens application
        When user login with valid username and password
        Then user should see product page

    Scenario: Proceed to add product to cart and Check Out
        Given user is on product page
        When user selects a product
            And user adds product to cart
            And product should be added to cart
        When user proceeds to checkout
            And user filled the checkout information
            And user filled the payment information
            And user reviews the order
            And user places the order
        Then order should be placed successfully
