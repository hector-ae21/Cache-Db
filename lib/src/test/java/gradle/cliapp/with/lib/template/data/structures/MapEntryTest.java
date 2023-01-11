package gradle.cliapp.with.lib.template.data.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class MapEntryTest {
    private MapEntry mapEntry;
    @BeforeEach
    void setUp() {
        mapEntry = new MapEntry("key2", "value2");
    }
    @Test
    void testGet() {
        assertEquals("key2", mapEntry.getKey());
        assertEquals("value2", mapEntry.getValue());
    }
    @Test
    void testSet() {
        mapEntry.setKey("key1");
        mapEntry.setValue("value1");
        assertEquals("key1", mapEntry.getKey());
        assertEquals("value1", mapEntry.getValue());
    }

    @Test
    void testCompareTo(){
        MapEntry mapEntry2 = new MapEntry("key1", "value1");
        MapEntry mapEntry3 = new MapEntry("key3", "value3");
        assertEquals(0, mapEntry.compareTo(mapEntry));
        assertEquals(1, mapEntry.compareTo(mapEntry2));
        assertEquals(-1, mapEntry.compareTo(mapEntry3));
    }
}
