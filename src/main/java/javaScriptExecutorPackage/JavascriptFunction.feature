Feature: To test javascript executor based activities

  Scenario: click operation using js
    When JS Function_I navigate to google page "https://www.google.com/"
    Then JS Function_I click on Sign in button