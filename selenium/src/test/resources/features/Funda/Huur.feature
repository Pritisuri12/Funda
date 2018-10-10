@huur
Feature:As a end cutomer want to search house for rent

  Scenario: See all the options of house in selected area
    Given that I am an end cutomer
    And I want to search a house for rent
    And I entered the location "amsterdam"
    And select the distance "1" km
    And select the starting price range "100"
    And select the ending price range "300"
    When I click on Zoek
    Then I should be on the huur page
