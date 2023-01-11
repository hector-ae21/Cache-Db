package gradle.cliapp.with.lib.template.exceptions;

/**
 * KeyNotFoundException class
 */
public class KeyNotFoundException extends RuntimeException {
    /**
     * Create a new KeyNotFoundException
     */
    public KeyNotFoundException() {
        super("Key not found");
    }
}
