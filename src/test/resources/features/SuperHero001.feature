Feature: SuperHero API

  Scenario: Get SuperHero by id between 1-731 randomly

    Given set a random id path parameter
    Then get the superhero with given id

  Scenario: Get the Biography of the SuperHero with random id

    Given set a random id with "biography" path parameter
    Then get the biography of the SuperHero

  Scenario: Get the appearance of the SuperHero with random id
    
    Given set a random id with "appearance" path param
    Then get the appearance of the SuperHero
  @API
  Scenario: Get the worj of the SuperHero with random id

    Given set a random id with "work" parameter
    Then get the work of the SuperHero