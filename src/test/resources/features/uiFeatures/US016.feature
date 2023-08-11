# US_016
# When I enter the main page as a user, various actions should be performed on the Consulting page at the top of the page.
# Education, Career, Information Tech titles should be seen on the page that opens when Consulting is clicked.
# Transitions should be possible on the relevant page
# Click Learn More in Education, Career, Information Tech windows
# Clicking Learn More buttons should open the relevant page.

Feature: US016

  @UI
  Scenario Outline: Outline ile
    Given users goes to home page
    When user clicks on Consulting page
    Then user verifies "<title>" is visible
    When user clicks on "<learn more>"
    Then user verifies "<title>" is visible on relevant page
    And user verifies the "<url>"
    Examples:
      | title            | learn more | url                                       |
      | Education        | 0          | http://kesifplus.com/consulting/education |
      | Career           | 1          | http://kesifplus.com/consulting/career    |
      | Information Tech | 2          | http://kesifplus.com/consulting/IT        |

  @UI
  Scenario: Datatable ile
    Given users goes to home page
    When user clicks on Consulting page
    Then user verifies relevant page is visible after clicking learn more
      | Education        | http://kesifplus.com/consulting/education |
      | Career           | http://kesifplus.com/consulting/career    |
      | Information Tech | http://kesifplus.com/consulting/IT        |