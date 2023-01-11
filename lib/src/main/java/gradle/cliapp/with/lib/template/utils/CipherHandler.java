package gradle.cliapp.with.lib.template.utils;


import java.io.*;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

/**
 * CipherHandler class
 */
public class CipherHandler {
    /**
     * key to encrypt and decrypt
     */
    private static final byte[] key = "password".getBytes();
    /**
     * algorithm to use
     */
    private static final String transformation = "DES";

    /**
     * Encrypt a string
     * @param object the object to encrypt
     * @param ostream the output stream
     * @throws IOException if the object cannot be written
     * @throws NoSuchAlgorithmException if the algorithm is not found
     * @throws NoSuchPaddingException if the padding is not found
     * @throws InvalidKeyException if the key is invalid
     */
    public static void encrypt(Serializable object, OutputStream ostream) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        try {
            // Length is 16 byte
            SecretKeySpec sks = new SecretKeySpec(key, transformation);

            // Create cipher
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, sks);
            SealedObject sealedObject = new SealedObject(object, cipher);

            // Wrap the output stream
            CipherOutputStream cos = new CipherOutputStream(ostream, cipher);
            ObjectOutputStream outputStream = new ObjectOutputStream(cos);
            outputStream.writeObject(sealedObject);
            outputStream.close();
            cos.close();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decrypt the object
     * @param istream input stream
     * @return the decrypted object
     * @throws IOException if the file is not found
     * @throws NoSuchAlgorithmException if the algorithm is not found
     * @throws NoSuchPaddingException if the padding is not found
     * @throws InvalidKeyException if the key is not valid
     */
    public static Object decrypt(InputStream istream) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SecretKeySpec sks = new SecretKeySpec(key, transformation);
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, sks);

        CipherInputStream cipherInputStream = new CipherInputStream(istream, cipher);
        ObjectInputStream inputStream = new ObjectInputStream(cipherInputStream);
        SealedObject sealedObject;
        try {
            sealedObject = (SealedObject) inputStream.readObject();
            inputStream.close();
            cipherInputStream.close();
            return sealedObject.getObject(cipher);
        } catch (ClassNotFoundException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }
}