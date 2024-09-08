package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static drivers.ConfigsDriver.getAuthConfig;
import static drivers.ConfigsDriver.getBrowserstackConfig;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", getAuthConfig().getLogin());
        caps.setCapability("browserstack.key", getAuthConfig().getPassword());

        // Set URL of the application under test
        caps.setCapability("app", getBrowserstackConfig().getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", getBrowserstackConfig().getDevice());
        caps.setCapability("os_version", getBrowserstackConfig().getOSVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", getBrowserstackConfig().getProject());
        caps.setCapability("build", getBrowserstackConfig().getBuild());
        caps.setCapability("name", getBrowserstackConfig().getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(getBrowserstackConfig().getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}