@All
Feature:Flixmedia Website

IF I visit http://www.flixmedia.eu
I should see the webpage

@FWstatus
Scenario:Http status

Given I Navigate to  "FlixWebsite"
Then I should be able to see the "FlixSiteLogo" and "WhatWeDo"
