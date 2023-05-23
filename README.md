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

## What is java

Java is a general-purpose, class-based, object-oriented programming language designed for having lesser implementation dependencies. It is a computing platform for application development. Java is fast, secure, and reliable, therefore. It is widely used for developing Java applications in laptops, data centers, game consoles, scientific supercomputers, cell phones, etc.

![java](https://github.com/Mamun104/Web_AutomationTestingUsing_TestNGFramework/assets/78067017/8001c410-5eee-4938-858a-b09f1d3160de)


## How to Install java and Set Up

1. Go to this link and download JDK : https://www.oracle.com/java/technologies/downloads/ 
2. When installed successfully, then set Java Home Path
3. To set java home path in windows OS:
4. System properties > Advanced system settings > Environment variables
  - Click on New button
  - Set variable name as JAVA_HOME
  - and Variable value field of installed JDK path as C:\Program Files\Java\jdk1.8.0_161
  - Click on Ok button

![JAVA HOME](https://github.com/Mamun104/Web_AutomationTestingUsing_TestNGFramework/assets/78067017/097ecf41-fe4a-4153-ac17-2220c743e358)

5. Now go to cmd and hit following command to check if java is installed.

              java --version
 
 ![javmd](https://github.com/Mamun104/Web_AutomationTestingUsing_TestNGFramework/assets/78067017/59073e7b-a066-4b22-9f78-91d32f4d089d)

 
 6. Then you can install any IDE for writing code like as Eclipse, NetBeans or IntellIJ. I will recommend you to install IntellIJ as this is used in professional sectors.


## How to Install IDE IntellIJ

1. Go to this link and download IDE: https://www.jetbrains.com/idea/download/#section=windows
2. I recommend downloading for community version

## Run the automation script

- Open cmd to the project folder
- Type this command:

                gradle clean test
              
- Selenium will open the browser and start automation.
- To view report, type this command:
                
                allure generate allure-results --clean -o allure-report
                allure serve allure-results

## Report View:

![a2](https://github.com/Mamun104/Web_AutomationTestingUsing_TestNGFramework/assets/78067017/b31543f0-6591-4ef0-92c2-60402bc4e063)
![a1](https://github.com/Mamun104/Web_AutomationTestingUsing_TestNGFramework/assets/78067017/5ff1a77b-b7cb-4222-afd8-5c171e5fa638)



