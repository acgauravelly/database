Feature: Filter out Penis word

  @penis
  Scenario Outline: Filter out the Word penis from the MOT

    Given Iam on the mot "<page>"
    And I expand features
    When I search for the word "penis"
    Then I should not find the word

    Examples:
      | page                                                       |
      | http://media.flixcar.com/delivery/mobile/show/6/ae/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/zh/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/hk/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/tw/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/hr/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/cz/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/nl/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/be/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/au/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b1/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b5/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e9/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e1/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/in/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e2/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ie/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e4/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b3/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/nz/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e5/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/d2/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b7/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/za/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/s7/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b9/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e6/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/u1/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/us/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/e7/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/fi/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/fr/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/b4/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/c4/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/s5/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/de/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/at/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/s4/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/el/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/hu/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/id/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/it/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/s6/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ja/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ko/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/no/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/pl/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/pt/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/br/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ro/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ru/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/sk/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/sl/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/es/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/f4/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/cl/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/f5/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/mx/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/pa/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/pe/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/sv/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/ti/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/tr/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/vn/1098461 |
      | http://media.flixcar.com/delivery/mobile/show/6/en/1098461 |
