package uml.spring2014.exceptions;

/**
 * Created exception to handle missing data from UI.
 * 
 * @author Sara Gerstung
 */
public class NoDataException extends Throwable {
    
    public NoDataException() {
        super("No Data");
    }
    
    public NoDataException(String message) {
       super(message);
    }
}/* End NoDataException */
