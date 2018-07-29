package com.cucumber.framework.GeneralHelperSel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class SeleniumFunc implements SeleniumFuncLoc {
	private final Logger log = LoggerHelper.getLogger(SeleniumFunc.class);
	protected WebDriver driver;
	
	public SeleniumFunc(WebDriver driver) {
		this.driver=driver;
	}

	public void testSel() {
		System.out.println("In testSel of SeleniumFunc"+driver);
	}
	
	
	public static void robotClass()  {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}
	
	public  String captureScreen(String name) {
		if (name == "") {
			name = "blank";
		}

		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY-hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "target\\screenshot\\";
			destFile = new File((String) reportDirectory + name + "_" + formatter.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
		
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "height='200' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
	public void getNumberOfFrames() {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
		}
	
	public static void HandleStaleElement(WebElement element) {
		for(int i=0; i<4;i++) {
            try {
             element.click();
             break;
            } catch(StaleElementReferenceException e) {
              e.toString();
        System.out.println("Trying to recover from a stale element :" + e.getMessage());
            }
         }
	 }
	
	public  void getRefresh() {
		driver.navigate().refresh();
	}
	
	public  String goToFrame(WebElement element) {
		String frameNameone=null;
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
        for(int i=0;i<frames.size();i++) {
		System.out.println(frames.get(i).getAttribute("id"));
		String frameNametwo=frames.get(i).getAttribute("id");
		driver.switchTo().defaultContent();
		waitFor(5);
		driver.switchTo().frame(frameNametwo);
		try {
		if(element.isDisplayed()) {
			System.out.println("Element"+ element +"is present in the frame"+ frameNametwo);
			frameNameone=frameNametwo;
			break;
			}
		}catch(Exception e) {
			System.out.println("Element is not present inside the frame"+ element);
			driver.switchTo().defaultContent();
	    }
	}
        return frameNameone;
		}
	
	public void goToFrameByName(String framename) {
		driver.switchTo().frame(framename);
	}
	public void waitFor(int millisec){
		try {
			Thread.sleep(millisec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElement(WebElement element, int timeunitForsec) {
		WebDriverWait wait = new WebDriverWait(driver, timeunitForsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	
	
}
