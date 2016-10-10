package wbl.MobileAutomationAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.remote.MobileCapabilityType;

public class App {

	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) {

		try {
			File xoomapp = new File(System.getProperty("user.dir")+"\\resources\\xoom.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"22");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus");
			capabilities.setCapability(MobileCapabilityType.VERSION,"5.1.1");
			capabilities.setCapability(MobileCapabilityType.APP,xoomapp.getAbsolutePath());

			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.xoom.android.app.MainActivity_");
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.xoom.android.app");

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4727/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
	}
}
}