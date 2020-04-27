Feature: Home Screenshots

  As an anonymous user
  I want to see home page and its elements
  In order to validate their styles

  @Home
  @UIValidation
  Scenario: capture a Screenshot of the Header
    Given The user is on the Inkafarma Page
    When He captures a screenshot of the Header in Home
#    Then The image is saved

  @Home
  @UIValidation
  Scenario: capture a Screenshot of the Home
    Given The user is on the Inkafarma Page
    When He captures a screenshot of the Body in Home
#    Then The image is saved

  @Home
  @UIValidation
  Scenario: capture a Screenshot of the Footer
    Given The user is on the Inkafarma Page
    When He captures a screenshot of the Footer in Home
#    Then The image is saved

  @Home
  @UIValidation
  Scenario: capture a Screenshot of the Entire Page
    Given The user is on the Inkafarma Page
    When He captures a screenshot of the entire Home Page
#    Then The image is saved