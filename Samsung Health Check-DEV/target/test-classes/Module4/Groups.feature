@All,@dec
Feature:Create groups and apply restrictions
  As a Admin user
  I should be able to create groups and should  apply restrictions


  @Groups
  Scenario:Ability to create groups and manage
    Given Iam on Landing Page as an Admin user
    Then I should be able to create a group
    And  I should manage restrictions