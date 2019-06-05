package com.uzabase.contentreader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.XMLEvent;

import com.uzabase.exceptions.RSSFeedContentReaderException;
import com.uzabase.models.Item;
import com.uzabase.models.Item.ItemBuilder;
import com.uzabase.models.RSSFeed;
import com.uzabase.models.RSSFeed.RSSFeedBuilder;
import com.uzabase.utils.CommonUtil;;
/**
 * RSS feed content reader implementation for version 2.0
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedContentReaderVersion2Impl implements RSSFeedContentReader<RSSFeed> {

	@Override
	public RSSFeed read(XMLEventReader xmlEvenReader) throws RSSFeedContentReaderException {
		 RSSFeed rssFeed =  null;
		 try {
			 XMLEvent event = nextStartElement(xmlEvenReader);
			if ( event== null) {
				throw new RSSFeedContentReaderException("Invalid Rss Feed content.Content could not be read!");
			}

				String element = event.asStartElement().getName().getLocalPart();
				if (element.equalsIgnoreCase("channel")) {
					
					RSSFeedBuilder rssFeedBuilder = new RSSFeedBuilder();
					List<Item> items = new ArrayList<Item>();
					
					while (xmlEvenReader.hasNext()) {
						event = xmlEvenReader.nextEvent();
						if (event.isStartElement()) {
							element = event.asStartElement().getName().getLocalPart();
							ItemBuilder itembuilder = null;
							switch (element) {
							case "title":
								rssFeedBuilder.title(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "link":
								rssFeedBuilder.link(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "description":
								rssFeedBuilder.description(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "lastBuildDate":
								rssFeedBuilder.lastBuildDate(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "docs":
								rssFeedBuilder.docs(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "generator":
								rssFeedBuilder.generator(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
								break;
							case "item":
								itembuilder=new ItemBuilder();
								while (xmlEvenReader.hasNext()) {
									event = xmlEvenReader.nextEvent();
									if (event.isStartElement()) {
										element = event.asStartElement().getName().getLocalPart();
										switch (element) {
										case "title":
											itembuilder.title(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
											break;
										case "link":
											itembuilder.link(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
											break;
										case "description":
											itembuilder.description(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
											break;
										case "pubDate":
											itembuilder.pubDate(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
											break;
										case "guid":
											itembuilder.guid(CommonUtil.removeIgnoredWords(getCharacterData(event, xmlEvenReader)));
											break;
										case "enclosure":
											itembuilder.enclosure(CommonUtil.removeIgnoredWords(getAttribute(event,"url")));
											break;
										
										}
									}else if(event.isEndElement()) {
										 EndElement endElement = event.asEndElement();
										 if (endElement.getName().getLocalPart().equals("item")) {
											 items.add(itembuilder.build());
											 break;
										 }
										 
									}
								}
								break;
							}
						}
					}
					rssFeedBuilder.items(items);
					rssFeed = rssFeedBuilder.build();
				}else {
					throw new RSSFeedContentReaderException("Invalid Rss Feed content.Content could not be read!");
				}
			
		} catch (XMLStreamException e) {
			throw new RSSFeedContentReaderException(e);
		}
		return rssFeed;
	}
		
	/**
	 * helper function to get next start element
	 * @param xmlEvenReader
	 * @return
	 * @throws XMLStreamException
	 */
	
	private XMLEvent nextStartElement(XMLEventReader xmlEvenReader) throws XMLStreamException {
		while(xmlEvenReader.hasNext()) {
			XMLEvent event = xmlEvenReader.nextEvent();
			 if (event.isStartElement()) {
				 return event;
			 }
		}
		return null;
	}
	/**
	 * helper function to get text value inside tag
	 * 
	 * @param event
	 * @param eventReader
	 * @return
	 * @throws XMLStreamException
	 */
	private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }
	/**
	 * helper function to get attribute value from tags
	 * @param event
	 * @param attr
	 * @return
	 */
	private String getAttribute(XMLEvent event,String attr) {
		  String result = "";
		  @SuppressWarnings("unchecked")
		Iterator<Attribute> attributes =event.asStartElement().getAttributes();
		  while (attributes.hasNext()) {
              Attribute attribute = attributes.next();
              if (attribute.getName().toString().equals(attr)) {
                  return attribute.getValue();
              }

          }
		return result;
	}

}
