package src.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverF implements MobileCapabilityTypeEx, AppPackage{
    public static AppiumDriver<MobileElement> getDriver(Platform platform)
    {
        AppiumDriver<MobileElement> driver;
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(UDID,"R38NB02HMSB");
        desiredCapabilities.setCapability(APP_PACKAGE,WEBDRIVER_IO);
        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
        URL appimSerrver=null;
        try {
            appimSerrver=new URL("http://localhost:4723/wd/hub");
        }catch (Exception e)
        {
            e.printStackTrace();

        }
        if (appimSerrver==null)
        {
            throw new RuntimeException("uRRL");

        }
        switch (platform)
        {
            case ANDROID:
                driver=new AndroidDriver<>(appimSerrver,desiredCapabilities);
                break;
            case IOS:
                driver=new IOSDriver<>(appimSerrver,desiredCapabilities);
                break;
            default:
                throw new IllegalArgumentException("Platform type can't be  null");
        }
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        return driver;
    }
}
