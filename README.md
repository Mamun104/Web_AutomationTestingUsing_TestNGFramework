# Web Automation Testing Using TestNG Framework

## Technology and Tool Used

- Tool: selenium
- IDE: IntelIJ
- Build tool: Gradle
- Language: Java
- Framework: TestNG, Allure

## Prerequisites

- Need to install jdk 11, gradle and allure

- Configure Environment variable for jdk 11, gradle and allure

- Need good internet connectivity

- Clone this project and unzip it

- Open the project folder

- Double click on "build.gradle" and open it through IntellIJ IDEA

- Let the project build successfully

- In "./src/test/resources/Users.json" replace the whole JSON content with [] and save

- Click on "Terminal" and run the automation scripts



## Run the automation script

- Open cmd to the project folder
- Type this command:

                gradle clean test
              
- Selenium will open the browser and start automation.
- To view report, type this command:
                
                allure generate allure-results --clean -o allure-report
                allure serve allure-results


