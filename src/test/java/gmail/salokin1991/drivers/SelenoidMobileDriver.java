package gmail.salokin1991.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.salokin1991.config.CredentialConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static CredentialConfig credentials =
            ConfigFactory.create(CredentialConfig.class);

    static String user = credentials.selenoidUser();
    static String password = credentials.selenoidPass();
    static String selenoidUrl = credentials.selenoidUrl();
    static String deviceName = credentials.selenoidDeviceName();
    static String platformName = credentials.selenoidPlatformName();
    static String osVersion = credentials.selenoidOsVersion();
    static String selenoidAppUrl = credentials.selenoidAppUrl();


    public static URL getSelenoidDeviceUrl() {
        try {
            return new URL(String.format("https://%s:%s@%s", user, password, selenoidUrl));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", osVersion);

//        desiredCapabilities.setCapability("locale", "en");
//        desiredCapabilities.setCapability("language", "en");

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", selenoidAppUrl);

        return new AndroidDriver(getSelenoidDeviceUrl(), desiredCapabilities);
    }
}
