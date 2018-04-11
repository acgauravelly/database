$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Compare.feature");
formatter.feature({
  "line": 1,
  "name": "Compare our content with WC",
  "description": "",
  "id": "compare-our-content-with-wc",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Cmpare unilver content",
  "description": "",
  "id": "compare-our-content-with-wc;cmpare-unilver-content",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@compare"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I visit the \"\u003cwcurl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I get the \"wc\" content",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I visit the \"\u003cFlixurl\u003e\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#    And I get the \"flix\" content"
    }
  ],
  "line": 10,
  "name": "the content should match",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "compare-our-content-with-wc;cmpare-unilver-content;",
  "rows": [
    {
      "cells": [
        "wcurl",
        "Flixurl"
      ],
      "line": 13,
      "id": "compare-our-content-with-wc;cmpare-unilver-content;;1"
    },
    {
      "cells": [
        "http://origin.flixcar.com/delivery/inpage/show/6/us/1310706",
        "http://www.webcollage.net/MainApp/preview-ppp?module\u003dsuave\u0026site\u003departner\u0026wcpc\u003d1372368513318\u0026view\u003dlive\u0026rcpName\u003dWebcollage"
      ],
      "line": 14,
      "id": "compare-our-content-with-wc;cmpare-unilver-content;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Cmpare unilver content",
  "description": "",
  "id": "compare-our-content-with-wc;cmpare-unilver-content;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@compare"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I visit the \"http://origin.flixcar.com/delivery/inpage/show/6/us/1310706\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I get the \"wc\" content",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I visit the \"http://www.webcollage.net/MainApp/preview-ppp?module\u003dsuave\u0026site\u003departner\u0026wcpc\u003d1372368513318\u0026view\u003dlive\u0026rcpName\u003dWebcollage\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#    And I get the \"flix\" content"
    }
  ],
  "line": 10,
  "name": "the content should match",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://origin.flixcar.com/delivery/inpage/show/6/us/1310706",
      "offset": 13
    }
  ],
  "location": "WCTests.iVisitThe(String)"
});
formatter.result({
  "duration": 14840253013,
  "error_message": "cucumber.runtime.CucumberException: Failed to instantiate class Tests.WCTests\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:46)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.getInstance(DefaultJavaObjectFactory.java:32)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:160)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\nCaused by: java.lang.reflect.InvocationTargetException\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:40)\r\n\t... 49 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\"wc-fragment\"}\nCommand duration or timeout: 10.07 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.153\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d45.0.1, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: e683f6ef-503c-4fda-8c9b-be1c5924d633\n*** Element info: {Using\u003dclass name, value\u003dwc-fragment}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:477)\r\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:391)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat Pages.BasePage.findElement(BasePage.java:37)\r\n\tat Pages.BasePage.getTextofElement(BasePage.java:57)\r\n\tat Pages.WCPage.getWcContentText(WCPage.java:19)\r\n\tat Pages.WCPage.\u003cinit\u003e(WCPage.java:13)\r\n\tat Tests.WCTests.\u003cinit\u003e(WCTests.java:14)\r\n\t... 54 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\"wc-fragment\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.153\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/Ajay/AppData/Local/Temp/anonymous8088937887648762640webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.fxdriver.Timer.prototype.setTimeout/\u003c.notify(file:///C:/Users/Ajay/AppData/Local/Temp/anonymous8088937887648762640webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:625)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "wc",
      "offset": 11
    }
  ],
  "location": "WCTests.iGetTheContent(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.webcollage.net/MainApp/preview-ppp?module\u003dsuave\u0026site\u003departner\u0026wcpc\u003d1372368513318\u0026view\u003dlive\u0026rcpName\u003dWebcollage",
      "offset": 13
    }
  ],
  "location": "WCTests.iVisitThe(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WCTests.theContentShouldMatch()"
});
formatter.result({
  "status": "skipped"
});
});