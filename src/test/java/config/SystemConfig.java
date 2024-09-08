package config;

import org.aeonbits.owner.Config;

public interface SystemConfig extends Config {
    @Key("deviceHost")
    @DefaultValue("emulation")
    String getDeviceHost();
}
