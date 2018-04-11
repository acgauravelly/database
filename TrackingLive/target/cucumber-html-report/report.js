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
      "name": "@Additional"
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
  "name": "I visit the \"attach widget Clamp\"",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "# And I play the Video"
    }
  ],
  "line": 8,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I should be able to verify the impressions for \"attach widget\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "attach widget Clamp",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitThe(String)"
});
formatter.result({
  "duration": 57834757332,
  "status": "passed"
});
formatter.match({
  "location": "TrackingTests.iExportTheHarfile()"
});
formatter.result({
  "duration": 22275495754,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "attach widget",
      "offset": 48
    }
  ],
  "location": "TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(String)"
});
formatter.result({
  "duration": 147255705,
  "status": "passed"
});
formatter.uri("Comparision.feature");
formatter.feature({
  "line": 2,
  "name": "Comparision Table Tracking",
  "description": "",
  "id": "comparision-table-tracking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Additional"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Comparision table  Impression on Inpage",
  "description": "",
  "id": "comparision-table-tracking;comparision-table--impression-on-inpage",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@comparisionInpage"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I visit the \"Comparision Clamp\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should be able to verify the impressions for \"Comparision table\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Comparision Clamp",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitThe(String)"
});
formatter.result({
  "duration": 49861567324,
  "status": "passed"
});
formatter.match({
  "location": "TrackingTests.iExportTheHarfile()"
});
formatter.result({
  "duration": 21662509232,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Comparision table",
      "offset": 48
    }
  ],
  "location": "TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(String)"
});
formatter.result({
  "duration": 2272423,
  "error_message": "java.lang.AssertionError: Har file not created\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Pages.BasePage.additionalFeaturesTracking(BasePage.java:305)\r\n\tat Tests.TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(TrackingTests.java:79)\r\n\tat ✽.Then I should be able to verify the impressions for \"Comparision table\"(Comparision.feature:8)\r\n",
  "status": "failed"
});
formatter.uri("Reviews.feature");
formatter.feature({
  "line": 2,
  "name": "Reviews Logging",
  "description": "",
  "id": "reviews-logging",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Additional"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Reviews impresion on Inpage",
  "description": "",
  "id": "reviews-logging;reviews-impresion-on-inpage",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@inpagereviews"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I visit the \"clamp url\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I should be able to verify the impressions for \"reviews\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "clamp url",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitThe(String)"
});
formatter.result({
  "duration": 49807585100,
  "status": "passed"
});
formatter.match({
  "location": "TrackingTests.iExportTheHarfile()"
});
formatter.result({
  "duration": 21665491202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "reviews",
      "offset": 48
    }
  ],
  "location": "TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(String)"
});
formatter.result({
  "duration": 1368745,
  "error_message": "java.lang.AssertionError: Har file not created\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat Pages.BasePage.Tracking(BasePage.java:214)\r\n\tat Tests.TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(TrackingTests.java:71)\r\n\tat ✽.Then I should be able to verify the impressions for \"reviews\"(Reviews.feature:9)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 12,
  "name": "Reviews impression on Minisite",
  "description": "",
  "id": "reviews-logging;reviews-impression-on-minisite",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@minisitereviews"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I visit the \"Minisite reviews  url\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I should be able to verify the impressions for \"reviews\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Minisite reviews  url",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitThe(String)"
});
formatter.result({
  "duration": 49964166446,
  "status": "passed"
});
formatter.match({
  "location": "TrackingTests.iExportTheHarfile()"
});
formatter.result({
  "duration": 21615770519,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "reviews",
      "offset": 48
    }
  ],
  "location": "TrackingTests.iShouldBeAbleToVerifyTheTrackingFor(String)"
});
formatter.result({
  "duration": 37288912,
  "status": "passed"
});
});