package www.albin;

import www.log.MonLogger;

public class ExceptionServlet  extends Exception{
	private static final long serialVersionUID = 1L;


	public ExceptionServlet(String msg) {
		super(msg);
		MonLogger.setLogger("ExceptionServlet","severe",msg);
	}

	
	public String getMessage() {
		return super.getMessage();
	}
	
}


