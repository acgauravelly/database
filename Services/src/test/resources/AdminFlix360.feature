@All
Feature: As an admin flix360 user
   I navigate to the url and check if service is available

  @AF360

  Scenario: Admin flix360 interface is available

    Given I navigate to "adminFlix360" Url
    Then I should be able to check the "LoginForm"  is displayed