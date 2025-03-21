package SC;

public class CannotRideException extends Exception {

  public static final String MESSAGE = "No rides left";

  public CannotRideException() {
    // En vez de llamar a super, es mejor llamar a this y reutilizar el codigo de abajo
    this(MESSAGE);
  }

  public CannotRideException(String msg) {
    super(msg);
  }

}

