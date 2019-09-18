Feature: web driver wait function

  Background: Common step
    Given   WebdriverWaitFunction_I open face book home page "https://www.facebook.com/"

    Scenario: Fixed web driver wait
      When  WebdriverWaitFunction_I wait "4000" milli second
      Then  WebdriverWaitFunction_I click on login button
      When  WebdriverWaitFunction_I call quit method browser will close

      @ImplicitWait
    Scenario: Implicit wait
      When  WebdriverWaitFunction_I wait "10" second , it should wait 10s for the element
      Then  WebdriverWaitFunction_I click on login button
      And   WebdriverWaitFunction_I send "name" to the user name
      When  WebdriverWaitFunction_I call quit method browser will close

      @ExplicitWait
    Scenario: Explicit wait
      When  WebdriverWaitFunction_I provide the dynamic wait with polling duration 250ms and time out duration as 60s
      Then  WebdriverWaitFunction_I click on login button
      And   WebdriverWaitFunction_I send "name" to the user name
      When  WebdriverWaitFunction_I call quit method browser will close
