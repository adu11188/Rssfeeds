package com.uzabase.contentreader;

import javax.xml.stream.XMLEventReader;

import com.uzabase.exceptions.RSSFeedContentReaderException;
/**
 * RSS content reader interface
 * 
 * @author adarshsumma
 *
 * @param <T>
 */
public interface RSSFeedContentReader<T> {

	public T read(XMLEventReader xmlEvenReader) throws RSSFeedContentReaderException;
}
