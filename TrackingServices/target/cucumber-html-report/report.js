$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VideoTracking.feature");
formatter.feature({
  "line": 2,
  "name": "Video Tracking",
  "description": "",
  "id": "video-tracking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenario({
  "line": 12,
  "name": "Minisite Video Tracking",
  "description": "",
  "id": "video-tracking;minisite-video-tracking",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@Minisitevideos"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I visit the \"minisite\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I play the \"minisite\" Video",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I should be able to verify the impressions for \"minisite videos\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "minisite",
      "offset": 13
    }
  ],
  "location": "TrackingTests.iVisitThe(String)"
});
formatter.result({
  "duration": 22669998938,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "minisite",
      "offset": 12
    }
  ],
  "location": "TrackingTests.iPlayTheVideo(String)"
});
