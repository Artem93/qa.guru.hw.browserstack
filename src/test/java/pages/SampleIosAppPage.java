package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SampleIosAppPage {
    private static final SelenideElement textBtn = $("[name=\"Text\"]");
    private static final SelenideElement outputTextView = $("[value=\"Waiting for text input.\"]");
    private static final SelenideElement inputTextView = $("[value=\"Enter a text\"]");

    @Step("Клик на кнопку Text")
    public SampleIosAppPage clickOnTextButton() {
        textBtn.click();
        return this;
    }

    @Step("Проверка отображения вьхи вывода")
    public SampleIosAppPage checkOutputView() {
        outputTextView.shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения инпута")
    public SampleIosAppPage checkInputView() {
        inputTextView.shouldBe(visible);
        return this;
    }
}
