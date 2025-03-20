package SC;

public class CannotRideException extends Exception {

  public static final String MESSAGE = "No rides left";

  public CannotRideException() {
    super(MESSAGE);
  }

  public CannotRideException(String msg) {
    super(msg);
  }

}

