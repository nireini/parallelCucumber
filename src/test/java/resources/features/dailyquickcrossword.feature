@dailyquickcrossword

Feature: Daily Quick Crossword - Crossword Page

  Scenario: Verify that the level completion screen appears after successfully finishing the day
  puzzle
    Given I access the Daily Quick Crossword page
    When I click agree button
    And I click play button
    And click On Current Day With Daily Bonus
    And Compare Date Text
    And click On Reveal Button
    And click On Reveal Puzzle Button
    And Check Results Title Is Displayed
    And Check SECTION COMPLETED WITHOUT HELP OR ERRORS Is_Displayed
    And Check RESULT FOR COMPLETED WITHOUT HELP OR ERRORS Is Displayed
    And Check SECTION COMPLETION SCORE is displayed
    And Check RESULT FOR COMPLETION SCORE is displayed
    And Check SECTION TIME is displayed
    And Check RESULT FOR PUZZLE TIME COMPLETION is displayed
    And Check SECTION DAILY BONUS is displayed
    And Check RESULT FOR DAILY BONUS is displayed
    And Check SECTION PUZZLE SCORE is displayed
    And Check RESULT FOR PUZZLE SCORE is displayed
    And Check SECTION TOTAL SCORE is displayed
    And Check RESULT FOR TOTAL SCORE is displayed
    And Check SECTION ONE PUZZLE THIS MONTH is displayed
    And Check REVIEW ANSWERS BUTTON is displayed
    And Click Submit total score button
    Then Click on play again button