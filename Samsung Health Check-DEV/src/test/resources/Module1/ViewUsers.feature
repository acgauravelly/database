@All
Feature:View users
  As an Admin user
  I should be able to view users

  @ViewUsers
  Scenario:View added users
    Given Iam on Landing Page as an Admin user
    Then I should be able to view the users in the system and make changes