@All
Feature:Assign users to group
  As an Admin user
  I should be able to Assign users to a group

  @AssignUser
  Scenario:Assign users to a group

    Given Iam on Landing Page as an Admin user
    And  Iam on the Admin menu
    Then I should be able to Assign users to groups