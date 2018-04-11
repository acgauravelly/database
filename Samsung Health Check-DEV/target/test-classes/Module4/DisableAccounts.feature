@All
Feature:Disable user accounts
  As an Admin user
  I should be able to disable accounts.

  @Disable
  Scenario:Disable user accounts

  Given Iam on Landing Page as an Admin user
   Then I should be able to disable user accounts as required