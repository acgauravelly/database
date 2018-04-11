Feature: JS errors

  @jserror
  Scenario Outline: : JS Errors not present
    Given Iam on the "<flixUrl>"
    Then I should not see any JS errors

    Examples:
      | flixUrl                                                                                                           |
      | http://origin.flixcar.com/delivery/inpage/show/6/en/1163602                                                       |
      | http://origin.flixcar.com/delivery/minisite/show/6/en/1163602                                                     |
      | http://origin.flixcar.com/delivery/inpage/show/6/es/1163602                                                       |
      | http://origin.flixcar.com/delivery/minisite/show/6/es/1163602                                                     |
      | http://origin.flixcar.com/delivery/inpage/show/6/it/1163602                                                       |
      | http://origin.flixcar.com/delivery/minisite/show/6/it/1163602                                                     |
      | http://origin.flixcar.com/delivery/inpage/show/6/fr/1163602                                                       |
      | http://origin.flixcar.com/delivery/minisite/show/6/fr/1163602                                                     |
      | http://origin.flixcar.com/delivery/inpage/show/6/de/1163602                                                       |
      | http://origin.flixcar.com/delivery/minisite/show/6/de/1163602                                                     |
      | http://demo.flixmedia.tv/inpage/v2/demo/dev/darty/darty-mot.php?mpn=SM-G935FZDAXFA&ean=&distributor=6&language=en |