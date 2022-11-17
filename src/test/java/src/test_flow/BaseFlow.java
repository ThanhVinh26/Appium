package src.test_flow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.modle.pages.LoginScreenmode01;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void gotoLogin()
    {
        new LoginScreenmode01(appiumDriver).bottomnav().ClickLoginIcon();

    }
}
