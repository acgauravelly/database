@All
Feature:Restricting embargo content
  As an Embargo user
  I shoul dbe able to see the content before standard users

  @Embargo
  Scenario: Embargo Content
    Given Iam logged in as Embargo User
    And Iam on the Embargo page
    Then I should see the embargo content

  @standard
  Scenario: :Restrict embargo content
    Given Iam logged in as a standard user
    And Iam on the Embargo page
    Then I should not see the emabrgo content

