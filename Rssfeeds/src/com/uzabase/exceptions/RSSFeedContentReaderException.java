package com.uzabase.exceptions;
/**
 * 
 * @author adarshsumma
 *
 */
public class RSSFeedContentReaderException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RSSFeedContentReaderException () {

    }

    public RSSFeedContentReaderException (String message) {
        super (message);
    }

    public RSSFeedContentReaderException (Throwable cause) {
        super (cause);
    }

    public RSSFeedContentReaderException (String message, Throwable cause) {
        super (message, cause);
    }
}
