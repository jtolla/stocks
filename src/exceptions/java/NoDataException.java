package exception;

/**
 *
 * @author Sara
 */
public class NoDataException extends Throwable {
    
    public NoDataException() {
        super("No Data");
    }
    public NoDataException(String message) {
        
        super(message);
    }
}
