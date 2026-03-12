import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.SettingsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingsTest {
    static UiAutomator2Options deviceOptions;
    AndroidDriver mobileDriver;

    @BeforeAll
    public static void setupCapabilities() {
        deviceOptions = new UiAutomator2Options();
        deviceOptions.setDeviceName("emulator-5554");
        deviceOptions.setAutomationName("UiAutomator2");
        deviceOptions.setPlatformName("Android");
        deviceOptions.setPlatformVersion("15");
        deviceOptions.setAppPackage("com.android.settings");
        deviceOptions.setAppActivity("com.android.settings.Settings");
        deviceOptions.setNoReset(false);
        deviceOptions.setNewCommandTimeout(Duration.ofSeconds(150));
    }

    @BeforeEach
    public void init() throws MalformedURLException {
        // התחברות לשרת Appium
        mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), deviceOptions);
    }

    @AfterEach
    public void quit() {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }

    @Test
    public void verifySystemKeyboardNavigation() {
        SettingsPage settingsPage = new SettingsPage(mobileDriver);

        settingsPage.scrollToSystemMenu();
        Assertions.assertTrue(settingsPage.isSystemMenuOpen(), "דף המערכת לא נטען כראוי");

        settingsPage.openKeyboardSettings(); 
        Assertions.assertTrue(settingsPage.isKeyboardConfigDisplayed(), "הגדרות המקלדת לא הוצגו");
    }
}