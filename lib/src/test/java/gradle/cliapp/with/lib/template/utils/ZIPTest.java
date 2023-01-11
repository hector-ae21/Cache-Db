package gradle.cliapp.with.lib.template.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ZIPTest {

    private static String hash = Hash.hashCodesHex("test");

    @AfterAll
    static void tearDown() {
        File file = new File(hash + ".zip");
        file.delete();
    }

    @BeforeEach
    void setUp() throws IOException {
        new FileHandler(hash).createDirectory();
    new File(hash + "\\test.txt").createNewFile();
    new File(hash + "\\test2.txt").createNewFile();
    }
    @Test
    void testCompress() {
        ZIP.compress(hash);
        assertTrue(new File(hash+".zip").exists());
    }

    @Test
    void testDecompress() {
        ZIP.decompress(hash + ".zip");
        File[] files = {
                new File(hash + "\\test.txt"), new File(hash + "\\test2.txt")
        };
        assertArrayEquals(new File(hash).listFiles(), files);
    }
}
