Feature: To test Bugzilla bug creation

  Scenario: Bugzilla test
    Given Bugzilla_I am at buzilla home page
    Then  Bugzilla_I click on file a bug and navigate to login page
    Then  Bugzilla_I log into the application and navigate to enter bug page
    And   Bugzilla_I provide the details component as "TestComponent" version as "unspecified" severity as "normal" hardware as "Other"
    And   Bugzilla_I provide other details like operating system as "Linux" priority as "Normal" summery as "Bug details" description as "Test Bugzilla"
    And   Bugzilla_I select submit bug button
    And   Bugzilla_I am at summery page and i click logout button
    Then  Bugzilla_I check the page title
          |Bugzilla|

