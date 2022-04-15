import java.lang.Exception;

public class ShortageException extends Exception {
    public ShortageException(){
        super("Inventory is short, can't retrieve items.");
    }
}
