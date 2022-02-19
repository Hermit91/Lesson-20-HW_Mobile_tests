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

public class EmulatedMobileDriver implements WebDriverProvider {

    public static CredentialConfig credentials = ConfigFactory.create(CredentialConfig.class);

    static String deviceName = credentials.emulatedDeviceName();
    static String platformName = credentials.emulatedPlatformName();
    static String emulatedUrl = credentials.emulatedUrl();
    static String appPath = credentials.emulatedAppPath();

    public static URL getEmulatedUrl() {

        try {
            return new URL(emulatedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        desiredCapabilities.setCapability("app", getAbsolutePath(appPath));

        return new AndroidDriver(getEmulatedUrl(), desiredCapabilities);

    }

}