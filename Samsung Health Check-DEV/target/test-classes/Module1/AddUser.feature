@All
Feature:Add a new user
  As an Admin user
  I should be able to add users

  @AddUser
  Scenario:Adding a new user
    Given Iam on Landing Page as an Admin user
    And I add a new user
    Then I should be able to see the newly added user in the system