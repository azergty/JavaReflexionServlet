package www.albin;

import www.log.MonLogger;

public class Exception404  extends Exception{
	private static final long serialVersionUID = 1L;


	public Exception404(String msg) {
		super(msg);
		MonLogger.setLogger("Exception404","severe",msg);
	}

	
	public String getMessage() {
		return super.getMessage();
	}
	
}
