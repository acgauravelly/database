Feature: Fetch data from website
  As a website user
  I want to fetch certain data

  @datafetch
  Scenario: Fetching the data

    Given I visit "https://www.google.co.uk/contact/"
    And I get the "searchterm"
    When i search with searchterm
    Then I should be able to get the data
    And make a api call at "http://media.flixfacts.com/staging/flixpreview/index.php?mpn=karmadrone&language=en&live="
