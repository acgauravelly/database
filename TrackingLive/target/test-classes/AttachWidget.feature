@Additional
Feature:AW Tracking

  @AW
  Scenario:AW Impression
    Given I visit the "attach widget Clamp"
   # And I play the Video
    And I export the harfile
    Then I should be able to verify the impressions for "attach widget"