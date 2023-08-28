@dailyquickcrossword

Feature: Daily Quick Crossword - Crossword Page

  Scenario: Validate li element present in iframe
    Given I access the Daily Quick Crossword page
    When I click agree button
    And I click play button
    Then li element present in iframe