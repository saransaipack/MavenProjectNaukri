package com.listener;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.NaukriMaven.NaukriBase_Class;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport {
	public static ExtentTest extenttest;
	
@BeforeSuite
public void extentTestReportStartup() throws IOException {
	NaukriBase_Class base=new NaukriBase_Class() {
		
	};
	base.extentReportStart(null);
}
public void extentReportEnd() throws IOException {
	NaukriBase_Class base=new NaukriBase_Class() {
};
base.extentReportTeamDown(null);

}}
