import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.ClockPage;
import org.junit.jupiter.api.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClockTest {
    static UiAutomator2Options deviceCapabilities; // שינוי שם מ-appOptions
    AndroidDriver mobileDriver;

    @BeforeAll
    public static void setupCapabilities() {
        deviceCapabilities = new UiAutomator2Options();
        deviceCapabilities.setDeviceName("emulator-5554");
        deviceCapabilities.setAutomationName("UiAutomator2");
        deviceCapabilities.setPlatformName("Android");
        deviceCapabilities.setPlatformVersion("15");
        deviceCapabilities.setAppPackage("com.google.android.deskclock");
        deviceCapabilities.setAppActivity("com.android.deskclock.DeskClock");
        deviceCapabilities.setNoReset(false);
        deviceCapabilities.setNewCommandTimeout(Duration.ofSeconds(150));
    }

    @BeforeEach
    public void initializeDriver() throws MalformedURLException {
        mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), deviceCapabilities);
    }

    @AfterEach
    public void tearDown() {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }

    @Test
    @DisplayName("בדיקת ספירה לאחור של טיימר - 31 שניות")
    public void verifyTimerCountdownLogic() {
        ClockPage timerScreen = new ClockPage(mobileDriver);

        timerScreen.goToTimerTab();
        Assertions.assertTrue(timerScreen.isTimerInputReady(), "שגיאה: מסך הזנת הטיימר לא הופיע");

        timerScreen.setTimerDuration();
        Assertions.assertEquals("00h 00m 31s", timerScreen.getCurrentInputValue(), "שגיאה: הזמן שהוזן אינו תקין");

        timerScreen.clickStart();

        WebDriverWait wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(35));
        wait.until(ExpectedConditions.textToBePresentInElement(timerScreen.getCountdownDisplayElement(), "1"));

        Assertions.assertTrue(timerScreen.getRunningTimerValue().contains("1"), "שגיאה: הטיימר לא הציג את הזמן המצופה לאחר ההמתנה");
    }
}