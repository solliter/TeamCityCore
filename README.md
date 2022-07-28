Technology Used : Java, TestNG, Selenium, Maven, Allure

Framework Used: Page Object Model

Requirements: Browser Google Chrome ver.102.0.5005.63, TeamCity without projects, windows 10.

Before tests:
in src/main/java/constants file Constants
Change variables:

1."port" on port which you gonna use

2."usernameValid" and "passwordValid" on a valid username and password

3."repositoryNamePositive"  and its URL like https://github.com/solliter/TeamCityLogIn#refs/heads/master 

for autotests with autotests that gonna pass build and "repositoryNameNegative" that not gonna pass it (Or just use mine TeamCityLogIn and catsbuilder)

How to run tests: mvn clean test or Run from IDE, class LogInTests.

How to get reports: run in powershell 
allure serve F:\Projects\TeamCityLogIn\allure-results (Change on your path to allure-results)

If you have error with allure and powershell:

 1.Install last version of allure coomandline https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline
 
 2.Navigate to bin directory 
 
 3.Use allure.bat for Windows or allure for other Unix platforms.
 
 4.Add allure to system PATH.
 
than try again get reports.

p/s If there are some problems with builds just use comment shortcuts in TeamCityTests and choose any repository you want
