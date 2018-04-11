Feature: Log in

  @Login
  Scenario Outline: : Log in to MC
    Given Iam on login page
    And I login as "<user>" with "<password>"
    Then I should be able to access landing page

    Examples:
      | user              | password |
      | ajay@flixmedia.tv | Pass123  |