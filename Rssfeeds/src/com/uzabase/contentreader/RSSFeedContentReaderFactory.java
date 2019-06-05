package com.uzabase.contentreader;
/**
 * Factory to get content reader
 * 
 * @author adarshsumma
 *
 * @param <T>
 */
public class RSSFeedContentReaderFactory {

	/**
	 * Gets RSS content reader type based on version
	 * 
	 * @param version
	 * @return
	 */
	public  static  RSSFeedContentReader<?> getRSSFeedContentReaderInstance(String version) {

		switch (version) {

		case "2.0":
			return new RSSFeedContentReaderVersion2Impl();

		default:
			return null;
		}

	}
}
