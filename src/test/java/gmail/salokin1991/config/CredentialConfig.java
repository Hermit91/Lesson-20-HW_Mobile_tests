package gmail.salokin1991.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialConfig extends Config {

    String browserstackUser();

    String browserstackKey();

    String browserstackAppUrl();

    String browserstackRemoteUrl();

    String browserstackVideoUrl();


    String emulatedUrl();

    String emulatedDeviceName();

    String emulatedPlatformName();

    String emulatedAppPath();


    String localUrl();

    String localDeviceName();

    String localPlatformName();

    String localAppPath();


    String selenoidUrl();

    String selenoidUser();

    String selenoidPass();

    String selenoidDeviceName();

    String selenoidPlatformName();

    String selenoidOsVersion();

    String selenoidAppUrl();

}
