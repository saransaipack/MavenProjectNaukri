package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NaukriMaven.NaukriBase_Class;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ITestMethods extends NaukriBase_Class implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		
			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentReport.extenttest.pass(result.getMethod() + " **---***" +"Test Pass",
					MediaEntityBuilder.createScreenCaptureFromBase64String(TakeScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReport.extenttest.fail(result.getMethod() + " **---***" +"Test Pass",
					MediaEntityBuilder.createScreenCaptureFromBase64String(TakeScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
