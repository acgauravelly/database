$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Module2/KewordSearch.feature");
formatter.feature({
  "line": 2,
  "name": "Natural search with Keyword",
  "description": "As a MC user\r\nI should be able to search with keyword from natural search",
  "id": "natural-search-with-keyword",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.background({
  "line": 7,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 8,
  "name": "Iam logged in to the Hub as \"admin\" user",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Iam on \"landing page\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 29
    }
  ],
  "location": "AdminFunctionsTest.iamLoggedInToTheHubAsUser(String)"
});
formatter.result({
  "duration": 12708967183,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "landing page",
      "offset": 8
    }
  ],
  "location": "SearchTests.iamOn(String)"
});
formatter.result({
  "duration": 410340540,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Advanced keyword search",
  "description": "",
  "id": "natural-search-with-keyword;advanced-keyword-search",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@advkeysearch"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I should be able to use \"advanced keyword\" search",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "advanced keyword",
      "offset": 25
    }
  ],
  "location": "SearchTests.iShouldBeAbleToUseSearch(String)"
});
formatter.result({
  "duration": 7273456253,
  "status": "passed"
});
});