Feature: Task2

  @Smoke @Denys
  Scenario Outline: ShipWorks user story
    Given select the "<selections>"
    When select "Text Box" fill out to "<fullName>", "<email>", "<currentAdress>" and "<permanentAdress>" and click submit btn
    Then assert text from output "<fullName>", "<email>", "<currentAdress>" and "<permanentAdress>"

    Examples: 
      | selections | Price | fullName | email            | currentAdress | permanentAdress |
      | Elements   |    10 | Tamara   | Tamara@gmail.com | Miami, FL     | NewYork, NY     |

  @Smoke @Denys
  Scenario Outline: user story two
    Given select the "<selections>"
    When navigate "Check Box"
    Then select iconExpandClose then click on "Desktop" and  "Downloads" then assert text "You have selected :, desktop, notes, commands, downloads, wordFile, excelFile"

    Examples: 
      | selections |
      | Elements   |

  @Smoke @Denys
  Scenario Outline: user story tree
    Given select the "<selections>"
    When navigate to element group  "<group>"
    Then navigate "Browser Windows"
    And click on tabButton
    When Window is open get text from page and assert with String "This is a sample page"

    Examples: 
      | selections | group                   |
      | Elements   | Alerts, Frame & Windows |

  @Smoke @Denys
  Scenario: user story fourth
    Given select the "Elements"
    When navigate to element group  "Alerts, Frame & Windows"
    Then navigate "Browser Windows"
    And click on New Window
    When Window is open get text from page and assert with String "This is a sample page"

  @Progression @Denys
  Scenario Outline: user story fifth
    Given select the "<selections>"
    When navigate to element group  "<group>"
    Then navigate "Alerts"

    Examples: 
      | selections | group                   |
      | Elements   | Alerts, Frame & Windows |
