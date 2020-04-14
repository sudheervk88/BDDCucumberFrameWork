Feature: Face book

  Background: Common step for web element
    Given WebElement Function_I open face book page "https://www.facebook.com/"

  Scenario: Get element from face book
    When  WebElement Function_I provide unique locator to find element
    Then  WebElement Function_I should get web element
    When  BrowserFunction_I call quit method browser will close

  Scenario: Get Multiple elements
    When  WebElement Function_I provide non unique locator to find element
    Then  WebElement Function_I should get list of web elements
    When  BrowserFunction_I call quit method browser will close

  Scenario:  Work with text box field
    When   WebElement Function_I call send key method value "abcd" should enter in the text box
    When   WebElement Function_I call get text method value should return
    When   WebElement Function_I call clear method the value should clear
    When   BrowserFunction_I call quit method browser will close

    @Smoke
  Scenario:  Work with button,check box,hyperlink and Radio button
    When   WebElement Function_I click on button it should perform the click action
    When   WebElement Function_I click on radio button it should get selected
    When   WebElement Function_I click on hyper link it should get open
    When   BrowserFunction_I call quit method browser will close

  @Smoke-dropdown
  Scenario: work with drop down boxes
   When     WebElement Function_I select value by visible text it should select the value
   When     WebElement Function_I select value by index it should select the value
   When     WebElement Function_I select value by value method it should select the value
   When     WebElement Function_I call get option it should print all values in the drop down
   When     BrowserFunction_I call quit method browser will close