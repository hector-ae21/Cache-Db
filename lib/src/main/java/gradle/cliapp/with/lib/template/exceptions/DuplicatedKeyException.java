package gradle.cliapp.with.lib.template.exceptions;

/**
 * DuplicatedKeyException class
 */
public class DuplicatedKeyException extends Exception {
    /**
     * Create a new DuplicatedKeyException
     */
    public DuplicatedKeyException() {
        super("Key already exists");
    }
}
