package tests.wiki;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.WikiOnboardingPage;
import tests.TestBase;

public class WikiOnboardingTests extends TestBase {
    @Test
    @Tag("android")
    @DisplayName("Проверка прохождения онбординга")
    void onboardingWikiTest(){
        String firstPrimaryText = "The Free Encyclopedia\n…in over 300 languages";
        String firstSecondaryText = "We’ve found the following on your device:";
        String secondPrimaryText = "New ways to explore";
        String secondSecondaryText = "Dive down the Wikipedia rabbit hole with a constantly updating Explore feed." +
                " \nCustomize the feed to your interests – whether it’s learning about historical events On this day," +
                " or rolling the dice with Random.";
        String thirdPrimaryText = "Reading lists with sync";
        String thirdSecondaryText = "You can make reading lists from articles you want to read later," +
                " even when you’re offline. \nLogin to your Wikipedia account to sync your reading lists. Join Wikipedia";
        String fourthPrimaryText = "Data & Privacy";
        String fourthSecondaryText = "We believe that you should not have to provide personal information" +
                " to participate in the free knowledge movement. Usage data collected for this app is anonymous. " +
                "Learn more about our privacy policy and terms of use.";

        WikiOnboardingPage wikiOnboardingPage = new WikiOnboardingPage();
        wikiOnboardingPage
                .checkCenteredImage()
                .checkPrimaryTextView(firstPrimaryText)
                .checkSecondaryTextView(firstSecondaryText)
                .clickContinue()
                .checkCenteredImage()
                .checkPrimaryTextView(secondPrimaryText)
                .checkSecondaryTextView(secondSecondaryText)
                .clickContinue()
                .checkCenteredImage()
                .checkPrimaryTextView(thirdPrimaryText)
                .checkSecondaryTextView(thirdSecondaryText)
                .clickContinue()
                .checkCenteredImage()
                .checkPrimaryTextView(fourthPrimaryText)
                .checkSecondaryTextView(fourthSecondaryText)
                .clickDone()
                .checkOnboardingNotExists();
    }
}
