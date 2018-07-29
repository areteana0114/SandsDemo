package com.cucumber.framework.PageObjects;

public interface LogoutPageLoc {
	//a[@title='CS Inbound Officer (Loan, Card)']
	String down_arrow_xpath="//i[@class='pi pi-caret-down']";
    String logout_xpath="//a//span[contains(text(),'Logout')]";
    String username_xpath="//input[@id='txtUserID']";
    String login_popup_close_xpath="//div[@class='pzbtn-mid' and text()='Close']";

}
