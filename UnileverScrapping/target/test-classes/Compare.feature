@All
Feature: Compare our content with WC

  @compare
  Scenario Outline: Compare unilver content

    Given I visit the "<WCurl>"
    And I get the "wc" content
    When  I  also visit the "<Flixurl>"
    And I get the "flix" content
    Then the content should match

    Examples:
      | WCurl                                                                                                                    | Flixurl                                                     |
      | http://www.webcollage.net/MainApp/preview-ppp?module=suave&site=epartner&wcpc=1372368513318&view=live&rcpName=Webcollage | http://origin.flixcar.com/delivery/inpage/show/6/us/1310706 |



