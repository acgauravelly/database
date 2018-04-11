Feature: Dyson content on Darty check

  @dyson
  Scenario Outline:Ensure Dyson content is available on darty

    Given I navigate to "<dartyUrl>"
    Then I should see our dyson content

    Examples:
      | dartyUrl                                                                                                        |
      | http://www.darty.com/nav/achat/petit_electromenager/chauffage_ventilation/purificateur/dyson_hot_cool_hp02.html |