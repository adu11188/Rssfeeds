package com.uzabase.exceptions;
/**
 * 
 * @author adarshsumma
 *
 */
public class PropertiesFileNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PropertiesFileNotFoundException () {

    }

    public PropertiesFileNotFoundException (String message) {
        super (message);
    }

    public PropertiesFileNotFoundException (Throwable cause) {
        super (cause);
    }

    public PropertiesFileNotFoundException (String message, Throwable cause) {
        super (message, cause);
    }
}
