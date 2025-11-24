Feature: update booking

  Background:
    * def payload = read('classpath:data/create_token_request.json')
    * def tokenSesion = call read('classpath:helpers/create_token_helper.feature') { request: payload }
    * def booking = call read('classpath:helpers/update_helper.feature@GetBookingIds')

  @UpdateBooking
  Scenario: update booking total
    * def bodyRequest = read('classpath:data/update_booking.json')
    * def positionNumber = randomNumber()
    * def bookingPosition = booking.response[positionNumber].bookingid
    * def jsonResponse = call read('classpath:helpers/update_helper.feature@UpdateBooking') { bookingIds: #(bookingPosition), token : #(tokenSesion.response.token), body: #(bodyRequest)}
    * def schema = read('classpath:schemas/update_booking_schema.json')
    * match jsonResponse.response == schema

  @UpdateBookingPartial
  Scenario Outline: update booking partial
    * def bodyRequest = read('classpath:data/update_booking_partial.json')
    * def positionNumber = randomNumber()
    * def key = Object.keys(input)[0]
    * def value = input[key]
    * def bookingPosition = booking.response[positionNumber].bookingid
    * def responseInitial = call read('classpath:helpers/update_helper.feature@@GetBooking') {bookingIds: #(bookingPosition)}
    * def jsonInitial = responseInitial.response
    * def jsonResponse = call read('classpath:helpers/update_helper.feature@UpdateBookingPartial') {bookingIds: #(bookingPosition), token: #(tokenSesion.response.token), body: <input> }
    * def schema = read('classpath:schemas/update_booking_schema.json')
    * match jsonResponse.response == schema
    * match jsonInitial != jsonResponse.response
    Examples:
      | input             |
      | #(bodyRequest[0]) |
      | #(bodyRequest[1]) |
      | #(bodyRequest[2]) |
      | #(bodyRequest[4]) |
      | #(bodyRequest[5]) |
      | #(bodyRequest[6]) |

