package gradle.cliapp.with.lib.template.utils;

import gradle.cliapp.with.lib.template.data.structures.MapEntry;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import javax.crypto.*;
import java.io.*;
import java.security.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CipherHandlerTest {


    @Test
    void testEncrypt() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        File file = new File (Hash.hashCodesHex("test") + ".txt");
        file.createNewFile();
        CipherHandler.encrypt(new MapEntry("test", "test"),new FileOutputStream(file));
        MapEntry actual = (MapEntry) CipherHandler.decrypt(new FileInputStream(file));
        MapEntry expected = new MapEntry("test", "test");
        file.delete();
        assertEquals(expected.getKey(),actual.getKey());
        assertEquals(expected.getValue(),actual.getValue());
    }
}
