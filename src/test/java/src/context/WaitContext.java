package src.context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitContext implements ExpectedCondition<Boolean> {
    private final AppiumDriver<MobileElement> appiumDriver;
    public WaitContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver=appiumDriver;
    }

    @Override
    public Boolean apply(WebDriver webDriver) {

        return appiumDriver.getContextHandles().size()>1;
    }
}
