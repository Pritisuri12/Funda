@nieuwbouw
Feature:As a end cutomer want to search for new construction

  Scenario: See all the options of house in selected area
    Given that I am an end cutomer
    And I want to search a house of new construction
    And I entered the location "amsterdam"
    And select the distance "1" km
    When I click on Zoek
    Then I should be on the Nieuwbouw  page
   # And price range is between specified limits
   # And the different houses with price are displayed
