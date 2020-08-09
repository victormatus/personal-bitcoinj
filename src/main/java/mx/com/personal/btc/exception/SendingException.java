package mx.com.personal.btc.exception;

public class SendingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7439635839581627282L;
	
	public SendingException(String message) {
		super(message);
	}

}
