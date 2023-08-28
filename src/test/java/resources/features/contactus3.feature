@contact-us3

Feature: Submit data to webdriveruniversity.com using contact us form

  Background:
    Given I access the wedriver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    When I enter a unique last name
    And I enter a unique email address
    And i enter comments comment
    When i click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    When I enter a specific first name sarah
    And I enter a specific last name woods
    And I enter a specific email address sarah_woods123@mail.com
    And I enter a specific comment "How are you today?"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message