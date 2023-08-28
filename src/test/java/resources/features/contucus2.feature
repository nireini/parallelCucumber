@contact-us2

Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page2
    When I enter a unique first name joe
    And I enter a unique last name blogs
    And I enter a unique email Joe_blogs123@mail.com
    And I enter a unique comment "comment"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message