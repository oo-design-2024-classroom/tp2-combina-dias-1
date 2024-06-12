import factory.game.GameCreator;
import playbackMode.GameController;

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
        GameController game = createGameFromFile(args[0]);
        game.reproduce();
    }

    private static GameController createGameFromFile(String filename) throws IOException {
        Properties properties = loadPropertiesFile(filename);
        String boardPositionsString = getProperty(properties, "BOARD");
        String variantString = getProperty(properties, "VARIANT");
        String displayString = getProperty(properties, "DISPLAY");
        String playbackModeString = getProperty(properties, "PLAYBACKMODE");
        String rowsString = getProperty(properties, "ROWS");
        String colsString = getProperty(properties, "COLS");
        int rows = Integer.parseInt(rowsString);
        int cols = Integer.parseInt(colsString);
        return GameCreator.getGame(variantString, playbackModeString, displayString, rows, cols, boardPositionsString);
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