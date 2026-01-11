Feature: Login My Demo App

    Background:
        Given user opens application
        When user login with valid username and password
        Then user should see product page

    Scenario: Add product to cart
        Given user is on product page
        When user selects a product
            And user adds product to cart
        Then product should be added to cart
