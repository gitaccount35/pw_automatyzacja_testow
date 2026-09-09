package com;

import com.codeborne.selenide.WebDriverRunner;
import com.pageobjects.LoginPage;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.common.Constants.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Slf4j
public class StoryTest {

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    public void ShouldCreateStory() {

        Faker faker = new Faker();
        var tempText = faker.artist().name();
        log.info("We are creating story");
        sleep(5000);

        var homePage = open (URL, LoginPage.class)
                .maximizeWindow()
                .login(EMAIL, PASSWORD)
                .createStory(tempText)
                .changeView();
        Selenide.refresh();
        sleep(5000);

        homePage.getLastUserStory(tempText).shouldBe(text(tempText));
        sleep(5000);

    }

}
