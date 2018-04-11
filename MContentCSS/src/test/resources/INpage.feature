@All
Feature:INpage


@INpage
Scenario:Ability to add  an INpage to a product

Given I am logged in 
Given I am on the product page  
And I add an INpage in German 
Then I should see the INpage JavaScript  and be able to edit information and delete the INpage
