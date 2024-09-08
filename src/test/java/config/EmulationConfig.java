package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:${env}.properties",
        "classpath:emulator.properties"
})
public interface EmulationConfig extends Config {

    @Key("osVersion")
    String getOSVersion();

    @Key("device")
    String getDevice();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
