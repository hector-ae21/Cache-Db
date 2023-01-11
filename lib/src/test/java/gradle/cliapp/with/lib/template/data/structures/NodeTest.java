package gradle.cliapp.with.lib.template.data.structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NodeTest {
    private Node firstNode;

    @BeforeEach
    void setUp() {
        firstNode = new Node("This is the first node");
        firstNode.setNext(new Node("This is the second node"));
        firstNode.getNext().setNext(new Node("This is the third node"));
    }

    @Test
    void testGetData() {
        assertEquals("This is the first node", firstNode.getData());
    }

    @Test
    void testGetNext() {
        assertEquals("This is the second node", firstNode.getNext().getData());
        assertEquals("This is the third node", firstNode.getNext().getNext().getData());
    }

    @Test
    void testCount() {
        assertEquals(3, firstNode.count());
    }
}
