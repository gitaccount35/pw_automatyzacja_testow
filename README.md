# pw_automatyzacja_testow

UI automation tests for Threads, written in Java with Maven, TestNG, and Selenide. The tests use a page-object structure to sign in, interact with the site, and verify visible content in a Chrome browser.

## Requirements

- Java 17
- Maven
- Google Chrome
- A Threads account that can sign in through Instagram

## Configuration

The tests read the site URL and login credentials from `env.properties` in the project root. Copy `env.properties.sample` to `env.properties`, then fill in the URL, email, and password values:

```properties
url=https://threads.com
email=your-account-email
```

Keep credentials private. `env.properties` is excluded from Git; do not commit real account details.

Selenide is configured to use Chrome in `src/test/resources/selenide.properties`.

## Run the tests

From the project root, run:

```bash
mvn test
```

Maven Surefire runs the TestNG suite defined in `testng.xml`. The tests use the live Threads site, so they require an internet connection and valid account credentials.

## Tests and coverage

| Test class | Test method | What it tests | Included in `mvn test` |
|---|---|---|---|
| `StoryTest` | `ShouldCreateStory` | Signs in, creates a post with generated text, opens the profile, refreshes the page, and checks that the generated text is displayed. | Yes |
| `LoginTest` | `sampleTest` | Signs in and checks that the post button is visible on the home page. | No — its class entry is commented out in `testng.xml`. |

To include `LoginTest` in the standard Maven run, uncomment its class entry in `testng.xml`.

## Project structure

- `src/test/java/com/` — TestNG test classes.
- `src/test/java/com/pageobjects/` — Selenide page objects for the login and home pages.
- `src/test/java/com/common/Constants.java` — Reads the URL and credentials from `env.properties`.
- `src/test/resources/` — Selenide browser settings and logging configuration.
- `testng.xml` — TestNG suite used by Maven Surefire.
