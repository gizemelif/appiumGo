import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    private AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel_2_XL_API_24");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("appPackage", "com.geovisiongroup.visiongo");
        desiredCapabilities.setCapability("appActivity", "com.geovisiongroup.visiongo.MainActivity");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @Test
    public void loginPageTest(){
        LoginPage loginPage = new LoginPage();
    }
}
