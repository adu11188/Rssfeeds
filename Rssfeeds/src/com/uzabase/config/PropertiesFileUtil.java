package com.uzabase.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.uzabase.exceptions.PropertiesFileNotFoundException;
/**
 * Application Properties utility
 * 
 * @author adarshsumma
 *
 */
public class PropertiesFileUtil {

	private PropertiesFileUtil() {
		
	}
	/**
	 * Fetch the property from application.properties file
	 * @param key
	 * @return
	 * @throws PropertiesFileNotFoundException
	 */
	public static String getPropertyValues(String key) throws  PropertiesFileNotFoundException{
		try {
			Properties prop = new Properties();
			InputStream input = null;
			String filename = "application.properties";
			input = PropertiesFileUtil.class.getClassLoader().getResourceAsStream(filename);
			prop.load(input);
			return prop.getProperty(key);
		}catch(IOException e) {
			throw new PropertiesFileNotFoundException("application.properties missing in classpath ",e);
		}
	}
}
