package gmail.salokin1991.drivers;

import com.codeborne.selenide.WebDriverProvider;
import gmail.salokin1991.config.CredentialConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static CredentialConfig credentials =
            ConfigFactory.create(CredentialConfig.class);

    static String user = credentials.browserstackUser();
    static String key = credentials.browserstackKey();
    static String appUrl = credentials.browserstackAppUrl();
    static String remoteUrl = credentials.browserstackRemoteUrl();

    public static URL getBrowserstackUrl() {

        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", user);
        desiredCapabilities.setCapability("browserstack.key", key);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", appUrl);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);

    }

}