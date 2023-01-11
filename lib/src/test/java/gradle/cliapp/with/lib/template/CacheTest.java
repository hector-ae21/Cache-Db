package gradle.cliapp.with.lib.template;

import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.exceptions.DuplicatedKeyException;
import gradle.cliapp.with.lib.template.exceptions.KeyNotFoundException;
import gradle.cliapp.with.lib.template.utils.Hash;
import org.junit.jupiter.api.*;

import java.io.File;

public class CacheTest {
    private final Cache cache = new Cache("test");

    @AfterAll
    static void tearDown() {
        new File("data\\"+ Hash.hashCodesHex("test") + ".zip").delete();
    }
    @BeforeEach
    void setUp(){
        cache.put("key1", "value1");
        cache.put("key2", "value2");
    }
    @Test
    void testAdd() throws DuplicatedKeyException {
        cache.addNew("key3", "value3");
        cache.addNew("key4", "value4");
        assertEquals("value3", cache.get("key3"));
        assertEquals("value4", cache.get("key4"));
        assertThrows(DuplicatedKeyException.class, () -> cache.addNew("key1", "value3"));
    }

    @Test
    void testRemove() {
        cache.remove("key1");
        assertFalse(cache.exists("key1"));
        assertThrows(KeyNotFoundException.class, () -> cache.remove("key1"));
    }

    @Test
    void testCount() {
        assertEquals(4, cache.size());
    }

    @Test
    void testPut() {
        cache.put("key2", "value4");
        cache.put("key3", "value5");
        assertEquals("value5", cache.get("key3"));
        assertEquals("value4", cache.get("key2"));
    }

    @Test
    void testGet() {
        assertEquals("value2", cache.get("key2"));
        assertEquals("value1", cache.get("key1"));
    }

    @Test
    void testGetAllKeys(){
        String[] keys = cache.getAll();
        assertEquals("key1", keys[0]);
        assertEquals("key2", keys[1]);
        assertEquals("key3", keys[2]);
        assertEquals("key4", keys[3]);
    }

    @Test
    void testExist(){
        assertTrue(cache.exists("key2"));
        assertFalse(cache.exists("key6"));
    }
}
