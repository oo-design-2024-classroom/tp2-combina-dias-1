import game.Game;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length != 1) {
            throw new IllegalArgumentException("Debe ingresar un archivo de configuración.");
        } else if (args[0].isEmpty()) {
            throw new IllegalArgumentException("El archivo de configuración no puede estar vacío.");
        }
        Game game = createGameFromFile(args[0]);
        game.play();
    }

    private static Game createGameFromFile(String filename) throws IOException {
        Properties properties = loadPropertiesFile(filename);
        String boardPositionsString = getProperty(properties, "BOARD");
        String variantString = getProperty(properties, "VARIANT");
        String displayString = getProperty(properties, "DISPLAY");
        String playbackModeString = getProperty(properties, "PLAYBACKMODE");
        return new Game(variantString, boardPositionsString, playbackModeString, displayString);
    }

    public static Properties loadPropertiesFile(String configFileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(configFileName));
        return properties;
    }

    public static String getProperty(Properties properties, String key) {
        String value = properties.getProperty(key);
        if (value == null) throw new IllegalArgumentException("La propiedad '" + key + "' no está definida en el archivo de configuración.");
        return value;
    }
}