@All
Feature:MiniSite


@MiniSite
Scenario:Ability to add  an MiniSite to a product

Given I am logged in 
Given I am on the product page  
And I add an MiniSite in German 
Then I should see the MiniSite JavaScript  and be able to edit information and delete the MiniSite
