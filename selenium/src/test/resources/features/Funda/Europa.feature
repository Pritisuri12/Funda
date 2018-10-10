@europa
Feature:As a end cutomer want to search house in europe

  Scenario: See all the options of house in selected area
    Given that I am an end cutomer
    And I want to search a house in europe
    And I select the location "Alle landen"
    When I click on Zoek
    Then I should be on the europa page

