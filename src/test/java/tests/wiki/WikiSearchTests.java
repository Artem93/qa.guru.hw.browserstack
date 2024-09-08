package tests.wiki;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.WikiSearchPage;
import tests.TestBase;

public class WikiSearchTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Проверка отображения Appium в результатах поиска")
    void successfulSearchTest() {
        Selenide.back();
        WikiSearchPage wikiSteps = new WikiSearchPage();
        wikiSteps
                .clickOnSearchField()
                .typeInSearchField("Appium")
                .verifyContent();
    }

    @Test
    @Tag("android")
    @DisplayName("Проверка загрузки страницы поискового результатар")
    void checkErrorAfterOpenPageTest() {
        Selenide.back();
        WikiSearchPage wikiSteps = new WikiSearchPage();
        wikiSteps
                .clickOnSearchField()
                .typeInSearchField("Appium")
                .clickOnResult(0)
                .checkTextOnPage();
    }
}