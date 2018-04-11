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
  "duration": 52191062940,
  "status": "passed"
});
formatter.match({
  "location": "TrackingTests.iExportTheHarfile()"
});
formatter.result({
  "duration": 20608092345,
  "error_message": "org.json.JSONException: JSONObject[\"request\"] not found.\r\n\tat org.json.JSONObject.get(JSONObject.java:498)\r\n\tat org.json.JSONObject.getJSONObject(JSONObject.java:592)\r\n\tat Pages.BasePage.logEntries(BasePage.java:123)\r\n\tat Pages.TrackingPage.writeLogstoHarfile(TrackingPage.java:96)\r\n\tat Tests.TrackingTests.iExportTheHarfile(TrackingTests.java:57)\r\n\tat ✽.And I export the harfile(AttachWidget.feature:8)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
});