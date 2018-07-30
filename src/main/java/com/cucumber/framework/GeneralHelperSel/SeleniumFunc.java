package com.cucumber.framework.GeneralHelperSel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.cucumber.framework.CS.CustomerServ;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class SeleniumFunc implements SeleniumFuncLoc {
	private final Logger log = LoggerHelper.getLogger(SeleniumFunc.class);
	protected  WebDriver driver;
	//public static WebDriver driver;
	
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
		for(int i=0; i<15;i++) {
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
	public static void waitFor(int millisec){
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
	
	public void printAllWindowIds() {
		 Set<String> windowids1= driver.getWindowHandles();
	     Iterator<String> iter1=windowids1.iterator();
	     while(iter1.hasNext()) {
	  	   System.out.println(iter1.next());
	     }
	}
	
	public void switchToSecondWindow() {
	 Set<String> windowids1= driver.getWindowHandles();
     Iterator<String> iter1=windowids1.iterator();
    /* while(iter1.hasNext()) {
  	   System.out.println(iter1.next());
     }*/
     
     String pwindow=iter1.next();
     System.out.println("parent window id is:"+pwindow);
     String cwindow=iter1.next();
     System.out.println("child window id is:"+cwindow);
     waitFor(5);
     driver.switchTo().window(cwindow);
	}
	
	public void switchToThirdWindow() {
		 Set<String> windowids1= driver.getWindowHandles();
	     Iterator<String> iter1=windowids1.iterator();
	    /* while(iter1.hasNext()) {
	  	   System.out.println(iter1.next());
	     }*/
	     
	     String pwindow=iter1.next();
	     System.out.println("parent window id is:"+pwindow);
	     String fcwindow=iter1.next();
	     System.out.println("first child window id is:"+fcwindow);
	     String scwindow=iter1.next();
	     System.out.println("second child window id is:"+scwindow);
	     waitFor(5);
	     driver.switchTo().window(scwindow);
		}
	
	public void verifyPageTitle(String value) {
       waitFor(5);
       System.out.println("Title is :"+value);
	   Assert.assertTrue(driver.getTitle().contains(value), "Expected page "+value+" not displayed");
	}
	
	//select value from dropdown using visible text
	public void selectFromDropdownUsingVisibleText(String expath,String valuetoselect) {
	Select s=new Select(driver.findElement(By.xpath(expath)));
	s.selectByVisibleText(valuetoselect);
	}
	
	//select value from dropdown using index
	public void selectFromDropdownUsingIndex(String expath,int indexvalue) {
	Select s=new Select(driver.findElement(By.xpath(expath)));
	s.selectByIndex(indexvalue);
	}
	
	//select value from dropdown using value of the value
		public void selectFromDropdownUsingValue(String expath,String value) {
		Select s=new Select(driver.findElement(By.xpath(expath)));
		s.selectByValue(value);
		}
		
		public void clickOnSelectedElement(String expath,int i) {
			List<WebElement> elements=driver.findElements(By.xpath(expath));
			System.out.println(elements.size());
			clickUsingAction(elements.get(i));
	    }
		
		public void clickUsingAction(WebElement element) {
			Actions action=new Actions(driver);
			action.moveToElement(element).click().build().perform();
		}
		
		public void clickLinkInTable(String expath,int row,int col,int link) {
			 List<WebElement> rows = driver.findElements(By.xpath(expath));
			 System.out.println("rows size are: "+rows.size());
	        	 List<WebElement> cells=rows.get(row).findElements(By.tagName("td"));
	        	 System.out.println("cell size are: "+cells.size());
	        	 String linktext=cells.get(col).getText();
	        	 System.out.println("Id is: "+linktext);
	        	 
	        	List<WebElement> links= cells.get(col).findElements(By.tagName("a"));
	        	System.out.println("Link are :"+links.size());
	        	System.out.println(links.get(link).getText());
	        	
	        	HandleStaleElement(links.get(link));
	        
	        	System.out.println(links.get(link).getAttribute("href"));
	        	waitFor(5);
	        
		}
		
		public void clickLinkInTableDynamically(String expath,String Headertext,int link) {
			 List<WebElement> rows = driver.findElements(By.xpath(expath));
			 System.out.println("rows size are: "+rows.size());
	        	 List<WebElement> headers=rows.get(0).findElements(By.tagName("th"));
	        	 System.out.println("Header size are: "+headers.size());
	        	 for(int j=0;j<headers.size();j++) {
	        	 String headertext=headers.get(j).getText();
	        	 System.out.println("Header is: "+headertext);
	        	  if(headertext.equalsIgnoreCase(Headertext)) {
	        		  System.out.println("Header is: "+headertext+" "+Headertext);  
	        				 System.out.println("In Rows for loop");
	        				 for(int i=1;i<rows.size();i++) {
	        				 List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
	        	        	 System.out.println("cell size are: "+cells.size());
	        	        	 String linktext=cells.get(j).getText();
	        	        	 System.out.println("Text is: "+linktext);
	        	        		List<WebElement> links= cells.get(j).findElements(By.tagName("a"));
	        		        	System.out.println("Link are :"+links.size());
	        		        	System.out.println(links.get(link).getText());	        		 
	        		        	HandleStaleElement(links.get(link));	        		        
	        		        	System.out.println(links.get(link).getAttribute("href"));
	        		        	waitFor(5);
	        		            break;
	        		
	        				 }
	        				 break;
	        	  }
	        }
			 
		}
		
		public String getLinkTextFromTableDynamically(String expath,String Headertext,int link) {
			String text=null;
			 List<WebElement> rows = driver.findElements(By.xpath(expath));
			 System.out.println("rows size are: "+rows.size());
	        	 List<WebElement> headers=rows.get(0).findElements(By.tagName("th"));
	        	 System.out.println("Header size are: "+headers.size());
	        	 for(int j=0;j<headers.size();j++) {
	        	 String headertext=headers.get(j).getText();
	        	 System.out.println("Header is: "+headertext);
	        	  if(headertext.equalsIgnoreCase(Headertext)) {
	        		  System.out.println("Header is: "+headertext+" "+Headertext);  
	        				 System.out.println("In Rows for loop");
	        				 for(int i=1;i<rows.size();i++) {
	        				 List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
	        	        	 System.out.println("cell size are: "+cells.size());
	        	        	 String linktext=cells.get(j).getText();
	        	        	 System.out.println("Text is: "+linktext);
	        	        		List<WebElement> links= cells.get(j).findElements(By.tagName("a"));
	        		        	System.out.println("Link are :"+links.size());
	        		        	System.out.println(links.get(link).getText());
	        		        	 text=links.get(link).getText();
	        		        //	HandleStaleElement(links.get(link));	        		        
	        		        //	System.out.println(links.get(link).getAttribute("href"));
	        		        	waitFor(5);
	        		            break;
	        		
	        				 }
	        				 break;
	        	  }
	        }
				return text;
			 
		}
		
		public void clickButtonInTable(String expath,int row,int col,int button) {
			 List<WebElement> rows = driver.findElements(By.xpath(expath));
			 System.out.println("rows size are: "+rows.size());
	        	 List<WebElement> cells=rows.get(row).findElements(By.tagName("td"));
	        	 System.out.println("cell size are: "+cells.size());
	        	 String linktext=cells.get(col).getText();
	        	 System.out.println("Id is: "+linktext);     	 
	        	List<WebElement> buttons= cells.get(col).findElements(By.tagName("button"));
	        	System.out.println("Buttons are :"+buttons.size());
	        	System.out.println(buttons.get(button).getText());	
	        	HandleStaleElement(buttons.get(button));
	        	waitFor(5);
	        
		}
		
		public void writeDataToFile(String text) {
			
			try		
	        {	  
	        	 File file = new File("test.data");
	            // Delete old file if exists
				file.delete();		
	            file.createNewFile();			
	            FileWriter fileWrite = new FileWriter(file);							
	            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
	            Bwrite.write(text);																									
	            Bwrite.newLine();             		
	            Bwrite.close();			
	            fileWrite.close();	
	            
	        }
	        catch(Exception ex)					
	        {		
	            ex.printStackTrace();			
	        }		
		}
		
		public String ReadDataFromFile() throws IOException {
			String str=null;
			try {
				  File file = new File("test.data");							
			        FileReader fileReader = new FileReader(file);							
			        BufferedReader Buffreader = new BufferedReader(fileReader);							
			        String strline;	
			        while((strline=Buffreader.readLine())!=null){									
			      		System.out.println(strline);
			      		str=strline;
			        }
			        Buffreader.close();
			        fileReader.close();
			       
				}catch(Exception ex){					
			        ex.printStackTrace();			
			        }
			return str;	
			
			}
			
		

	
}
