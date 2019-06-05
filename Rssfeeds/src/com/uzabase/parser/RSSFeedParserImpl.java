package com.uzabase.parser;

import java.io.InputStream;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.uzabase.contentreader.RSSFeedContentReader;
import com.uzabase.contentreader.RSSFeedContentReaderFactory;
import com.uzabase.exceptions.RSSFeedContentReaderException;
import com.uzabase.exceptions.RSSFeedParserException;
import com.uzabase.exceptions.RSSFeedVersionNotSupportedException;
import com.uzabase.models.RSSFeed;
/**
 * Implementation class for RSS feed parser
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedParserImpl implements RSSFeedParser<RSSFeed> {

	
	@Override
	/**
	 * Parses the input stream and returns RSSFeed object
	 * 
	 */
	public RSSFeed parse(InputStream is) throws RSSFeedVersionNotSupportedException, RSSFeedParserException {

		RSSFeed rssFeed = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader eventReader = inputFactory.createXMLEventReader(is);

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					/**
					 * look for rss tag to extract version
					 */
					if (startElement.getName().getLocalPart().equals("rss")) {
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();

						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							/**
							 * extract version attribute from rss tag
							 */
							if (attribute.getName().toString().equalsIgnoreCase("version")) {
								String rssFeedXmlVersion = attribute.getValue();
								
								//System.out.println("rssFeedXmlVersion:"+rssFeedXmlVersion);
								/**
								 * Get content reader implementation using the rss version
								 */
								RSSFeedContentReader<?> rssFeedContentReader =  RSSFeedContentReaderFactory.getRSSFeedContentReaderInstance(rssFeedXmlVersion);
								/**
								 * Throw exception if version is not supported by current implementation
								 */
								if(rssFeedContentReader==null) {
									throw new RSSFeedVersionNotSupportedException("RSS feed version:"+rssFeedXmlVersion+" not supported");
								}
									
								/**
								 * Read the Rss content using content reader
								 */
							    rssFeed =  (RSSFeed) rssFeedContentReader.read(eventReader);
								return rssFeed;
								
							}
						}
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RSSFeedParserException(e);
		} catch (RSSFeedContentReaderException e) {
			throw new RSSFeedParserException(e);
		}
		return rssFeed;
	}

}
