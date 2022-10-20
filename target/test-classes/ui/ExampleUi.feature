@ui
Business Need: UI Validation Test

  Scenario: User can use Location filter to find job
    Given User is on the workatbackbase.com
    When User select 'Krakow' location
    Then In filter section appears 'Krakow' name

  Scenario: User can use Function filter to find job
    Given User is on the workatbackbase.com
    And User select 'QA' as a function
    Then In filter section appears 'QA' name
