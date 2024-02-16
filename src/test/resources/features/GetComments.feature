Feature: Comments

  @GetComments
  Scenario: Retrieve comments successfully
    When the administrator consumes the GET endpoint for comments with query parameter
    Then the comments should appear successfully