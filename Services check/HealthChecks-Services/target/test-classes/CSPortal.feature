@All
Feature:C S Portal

IF I visit http://creative.flixmedia.tv
I should see the webpage

@CSPstatus
Scenario:Http status

Given I Navigate to  "CSPortal"
Then I should be able to see the "CSPortalLogo" and "CSPortalFooter"