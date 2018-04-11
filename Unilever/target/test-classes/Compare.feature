Feature: Compare our content with WC

  @compare
  Scenario Outline: Cmpare unilver content

    Given I visit the "<wcurl>"
    And I get the "wc" content
    When  I visit the "<Flixurl>"
#    And I get the "flix" content
    Then the content should match

    Examples:
      | wcurl                                                       | Flixurl                                                                                                                  |
      | http://origin.flixcar.com/delivery/inpage/show/6/us/1310706 | http://www.webcollage.net/MainApp/preview-ppp?module=suave&site=epartner&wcpc=1372368513318&view=live&rcpName=Webcollage |