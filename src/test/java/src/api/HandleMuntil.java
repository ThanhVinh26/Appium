package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import src.driver.AppPackage;
import src.driver.DriverF;
import src.driver.Platform;

import java.time.Duration;

public class HandleMuntil {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            MobileElement navloginBtn= appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navloginBtn.click();
            //tìm element
            MobileElement emailinput=appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passinput=appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginbtn=appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            //input
            emailinput.sendKeys("teo@sth.com");
            passinput.sendKeys("12345678");
            loginbtn.click();
            //run app in bg
            //appiumDriver.runAppInBackground(Duration.ofSeconds(3));
            //open app
            appiumDriver.activateApp(AppPackage.SETTINGS);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Network & internet']")).click();
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Internet']")).click();
            boolean isWifioff=appiumDriver.findElements(MobileBy.xpath("//*[@text='Add network']")).isEmpty();
            int timetoTogle=isWifioff ? 1 : 2;
            MobileElement toogle=appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));
            for (int toogletime = 0; toogletime < timetoTogle; toogletime++) {
                toogle.click();
            }

            //come back
            appiumDriver.activateApp(AppPackage.WEBDRIVER_IO);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            //debug
            Thread.sleep(3000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
