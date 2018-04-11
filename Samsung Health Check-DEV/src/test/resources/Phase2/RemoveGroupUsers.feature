@All
Feature: Remove users from the group from edit view
  As an Admin user
  I should be able to remove a user associated with a group

  @remove
  Scenario: Remove users from group
    Given Iam on Landing Page as an Admin user
    And Iam on the Admin menu
    And I remove a user from a group
    Then the user should be removed from the group


