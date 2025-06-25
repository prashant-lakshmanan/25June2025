package com.dws.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener, ISuiteListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName();
		
		javaUtil=new JavaUtility();
		String time = javaUtil.getSystemDateTime();
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots"+methodName+"-"+time+".png");
		
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
