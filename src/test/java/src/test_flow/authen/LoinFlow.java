package src.test_flow.authen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.modle.component.login.LoginFormCom;
import src.modle.pages.LoginScreenmode01;
import src.test_flow.BaseFlow;

public class LoinFlow extends BaseFlow {
    private String username;
    private String password;


    public LoinFlow(AppiumDriver<MobileElement> appiumDriver,String username, String password) {
        super(appiumDriver);

        this.username = username;
        this.password = password;
    }

    public void login()
    {
        LoginScreenmode01 loginScreenmode01=new LoginScreenmode01(appiumDriver);
        LoginFormCom loginFormCom=loginScreenmode01.loginFormCom();
        if(!username.isEmpty()) loginFormCom.usernameElement(username);
    }
    public void verifyLogin()
    {

    }
}
