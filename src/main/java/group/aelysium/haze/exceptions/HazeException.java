package group.aelysium.haze.exceptions;

public class HazeException extends RuntimeException {
    public HazeException(String message) {
        super(message);
    }
    public HazeException() {
        super("There was a fatal error while performing this operation.");
    }
}
