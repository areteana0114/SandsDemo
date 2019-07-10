package com.cucumber.framework.PageObjects.scheduleactivity;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.CS.CustomerServLoc;
import com.cucumber.framework.PageObjects.LoginPage;
import com.cucumber.framework.PageObjects.LoginPageLoc;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class ScheduleActivityPage extends CustomerServ implements ScheduleActivityPageLoc {

	
	private final Logger log = LoggerHelper.getLogger(ScheduleActivityPage.class);
	ScheduleActivityPage scheduleactivitypage;
	
	public ScheduleActivityPage(WebDriver driver) {
		super(driver);
		}

	public void testScheduleActivityPage() {
		//System.out.println("In ScheduleActivityPage method :"+ driver);
	}
	
	public void sendScheduleActivityObject(ScheduleActivityPage scheduleactivitypage) {
		this.scheduleactivitypage=scheduleactivitypage;
		//System.out.println("In sendLoginObject method search page"+this.loginpage);
	}
	
	//click on New button on header
	public void clickOnNewButton() {
		WebElement new_button=driver.findElement(By.xpath(new_button_xpath));
		scheduleactivitypage.waitForElement(new_button, 3);
		new_button.click();
	    waitFor(2);
	}
	
	public void HoverOnDemoScreenPops() {
		WebElement demo_screens_pop=driver.findElement(By.xpath(demo_screen_pops_xpath));
		scheduleactivitypage.waitForElement(demo_screens_pop, 3);
		Actions action=new Actions(driver);
		action.moveToElement(demo_screens_pop).build().perform();
	    waitFor(2);
	}
	
	public void clickOnDemoPop(String name) {
		List<WebElement> demo_pop_button=driver.findElements(By.xpath(demo_pop_button_xpath));
		waitFor(2);
		for(int i=0;i<demo_pop_button.size();i++) {
			if(demo_pop_button.get(i).getText().contains(name)) {
				System.out.println(demo_pop_button.get(i).getText());
				scheduleactivitypage.waitForElement(demo_pop_button.get(i), 3);
				demo_pop_button.get(i).click();
				break;
			}
		}
		waitFor(2);
	}
	
	public void clickOnAcceptButton() {
		WebElement accept_button=driver.findElement(By.xpath(accept_button_xpath));
		scheduleactivitypage.waitForElement(accept_button, 3);
		accept_button.click();
	    waitFor(5);
	}
	
	public void verifyUserPageIsOpen() {
		scheduleactivitypage.goToFrameByName(frame_Gadget_One);
		Assert.assertTrue(driver.findElement(By.xpath(add_task_xpath)).isDisplayed(), "Customer Page is not displayed");
		waitFor(5);
		
	}
	
	public void clickOnTask() {
		WebElement task_button=driver.findElement(By.xpath(task_xpath));
		scheduleactivitypage.waitForElement(task_button, 3);
		task_button.click();
	    waitFor(5);
	}
	
	public void selectTaskType(String tasktype) {
		scheduleactivitypage.selectFromDropdownUsingVisibleText(task_type_dd_xpath, tasktype);
		waitFor(3);
	}
	
	public void selectEscalateAsNo() {
		WebElement escalate_button=driver.findElement(By.xpath(escalate_xpath));
		scheduleactivitypage.waitForElement(escalate_button, 3);
		escalate_button.click();
	    waitFor(3);
	}
	
	public void selectAccount(String account) {
		scheduleactivitypage.selectFromDropdownUsingVisibleText(link_account_dd_xpath, account);
		waitFor(3);
	}
	
	public void selectAssignTo(String assignee) {
		scheduleactivitypage.selectFromDropdownUsingVisibleText(assign_to_dd_xpath, assignee);
		waitFor(3);
	}
	
	public void selectWorkbasket(String wb) {
		scheduleactivitypage.selectFromDropdownUsingVisibleText(workbasket_dd_xpath, wb);
		waitFor(3);
	}
	
	public void enterNotes(String comments) {
		WebElement notes_textarea=driver.findElement(By.xpath(notes_textarea_xpath));
		scheduleactivitypage.waitForElement(notes_textarea, 3);
		notes_textarea.sendKeys(comments);
	    waitFor(3);
	}
	
	public void clickOnSubmit() {
		WebElement submit_xpath=driver.findElement(By.xpath(submit_button_xpath));
		scheduleactivitypage.waitForElement(submit_xpath, 3);
		submit_xpath.click();
	    waitFor(3);
	}
	
	public void verifyConfirmationMsg() {
		WebElement confirm_msg=driver.findElement(By.xpath(confirm_msg_xpath));
		scheduleactivitypage.waitForElement(confirm_msg, 3);
		confirm_msg.getText().contains("has been created successfully");
	    waitFor(3);
	}
	
	public void clickOnConfirm() {
		WebElement confirm_button=driver.findElement(By.xpath(confirm_button_xpath));
		scheduleactivitypage.waitForElement(confirm_button, 3);
		confirm_button.click();
	    waitFor(3);
	}
	
	public void clickOnWB() {
		scheduleactivitypage.switchToDefaultContent();
		 waitFor(3);
		 scheduleactivitypage.goToFrameByName(frame_Gadget_zero);
		 waitFor(5);
	}
	
	public void clickResolveRadiobtn() {
		scheduleactivitypage.switchToDefaultContent();
		 waitFor(3);
		
		 scheduleactivitypage.goToFrameByName(frame_Gadget_One);
		 waitFor(5);
		WebElement resolve_radio_button=driver.findElement(By.xpath(resolve_xpath));
		scheduleactivitypage.waitForElement(resolve_radio_button, 3);
		resolve_radio_button.click();
		
	    waitFor(3);
	}
	
	public void clickOnSubmitInWrapUpScreen() {
		
		WebElement submit_btn_wrapup=driver.findElement(By.xpath(submit_button_Wrapupscreen_xpath));
		scheduleactivitypage.waitForElement(submit_btn_wrapup, 3);
		submit_btn_wrapup.click();
		
	    waitFor(10);
	}
	
	public void clickWBResultsRow(String caseid) {
		String xpathstart="//*[@id='$PpgRepPgSubSectionCPMMyWorkBasketListBB$ppxResults$l";
		String xpathend="']/td[1]/div/span";
		for(int i=1;i<=100;i++) {
			WebElement caseID=driver.findElement(By.xpath(xpathstart+i+xpathend));
			try {
			if(caseID.getText().equalsIgnoreCase(caseid)){
				caseID.click();
				break;
			}
			}catch(Exception e) {
				System.out.println("No such element"+e.getMessage());
			}
		}
		waitFor(5);
	}
	
}
