Feature: week 3

  @UI
  Scenario: is user able to login after registration
    Given user goes to register page
    When user complete registration
    And user is able to see "Register Successfully!" alert
    And user is able to login with new credentials
    Then user is able to see sidebar locator as follow
      | Dashboard |
      | Profile   |
      | Courses   |
      | Settings  |
      | Calendar  |
      | Support   |


  @UI
  Scenario Outline: is register page works as expected
    Given user goes to register page
    When user send wrong email address "<email>"
    Then user is able to get correct warning text "<warningText>"
    Examples: data for negative register scenario
      | email | warningText                                                        |
      | a     | Please include an '@' in the email address. 'a' is missing an '@'. |
      | a@    | Please enter a part following '@'. 'a@' is incomplete.             |

    @UI
  Scenario: flash webelement
    Given user goes to register page
    When flash email webElement