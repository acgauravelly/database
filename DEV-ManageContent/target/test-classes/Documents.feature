@All
Feature:Documents


@Documents
Scenario:Ability to add edit and delete documents

Given I am logged in 
Given I am on the product page  
And I add a Document
Then I should see the added Document and be able to edit information and delete it.