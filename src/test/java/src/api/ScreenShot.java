package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import src.driver.DriverF;
import src.driver.Platform;

import java.io.File;

public class ScreenShot {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            MobileElement navLoginForm=appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginForm.click();

            //full màn hình
            File base64screenshow=appiumDriver.getScreenshotAs(OutputType.FILE);
            String filelocation=System.getProperty("user.dir").concat("/screenshots/").concat("LoginScreen.png");
            FileUtil.copyFile(base64screenshow,new File(filelocation));
            //k lay status bar
            MobileElement loginForm=appiumDriver.findElement(MobileBy.AccessibilityId("login-screen"));
            File baseLogin=loginForm.getScreenshotAs(OutputType.FILE);
            String Loginfilelocation=System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
            FileUtil.copyFile(baseLogin,new File(Loginfilelocation));
            // lay 1 element
            MobileElement loginbtn=appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            File baseLoginbtn=loginbtn.getScreenshotAs(OutputType.FILE);
            String Loginbtnfilelocation=System.getProperty("user.dir").concat("/screenshots/").concat("Loginbtn.png");
            FileUtil.copyFile(baseLoginbtn,new File(Loginbtnfilelocation));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
