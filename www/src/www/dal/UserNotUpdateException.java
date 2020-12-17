package www.dal;

import www.log.MonLogger;

public class UserNotUpdateException extends Exception{

	  public UserNotUpdateException(String e) {
	    super(e);
	    MonLogger.setLogger("UserNotUpdateException","severe",e);
	  }

		public String getMessage() {
			return super.getMessage();
		}

	  private static final long serialVersionUID = 2L;

	}

