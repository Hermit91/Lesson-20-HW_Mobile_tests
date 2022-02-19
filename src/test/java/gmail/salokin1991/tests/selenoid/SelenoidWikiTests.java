package gmail.salokin1991.tests.selenoid;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SelenoidWikiTests extends SelenoidTestBase {

    @Test
    @Tag("selenoid")
    @DisplayName("Check Wikipedia language 'English'")
    void donatePageExistTest() {

        step("Tap CONTINUE", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });
        step("Tap CONTINUE", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });
        step("Tap CONTINUE", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });
        step("Tap GET STARTED", () -> {
            $(MobileBy.xpath(("//*[@text='GET STARTED']"))).click();
        });
        step("Tap menu", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Tap settings", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        });
        step("Tap Wikipedia Language", () -> {
            $(MobileBy.id("android:id/summary")).click();
        });
        step("Check language 'English'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/wiki_language_title")).shouldHave(text("English"));
        });
    }

}
