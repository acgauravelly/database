Feature: Proxying

  @proxy
  Scenario Outline: Test website speed through proxy

    Given I navigate to the "<url>" with proxy
    And I wait for content to load
    Then I measure the time taken

    Examples:
      | url                                                                                           |

#      | http://media.flixfacts.com/staging/darty/darty-new-live.php?distributor=2754&mpn=TR4110BL1&language=fr |
      | http://www.mediamarkt.de/de/product/_samsung-galaxy-j5-2017-duos-blue-16-gb-blau-2279580.html |