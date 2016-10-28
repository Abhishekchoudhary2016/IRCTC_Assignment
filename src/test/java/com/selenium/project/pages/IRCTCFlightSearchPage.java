package com.selenium.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IRCTCFlightSearchPage {
	WebDriver driver;
	
	private By oneWayRadio= By.xpath("//div[@class='onewayradio']//input[@name='tripType']");
	private By  roundTripRadio = By.xpath("//div[@class='roundtripradio']//input[@name='tripType']");
	private By  Source=By.xpath("//input[@id='origin']");
	private By Destination =By.xpath("//input[@id='destination']");
	private By dateButton =By.xpath("//input[@name='departDate']/following-sibling::img");
	private By date =By.xpath("//div[@id='ui-datepicker-div']//a[text()='20']");;
	private By number_Adult= By.xpath("//select[@id='noOfAdult']");
	private By number_child=By.xpath("//select[@id='noOfChild']");
	private By number_infant= By.xpath("//select[@id='noOfInfant']");
	private By search_btn =By.xpath("//div[@id='showdometic']/div[@class='srchbtn']");
	private By list_flight=By.className("onewayflightinfo");
	
	public IRCTCFlightSearchPage(WebDriver driver){
		this.driver=driver;
	}
	public Boolean checkOneWayRadio(){	
	return driver.findElement(oneWayRadio).isSelected();
	}
	public Boolean checkTwoWayRadio()
	{
		return driver.findElement(roundTripRadio).isSelected();
	}
	public void enterSource(String sourceJourney) throws InterruptedException
	{
		driver.findElement(Source).sendKeys(sourceJourney);
		Thread.sleep(2000);
		driver.findElement(Source).sendKeys(Keys.TAB);
	}
	
	public void enterDestination(String destinationJourney) throws InterruptedException
	{
		driver.findElement(Destination).sendKeys(destinationJourney);
		Thread.sleep(2000);
		driver.findElement(Destination).sendKeys(Keys.TAB);
	}
	public void selectDate()
	{
		driver.findElement(dateButton).click();
		driver.findElement(date).click();
	}
	public void selectAdult(Select select, int index)
	{
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfAdult']")));
		select.selectByIndex(index);
	}
	public void selectChild(Select select, int index)
	{
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfChild']")));
		select.selectByIndex(index);
	}
	public void selectInfant(Select select, int index){
		select = new Select(driver.findElement(By.xpath("//select[@id='noOfInfant']")));
		select.selectByIndex(index);
	}
	public void clickOnSearchFlight()
	{
		driver.findElement(search_btn).click();
	}
	public int displayFlight()
	{
		List<WebElement> list = driver.findElements(list_flight);
		System.out.println("Total no of flights: "+list.size());
		System.out.println("first element: "+list);
		return list.size();
	}
}
