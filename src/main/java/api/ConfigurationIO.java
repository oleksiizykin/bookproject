package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationIO {
    public static Path pathToConfiguration = Paths.get("src", "test", "resources", "configuration.properties");

    public String getProperty(String propertyName, Path path) throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream(new File(path.toUri()));
        properties.load(is);
        return properties.getProperty(propertyName);
    }
}
