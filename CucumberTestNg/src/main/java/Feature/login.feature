Feature: nopcommerce login feature

  Scenario: nopCommerce login test page
    Given user enters browser
    And user is on loginpage
    Then user enters username and password
    Then validate home page title
    And user enter valid information
    Then check email created or not
    Then logout page sucessfully working
    Then Browser will be close
    #Examples: 
      #| username            | password |
      #| admin@yourstore.com | admin    |
