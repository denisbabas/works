Feature: Task2

  @Smoke @Denys
  Scenario Outline: ShipWorks user story
    Given select the "<selections>"
    When select "Text Box" fill out to "<fullName>", "<email>", "<currentAdress>" and "<permanentAdress>" and click submit btn
	Then assert text from output "<fullName>", "<email>", "<currentAdress>" and "<permanentAdress>"
    Examples: 
      | selections | Price | fullName | email            | currentAdress | permanentAdress |
      | Elements   |    10 | Tamara   | Tamara@gmail.com | Miami, FL     | NewYork, NY     |

      
  @Progression @Denys
  Scenario Outline: user story two
  Given select the "<selections>"
  When navigate "Check Box"
  Then select iconExpandClose then click on "Desktop" and  "Downloads" then assert text "You have selected : desktop, notes, commands, downloads, wordFile, excelFile"
  
   Examples: 
      | selections | 
      | Elements   |