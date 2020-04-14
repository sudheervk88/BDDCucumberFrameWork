@BrowserRuntime
Feature: Browser function

  Background: Common actions
    Given BrowserFunction_I have chrome driver instance

  Scenario: Browser function open web page

    And   BrowserFunction_I navigate to "http://the-internet.herokuapp.com/"
   # When  BrowserFunction_I call quit method browser will close


  Scenario: Browser function back,forward and refresh
    And   BrowserFunction_I navigate to "http://the-internet.herokuapp.com/"
    And   BrowserFunction_I navigate to "https://www.google.com/"
    Then  BrowserFunction_I call back api
    Then  BrowserFunction_I call forward api
    Then  BrowserFunction_I call refresh api
  #  When  BrowserFunction_I call quit method browser will close

  Scenario: Browser maximize
    When  BrowserFunction_I maximize the browser
  #  When  BrowserFunction_I call quit method browser will close
