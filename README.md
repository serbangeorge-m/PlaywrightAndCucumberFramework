
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