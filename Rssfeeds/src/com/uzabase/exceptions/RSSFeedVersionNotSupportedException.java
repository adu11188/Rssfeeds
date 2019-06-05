package com.uzabase.exceptions;
/**
 * 
 */
import org.xml.sax.SAXException;

public class RSSFeedVersionNotSupportedException extends SAXException{
	private static final long serialVersionUID = 1L;

	public RSSFeedVersionNotSupportedException () {

    }

    public RSSFeedVersionNotSupportedException (String message) {
        super (message);
    }


}
