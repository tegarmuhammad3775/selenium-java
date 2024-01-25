@All
  Feature: Para bank Registration

    @positive @register
    Scenario: Success register
      Given User is on parabank homepage
      When User is in register page
      Then User input name
      And User input address detail
      And User fill valid username and password
      And User input password confirmation
      When user click Register button
      Then user regist successfully

    @negative @register
    Scenario: Failed register - Missmatch Password
      Given User is on parabank homepage
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input password confirmation
      And User input invalid password confirmation
      When User click Register button
      Then user get error password did not match
