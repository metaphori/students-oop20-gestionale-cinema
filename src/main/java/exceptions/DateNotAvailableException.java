package exceptions;

//@SuppressWarnings("serial")
public class DateNotAvailableException extends Exception {

	/**
	 * Constructs a DateNotAvailableException with "This Date is not available"
	 * as its error message.
	 */

	public DateNotAvailableException() {
		super("This Date is not available");
	}

	/**
	 * Constructs a DateNotAvailableException with the specified message.
	 * 
	 * @param message
	 *            the specified error message.
	 */
	public DateNotAvailableException(final String message) {
		super(message);
	}

}
