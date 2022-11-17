package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverF;
import src.driver.Platform;

import java.time.Duration;
import java.util.List;

public class Back {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            MobileElement navFormsBtnE=appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navFormsBtnE.click();

            WebDriverWait wait=new WebDriverWait(appiumDriver, 5L);
            wait.until((ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Swipe horizontal\")"))));

            Dimension windowSize=appiumDriver.manage().window().getSize();
            int screenHeight=windowSize.getHeight();
            int screenWidth=windowSize.getWidth();

            //tinh touch point
            int xStartPoint=0*screenWidth/100;
            int xEndPoint=50*screenWidth/100;
            int yStartPoint=50*screenHeight/100;
            int yEndPoint=50*screenHeight/100;
            //chuyển qua tọa độ
            PointOption startPoint=new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint=new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            List<MobileElement> abc=appiumDriver.findElements(MobileBy.AccessibilityId("card"));
            if(abc.isEmpty())
            {
                throw new RuntimeException("ERROR");
            }else {
                abc.get(0).click();
            }
            //touch action
            TouchAction touchAction=new TouchAction(appiumDriver);
            touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500))).moveTo(endPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(500))).release().perform();
            ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.BACK));

            Thread.sleep(3000);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
