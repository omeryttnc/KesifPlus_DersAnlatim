#Introduce Yourself title Update Introduction menu should appear
#Update Introduction menu should be clickable
#A new menu should appear when the Update Introduction menu is clicked.
#The relevant menu must be clickable and writable

#Introduction information should be added to the menu
#The Save Introduction button should be clickable.
#When you click on the Save Introduction button, the information should appear in the menu.
#Delete button should be clickable
#When the Delete button is clicked, the information in the menu should be deleted

@login @UI @week5
Feature: US050

  Background:
    Given user is on the user panel page
    Then user verifies that the url is "https://kesifplus.com/user-panel"
    When user clicks on Profile tab

  Scenario: US050-TC001
    Then user verifies introduction card is visible
    And user verifies Update Introduction button is clickable
    When user clicks on the Update Introduction button
    Then user verifies introduction textarea is visible
    And user verifies introduction textarea is clickable

  Scenario: US050-TC002
    When user clicks on the Update Introduction button
    And user clicks on Save Introduction button
    Then user verifies introduction textarea is visible
    And user verifies save introduction button is visible

  Scenario: US050-TC003
    When user clicks on the Update Introduction button
    And user writes an introduction message
    And user clicks on Save Introduction button
    Then user verifies message is visible on the page
    When user clicks on the Update Introduction button
    Then user verifies Delete button is visible
    And user verifies Delete button is clickable
    When user clicks Delete button
    Then user verifies message is not visible on the page
