import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static WebDriverWait wait;
    protected Boolean android = true;
    protected String appiumURL = "http://localhost:4723";

    @BeforeScenario
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (android) {
            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("noReset", "true");
            appiumDriver = new AndroidDriver<MobileElement>(new URL(appiumURL), capabilities);
        } else {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000);
            capabilities.setCapability("commandTimeouts", 12000);
            capabilities.setCapability(MobileCapabilityType.APP, "Selendroid.app");
            appiumDriver = new IOSDriver<MobileElement>(new URL(appiumURL), capabilities);
        }
        wait = new WebDriverWait(appiumDriver, 15);
    }

    @AfterScenario
    public void quit() {
        appiumDriver.closeApp();
    }
}
