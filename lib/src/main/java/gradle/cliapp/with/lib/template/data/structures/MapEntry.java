package gradle.cliapp.with.lib.template.data.structures;

import java.io.Serializable;

public class MapEntry implements Comparable<MapEntry>, Serializable {

    /**
     * key of the entry
     */
    private String key;
    /**
     * value of the entry
     */
    private String value;
    /**
     * Create a new entry
     *
     * @param key   key of the entry
     * @param value value of the entry
     */
    public MapEntry(String key, String value) {
        setKey(key);
        setValue(value);
    }


    /**
     * Get the key of the entry
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key of the entry
     *
     * @param key key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get the value of the entry
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of the entry
     *
     * @param value value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Compare the entries
     *
     * @param other other entry
     * @return 0 if equal, >0 if greater, <0 if smaller
     */
    @Override
    public int compareTo(MapEntry other) {
        return this.key.compareTo(other.key);
    }
}
