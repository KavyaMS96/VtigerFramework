package com.Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {


	public String getPropertyData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p=new Properties();
		p.load(fis);
		String v=p.getProperty(key);
		return v;
		
		
	}

}
