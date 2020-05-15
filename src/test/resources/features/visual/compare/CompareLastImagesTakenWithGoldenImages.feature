Feature: Compare last images taken with

  As an anonymous user
  I want to see home page and its elements
  In order to validate their styles

  @ImageCompare
  Scenario: Run the image comparison between golden image and the most resent batch of images
    Given There is a Golden Image Folder
    And There is a recent batch of Images
    When I run the comparison Software
    Then There is a new folder with the result of the comparison
