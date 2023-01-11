package gradle.cliapp.with.lib.template.utils;

/**
 * Hash class
 */
public class Hash {
    /**
     * Hash a string to a hex string
     * @param data string to hash
     * @return hex string
     */
    public static String hashCodesHex(String data){
        return String.format("%6x", data.hashCode()).trim();
    }
}
