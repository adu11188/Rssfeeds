package com.uzabase.input;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.uzabase.exceptions.RSSFeedParserException;
import com.uzabase.exceptions.RSSFeedVersionNotSupportedException;
import com.uzabase.models.RSSFeed;
import com.uzabase.parser.RSSFeedParser;
import com.uzabase.parser.RSSFeedParserImpl;
/**
 * Adapter class for RSS feed input to parser
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedInputAdapter{

	RSSFeedParser<RSSFeed> rfp = new RSSFeedParserImpl();
	/**
	 * Reads rss feed from rss feed URL
	 * @param urlS
	 * @return
	 * @throws IOException
	 * @throws RSSFeedVersionNotSupportedException
	 * @throws RSSFeedParserException
	 */
	public RSSFeed getRSSFeedFromURL(String urlS) throws IOException, RSSFeedVersionNotSupportedException, RSSFeedParserException {
		InputStream is = null;
		URL url = new URL(urlS);
		is = url.openStream();
		return rfp.parse(is);
	}
/**
 * Reads file and return RSSFeed object
 * 
 * @param filepath
 * @return
 * @throws FileNotFoundException
 * @throws RSSFeedVersionNotSupportedException
 * @throws RSSFeedParserException
 */
	public RSSFeed getRSSFeedFromFile(String filepath) throws FileNotFoundException, RSSFeedVersionNotSupportedException, RSSFeedParserException {
		InputStream is = new FileInputStream(filepath);
		return rfp.parse(is);
	}
	/**using utf-8 and return RSSFeed object
	 * 
	 * Reads input string 
	 * @param s
	 * @return
	 * @throws RSSFeedVersionNotSupportedException
	 * @throws RSSFeedParserException
	 */
	public RSSFeed getRSSFeedFromString(String s) throws RSSFeedVersionNotSupportedException, RSSFeedParserException {
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rfp.parse(is);
	}

}
