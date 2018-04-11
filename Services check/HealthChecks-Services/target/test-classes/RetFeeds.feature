@All
Feature:Retailer Feeds

IF I visit http://feed.flixsyndication.net/api/feed/?distributor_id=370&language=us&format=xml
I should see the webpage

@RFstatus
Scenario:Http status

Given I Navigate to  "RetFeedURls"
Then I should be able to get the status of the "RetFeedURls"
