Feature: Downloading the file

  Scenario Outline: Downlaod resume from naukri
    Given open browser and enter url
    When Enter <username> and <password>
    And click on signin
    Then user click on update resume
    And Click on download arrow to download the resume.
    When User wants to read data from downloaded file

    Examples: 
      | username                | password       |
      | skothapally23@gmail.com | sravanthisravs |
