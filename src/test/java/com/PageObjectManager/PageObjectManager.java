package com.PageObjectManager;

import com.Utility.FileReaderManager;

public class PageObjectManager {
	private FileReaderManager fileReaderManager;
	private static PageObjectManager pageObjectManager;
	private NaukriLoginPageModel naukriLoginPageModel;
	public FileReaderManager getFileReaderManager() {
		if(fileReaderManager==null) {
			fileReaderManager=new FileReaderManager();
		}
		return fileReaderManager;
	}
	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager==null) {
			pageObjectManager=new PageObjectManager();
		}
		return pageObjectManager;
	}
	public NaukriLoginPageModel getNaukriLoginPageModel() {
		if(naukriLoginPageModel==null) {
			naukriLoginPageModel=new NaukriLoginPageModel();
		}
		return naukriLoginPageModel;
	}

}
