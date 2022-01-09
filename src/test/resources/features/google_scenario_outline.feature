@google_scenario_outline
@regression
@Smoke
Feature: Data driven testing using Scenario outline with Examples table

  Scenario Outline: Google capital cities search
    Given User is on google home page
    When User searches for "<country>" capital
    Then User should see "<capital>" in the result
    Examples:
      | country| capital|
      | USA    | Washington DC |
      | Turkey | Ankara |
      | Ukraine| Kyiv |
      | Turkmenistan| Ashgabat |
      | Latvia | Riga |
      | Uzbekistan | Tashkent |
      | Eritrea | Asmara |