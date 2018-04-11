Feature: Scraping

  @content
  Scenario Outline: Compare content

    Given I visit  "<webCollageUrl>"
    Then  I get the text from the page
    And I visit  "<FlixUrl>"
    Then I get the text from the "Flix" page
    Then I should be able to compare

    Examples:
      | webCollageUrl                                                                                                             |FlixUrl|
      | http://www.webcollage.net/MainApp/preview-ppp?module=stives&site=epartner&wcpc=1415829748269&view=live&rcpName=Webcollage |http://origin.flixcar.com/delivery/inpage/show/6/us/1310432|
#      | http://www.webcollage.net/MainApp/preview-ppp?module=stives&site=epartner&wcpc=1371571157608&view=live&rcpName=Webcollage |
#      | http://www.webcollage.net/MainApp/preview-ppp?module=stives&site=epartner&wcpc=1371570783457&view=live&rcpName=Webcollage |
#      | http://www.webcollage.net/MainApp/preview-ppp?module=stives&site=epartner&wcpc=1371572119974&view=live&rcpName=Webcollage |