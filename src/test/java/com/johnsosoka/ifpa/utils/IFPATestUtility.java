package com.johnsosoka.ifpa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility class for testing.
 */
public class IFPATestUtility {

    /**
     * Reads a file from the test resources directory and returns its content as a String.
     *
     * @param fileName Name of the file to read.
     * @return Content of the file as a String.
     * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     */
    public static String readFileFromTestResources(String fileName) throws IOException {
        // Construct the path to the file in the test resources directory
        Path filePath = Paths.get("src/test/resources", fileName);

        // Read the file content into a String
        return Files.readString(filePath);
    }

}
