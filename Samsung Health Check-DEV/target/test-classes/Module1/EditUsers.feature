@All
Feature:Edit user details
  As an Admin user
  I should be able to edit user details

  @EditUser
  Scenario:Editing the existing user details
    Given Iam on Landing Page as an Admin user
    Then I should be able to edit the existing user details  in the system
    And  verify the changed details