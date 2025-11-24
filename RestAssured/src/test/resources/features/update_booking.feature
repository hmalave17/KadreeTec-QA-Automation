Feature: validate update booking services

  As a product owner,
  I need to set up a proof of concept
  to validate the behavior of different automation frameworks

  @UpdateBooking
  Scenario: user Update booking
    Given that a user is authenticated
    When updating a booking
    Then the system displays the update


  @UpdatePartialBooking
  Scenario Outline: user update partial booking
    Given that a user is authenticated
    When updating partial booking "<updateParameter>"
    Then booking is partially updated "<updateParameter>"
    Examples:
      | updateParameter |
      | firstname       |
      | lastname        |
      | totalprice      |
      | additionalneeds |


