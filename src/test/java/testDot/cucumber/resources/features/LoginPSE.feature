Feature: Login into PSe website

  Scenario: User login using valid email and password
    Given User launch the website
    And User input registered email
    And User input valid password
    When User click login button
    Then Screen redirected to main page

  Scenario: User login using valid username and password
    Given User launch the website
    And User input registered username
    And User input valid password
    When User click login button
    Then Screen redirected to main page

  Scenario: User login using valid email but with wrong password
    Given User launch the website
    And User input registered email
    And User input wrong password
    When User click login button
    Then Error password incorrect

  Scenario: User login using unregistered email
    Given User launch the website
    And User input unregistered email
    And User input any password
    When User click login button
    Then Error email unknown

  Scenario: User login when email field still empty
    Given User launch the website
    And User input any password
    When User click login button
    Then Error email required

  Scenario: User login when password field still empty
    Given User launch the website
    And User input registered email
    When User click login button
    Then Error password empty



