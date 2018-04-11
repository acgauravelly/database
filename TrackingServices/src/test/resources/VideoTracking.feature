@All
Feature:Video Tracking

  @Inpagevideos
  Scenario:Inpage Video Tracking
    Given I visit the "inpage"
    And I play the "inpage" Video
    And I export the harfile
    Then I should be able to verify the impressions for "inpage videos"

  @Minisitevideos
  Scenario:Minisite Video Tracking
    Given I visit the "minisite"
    And I play the "minisite" Video
    And I export the harfile
    Then I should be able to verify the impressions for "minisite videos"