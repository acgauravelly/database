@All
Feature: As a  user
  I navigate to the url and check if Attach widget service is available

  @AW

  Scenario: Attach Widget interface is available

    Given I navigate to "aw" Url
    Then I should be able to check the "aw"  is displayed