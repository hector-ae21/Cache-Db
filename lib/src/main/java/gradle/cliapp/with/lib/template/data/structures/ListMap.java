package gradle.cliapp.with.lib.template.data.structures;

import gradle.cliapp.with.lib.template.exceptions.KeyNotFoundException;

/**
 * ListMap class
 */
public class ListMap {

    /**
     *  list
     */
    private final List<MapEntry> list = new List<>();

    /**
     * Get size of the list
     * @return size of the list
     */
    public int size() {
        return list.size();
    }

    /**
     * Get array of keys
     * @return array of keys
     */
    public Object[] keys() {
        Object[] keys = list.listData();
        Object[] result = new Object[keys.length];
        for (int i = 0; i < keys.length; i++) {
            result[i] = ((MapEntry) keys[i]).getKey();
        }
        return result;
    }

    /**
     * Get array of values
     * @return array of values
     */
    public Object[] values() {
        Object[] values = list.listData();
        Object[] result = new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = ((MapEntry) values[i]).getValue();
        }
        return result;
    }

    /**
     * Add a new entry to the list if not exists
     * @param key key of the entry
     * @param value value of the entry
     */
    public boolean add(String key, String value) {
        if (this.contains(key)){
            return false;
        } else {
            list.insert(new MapEntry(key, value));
            return true;
        }
    }

    /**
     * update an entry
     * @param key key of the entry
     * @param value value of the entry
     */
    public void put(String key, String value) {
        if (this.contains(key)){
            list.get(new MapEntry(key,null)).setValue(value);
        } else {
            list.insert(new MapEntry(key, value));
        }
    }


    /**
     * If the list contains the key
     * @param key key to check
     * @return true if the list contains the key
     */
    public boolean contains(String key) {
        return list.get(new MapEntry(key, null)) != null;
    }

    /**
     * Get the value of the key
     * @param key key to get
     * @return value of the key
     * @throws KeyNotFoundException if the key is not found
     */
    public String get(String key) {
        MapEntry entry = list.get(new MapEntry(key, null));
        if (entry == null) {
            throw new KeyNotFoundException();
        }
        return entry.getValue();
    }

    /**
     * Remove the entry of the key
     * @param key key to remove
     * @return true if the key is removed
     */
    public boolean remove(String key) {
        if (!contains(key)) return false;
        list.remove(new MapEntry(key, null));
        return true;
    }
}
