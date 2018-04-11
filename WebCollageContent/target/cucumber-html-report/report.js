$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("WebCollage.feature");
formatter.feature({
  "line": 2,
  "name": "WC content",
  "description": "",
  "id": "wc-content",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Filter WC content",
  "description": "",
  "id": "wc-content;filter-wc-content",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@wc"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I visit a \"\u003curl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the search for webcollage content should be \"\u003cResult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "wc-content;filter-wc-content;",
  "rows": [
    {
      "cells": [
        "url",
        "Result"
      ],
      "line": 13,
      "id": "wc-content;filter-wc-content;;1"
    },
    {
      "cells": [
        "http://www.stoehr-diskont.at/i/samsung-addwash-ww8ak44205w-136527/",
        "FALSE"
      ],
      "line": 14,
      "id": "wc-content;filter-wc-content;;2"
    },
    {
      "comments": [
        {
          "line": 15,
          "value": "#      | https://plazalama.com/tv-led-samsung-m-un88js9500f-88-cvo-uhd.html/                               | FALSE  |"
        },
        {
          "line": 16,
          "value": "#      | http://www.alshop.com/samsung-galaxy-note-4-32gb-lte-smartphone-n910c-charcoal-black.html            | FALSE  |"
        }
      ],
      "cells": [
        "https://baybloorradio.com/samsung-55quot-q7f-qled-4k-tv",
        "TRUE"
      ],
      "line": 17,
      "id": "wc-content;filter-wc-content;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Filter WC content",
  "description": "",
  "id": "wc-content;filter-wc-content;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@wc"
    },
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I visit a \"http://www.stoehr-diskont.at/i/samsung-addwash-ww8ak44205w-136527/\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I export the harfile",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the search for webcollage content should be \"FALSE\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.stoehr-diskont.at/i/samsung-addwash-ww8ak44205w-136527/",
      "offset": 11
    }
  ],
  "location": "WebCollageTests.iVisitA(String)"
});
