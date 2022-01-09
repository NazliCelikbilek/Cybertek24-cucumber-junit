@google
@regression
@Smoke
Feature: Passing multiple parameters to the step

  Scenario: User should be able to search titles
    Given User is on google home page
    Then User should be able to search for following:
      |java|
      |selenium|
      |cucumber bdd|
      |QA automation|
      |wooden spoon|