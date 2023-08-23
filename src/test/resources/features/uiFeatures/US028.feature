#US_028	As a user, I should be able to perform various actions in the user panel.
# Account button should be clickable on the Home Page.
#When the Account button is clicked, the Account Panel should appear.
#Log in to the system with valid ciredentials in the Account Panel
#When you log in to the system, the user panel should appear.
#When you click on the button in the lower section, the page dimensions should change.

  Feature: US028
    @UI
    Scenario: TC001
      Given users goes to home page
      Then user verifies Account is clickable
      When user clicks on Account button
      And user enters valid credentials
      And user clicks on login button
      Then user verifies the dimensions of the sidebar without minimizing
      When user clicks on the left arrow
      Then user verifies the dimensions of the sidebar after minimizing
