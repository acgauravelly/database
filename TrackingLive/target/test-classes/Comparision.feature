@Additional
Feature:Comparision Table Tracking

  @comparisionInpage
  Scenario:Comparision table  Impression on Inpage
    Given I visit the "Comparision Clamp"
    And I export the harfile
    Then I should be able to verify the impressions for "Comparision table"

#    @comparisionMinisite

  #  Scenario: Comparision table Impression on Minisite
   #   Given I visit the "minisite comparision url"
    #  And I export the harfile
     # Then I should be able to verify the impressions for "Comparision table"