@cloudtables
Feature: DDT example with Cloudtables

  Scenario Outline: Adding multiple users to the table
    Given User is on cloudtables homepage
    When User clicks on New button
    When User enters "<firstname>" to firstname field
    And User enters "<lastname>" to lastname field
    And User enters "<position>" to position field
    And User enters "<salary>" to salary field
    And User clicks on create button

    Examples:
      | firstname | lastname | position            | salary |
      | Omer      | K        | SDET                | 115000 |
      | Esin      | Y        | Automation Engineer | 150000 |
      | Nazli     | C        | Developer           | 130000 |
      | Eduardo   | Z        | UI Developer        | 180000 |