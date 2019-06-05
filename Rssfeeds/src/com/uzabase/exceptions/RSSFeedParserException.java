package com.uzabase.exceptions;
/**
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedParserException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RSSFeedParserException () {

    }

    public RSSFeedParserException (String message) {
        super (message);
    }

    public RSSFeedParserException (Throwable cause) {
        super (cause);
    }

    public RSSFeedParserException (String message, Throwable cause) {
        super (message, cause);
    }
}
