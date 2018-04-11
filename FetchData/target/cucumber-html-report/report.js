$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FetchData.feature");
formatter.feature({
  "line": 1,
  "name": "Fetch data from website",
  "description": "As a website user\r\nI want to fetch certain data",
  "id": "fetch-data-from-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Fetching the data",
  "description": "",
  "id": "fetch-data-from-website;fetching-the-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@datafetch"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I visit \"https://www.google.co.uk/contact/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I get the \"searchterm\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "i search with searchterm",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should be able to get the data",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "make a api call at \"http://media.flixfacts.com/staging/flixpreview/index.php?mpn\u003dkarmadrone\u0026language\u003den\u0026live\u003d\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.co.uk/contact/",
      "offset": 9
    }
  ],
  "location": "FetchDataTest.iVisit(String)"
});
formatter.result({
  "duration": 5467717065,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "searchterm",
      "offset": 11
    }
  ],
  "location": "FetchDataTest.iGetThe(String)"
});
formatter.result({
  "duration": 77557040,
  "status": "passed"
});
formatter.match({
  "location": "FetchDataTest.iSearchWithSearchterm()"
});
formatter.result({
  "duration": 8110001681,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"lst-ib\"}\n  (Session info: chrome\u003d59.0.3071.104)\n  (Driver info: chromedriver\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 5.01 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027FLIXPC010\u0027, ip: \u0027192.168.1.131\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\Ajay\\AppData\\Local\\Temp\\scoped_dir16196_1866}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d59.0.3071.104, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 1d0512363c042a93b481145d7a1f8b69\n*** Element info: {Using\u003did, value\u003dlst-ib}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat Pages.BasePage.findElement(BasePage.java:42)\r\n\tat Pages.BasePage.writetoField(BasePage.java:59)\r\n\tat Pages.FetchDataPage.search(FetchDataPage.java:30)\r\n\tat Tests.FetchDataTest.iSearchWithSearchterm(FetchDataTest.java:40)\r\n\tat ✽.When i search with searchterm(FetchData.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "FetchDataTest.iShouldBeAbleToGetTheData()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "http://media.flixfacts.com/staging/flixpreview/index.php?mpn\u003dkarmadrone\u0026language\u003den\u0026live\u003d",
      "offset": 20
    }
  ],
  "location": "FetchDataTest.makeAApiCallAt(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Failed Scenario: Fetching the data");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 474104702,
  "status": "passed"
});
});