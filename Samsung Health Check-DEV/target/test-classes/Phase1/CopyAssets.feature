@All
Feature: Copying assets to different languages
  As an admin user
  I should be able to copy assets from a product to different products and languages

  @copy
  Scenario: Copying assets to other languages
    Given Iam on Landing Page as an Admin user
    And I click on BatchAssociation
    And select a from product and to product
    And I click Save and Update
    Then assets should be copied over

