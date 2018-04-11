#@All
Feature: Log in to MC

  @login
  Scenario: Log in
    Given I navigate to loginUrl
    And I do a default Login
    Then I should be logged in
