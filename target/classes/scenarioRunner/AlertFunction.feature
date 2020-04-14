Feature: Alert

  Background: The common step for scenarios
    Given  Alerts_I navigate to the given url "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert"

    Scenario: Handling alert
      When Alerts_I click on try it button it should show the alert
      And  Alerts_I switch to alert and accept the alert
      Then Alerts_I switch to default content
    #  When Alerts_I call quit method browser will close

      @Confirmation_popUp
    Scenario: Working with confirmation popup
      Given  Alerts_I navigate to the given web page "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm"
      When   Alerts_I click on try it button it should show the alert
      And    Alerts_I switch to alert and dismiss the alert
      Then   Alerts_I switch to default content
    #  When   Alerts_I call quit method browser will close

      @Prompt_popUp
    Scenario: Working with prompt popup
      Given  Alerts_I navigate to the given webpage "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt"
      When   Alerts_I click on try it button it should show the alert
      And    Alerts_I provide string as "Test String"
      And    Alerts_I take screenshot of the page
      Then   Alerts_I get the text from the prompt
      Then   Alerts_I switch to default content
  #    When   Alerts_I call quit method browser will close

      @Boot_strap_popUp
    Scenario: Working with Boot strap pop up
      Given  Alerts_I navigate to the given page "https://www.w3schools.com/bootstrap/bootstrap_modal.asp"
      When   Alerts_I click on open model button
      Then   Alerts_It should open bootstrap popup
      Then   Alerts_I click on close button to close popup
   #   When   Alerts_I call quit method browser will close