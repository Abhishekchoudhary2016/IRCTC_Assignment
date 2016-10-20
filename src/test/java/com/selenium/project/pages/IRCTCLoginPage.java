package com.selenium.project.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IRCTCLoginPage {
	
	WebDriver driver;
	private By flightTicket = By.xpath("//a[text()='Flight Tickets']");
	
	
	public IRCTCLoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	public void clickOnFlight()
	{
		driver.findElement(flightTicket).click();
	}
	
	public void windowSwitch(String parentWindow)
	{
		Set<String> windowHandle=driver.getWindowHandles();
		for(String window:windowHandle)
		{
			if(!window.equals(parentWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
	}

}
