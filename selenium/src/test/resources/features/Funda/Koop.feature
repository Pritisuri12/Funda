@koop
Feature:As a end cutomer want to search house for buying

  Scenario: See all the options of house in selected area
    Given that I am an end cutomer
    And I want to search a house for buying
    And I entered the location "amsterdam"
    And select the distance "1" km
    And select the starting price range "100.000"
    And select the ending price range "300.000"
    When I click on Zoek
    Then I should be on the koop page


   @specialchar
   Scenario: Negative test case
     Given that I am an end cutomer
     And I want to search a house for buying
     And I entered the location "<<<<>_+./;'']["
     When I click on Zoek
     Then I should get some warning message



  @onlynumbers
  Scenario: Negative test case
    Given that I am an end cutomer
    And I want to search a house for buying
    And I entered the location "234567890"
    When I click on Zoek
    Then I should get some warning message
