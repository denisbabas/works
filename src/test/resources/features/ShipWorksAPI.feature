Feature: Task1


  @API @Denys
  Scenario Outline: Second task
    #Given Using an application, implement a call that returns is a 404
    When Using an application, read all the data from the .csv file and get parameters and have a return code 200
    Then check if there are any users that have email starting with "<Word>" then get their company name and write it to a file and assert response code 200

    Examples: 
      | Word |
      | S    |
