Feature: Commercial Displays

  @commercial

  Scenario:Hospital patient Room

    Given I visit the "hospitalPatientRoom" page
    And I get the categories
    Then I retrieve mpns from each category

  @smart
  Scenario:Pro Centric Smart

    Given I visit the "proCentricSmartDsiplays" page
    And I get the categories
    Then I retrieve mpns from each category

  @value
  Scenario:Pro Centric Value

    Given I visit the "proCentricValueDsiplays" page
    And I get the categories
    Then I retrieve mpns from each category

  @cldisplays
  Scenario:Commercial lite Displays

    Given I visit the "commercialLiteDisplays" page
    And I get the categories
    Then I retrieve mpns from each category

  @oled
  Scenario:Hospitality Oled

    Given I visit the "hospitalityOledDisplays" page
    And I get the categories
    Then I retrieve mpns from each category

  @headend
  Scenario:Head End Systems

    Given I visit the "headEndSystems" page
    And I get the categories
    Then I retrieve mpns from each category

  @interface
  Scenario:Interface controls

    Given I visit the "interfaceControls" page
    And I get the categories
    Then I retrieve mpns from each category

  @commercialLed
  Scenario:commercial leds

    Given I visit the "commercialLed" page
    And I get the categories
    Then I retrieve mpns from each category

  @superSign
  Scenario:Super Sign

    Given I visit the "superSignTvs" page
    And I get the categories
    Then I retrieve mpns from each category
