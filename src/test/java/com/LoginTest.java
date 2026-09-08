package com;

import com.pageobjects.LoginPage;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.common.Constants.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Slf4j
public class LoginTest {

    @AfterMethod
    public void afterMethod(){
        getWebDriver().close();
    }

    @Test
    public void sampleTest() {

        log.info("I'm here hi hi");
        //String className = this.getClass().getSimpleName();
        //log.info(className);

        var homePage = open (URL, LoginPage.class)
                .login(EMAIL, PASSWORD);
        homePage.getPostButton().shouldBe(visible);
        sleep(5000);

    }
    

 }
