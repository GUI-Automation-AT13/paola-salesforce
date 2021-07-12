package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VariableConfiguration {
    public static Properties CONFIG = new Properties();

    static {
        try {
            CONFIG = read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String CONFIG_PATH = "credential.properties";

    /**
     * Gets the values inside a properties file.
     *
     * @return the read properties.
     */
    public static Properties read() throws IOException {
        Properties properties = new Properties();
        File file = new File(CONFIG_PATH);

        if (!file.exists()) {
            file.createNewFile();
        }
        try (InputStream reading = new FileInputStream(file)) {
            properties.load(reading);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Gets each value of the environment value from a configuration file or from the system environment variable.
     *
     * @param variables is the value to be obtained from the environment variables
     * @return the environment value
     */
    public static String envVariables(final String variables) {
        if (CONFIG.getProperty(variables) != null) {
            return CONFIG.getProperty(variables);
        }
        return System.getenv(variables);
    }
}
