package com.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    public SelenideElement getPostButton(){
        return $x("//div[text()='Opublikuj']");

    }
    public HomePage createStory(String storyContent){

        $("div[aria-label*='Puste pole tekstowe.'][role='button']").click();
        sleep(5000);

        $("div[aria-label*='Puste pole tekstowe.'][role='textbox']").setValue(storyContent);
        //[data-lexical-editor='true']
        sleep(5000);
        $x("//div[@aria-hidden='false']//div[text()='Opublikuj']").click();
        sleep(5000);

        return this;
    }
    public HomePage changeView(){


        $("div[style*='--padding'] a[href*='piotrw']").click();
        //$("span[style*='transform'] svg[aria-label='Więcej']").click();
        //$x("//div[@tabindex='-1']//span[text()='Obserwowanie']").click();
        return this;
    }

    public SelenideElement getLastUserStory(String storyContent){

       return $x("//span[text()='" + storyContent + "']");

    }
}
