package gmail.salokin1991.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.salokin1991.config.CredentialConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static gmail.salokin1991.utils.FileUtils.getAbsolutePath;

public class LocalMobileDriver implements WebDriverProvider {

    public static CredentialConfig credentials =
            ConfigFactory.create(CredentialConfig.class);

    static String deviceName = credentials.localDeviceName();
    static String platformName = credentials.localPlatformName();
    static String localUrl = credentials.localUrl();
    static String appPath = credentials.localAppPath();

    public static URL getLocalUrl() {

        try {
            return new URL(localUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);

//        desiredCapabilities.setCapability("locale", "en");
//        desiredCapabilities.setCapability("language", "en");

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        desiredCapabilities.setCapability("app", getAbsolutePath(getAbsolutePath(appPath)));

        return new AndroidDriver(getLocalUrl(), desiredCapabilities);

    }

}