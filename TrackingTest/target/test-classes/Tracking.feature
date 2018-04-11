@All
Feature: Verify impressions are present for Inpage,Minisite,Reviews ,Hotspots

  @reviews
  Scenario: Review impression
    Given I visit the "clamp url"
    And I export the harfile
    Then I should be able to verify the impressions for "reviews"


  @hotspots
  Scenario: Hotspot impression
    Then I should be able to verify the impressions for "hotspots"

  @inpage
  Scenario: Inpage impression
    Then I should be able to verify the impressions for "inpage"

  @minisite
  Scenario: Minisite impression
    Then I should be able to verify the impressions for "minisite"

  @minisitereviews
  Scenario: Review impression on Minisite
    Given I visit the "Minisite reviews  url"
    And I export the harfile
    Then I should be able to verify the impressions for "reviews"

  @mediaload
  Scenario:Video Tracking
#    Given I visit the "clamp url"
#   # And I play the Video
#    And I export the harfile
    Then I should be able to verify the impressions for "inpage videos"