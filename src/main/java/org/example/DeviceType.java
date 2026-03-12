package org.example;

public enum DeviceType {
    NETWORK_OPTIONS("Network & internet"),
    BLUETOOTH_DEVICES("Connected devices"),
    APPLICATION_LIST("Apps"),
    NOTIFICATION_SETTINGS("Notifications"),
    BATTERY_INFO("Battery"),
    STORAGE_MANAGER("Storage"),
    SOUND_VIBRATION("Sound & vibration"),
    DISPLAY_TOUCH("Display & touch"),
    WALLPAPER_THEME("Wallpaper & style"),
    ACCESSIBILITY_TOOLS("Accessibility"),
    SECURITY_PRIVACY("Security & privacy"),
    LOCATION_SERVICES("Location"),
    SAFETY_EMERGENCY("Safety & emergency"),
    USER_ACCOUNTS("Passwords, passkeys & accounts"),
    PARENTAL_CONTROLS("Digital Wellbeing & parental controls"),
    GOOGLE_SERVICES("Google"),
    SYSTEM_CORE("System"), // זה המפתח שמשמש אותנו בטסט של ה-Settings
    DEVICE_DETAILS("About emulated device"),
    TIPS_HELP("Tips & support");

    private final String label;
    DeviceType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}