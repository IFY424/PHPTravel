package com.selenium.Nayilalibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class JavaPropertiesManager {
	final static Logger logger = Logger.getLogger(JavaPropertiesManager.class);
	private String propertiesFile;
	private Properties prop;
	private OutputStream output;
	private InputStream input;

	public JavaPropertiesManager(String propertiesFilePath) {
		propertiesFile = propertiesFilePath;
		logger.info("Using Config File: "+propertiesFilePath);
		prop = new Properties();
	}

	public String readProperty(String key) {
		String value = null;
		try {
			input = new FileInputStream(propertiesFile);
			prop.load(input);
			value = prop.getProperty(key);

		} catch (Exception e) {
			logger.info(e);
		} finally {
			if (input != null) {
				try {
					input.close();

				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
		return value;
	}

	public void setProterty(String key, String value) {
		try {
			output = new FileOutputStream(propertiesFile);
			prop.setProperty(key, value);
			prop.store(output, null);

		} catch (Exception e) {
			logger.error(e);
		}
	}

}
