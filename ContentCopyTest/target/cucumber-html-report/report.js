$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Translation.feature");
formatter.feature({
  "line": 1,
  "name": "Xml Translation",
  "description": "As a Qa\r\nI should be able to check the translation is correct as of XML",
  "id": "xml-translation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Translation check",
  "description": "",
  "id": "xml-translation;translation-check",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@translation"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I read the xml from csv",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I get the value of node",
  "keyword": "And "
});
formatter.match({
  "location": "Translationtest.iReadTheXmlFromCsv()"
});
formatter.result({
  "duration": 180466555,
  "status": "passed"
});
formatter.match({
  "location": "Translationtest.iGetTheValueOfNode()"
});
formatter.result({
  "duration": 246232714607,
  "status": "passed"
});
});