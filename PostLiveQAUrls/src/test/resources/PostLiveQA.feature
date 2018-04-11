Feature: Dev urls not present

  @devUrls
  Scenario Outline: Making sure Post live urls do not have dev content
    Given I navigate to the "<url>"
    And I wait for logs to be exported
    Then there should be no dev urls present

    Examples:
      | url                 |
      | http://google.co.uk |
