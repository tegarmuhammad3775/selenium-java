@All
  Feature: Login

    @login_test
    Scenario: Login
      Given User is on login page
      When User fill username and password
      And User click login button
      Then User verify login result