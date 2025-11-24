Feature: Helpers for create token

  @createToken
  Scenario: create token successful
    * url baseUrl
    * path 'auth'
    * headers headersAuth
    * request payload
    * method post
    * status 200
