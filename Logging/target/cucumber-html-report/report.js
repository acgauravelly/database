$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AttachWidget.feature");
formatter.feature({
  "line": 2,
  "name": "AW Tracking",
  "description": "",
  "id": "aw-tracking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "AW Impression",
  "description": "",
  "id": "aw-tracking;aw-impression",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@AW"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I visit the \"aw\"",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#    And I export the harfile"
    }
  ],
  "line": 8,
  "name": "I should be able to verify the impressions for \"attach widget\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "aw",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitTheClamp(String)"
});
formatter.result({
  "duration": 41657307745,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "attach widget",
      "offset": 48
    }
  ],
  "location": "TrackingTests.iShouldBeAbleToVerifyTheImpressionsFor(String)"
});
formatter.result({
  "duration": 14825368,
  "status": "passed"
});
});