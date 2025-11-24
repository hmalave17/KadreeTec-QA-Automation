Feature: validate create booking services

  As a product owner,
  I need to set up a proof of concept
  to validate the behavior of different automation frameworks

  @CreateBookingSuccessful
  Scenario: create booking successful
    Given user into her data
    When user consume the services
    Then systems create the booking

  @InputsMandatory
  Scenario Outline: failed create booking
    Given user doesnot into her data complete "<idTest>"
    When user consume the services
    Then system shows error
    Examples:
      | idTest |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |
      | 6      |