package Views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.rmi.runtime.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private AndroidDriver driver;
    public LoginPage() throws Exception {

        userLoginProcess();
        permissionAllow();

    }

    @Test
    public void userLoginProcess() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            MobileElement username = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
            username.click();
            username.sendKeys("TEST90022144");
            driver.hideKeyboard();
            Reports.report("OK", "Login Page",
                    "Username metin alanı ekranda mevcut.İlgili metin girildi ve klavye kapatıldı...");

        }catch (NoSuchElementException e) {
            Reports.report("NoElement", "Login Page", "Username metin alanı ekranda mevcut değil...");

        }
        try{
            MobileElement password = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
            password.click();
            password.sendKeys("1111");
            driver.hideKeyboard();
            Reports.report("OK","Login Page","Password metin alanı mevcut. İlgili metin girildi ve klavye kapatıldı...");

        }catch (NoSuchElementException e){
            Reports.report("NoElement","Login Page","Password metin alanı mevcut değil...");
        }
        try{
            MobileElement loginBtn = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
            loginBtn.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Reports.report("OK","Login Page","Login butonu ekranda mevcut. Butona tıklandı ve giriş yapıldı...");
        }catch (NoSuchElementException e){
            Reports.report("NoElement", "Login Page", "Login butonu ekranda mevcut değil...");
        }
    }
    @Test
    public void permissionAllow(){
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
        try{
            String izinVer = "ALLOW";
            MobileElement allow = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
            if(allow.getText().equals(izinVer)){
                allow.click();
                Reports.report("OK","Updates Page","Ekrana izin isteme pop-up ı çıktı ve allow butonuna tıklandı..");
            }else {
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            }

        }catch(NoSuchElementException e){
            Reports.report("NoElement","Updates Page","Ekrana izin isteme pop-up ı gelmedi...");
        }
    }

}
