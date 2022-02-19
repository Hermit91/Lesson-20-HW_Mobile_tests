package gmail.salokin1991.tests.selenoid;

import com.codeborne.selenide.Configuration;
import gmail.salokin1991.drivers.SelenoidMobileDriver;
import gmail.salokin1991.helpers.AttachSelenoid;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class SelenoidTestBase {
    @BeforeAll
    public static void setup() {

        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = SelenoidMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;

    }

    @BeforeEach
    public void startDriver() {

        open();

    }

    @AfterEach
    public void afterEach() {
        AttachSelenoid.screenshotAs("Last screenshot");
        AttachSelenoid.pageSource();
        AttachSelenoid.addVideo();
        closeWebDriver();
    }
}
