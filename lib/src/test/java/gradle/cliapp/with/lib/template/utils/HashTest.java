package gradle.cliapp.with.lib.template.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class HashTest {

        @Test
        void testHashCodesHex() {
            String actual = Hash.hashCodesHex("test");
            String expected = "364492";
            assertEquals(expected, actual);
        }
}
