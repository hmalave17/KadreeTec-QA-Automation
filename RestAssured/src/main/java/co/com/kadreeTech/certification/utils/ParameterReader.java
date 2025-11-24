package co.com.kadreeTech.certification.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterReader {

    private static final Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterReader.class);

    private ParameterReader() {}

    public static void addPropertiesSource(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new IOException("Properties file not found at path: " + path);
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
            LOGGER.info("Properties loaded successfully from {}", path);

        } catch (IOException e) {
            throw new IOException("Failed to load properties from path: " + path, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

