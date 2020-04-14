Feature: To test javascript executor based activities

  Scenario: click operation using js
    Given JS Function_I navigate to google page "https://www.google.com/"
    When  JS Function_I click on Sign in button