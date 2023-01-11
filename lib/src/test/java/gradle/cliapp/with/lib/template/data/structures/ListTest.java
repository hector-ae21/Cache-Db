package gradle.cliapp.with.lib.template.data.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ListTest {
    private List<String> list;
    @BeforeEach
    void setUp() {
        list = new List<String>();
        list.insert("This is the first node");
        list.insert("This is the second node");
        list.insert("This is the third node");
    }
    @Test
    void testAdd() {
        assertEquals("This is the first node", list.get("This is the first node"));
        assertEquals("This is the second node", list.get("This is the second node"));
        assertEquals("This is the third node", list.get("This is the third node"));
    }
    @Test
    void testCount() {
        assertEquals(3, list.size());
    }
    @Test
    void testRemove() {
        list.remove("This is the second node");
        assertEquals("This is the first node", list.get("This is the first node"));
        assertEquals("This is the third node", list.get("This is the third node"));
    }
    @Test
    void testListData() {
        Object[] data = list.listData();
        assertEquals("This is the first node", data[0]);
        assertEquals("This is the second node", data[1]);
    }
}
