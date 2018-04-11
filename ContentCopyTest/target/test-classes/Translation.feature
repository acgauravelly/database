Feature: Xml Translation
  As a Qa
  I should be able to check the translation is correct as of XML

  @translation
  Scenario: Translation check
    Given I read the xml from csv
    And I get the value of node