Feature: week 4 database
  Scenario: database de kullanici okuma
    Given connection mysql database
    When we create new user
    Then assert new user is in database

    @MDB
    Scenario: database sqlite okuma
      When sql database bilgisi yazdir