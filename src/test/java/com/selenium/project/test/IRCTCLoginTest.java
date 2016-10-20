package com.selenium.project.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.IRCTCFlightSearchPage;
import com.selenium.project.pages.IRCTCLoginPage;

public class IRCTCLoginTest {

	@Test
	public void testIRCTC() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		IRCTCLoginPage login = new IRCTCLoginPage(driver);
		login.clickOnFlight();
		String pw=driver.getWindowHandle();
		login.windowSwitch(pw);
		Select select=null;
		IRCTCFlightSearchPage searchPage = new IRCTCFlightSearchPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(searchPage.checkOneWayRadio());
		Assert.assertFalse(searchPage.checkTwoWayRadio());
		searchPage.enterSource("delhi");
		searchPage.enterDestination("Jaipur");
		searchPage.selectDate();
		searchPage.selectAdult(select, 1);
		searchPage.selectChild(select, 1);
		searchPage.selectInfant(select, 1);
		searchPage.clickOnSearchFlight();
		int number= searchPage.displayFlight();
		Assert.assertTrue(number>0 && number<100);
		driver.quit();
	}
}
