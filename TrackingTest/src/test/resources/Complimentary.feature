@All
Feature:Complimentary Tracking

  As a complimentary page user
  I want to see all the tracking is generated

  @complimentary
  Scenario: Complimentary Tracking

    Given I visit the "complimentary page"
    And I export the harfile
    Then I should be able to verify the impressions for "Complimentary"