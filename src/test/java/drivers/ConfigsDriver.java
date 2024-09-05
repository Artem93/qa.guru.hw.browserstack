package drivers;

import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigsDriver {
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
    private static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    public static AuthConfig getAuthConfig() {
        return authConfig;
    }

    public static BrowserstackConfig getBrowserstackConfig(){
        return browserstackConfig;
    }
}
