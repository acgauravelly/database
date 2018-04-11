$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Inpage.feature");
formatter.feature({
  "line": 3,
  "name": "JW",
  "description": "As a user\r\nI want to play the JW player",
  "id": "jw",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@All,"
    },
    {
      "line": 2,
      "name": "@inpage"
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
  "name": "I visit \"inpage\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I switch to the iframe for  the JW player",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "inpage",
      "offset": 9
    }
  ],
  "location": "JWPlayerTest.iVisit(String)"
});
formatter.result({
  "duration": 6720416802,
  "status": "passed"
});
formatter.match({
  "location": "JWPlayerTest.iSwitchToTheIframeForTheJWPlayer()"
});
formatter.result({
  "duration": 15090522181,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "JW player is Idle",
  "description": "",
  "id": "jw;jw-player-is-idle",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@idle"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "the state of JW player should be \"idle\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "idle",
      "offset": 34
    }
  ],
  "location": "JWPlayerTest.theStateOfJWPlayerShouldBe(String)"
});
formatter.result({
  "duration": 17990857,
  "status": "passed"
});
formatter.after({
  "duration": 99841,
  "status": "passed"
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
  "name": "I visit \"inpage\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I switch to the iframe for  the JW player",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "inpage",
      "offset": 9
    }
  ],
  "location": "JWPlayerTest.iVisit(String)"
});
formatter.result({
  "duration": 980805513,
  "status": "passed"
});
formatter.match({
  "location": "JWPlayerTest.iSwitchToTheIframeForTheJWPlayer()"
});
formatter.result({
  "duration": 15103521883,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "JW player playing",
  "description": "",
  "id": "jw;jw-player-playing",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@play"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "I play the JW player",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the state of JW player should be \"playing\"",
  "keyword": "Then "
});
formatter.match({
  "location": "JWPlayerTest.iPlayTheJWPlayer()"
});
formatter.result({
  "duration": 3035650621,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "playing",
      "offset": 34
    }
  ],
  "location": "JWPlayerTest.theStateOfJWPlayerShouldBe(String)"
});
formatter.result({
  "duration": 25236523,
  "status": "passed"
});
formatter.after({
  "duration": 51627,
  "status": "passed"
});
});