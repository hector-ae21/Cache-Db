package gradle.cliapp.with.lib.template.utils;

import gradle.cliapp.with.lib.template.data.structures.MapEntry;

import java.io.*;

/**
 * FileHandler class
 */
public class FileHandler {

    /**
     * directory of the file
     */
    private final String directory ;

    /**
     * Constructor
     * @param directory directory of the file
     */
    public FileHandler(String directory) {
        this.directory = directory;
    }

    /**
     * delete a directory
     * @return true if the directory was deleted
     */
    public boolean deleteDirectory() {
        File dir = new File(directory);
        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                file.delete();
            }
        }
        dir.delete();
        return true;
    }

    /**
     * Create a new directory
     */
    public void createDirectory() {
        File folder = new File(directory);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    /**
     * delete a file
     * @param filename name of the file
     * @return true if the file is deleted
     */
    public boolean deleteFile (String filename) throws IOException {
        ZIP.decompress(directory + ".zip");
        boolean result = (new File(directory + "\\" + Hash.hashCodesHex(filename) + ".txt")).delete();
        ZIP.compress(directory);
        if (new File("data").exists() && new File("data").listFiles().length == 0) {
            new FileHandler("data").deleteDirectory();
        }
        return result;
    }

    /**
     * Write a file
     * @param data data to write
     * @return true if the file is written
     */
    public boolean writeToFile (MapEntry data) {
        try {
            ZIP.decompress(directory + ".zip");
            createDirectory(); // Create directory if it does not exist
            File file = new File(directory + "\\" + Hash.hashCodesHex(data.getKey()) + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            CipherHandler.encrypt(data, fileOutputStream);
            fileOutputStream.close();
            ZIP.compress(directory);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * read files of a directory
     * @return a list of files
     */
    public MapEntry [] loadFiles() {
        ZIP.decompress(directory + ".zip");
        File [] files = new File(directory).listFiles();
        if (files == null) {
            return null;
        }
        MapEntry[] data = new MapEntry[files.length];
        int i = 0;
        for (File file : files) {
            if (file.isFile()) {
                try {
                    FileInputStream fileIn=new FileInputStream(directory + "\\" + file.getName());
                    data[i++] = (MapEntry) CipherHandler.decrypt(fileIn);
                    fileIn.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        }
        ZIP.compress(directory);
        return data;
    }
}
