package com.cucumber.framework.PageObjects.scheduleactivity;

public interface ScheduleActivityPageLoc {

	String new_button_xpath="//a[@name='CPMInteractionPortalHeaderTop_pyDisplayHarness_5' and @title='New']";
	//String demo_screen_pops_xpath="//li[@data-test-id='201808060337180736630']//span[@class='menu-item-title' and text()='Demo Screen Pops']";
	String demo_screen_pops_xpath = "//li[@title='Launch demo screen pop options']";
	String demo_pop_button_xpath="//span[@class='menu-item-title' and starts-with(text(),'Demo Pop')]";
	String accept_button_xpath="//button[@name='IncomingCallPop_CallInteraction_64']";
	
	String frame_Gadget_One="PegaGadget1Ifr";
	String frame_Gadget_zero="PegaGadget0Ifr";
	String frame_Gadget_two="PegaGadget2Ifr";
	String add_task_xpath="//button[@title='Add Task']";
	String wb_xpath="//h3[@id='headerlabel1685' and text()='My workbaskets']";
	//String wb_xpath="//h3[@id='headerlabel1685']";
	
	//Schedule Activity Task xpaths
	
	String task_xpath="//div[text()='Task']";
	String task_type_dd_xpath="//select[@title='Task Type']";
	String escalate_xpath="//span[@class='col-3']/label[@for='6f3f77b6No']";
	String link_account_dd_xpath="//select[@name='$PpyWorkPage$pSelectedAccountNumber']";
	String assign_to_dd_xpath="//select[@title='Select routing option']";
	String workbasket_dd_xpath="//select[@title='Select workbasket']";
	String notes_textarea_xpath="//span[@id='CTRL_TA']";
	String submit_button_Wrapupscreen_xpath="//button[@name='CAWrapUp_pyWorkPage_10' and @title='Complete this assignment']";
	String confirm_msg_xpath="//div[@data-expr-id='435280bb580d6d7e48baa9185eeaaad8460701ef_7']";
	String confirm_button_xpath="//button[@title='Confirm' and text()='Confirm']";
	String resolve_xpath="//span[@class='col-3']/label[@for='47f6b90aResolve']";
	String submit_button_xpath="//button[@title='Complete this assignment' and text()='Submit']";
}
