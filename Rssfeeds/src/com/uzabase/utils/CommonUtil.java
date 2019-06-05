package com.uzabase.utils;

import com.uzabase.config.PropertiesFileUtil;
import com.uzabase.exceptions.PropertiesFileNotFoundException;

/**
 * This class handles common utilities
 * 
 * @author adarshsumma
 *
 */
public class CommonUtil {

	private CommonUtil() {

	}

	/**
	 * Removes ignored-words from the input string
	 * 
	 * @param input
	 * @return
	 */
	public static String removeIgnoredWords(String input) {
		try {
			String ignoredWords = PropertiesFileUtil.getPropertyValues("ignored-words");

			if (ignoredWords != null) {
				String[] igwrds = ignoredWords.split(",");
				for (String iw : igwrds) {
					input = input.replaceAll(iw, "");
				}
				return input;
			}
		} catch (PropertiesFileNotFoundException e) {
			e.printStackTrace();
		}

		return input;
	}
}
