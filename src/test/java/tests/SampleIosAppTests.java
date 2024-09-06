package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SampleIosAppPage;

public class SampleIosAppTests extends TestBase{

    @Test
    @Tag("ios")
    @DisplayName("Проверка перехода к инпуту по тапу на кнопку Text")
    void checkTapByTapOn(){
        SampleIosAppPage iosAppPage = new SampleIosAppPage();
        iosAppPage
                .clickOnTextButton()
                .checkInputView()
                .checkOutputView();
    }
}
