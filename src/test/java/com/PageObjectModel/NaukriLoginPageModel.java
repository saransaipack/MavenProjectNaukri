package com.PageObjectModel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.PageObjectManager.PageObjectManager;
import com.Utility.ExcelUtility;
import com.NaukriMaven.NaukriBase_Class;

public class NaukriLoginPageModel extends NaukriBase_Class implements com.interfaceElement.NaukriInterfaceElement {

	@FindBy(id=login_id)
	private WebElement login;
	@FindBy(id= userName_id)
	private WebElement userName;
	@FindBy(id=password_id)
	private WebElement Password;
	@FindBy(xpath=LoginBtn_xpath)
	private WebElement loginButton;
	@FindBy(css=title_css)
private WebElement title;
	public void NaukriPageObjectModel() {
		PageFactory.initElements(driver, this);
		}
	public void validLogin() throws IOException {
		//Click(login);
		passInput(userName,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
		passInput(Password,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
		Click(loginButton);
		validation(title,ExcelUtility.getCellValue("DATA", "ID", "Title"));
	}
	
}


