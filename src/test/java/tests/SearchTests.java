package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.WikiSearchPage;

public class SearchTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Проверка отображения Appium в результатах поиска")
    void successfulSearchTest() {
        WikiSearchPage wikiSteps = new WikiSearchPage();
        wikiSteps
                .clickOnSearchField()
                .typeInSearchField("Appium")
                .verifyContent();
    }

    @Test
    @Tag("android")
    @DisplayName("Проверка отображения ошибки при открытии страницы")
    void checkErrorAfterOpenPageTest() {
        WikiSearchPage wikiSteps = new WikiSearchPage();
        wikiSteps
                .clickOnSearchField()
                .typeInSearchField("Appium")
                .clickOnResult(0)
                .checkErrorOccurred();
    }
}