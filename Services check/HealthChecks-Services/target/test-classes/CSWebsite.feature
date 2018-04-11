@All
Feature:C S Website

IF I visit http://www.flixmedia.tv/cs/services
I should see the webpage

@CSWstatus
Scenario:Status

Given I Navigate to  "CSWebsite"
Then I should be able to see the "CSFlixLogo" and "CSFooter"
