import display.GameDisplay;
import factory.DisplaysFactory;
import factory.GameCreator;
import playbackMode.GameController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length != 1) {
            throw new IllegalArgumentException("Debe ingresar un archivo de configuración.");
        } else if (args[0].isEmpty()) {
            throw new IllegalArgumentException("El archivo de configuración no puede estar vacío.");
        }
        GameController game = createGameFromFile(args[0]);
        List<GameDisplay> displays = getDisplaysFromFile(args[0]);
        for(GameDisplay d: displays) game.addObserver(d);
        game.reproduce();
    }

    private static GameController createGameFromFile(String filename) throws IOException {
        Properties properties = loadPropertiesFile(filename);
        String boardPositionsString = getProperty(properties, "BOARD");
        String variantString = getProperty(properties, "VARIANT");
        String playbackModeString = getProperty(properties, "PLAYBACKMODE");
        String rowsString = getProperty(properties, "ROWS");
        String colsString = getProperty(properties, "COLS");
        int rows = Integer.parseInt(rowsString);
        int cols = Integer.parseInt(colsString);
        return GameCreator.getGame(variantString, playbackModeString, rows, cols, boardPositionsString);
    }

    private static List<GameDisplay> getDisplaysFromFile(String filename) throws IOException {
        Properties properties = loadPropertiesFile(filename);
        String displayType = getProperty(properties, "DISPLAY");
        return DisplaysFactory.factory(displayType);
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