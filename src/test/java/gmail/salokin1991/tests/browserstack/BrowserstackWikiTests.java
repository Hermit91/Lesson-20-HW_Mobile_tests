package gmail.salokin1991.tests.browserstack;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BrowserstackWikiTests extends BrowserstackTestBase {

    @Test
    @Tag("browserstack")
    @DisplayName("Check language selection field visibility")
    void searchTest() {

        step("Tap header menu", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Tap settings", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Tap Wikipedia Language", () -> {
            $(MobileBy.id("android:id/summary")).click();
        });
        step("Select input field? than type 'English'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_filter")).sendKeys("English");
        });
        step("Check language selection field visibility", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/preference_languages_list")).shouldBe(visible);
        });

    }
}
