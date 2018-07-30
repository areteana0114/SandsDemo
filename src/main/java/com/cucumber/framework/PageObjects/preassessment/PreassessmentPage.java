package com.cucumber.framework.PageObjects.preassessment;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class PreassessmentPage extends CustomerServ implements PreassessmentPageLoc{
	private final Logger log = LoggerHelper.getLogger(PreassessmentPage.class);
	PreassessmentPage preassessmentpage;
	
	public PreassessmentPage(WebDriver driver) {
		super(driver);
		}

	public void testPreassessmentPage() {
		//System.out.println("In TestLoginPage method :"+ driver);
	}
	
	public void sendPreassessmentObject(PreassessmentPage preassessmentpage) {
		this.preassessmentpage=preassessmentpage;
		//System.out.println("In sendPreassessmentObject method page"+this.preassessmentpage);
	}
	
	public void clickOnCreateButton() {
		WebElement create_button=driver.findElement(By.xpath(create_button_xpath));
		preassessmentpage.waitForElement(create_button, 3);
		create_button.click();
	    waitFor(3);
	}
	
	public void clickOnPreassessmentButton() {
		WebElement preassessment_button=driver.findElement(By.xpath(preassessment_button_xpath));
		preassessmentpage.waitForElement(preassessment_button, 3);
		preassessment_button.click();
	    waitFor(3);
	}

}
