How to run the tests:
1) Open command prompt from the root directory location
2) Execute command: mvn clean test

How to access the Allure report
1) Upon completion of the test execution, execute command: allure serve in the command prompt from same location
2) The above command generates a report in the temporary folder from the data found in target/surefire-reports/ and then creates a local Jetty server instance, serves generated report and opens html report in the default browser.
3) If you want to save html report on your project directory, run the following allure commands one by one:
	i) allure generate
	ii) allure open