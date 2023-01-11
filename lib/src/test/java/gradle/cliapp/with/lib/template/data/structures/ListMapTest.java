package gradle.cliapp.with.lib.template.data.structures;

import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.exceptions.KeyNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class ListMapTest {
    private ListMap listMap;
    @BeforeEach
    void setUp() {
        listMap = new ListMap();
        listMap.add("key1", "value1");
        listMap.add("key2", "value2");
        listMap.add("key3", "value3");
    }
    @Test
    void testAdd() {
        assertFalse(listMap.add("key3", "value4"));
        assertEquals("value1", listMap.get("key1"));
        assertEquals("value2", listMap.get("key2"));
        assertEquals("value3", listMap.get("key3"));
    }
    @Test
    void testCount() {
        assertEquals(3, listMap.size());
    }
    @Test
    void testRemove() {
        assertTrue(listMap.remove("key2"));
        assertEquals("value1", listMap.get("key1"));
        assertEquals("value3", listMap.get("key3"));
    }
    @Test
    void testKeys() {
        Object[] keys = listMap.keys();
        assertEquals("key1", keys[0]);
        assertEquals("key2", keys[1]);
        assertEquals("key3", keys[2]);
    }

    @Test
    void testValues() {
        Object[] values = listMap.values();
        assertEquals("value1", values[0]);
        assertEquals("value2", values[1]);
        assertEquals("value3", values[2]);
    }
}
