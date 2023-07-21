<!-- ABOUT THE PROJECT -->

## About the Project

Playwright Demo - This project is based on Microsoft Playwright which enables reliable end-to-end testing for modern web
apps.

Top Features:

- Easy to Configure.
- Auto-waits for all the relevant checks to pass and only then performs the requested action.
- Execution of test case is faster when compared with other competitive framework in market.
- Supports Heedful/Headless mode execution for Firefox/Webkit/Google Chrome/Chromium/MS Edge on Windows/Linux/Mac
  machines.
- Rerun Failed Test cases
- Supports 'download' event monitoring, so there is no need for user to actually wait for downloads to finish.
- Supports Serial and Parallel execution.
- Spark PDF/HTML Reports are generated after execution with an option to capture screenshot/video/trace file on failure.
- Nonetheless, Support from Microsoft so FREQUENT RELEASES and turn around time for any queries is 48 hours.

### Built With

- [Playwright](https://playwright.dev)
- [Cucumber](https://cucumber.io/)
- [JUnit](https://junit.org/junit5/)
- [Maven](https://maven.apache.org/)
- [OpenJDK](https://www.openlogic.com/openjdk-downloads)

## Getting Started

### Prerequisites

The following software are required:

- java : Download and Install java 1.8
  ```sh
  https://www.openlogic.com/openjdk-downloads
  ```
- Maven must be configured

### Installation

1. Clone the repo using below URL

```sh
https://github.com/serbangeorge-m/PlaywrightAndCucumberFramework.git
```

2. Navigate to folder and install dependencies using:

```sh
mvn clean install
```

<!-- USAGE EXAMPLES-->

## Usage

1. For Browser Configuration, change required value in browser and headless mode in `src/test/resources/config/config.properties`.
2. For executing test cases in parallel, navigate to pom.xml and in plugin in configuration section
   provide `<skipTests>false</skipTests>`
   Now if you want to run 4 features in parallel provide `<threadCount>4</threadCount>` in maven-failsafe-plugin section
   in pom.xml and execute below command
```JS
mvn verify
```
3. For executing test cases execute below command:
```JS
mvn clean test
```