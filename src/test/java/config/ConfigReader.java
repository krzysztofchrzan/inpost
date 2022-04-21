package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    public static Properties getConfig() {
        Properties properties = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
}
