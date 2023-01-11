package gradle.cliapp.with.lib.template.utils;


import java.io.*;
import java.util.Objects;
import java.util.zip.*;

/**
 * ZIP class
 */
public class ZIP {

    /**
     * Compress a directory
     * @param directory directory to compress
     */
    public static void compress(String directory)  {

        File compressFolder = new File(directory);

        if (compressFolder.exists()) {
            if (compressFolder.listFiles().length != 0) {
                File[] files = compressFolder.listFiles();
                try {
                    ZipOutputStream zous = new ZipOutputStream(new FileOutputStream(directory + ".zip"));
                    for (int i = 0; i < Objects.requireNonNull(files).length; i++) {



                        ZipEntry entry = new ZipEntry(files[i].getName());
                        zous.putNextEntry(entry);

                        FileInputStream fis = new FileInputStream(directory+ "\\" +entry.getName());
                        int leer;
                        byte[] buffer = new byte[1024];
                        while (0 < (leer = fis.read(buffer))) {
                            zous.write(buffer, 0, leer);
                        }
                        fis.close();
                        zous.closeEntry();

                    }
                    zous.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            new FileHandler(directory).deleteDirectory();



        }
    }

    /**
     * Decompress a zip file
     * @param file zip file to decompress
     */
    public static void decompress(String file) {
        File decompressFile = new File(file);

        if (decompressFile.exists()) {
                try {
                    new FileHandler(file.replace(".zip", "")).createDirectory();
                    ZipInputStream zis = new ZipInputStream(new FileInputStream(decompressFile));

                    ZipEntry outEntry;

                    while (null != (outEntry = zis.getNextEntry())) {

                        FileOutputStream fos = new FileOutputStream(file.replace(".zip", "") + "\\" + outEntry.getName());
                        int leer;
                        byte[] buffer = new byte[1024];
                        while (0 < (leer = zis.read(buffer))) {
                            fos.write(buffer, 0, leer);
                        }
                        fos.close();
                        zis.closeEntry();
                    }
                    zis.close();
                    decompressFile.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}