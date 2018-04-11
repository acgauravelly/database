@All
Feature:Remove users from group
  As an Admin user
  I should be able to remove users form a group

  @RemoveUser
  Scenario:Remove users from a group

    Given Iam on Landing Page as an Admin user
    And  Iam on the Admin menu
    Then I should be able to remove users form groups