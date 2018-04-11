Feature: Request Access

  @access
  Scenario: Request Access
    Given Iam on login page
    And I click request access link
    And I fill the form with the values
      | Fields      | Values                     |
      | first name  | Test                       |
      | lastName    | LastName                   |
      | email       | qa.automation@flixmedia.tv |
      | company     | Test                       |
      | country     | United Kingdom             |
      | jobTitle    | QA                         |
      | heardFrom   | Test                       |
      | agency      | Retailer                   |
      | agencyTitle | Test                       |
    Then I should see the confirmation message
