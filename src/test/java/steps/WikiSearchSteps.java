package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikiSearchSteps {

    @Step
    public WikiSearchSteps clickOnSearchField(){
        $(accessibilityId("Search Wikipedia")).click();
        return this;
    }

    @Step
    public WikiSearchSteps typeInSearchField(String request){
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(request);
        return this;
    }

    @Step
    public WikiSearchSteps verifyContent(){
        $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));
        return this;
    }
}
