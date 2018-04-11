@All
Feature:Video Tracking

  @Inpagevideos
  Scenario:Video Tracking
    Given I visit the "Video Clamp"
   # And I play the Video
    And I export the harfile
    Then I should be able to verify the impressions for "inpage videos"

  @Minisitevideos
  Scenario:Video Tracking
    Given I visit the "Minisite video  url"
 # And I play the Video
    And I export the harfile
    Then I should be able to verify the impressions for "minisite videos"