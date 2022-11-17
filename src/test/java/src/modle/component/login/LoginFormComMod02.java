package src.modle.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComMod02 {
    private final AppiumDriver<MobileElement> appiumDriver;

    private static  final By usernameSel= MobileBy.AccessibilityId("input-email");
    private static  final By passwordSel= MobileBy.AccessibilityId("input-password");
    private static  final By loginbtnSel= MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComMod02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    public void inputusernameElement(String username)
    {
          appiumDriver.findElement(usernameSel).sendKeys(username);
    }
    public void inputpasswordElement(String password)
    {
          appiumDriver.findElement(passwordSel).sendKeys(password);
    }
    public void Clickbtnlogin()
    {
          appiumDriver.findElement(loginbtnSel).click();
    }
}
