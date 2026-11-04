package com.pageobjects;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

        public HomePage login(String email, String password){

            sleep(5000);
            $x("//div[text()='Zezwól na wszystkie pliki cookie']").click();
            sleep(5000);
            $x("//span[text()='Użyj swojego konta na Instagramie']").click();
            sleep(5000);
            $x("//div[text()='Zaloguj się']").click();
            sleep(5000);
            $("input[autocomplete='username']").setValue(email);
            $("input[autocomplete='current-password']").setValue(password);
            //$(By.id("u_0_9_nv")).click();
            $x("//div[text()='Zaloguj się']").click();
            sleep(20000);

            return page(HomePage.class);
        }

    public LoginPage maximizeWindow() {

        WebDriverRunner.getWebDriver().manage().window().maximize();

    return this;
    }
}
