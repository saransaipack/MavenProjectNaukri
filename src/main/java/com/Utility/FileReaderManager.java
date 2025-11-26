package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;
	private static void setupproperty() throws IOException {
		try {
			File file=new File("C:\\Users\\DELL\\eclipse-workspace\\NaukriMaven\\src\\main\\resources\\Naukri.Properties");
			fileInputStream=new FileInputStream(file);
			property=new Properties();
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			Assert.fail("Error Occur");
		} catch (IOException e) {
			Assert.fail("Error Occur");
		}
	}
	public static String getDataProperty(String dataValue) throws IOException {
		setupproperty();
		String data=property.getProperty(dataValue);
		return data;
	}
public static void main(String[]args) throws IOException {
	System.out.println(getDataProperty("browser"));
}
}
