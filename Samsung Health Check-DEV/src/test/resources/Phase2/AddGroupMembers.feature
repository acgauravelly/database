@All
Feature:Add group members form edit group view

  As an admin user
  I should be able to add users from edit group view

  @addGM
  Scenario:Adding group members
    Given Iam on Landing Page as an Admin user
    And Iam on the Admin menu
    And I add users to the group
    Then I should see the group name assigned under edit user
