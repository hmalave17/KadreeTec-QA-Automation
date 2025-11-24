Feature: Helpers to update booking

  @GetBookingIds
  Scenario: Get Booking Ids
    * url baseUrl
    * path 'booking'
    * headers headersGetBooking
    * method get
    * status 200

  @GetBooking
  Scenario: Get Booking Ids
    * url baseUrl
    * path 'booking/' + bookingIds
    * headers headersGetBooking
    * method get
    * status 200

  @UpdateBooking
  Scenario: update total booking
    * url baseUrl
    * path 'booking/' + bookingIds
    * headers headerUpdateBooking(token)
    * request body
    * method put
    * status 200

  @UpdateBookingPartial
  Scenario: update partial booking
    * url baseUrl
    * path 'booking/' + bookingIds
    * headers headerUpdateBooking(token)
    * request body
    * method patch
    * status 200

