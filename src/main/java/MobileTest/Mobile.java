package MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class Mobile {
	
	static public AndroidDriver<MobileElement> driver, tempDrv;
    static public AndroidDriver<MobileElement> driver2;
//    WebDriver driver;
    
    
    @Test (priority = 0)
    public void test1()throws MalformedURLException, InterruptedException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("deviceName","HYMFM7QSTGSWZ5SC");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.android.bbkcalculator");
        capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator"); 
        // This is Launcher activity of your app
                                                   // (you can get it from apk info app)

 

    //    capabilities.setCapability("appPackage", "com.android.dialer");
      // capabilities.setCapability(MobileCapabilityType.APP, "com.android.dialer" );
    //    capabilities.setCapability("appActivity", ".DialtactsActivity");
        
      
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

            // locate the Text on the calculator by using By.name()
           driver.findElementById("com.android.bbkcalculator:id/digit7").click();
           
           driver.findElementById("com.android.bbkcalculator:id/plus").click();
        
           driver.findElementById("com.android.bbkcalculator:id/digit3").click();
            
            WebElement equalTo = driver.findElementById("com.android.bbkcalculator:id/equal");
            equalTo.click();
            WebElement results = driver.findElementById("com.android.bbkcalculator:id/input_edit");

 

            if(results.getText().equals("10"))
            {
                System.out.println("Test Passed...");
            }
            else
            {
                System.out.println("Test Failed...");
            }
    }

}
