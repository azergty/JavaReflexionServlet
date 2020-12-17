package www.dal;

import www.log.MonLogger;

public class UserNotUpdateEventException extends Exception {


  public UserNotUpdateEventException(String e) {
    super(e);
    MonLogger.setLogger("UserNotUpdateEventException","severe",e);
  }

	public String getMessage() {
		return super.getMessage();
	}

  private static final long serialVersionUID = 2L;

}

