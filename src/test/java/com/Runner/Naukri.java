package com.Runner;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.NaukriMaven.NaukriBase_Class;
import com.PageObjectManager.PageObjectManager;

public class Naukri extends NaukriBase_Class {
	@BeforeClass
	private void setupProperty() throws IOException {
		getBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
		getUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
		
	}
	@Test
	private void validTestLogin() throws IOException, InterruptedException {
		PageObjectManager.getPageObjectManager().getNaukriLoginPageModel().validLogin();
		}
//	@AfterClass
//	private void browserclosing() {

	}
	

