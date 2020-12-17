package www.dal;

import www.log.MonLogger;

public class UserNotCreateEventException extends Exception {

	  public UserNotCreateEventException(String e) {
	    super(e);
	    MonLogger.setLogger("UserNotCreateEventException","severe",e);
	  }

		public String getMessage() {
			return super.getMessage();
		}

	  private static final long serialVersionUID = 2L;

}



