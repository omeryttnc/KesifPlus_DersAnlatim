Business Need: week 1 links

  @UI
  Scenario: links test 1
    Given users goes to home page
    When user clicks on home button
    Then verify url is "http://kesifplus.com/"

    When user clicks on about us button
    Then verify url is "http://kesifplus.com/about-us"

    @UI
    Scenario: link test 2
      Given users goes to home page
      Then assert with enum
