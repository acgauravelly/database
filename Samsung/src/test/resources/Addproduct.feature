Feature: Add new product

  @add
  Scenario: Add new product
    Given Iam logged in to MC
    And I add a new product with following
      | Fields        | Values                 |
      | Name          | Test QA                |
      | Heading       | Test Auto              |
      | SubHeading    | Test Product           |
      | Description   | This is a test product |
      | LanguageField | English                |
      | Vendor        | Flixmedia              |
      | MPN           | TestMPN                |
      | Keyword       | TestAutomation         |

    Then I should be able to see the product

