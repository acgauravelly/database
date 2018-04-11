@All,@minisite
Feature: JW

  As a user
  I want to play the JW player

  Background:
    Given I visit "Minisite"
#    And I switch to the iframe for  the JW player

  @idle
  Scenario: JW player is Idle
    Then the state of JW player should be "idle"

  @play
  Scenario: JW player playing
    When I play the JW player
    Then the state of JW player should be "playing"

  @pause
  Scenario: JW player pausing
    When I pause the JW player
    Then the state of JW player should be "paused"