package src.api;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.context.Contexts;
import src.context.WaitContext;
import src.driver.DriverF;
import src.driver.Platform;

import java.util.ArrayList;
import java.util.List;

public class Hybrid {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver= DriverF.getDriver(Platform.ANDROID);
        try {
            appiumDriver.findElement(MobileBy.AccessibilityId("Webview")).click();
            WebDriverWait wait=new WebDriverWait(appiumDriver,5L);
            wait.until(new WaitContext(appiumDriver));

            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println("Context: "+contextHandle);
            }
            appiumDriver.context(Contexts.WEB_VIEW);
            WebElement navTogg=appiumDriver.findElementByCssSelector(".navbar__toggle");
            navTogg.click();
            List<MobileElement> menuItems=appiumDriver.findElementsByCssSelector(".menu__lít li a");
            if(menuItems.isEmpty() )
            {
                throw new RuntimeException("Loi roi nha");}
            List<MenuItemsData> menuItemsList=new ArrayList<>();
            for (MobileElement menuItem : menuItems) {
                String itemText=menuItem.getText();
                String itemHref=menuItem.getAttribute("href");
                if(itemText.isEmpty())
                {
                    menuItemsList.add(new MenuItemsData("Github",itemHref));
                }
                else
                {
                    menuItemsList.add(new MenuItemsData(itemText,itemHref));

                }
                System.out.println(menuItemsList);
            }
            appiumDriver.context(Contexts.NATIVE);
            appiumDriver.findElement(MobileBy.AccessibilityId("Home")).click();

            Thread.sleep(3000);


        }catch (Exception e )
        {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
    public static class MenuItemsData
    {
        private final String name;
        private final String href;
        public MenuItemsData(String name,String href)
        {
            this.name=name;
            this.href=href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }

        @Override
        public String toString() {
            return "MenuItems{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }

}
