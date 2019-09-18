
Feature: working with iframe

  Background: common step
    Given  IFrame_I navigate to url "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe"


    Scenario: Click on the elements in the iframe
      When  IFrame_I click on the element in the iframe it should click
      And   IFrame_I click on home button
  #    When  IFrame_I call quit method browser will close

      @Window
    Scenario: working with multiple window
      Given   MultipleWindow_I open the web page "https://www.w3schools.com/js/js_popup.asp"
      Then    MultipleWindow_I click on button it will open child browser window
      And     MultipleWindow_I switch to child browser and click on home button
   #   When    IFrame_I call quit method browser will close
