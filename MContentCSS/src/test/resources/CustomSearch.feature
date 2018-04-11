@All
Feature:Custom Search
As a MC user
I should be able search for products via custom search


@customSearch
Scenario:Ability to search for a product via custom search

Given I am logged in 
Given I am on Landing Page
Then I should search for products using custom search using MPN column
#And I should search for products using custom search using EAN column