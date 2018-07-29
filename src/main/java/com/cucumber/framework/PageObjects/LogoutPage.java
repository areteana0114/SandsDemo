package com.cucumber.framework.PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;
import com.cucumber.framework.helper.Logger.LoggerHelper;



public class LogoutPage extends CustomerServ implements LogoutPageLoc  {
	private final Logger log = LoggerHelper.getLogger(LogoutPage.class);
	LogoutPage logoutpage;

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}

	public void testLogoutPage() {
		//System.out.println("In test logout page");
		}
	
	public void sendLogoutObject(LogoutPage logoutpage) {
		this.logoutpage=logoutpage;
		//System.out.println("In sendLogoutObject method page"+this.logoutpage);
	}
	
	public void clickOnDownArrow() {
		logoutpage.switchToDefaultContent();
		//System.out.println(driver);
		try {
			driver.findElement(By.xpath(login_popup_close_xpath)).click();
	    }catch(Exception e) {
	    	//System.out.println("No such element present");
	    }
		try {
		driver.findElement(By.xpath(down_arrow_xpath)).click();
		Thread.sleep(5000);
		}catch(Exception e) {
	    	//System.out.println("Element down arrow is not present");
	    }
	}
	
	public void clickOnLogoutLink() {
		driver.findElement(By.xpath(logout_xpath)).click();
		SeleniumFunc.robotClass();
		
	}
	
	public boolean verifyUsernameField_IsDisplayed() {
		try {
			Assert.assertTrue(driver.findElement(By.xpath(username_xpath)).isDisplayed(),"Logout is not successful");
			//System.out.println("verify UsernameField_IsDisplayed method" + driver);
			return true;
			}catch(Exception e) {
			return false;
			}
	}
		
		
}
