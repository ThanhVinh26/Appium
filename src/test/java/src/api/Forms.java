package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import src.driver.DriverF;
import src.driver.Platform;

import java.util.List;

public class Forms {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            MobileElement navFormBtn=appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormBtn.click();
            MobileElement InputField=appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            InputField.sendKeys("abcxyz");
            MobileElement Switch=appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            Switch.click();
            MobileElement DropDown=appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
            DropDown.click();
            Thread.sleep(2000);
            MobileElement Select=appiumDriver.findElement((MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")));
            Select.click();
            Thread.sleep(2000);
            MobileElement ActiveBtn=appiumDriver.findElement(MobileBy.xpath("\t\n" +
                    "//android.view.ViewGroup[@content-desc=\"button-Active\"]/android.view.ViewGroup/android.widget.TextView"));
            ActiveBtn.click();
            Thread.sleep(1000);
            MobileElement OkBtn=appiumDriver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[3]"));
            OkBtn.click();
            Thread.sleep(1000);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
