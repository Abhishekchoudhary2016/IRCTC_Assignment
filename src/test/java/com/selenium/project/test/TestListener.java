package com.selenium.project.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sun.jna.platform.FileUtils;

public class TestListener implements ITestListener{
	
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Shit! Test Failed");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy@MM@dd_HH-mm-ss");
		Date date = new Date();
		String format= dateFormat.format(date);
		String systemDirPath= System.getProperty("user.dir");
	File f = ((TakesScreenshot)IRCTCLoginTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(f, new File(systemDirPath+format+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Wow test passed");
		
	}

}
