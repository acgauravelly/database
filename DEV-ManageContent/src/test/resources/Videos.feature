@All
Feature:Videos


@Videos
Scenario:Ability to add edit and delete Videos


Given I am logged in 
Given I am on the product page
And I add Video
Then I should see the added Video and be able to edit information and delete it.

