package wbl.MobileAutomationAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class YelpApp {

	public static AndroidDriver<WebElement> driver;

	@BeforeClass
	public static void setUp() {

		try {

			File yelpfile = new File(
					"C:\\Users\\sridhar\\workspace1\\MobileAutomationAppium\\resources\\com.yelp.android-6.9.0-10004503-minAPI10.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "22");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
			capabilities.setCapability(MobileCapabilityType.VERSION, "5.1.1");
			capabilities.setCapability(MobileCapabilityType.APP, yelpfile.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.yelp.android");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,
					"com.yelp.android.ui.activities.RootActivity");

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
			Thread.sleep(5000);

			// driver.quit();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void loginPageTest() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("splash_button_bottom").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("activity_login_editUsername").sendKeys("rangakanchana@gmail.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("activity_login_editPassword").sendKeys("gold123");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("activity_login_btnLogin").click();
	}

	@AfterClass
	public void cleanup() {

		driver.quit();
	}

}
