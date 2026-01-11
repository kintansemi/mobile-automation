package utils;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver initDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("emulator-5554");
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            String appPath = System.getProperty("user.dir")
                    + "/src/test/resources/apps/mda-1.0.13-15.apk";
            options.setApp(appPath);

            options.setAutoGrantPermissions(true);
            options.setNoReset(true);

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"), //
                    options
            );

            return driver;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}
