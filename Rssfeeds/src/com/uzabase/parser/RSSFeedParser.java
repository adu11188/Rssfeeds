package com.uzabase.parser;

import java.io.InputStream;

import com.uzabase.exceptions.RSSFeedParserException;
import com.uzabase.exceptions.RSSFeedVersionNotSupportedException;
/**
 * RSSFeed Parser interface
 * 
 * @author adarshsumma
 *
 * @param <T>
 */
public interface RSSFeedParser<T> {
	public T parse(InputStream is) throws RSSFeedVersionNotSupportedException, RSSFeedParserException ;
}
