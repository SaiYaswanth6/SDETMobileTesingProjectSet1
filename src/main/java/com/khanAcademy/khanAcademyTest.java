package com.khanAcademy;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class khanAcademyTest {
		// TODO Auto-generated method stub
		 public AndroidDriver driver;
		  @Test
		  public void login() throws InterruptedException {
			  
		    driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_search")).click();
		    Thread.sleep(5000);
		    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Arts and humanities\")")).click();
		    Thread.sleep(3000);
		   // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Art of Oceania\"));"));
		    
		    TouchAction act=new TouchAction(driver);
	        Dimension d= driver.manage().window().getSize();
	        int width=d.width;
	        int height=d.height;
	        int x1=width/2;
	        int y1=4*height/5;
	        int x2=width/2;
	        int y2=height/5;
	        Thread.sleep(3000);
	        while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Art of Oceania\")")).size()==0) {
	            act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2, y2)).release().perform();
	            Thread.sleep(1500);
	        }
	        
		    String expectedResult = "Art of Oceania";
		    String actualResult = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Art of Oceania\")")).getText();
		    Assert.assertEquals(actualResult, expectedResult);
		    System.out.println(expectedResult + " is displayed");
		    
		    driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Art of Oceania\")")).click();
		    String pageTitle = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Art of Oceania\")")).getText();
		    Assert.assertEquals(pageTitle, expectedResult);
		    System.out.println(expectedResult + " is opened");
		    
		  }
		@BeforeClass
		  public void beforeClass() throws MalformedURLException {
			DesiredCapabilities capability = new DesiredCapabilities();
	        //capability.setCapability("deviceName", "Sai");
	        capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Sai");
	        capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
	        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
	        driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		  }
		  @AfterClass
		  public void afterClass() {
			  driver.closeApp();
		  }	  
	}

/* TouchAction act=new TouchAction(driver);
        Dimension d= driver.manage().window().getSize();
        int width=d.width;
        int height=d.height;
        int x1=width/2;
        int y1=4*height/5;
        int x2=width/2;
        int y2=height/5;
        Thread.sleep(10000);
        while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Art of Oceania\")")).size()==0) {
            act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2, y2)).release().perform();
            Thread.sleep(2000);
        }*/