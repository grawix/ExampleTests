@api
Business Need: API Validation Test

  Scenario: Developer can retrieve activity with specific type
    When user send request with query parameter 'participants' and value '2' to retrieve activity
    Then retrieved activity has participants equals '3'
