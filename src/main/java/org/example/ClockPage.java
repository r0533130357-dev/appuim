package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ClockPage {
    private final AndroidDriver mobileDriver; // שינוי שם מ-driver ל-mobileDriver

    @AndroidFindBy(accessibility = "Timer")
    private WebElement timerNavigationButton;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_3")
    private WebElement buttonDigitThree;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_digit_1")
    private WebElement buttonDigitOne;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_setup_time")
    private WebElement timeSettingLabel;

    @AndroidFindBy(accessibility = "Start")
    private WebElement startProcessBtn;

    @AndroidFindBy(id = "com.google.android.deskclock:id/timer_text")
    private WebElement activeCountdownLabel;

    public ClockPage(AndroidDriver driver) {
        this.mobileDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public void goToTimerTab() {
        timerNavigationButton.click();
    }

    public boolean isTimerInputReady() {
        return buttonDigitOne.isDisplayed();
    }

    public void setTimerDuration() {
        buttonDigitThree.click();
        buttonDigitOne.click();
    }

    public String getCurrentInputValue() {
        return timeSettingLabel.getText();
    }

    public void clickStart() {
        startProcessBtn.click();
    }

    public String getRunningTimerValue() {
        return activeCountdownLabel.getText();
    }

    public WebElement getCountdownDisplayElement() {
        return activeCountdownLabel;
    }
}