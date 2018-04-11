@All
Feature:Hotspots

  @hotspot
  Scenario: Hotspot impression
    Given I visit the "hotspot url"
    And I export the harfile
    Then I should be able to verify the impressions for "hotspots"