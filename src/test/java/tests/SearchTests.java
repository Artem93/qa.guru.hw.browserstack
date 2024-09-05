package tests;

import org.junit.jupiter.api.Test;
import steps.WikiSearchSteps;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        WikiSearchSteps wikiSteps = new WikiSearchSteps();

        wikiSteps
                .clickOnSearchField()
                .typeInSearchField("Appium")
                .verifyContent();
    }
}