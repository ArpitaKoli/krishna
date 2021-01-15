Feature: Login parameterization
@SmokeTest
Scenario Outline: Login to application
Given Login with multiple testdata
When valid "<username>" and "<password>" 
And click login button
Then logged into application
Examples: 
       | username | password |
       | arpita.koli7@gmail.com | Radhe786@ |
       | arpita.koli7@gmail.com | Radhe786@ |
       | arpita.koli7@gmail.com | Radhe786@ |
       
