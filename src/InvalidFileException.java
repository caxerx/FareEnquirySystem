public class InvalidFileException extends RuntimeException {
    public InvalidFileException() {
        super("Something wrong with the format of fare.txt");
    }
}
