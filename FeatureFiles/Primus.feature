Feature: Primus Banking Module
@verifywithsingledata
Scenario: Validate Login
When I open PrimusBank Url on Chrome
And I enter UserName and Password in respected fields
When I click on Login Button
Then I should see adminflow text on CrrentUrl


When I click on Branch Link
When I click on NewBranch Link
And I enter allfields as on New Branch Entry form
When I click on Submit Button
Then I should see created Sucessfully text on PopUp Window
When I click on OK Button

When I click on Edit Icon
And I enter BranchName and Addressone in specific field
When I click on Update Button
Then I should see Branch updated Sucessfully text on popUp Window

When I click on Delete Icon
Then I should see delete this record text on popUp Window 
When I click on Logout Button