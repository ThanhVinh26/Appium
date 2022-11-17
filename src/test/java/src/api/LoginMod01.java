package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.driver.DriverF;
import src.driver.Platform;
import src.modle.component.login.LoginFormCom;
import src.modle.pages.LoginScreenmode01;

public class LoginMod01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            LoginScreenmode01 loginScreenmode01=new LoginScreenmode01(appiumDriver);
            loginScreenmode01.bottomnav().ClickLoginIcon();
            LoginFormCom loginFormCo=loginScreenmode01.loginFormCom();
            loginFormCo.usernameElement().sendKeys("teo@sth.com");
            loginFormCo.passwordElement().sendKeys("12345678");
            loginFormCo.btnloginElement().click();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
