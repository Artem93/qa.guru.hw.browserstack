package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikiSearchPage {

    private static final SelenideElement searchTextView = $(accessibilityId("Search Wikipedia"));
    private static final SelenideElement searchInput =  $(id("org.wikipedia.alpha:id/search_src_text"));
    private static final SelenideElement errorTextView =  $(id("view_wiki_error_text"));
    private static final ElementsCollection listOfResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Клик по фейк кнопке поиска")
    public WikiSearchPage clickOnSearchField() {
        searchTextView.click();
        return this;
    }

    @Step("Ввод в поиске слова {0}")
    public WikiSearchPage typeInSearchField(String request) {
        searchInput.sendKeys(request);
        return this;
    }

    @Step("Проверка, что на странице есть контент")
    public WikiSearchPage verifyContent() {
        listOfResults.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Клик на результат номер {0}")
    public WikiSearchPage clickOnResult(Integer numberResult) {
        listOfResults.get(numberResult).click();
        return this;
    }

    @Step("Проверка отображения ошибки")
    public WikiSearchPage checkErrorOccurred() {
        errorTextView.shouldHave(text("An error occurred"));
        return this;
    }
}
