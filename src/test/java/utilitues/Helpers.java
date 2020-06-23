package utilitues;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helpers {

    private Helpers() {}

    public static Properties getPropFromResources(String fileName) {
        ClassLoader loader = Helpers.class.getClassLoader();
        Properties prop = new Properties();
        try (InputStream inputStream = loader.getResourceAsStream(fileName)) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
