@All
  Feature: Login

    @Test1 @Positive @Login
    Scenario: Login
      Given User is on login page
      When User fill username and password
      And User click login button
      Then User verify login result

    @Test2 @Negative @Login
    Scenario: Login invalid username and password
      Given User is on login page
      When User fill wrong username and password
      And User click login button
      Then User get error message