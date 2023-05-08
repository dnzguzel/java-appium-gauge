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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    Logger logger = LoggerFactory.getLogger(getClass());
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static WebDriverWait wait;
    protected boolean androidMobile = true;
    @BeforeScenario
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (androidMobile) {
            capabilities.setCapability("automationName","uiautomator2");
            capabilities.setCapability("platformName","Android");
//            capabilities.setCapability("platformVersion","12");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.selendroid.testapp.HomeScreenActivity");
            capabilities.setCapability("udid","emulator-5554");
            capabilities.setCapability("noReset","true");
//            capabilities.setCapability("app","/Users/denizg/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
            appiumDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723"), capabilities);
        } else {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14");
            // IOS_XCUI_TEST for Apple
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000);
            capabilities.setCapability("commandTimeouts", 12000);
            // IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723"), capabilities)
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/denizg/AquaProjects/JavaTestProject/src/test/java/org/dnz/appium/MyRNDemoApp.app");
            appiumDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4723"), capabilities);
        }
        logger.info("Uygulama açıldı...");
        wait = new WebDriverWait(appiumDriver, 3000);
    }
    @AfterScenario
    public void quit() {
        appiumDriver.closeApp();
        appiumDriver.quit();
        logger.info("Uygulama kapatıldı...");
    }
}
