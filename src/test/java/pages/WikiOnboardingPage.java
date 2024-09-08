package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikiOnboardingPage {
    private static final SelenideElement primaryTextView =  $(id("org.wikipedia.alpha:id/primaryTextView"));
    private static final SelenideElement secondaryTextView =  $(id("org.wikipedia.alpha:id/secondaryTextView"));
    private static final SelenideElement centeredImage =  $(id("org.wikipedia.alpha:id/imageViewCentered"));
    private static final SelenideElement continueButton =  $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private static final SelenideElement onboardingDoneButton =  $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));
    private static final SelenideElement onboardingIndicatorView =  $(id("org.wikipedia.alpha:id/view_onboarding_page_indicator"));

    @Step("Проверка отображения заголовка")
    public WikiOnboardingPage checkPrimaryTextView(String text) {
        primaryTextView
                .shouldBe(visible)
                .shouldHave(text(text));
        return this;
    }

    @Step("Проверка отображения подзаголовка")
    public WikiOnboardingPage checkSecondaryTextView(String text) {
        secondaryTextView
                .shouldBe(visible)
                .shouldHave(text(text));
        return this;
    }

    @Step("Проверка отображения картинки")
    public WikiOnboardingPage checkCenteredImage() {
        centeredImage
                .shouldBe(visible);
        return this;
    }

    @Step("Клик на кнпоку продолжить")
    public WikiOnboardingPage clickContinue() {
        continueButton.click();
        return this;
    }

    @Step("Клик на кнпоку завершения обучения")
    public WikiOnboardingPage clickDone() {
        onboardingDoneButton.click();
        return this;
    }

    @Step("Проверка отсутствия онбординга")
    public WikiOnboardingPage checkOnboardingNotExists() {
        onboardingIndicatorView.shouldNotBe(exist);
        continueButton.shouldNotBe(exist);
        secondaryTextView.shouldNotBe(exist);
        primaryTextView.shouldNotBe(exist);
        return this;
    }
}
