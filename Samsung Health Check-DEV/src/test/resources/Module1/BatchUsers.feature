@All
Feature:Batch upload users
  As an Admin user
  I should be able to Batch upload  users

  @BatchUsers
  Scenario:Adding users via Batch upload using a csv file
    Given Iam on Landing Page as an Admin user
    And  I upload a csv file in the required format
    Then I should be able to see the newly added users in the system