@All
Feature:Add a new user
  As an Admin user
  I should be able to add users

  Background:
    Given Iam logged in to the Hub as "admin" user
    And Iam on the "admin" menu

  @adduser
  Scenario: Adding a new user as an admin


    When I add a new user
      | Fields     | value                 |
      | First Name | Test                  |
      | Last name  | Automation            |
      | Email      | Autotest@flixmedia.tv |
      | Language   | Dutch                 |
      | Group      | Marketing             |
      | User       | Admin                 |


    Then I should be able to see the newly added user in the list of users

  @batch
  Scenario: Batch upload users

    And I click on "batch upload users"
    When I upload a csv file
      | File name            | File path                          |
      | samsung_sample_login | C:\Assets\samsung_sample_login.csv |
    Then I should be able to see the batch users added

  @editUsers
  Scenario: Edit user details

    When I edit the "test user"
    And I fill the details as
      | Fields     | Values   |
      | First name | QA       |
      | Last Name  | Auto123 |
      | Groups     | None     |
    Then I should be able to see the above changes

    @catPriority
    Scenario: Category priority

      And I click on "set category priority"
      When I drag and drop the categories to the desired order
      Then search results should be in that order

