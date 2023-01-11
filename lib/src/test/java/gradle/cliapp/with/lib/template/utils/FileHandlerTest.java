package gradle.cliapp.with.lib.template.utils;

import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.data.structures.MapEntry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileHandlerTest {

        private static String hash = Hash.hashCodesHex("test");

        @AfterAll
        static void tearDown() {
            File file = new File(hash + ".zip");
            file.delete();
        }

        @BeforeEach
        void setUp() throws IOException {
            new FileHandler(hash).createDirectory();
        }

        @Test
        void testCreateDirectory() {
            assertTrue(new File(hash).exists() && new File(hash).isDirectory());
        }

        @Test
        void testDeleteDirectory() {
            new FileHandler(hash).deleteDirectory();
            assertFalse(new File(hash).exists());
        }

        @Test
        void testDeleteFile() throws IOException {
            new FileHandler(hash).deleteFile("test.txt");
            assertFalse(new File(hash + "\\test.txt").exists());
        }

        @Test
        void writeToFile() {
            assertTrue(new FileHandler(hash).writeToFile(new MapEntry("test", "test")));
        }

        @Test
        void readFromFile() {
            MapEntry [] entriesExpected = {
                    new MapEntry("test", "test"), new MapEntry("test2", "test"), new MapEntry("test3", "test")
            };
            new FileHandler(hash).writeToFile(entriesExpected[0]);
            new FileHandler(hash).writeToFile(entriesExpected[1]);
            new FileHandler(hash).writeToFile(entriesExpected[2]);

            MapEntry [] entriesActual = new FileHandler(hash).loadFiles();
            assertEquals(entriesActual.length, entriesExpected.length);
            for (int i = 0; i < entriesActual.length; i++) {
                assertEquals(entriesActual[i].getKey(), entriesExpected[i].getKey());
                assertEquals(entriesActual[i].getValue(), entriesExpected[i].getValue());
            }
        }
}
