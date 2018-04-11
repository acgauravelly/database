@All
Feature:Restriction to delete xml product
  As an Admin user
  I should not be able to delete an xml created product


  Background:
    Given Iam on Landing Page as an Admin user
     And  Iam on the xml created product

  @XmlProduct
  Scenario:Not able to delete xml product
    Then I should  not be able to delete the product

  @AssetsofXml
  Scenario:Not able to delete Assets of xml product
    Then I should not be able delete the assets of an xml created product

  @DeleteManualassets
  Scenario:Ability to delete manually uploaded assets of xml product
    Then I should be able to delete a manually uploaded asset

