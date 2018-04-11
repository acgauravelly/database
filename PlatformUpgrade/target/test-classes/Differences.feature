Feature: Find diff between dev and prod urls

  @diff
  Scenario Outline: Difference

    Given I open the  "<devurl>"
    And I read the "dev" pagesource
    When I open the  "<produrl>"
    And I read the "prod" pagesource
    Then there should be no differences

    Examples:
      | devurl                                                  | produrl                                                 |
#      | http://dev-delivery.flix360.com/inpage/show/6/us/805216 | C:\\Users\\Ajay\\Downloads\\lg-page.html |
#      | http://dev-delivery.flix360.com/inpage/show/6/us/805216 | http://origin.flixcar.com/delivery/inpage/show/6/us/1142786 |
#      | http://dev-delivery.flix360.com/inpage/show/6/us/805216 | http://dev-delivery.flix360.com/inpage/show/6/en/876063 |
      | http://dev-delivery.flix360.com/inpage/show/6/en/876063 | http://dev-delivery.flix360.com/inpage/show/6/en/876068 |