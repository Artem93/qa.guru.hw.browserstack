package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulationDriver;
import drivers.RealDriver;
import helpers.Attach;
import helpers.TypeHost;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static drivers.ConfigsDriver.getSystemConfig;
import static helpers.TypeHost.BROWSERSTACK;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = switch (TypeHost.valueOf(getSystemConfig().getDeviceHost().toUpperCase())) {
            case REAL -> RealDriver.class.getName();
            case EMULATION -> EmulationDriver.class.getName();
            case BROWSERSTACK -> BrowserstackDriver.class.getName();
        };
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.pageSource();
        closeWebDriver();

        if (TypeHost.valueOf(getSystemConfig().getDeviceHost().toUpperCase()).equals(BROWSERSTACK)) {
            Attach.addVideo(sessionId);
        }
    }
}